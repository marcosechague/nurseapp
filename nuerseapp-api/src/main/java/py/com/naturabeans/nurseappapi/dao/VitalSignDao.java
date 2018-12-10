package py.com.naturabeans.nurseappapi.dao;

import java.util.List;
import java.util.Optional;

import py.com.nurseapp.beans.VitalSign;

public interface VitalSignDao {
    public Optional<VitalSign> getVitalSign(Integer idVitalSign) ;
    public Optional<List<VitalSign>> getVitalSign(String codVitalSign) ;

}
