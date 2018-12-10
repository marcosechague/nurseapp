package py.com.nurseapp.beans;

public class PatientVitalSignBuilder {

    private Integer id;
    private Patient patient;
    private VitalSign vitalSign;
    private Integer valueVitalSign;
    private String condition;

    public PatientVitalSignBuilder idPatientVitalSign (Integer id){
        this.id = id;
        return this;
    }

    public PatientVitalSignBuilder patient (Patient patient){
        this.patient = patient;
        return this;
    }

    public PatientVitalSignBuilder vitalSign (VitalSign vitalSign){
        this.vitalSign = vitalSign;
        return this;
    }

    public PatientVitalSignBuilder valueVitalSign (Integer valueVitalSign){
        this.valueVitalSign = valueVitalSign;
        return this;
    }

    public PatientVitalSignBuilder condition (String  condition){
        this.condition = condition;
        return this;
    }
    public PatientVitalSign build (){
        return new PatientVitalSign(id, patient, vitalSign, valueVitalSign, condition);
    }

}
