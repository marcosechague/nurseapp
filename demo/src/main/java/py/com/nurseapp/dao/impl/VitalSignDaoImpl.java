package py.com.nurseapp.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import py.com.nurseapp.beans.VitalSign;
import py.com.nurseapp.dao.VitalSignDao;

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

    @Override
    public Optional<List<VitalSign>> getVitalSign(String codVitalSign) {
        return Optional.empty();
    }
}
