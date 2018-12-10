package py.com.nurseapp.beans;

public class PatientVitalSign {

    private Integer id;
    private Patient patient;
    private VitalSign vitalSign;
    private Integer valueVitalSign;
    private String condition;

    PatientVitalSign(Integer id, Patient patient, VitalSign vitalSign, Integer valueVitalSign, String condition) {
        this.patient = patient;
        this.vitalSign = vitalSign;
        this.valueVitalSign = valueVitalSign;
        this.condition = condition;
    }

    public Integer getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public Integer getValueVitalSign() {
        return valueVitalSign;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "PatientVitalSign{" + "id=" + id + ", patient=" + patient + ", vitalSign=" + vitalSign + ", valueVitalSign=" + valueVitalSign + ", condition='" + condition + '\'' + '}';
    }
}
