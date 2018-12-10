package py.com.nurseapp.beans;

import java.util.Date;

public class Patient {

    private Integer codPatient;
    private String name;
    private String document;
    private Date birthDate;
    private Status status;

    public Integer getCodPatient() {
        return codPatient;
    }

    public void setCodPatient(Integer codPatient) {
        this.codPatient = codPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" + "codPatient=" + codPatient + ", name='" + name + '\'' + ", document='" + document + '\'' + ", birthDate='" + birthDate + '\'' + ", status=" + status + '}';
    }
}
