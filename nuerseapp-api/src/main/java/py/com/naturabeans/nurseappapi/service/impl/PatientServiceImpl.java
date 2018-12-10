package py.com.naturabeans.nurseappapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.naturabeans.nurseappapi.dao.PatientDao;
import py.com.naturabeans.nurseappapi.dao.VitalSignDao;
import py.com.naturabeans.nurseappapi.service.PatientService;
import py.com.nurseapp.beans.*;
import py.com.nurseapp.dto.request.PatientDto;
import py.com.nurseapp.dto.request.PatientVitalSignDto;
import py.com.nurseapp.dto.response.ResponsePatientVitalSignDto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VitalSignDao vitalSignDao;

    @Override
    public Patient createPatient(PatientDto patientDto) {
       Patient patientCreated = patientDao.createPatient(patientDto.getName(), patientDto.getDocument(), new java.sql.Date (patientDto.getBithDate().getTime()));
        return patientCreated;
    }

    @Override
    public void deletePatient(Integer codPatient) {
            patientDao.deletePatient(codPatient);
    }

    @Override
    public void updatePatient(PatientDto patientDto) {

    }

    @Override
    public Patient getPatient(Integer idPatient) {
        return null;
    }

    @Override
    public List<Patient> getPatients(String name, String document, Status status) {
        return patientDao.getPatients(name, document, status).orElseThrow(RuntimeException::new);
    }

    @Override
    public ResponsePatientVitalSignDto registerPatientVitalSign(PatientVitalSignDto patientVitalSignDto) {

        //TODO check the exception
        Patient patient = patientDao.getPatient(patientVitalSignDto.getIdPatient()).orElseThrow(RuntimeException::new);
        Integer valueVitalSign = patientVitalSignDto.getValueVitalSign();
        List<VitalSign> vitalSignsByCode = vitalSignDao.getVitalSign(patientVitalSignDto.getCodVitalSign()).orElseThrow(RuntimeException::new);
        Integer patientAge = getYears(patient.getBirthDate());
        VitalSign vitalSignForPatientAge = vitalSignsByCode.stream().filter (vs -> patientAge>= vs.getMinAge() && patientAge<=vs.getMaxAge()).findFirst().orElseThrow(RuntimeException::new);
        String condition = getPatientCondition(patientAge, patientVitalSignDto.getValueVitalSign(), vitalSignForPatientAge);

        Integer idRegistered = patientDao.registerPatientVitalSign(patient.getCodPatient(),vitalSignForPatientAge.getIdVitalSign(),valueVitalSign, condition );

        PatientVitalSignBuilder patientVitalSignBuilder = new PatientVitalSignBuilder();

        ResponsePatientVitalSignDto response = new ResponsePatientVitalSignDto(
                                                patientVitalSignBuilder .idPatientVitalSign(idRegistered)
                                                                        .patient(patient)
                                                                        .vitalSign(vitalSignForPatientAge)
                                                                        .valueVitalSign(valueVitalSign)
                                                                        .condition(condition)
                                                                        .build());
        return response;
    }

    private Integer getYears(Date dateFrom){
        LocalDate date = dateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long years = ChronoUnit.YEARS.between(date, LocalDate.now());
        return (int) years;
    }

    private String getPatientCondition(Integer age, Integer valueVitalSignTaken, VitalSign vitalSign){
        if(valueVitalSignTaken.intValue() < vitalSign.getMinRange() ) return vitalSign.getLowLevelDescription();
        if(valueVitalSignTaken.intValue() > vitalSign.getMaxRange() ) return vitalSign.getHighLevelDescription();
        return vitalSign.getNormalLevelDescription();
    }
}
