package py.com.naturabeans.nurseappapi.service;

import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.dto.request.PatientDto;
import py.com.nurseapp.dto.request.PatientVitalSignDto;
import py.com.nurseapp.dto.response.ResponsePatientVitalSignDto;

import java.util.List;

public interface PatientService {

    public Patient createPatient(PatientDto patientDto) ;
    public void deletePatient(Integer codPatient) ;
    public void updatePatient(PatientDto patientDto) ;
    public Patient getPatient(Integer idPatient) ;
    public List<Patient> getPatients(String name, String document, Status status) ;
    public ResponsePatientVitalSignDto registerPatientVitalSign(PatientVitalSignDto patientVitalSignDto) ;




}
