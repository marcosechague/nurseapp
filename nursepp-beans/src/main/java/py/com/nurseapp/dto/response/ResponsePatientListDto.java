package py.com.nurseapp.dto.response;

import java.util.List;

import py.com.nurseapp.beans.Patient;

public class ResponsePatientListDto {

    private List<Patient> patients;

    public ResponsePatientListDto() {
    }

    public ResponsePatientListDto(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "ResponsePatientListDto{" + "patients=" + patients + '}';
    }
}
