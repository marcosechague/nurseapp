package py.com.nurseapp.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.Status;

public interface PatientDao {

    public Patient createPatient(String name, String documento, Date birthDate);
    public void deletePatient(Integer codPatient);
    public Patient updatePatient (String name, String documento, Date birthDate, Status status);
    public Optional<Patient> getPatient(Integer idPatient) ;
    public Optional<List<Patient>> getPatients(String name, String document, Status status) ;
    public Integer registerPatientVitalSign(Integer idPatient, Integer idVitalSign, Integer valueVItalSign, String condition);


}
