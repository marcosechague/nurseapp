package py.com.nurseapp.dto.response;

import py.com.nurseapp.beans.PatientVitalSign;

public class ResponsePatientVitalSignDto {
    private PatientVitalSign  patientVitalSign;

    public ResponsePatientVitalSignDto() {
    }

    public ResponsePatientVitalSignDto(PatientVitalSign patientVitalSign) {
        this.patientVitalSign = patientVitalSign;
    }

    public PatientVitalSign getPatientVitalSign() {
        return patientVitalSign;
    }

    public void setPatientVitalSign(PatientVitalSign patientVitalSign) {
        this.patientVitalSign = patientVitalSign;
    }

    @Override
    public String toString() {
        return "ResponsePatientVitalSignDto{" + "patientVitalSign=" + patientVitalSign + '}';
    }
}
