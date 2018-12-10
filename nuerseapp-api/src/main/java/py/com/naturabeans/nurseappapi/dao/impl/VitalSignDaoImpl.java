package py.com.naturabeans.nurseappapi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import py.com.naturabeans.nurseappapi.dao.PatientDao;
import py.com.naturabeans.nurseappapi.dao.VitalSignDao;
import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.beans.VitalSign;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class VitalSignDaoImpl extends JdbcDaoSupport implements VitalSignDao {

    private final String SQL_GET_VITAL_SIGN = "INSERT INTO public.patients (name, document, bithdate) VALUES ( ?, ?, ?)";

    @Autowired
    private DataSource dataSource;
//
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public Optional<VitalSign> getVitalSign(Integer idVitalSign) {
        return Optional.empty();
    }

    public Optional<List<VitalSign>> getVitalSign(String codVitalSign) {
        return Optional.empty();
    }
}
