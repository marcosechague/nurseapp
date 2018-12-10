package py.com.nurseapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.spi.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.dao.PatientDao;

@Repository
public class PatientDaoImpl  extends JdbcDaoSupport implements PatientDao {

    private final String SQL_INSERT_PATIENT = "INSERT INTO public.patients (name, document, bithdate) VALUES ( ?, ?, ?)";
    private final String SQL_GET_PATIENT_BY_ID = "SELECT * FROM public.patients WHERE id_patient = ?";
    
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public Patient createPatient(String name, String document, java.sql.Date birthDate){

        logger.info(SQL_INSERT_PATIENT);
        logger.info("1:" + name);
        logger.info("2:" + document);
        logger.info("3:" + birthDate);
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PATIENT, new String[]{"id_patient"});
                    ps.setString(1, name);
                    ps.setString(2, document);
                    ps.setDate(3, birthDate);

                    return ps;
                }
            }, keyHolder);
            Integer id = (Integer) keyHolder.getKey();
            Patient patientRegistered = getPatient(id).orElseGet(null);
            return patientRegistered;

        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity error ", e);
             throw new RuntimeException("Documen "+ document+" already exist");

        } catch (DataAccessException e) {
            logger.error("Database error", e);
            //throw new APIException(APIExceptionType.DATABASE, "");
        }

        //TODO ERASE!!
        return null;
    }

    @Override
    public void deletePatient(Integer codPatient) {

    }

    @Override
    public Patient updatePatient(String name, String documento, Date birthDate, Status status) {
        return null;
    }

    @Override
    public Optional<Patient> getPatient(Integer idPatient) {
    	try{	
			logger.info("SQL->"+SQL_GET_PATIENT_BY_ID);
			logger.info("1: "+idPatient);
			Patient patient = getJdbcTemplate().queryForObject(SQL_GET_PATIENT_BY_ID, new PatientMapper() , idPatient);
			
			return Optional.ofNullable(patient);
		} catch (EmptyResultDataAccessException e) {
			logger.warn("No patient with id "+idPatient);
			return Optional.empty();
		} catch (DataAccessException e) {
			logger.error("Database error", e);
			throw new RuntimeException();
		}
    }

    @Override
    public Optional<List<Patient>> getPatients(String name, String document, Status status) {
        return Optional.empty();
    }

    @Override
    public Integer registerPatientVitalSign(Integer idPatient, Integer idVitalSign, Integer valueVItalSign, String condition) {
        return null;
    }
    
    private class PatientMapper implements RowMapper<Patient> {

		@Override
		public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
			return getPatientFromResultSet(rs);
		}
		
	}
	
	private Patient getPatientFromResultSet(ResultSet rs) throws SQLException{
		
		Patient patient = new Patient();
		patient.setCodPatient(rs.getInt("ID_PATIENT"));
		patient.setDocument(rs.getString("document"));
		patient.setName(rs.getString("name"));
		patient.setBirthDate(rs.getDate("bithdate"));
		String status = rs.getString("status");
		patient.setStatus(Status.valueOf(status));
		return patient;
		
		
	}
}
