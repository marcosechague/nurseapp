package py.com.nurseapp.dto.request;

public class PatientVitalSignDto {

    private Integer idPatient;
    private String codVitalSign;
    private Integer valueVitalSign;

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getCodVitalSign() {
        return codVitalSign;
    }

    public void setCodVitalSign(String codVitalSign) {
        this.codVitalSign = codVitalSign;
    }

    public Integer getValueVitalSign() {
        return valueVitalSign;
    }

    public void setValueVitalSign(Integer valueVitalSign) {
        this.valueVitalSign = valueVitalSign;
    }

    @Override
    public String toString() {
        return "PatientVitalSignDto{" + "idPatient=" + idPatient + ", codVitalSign='" + codVitalSign + '\'' + ", valueVitalSign=" + valueVitalSign + '}';
    }
}
