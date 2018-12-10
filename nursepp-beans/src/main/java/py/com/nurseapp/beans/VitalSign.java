package py.com.nurseapp.beans;

public class VitalSign {

    private Integer idVitalSign;
    private String code;
    private String description;
    private Integer maxRange;
    private Integer minRange;
    private Integer maxAge;
    private Integer minAge;
    private String highLevelDescription;
    private String lowLevelDescription;
    private String normalLevelDescription;
    private Status status;

    public Integer getIdVitalSign() {
        return idVitalSign;
    }

    public void setIdVitalSign(Integer idVitalSign) {
        this.idVitalSign = idVitalSign;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
    }

    public Integer getMinRange() {
        return minRange;
    }

    public void setMinRange(Integer minRange) {
        this.minRange = minRange;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getHighLevelDescription() {
        return highLevelDescription;
    }

    public void setHighLevelDescription(String highLevelDescription) {
        this.highLevelDescription = highLevelDescription;
    }

    public String getLowLevelDescription() {
        return lowLevelDescription;
    }

    public void setLowLevelDescription(String lowLevelDescription) {
        this.lowLevelDescription = lowLevelDescription;
    }

    public String getNormalLevelDescription() {
        return normalLevelDescription;
    }

    public void setNormalLevelDescription(String normalLevelDescription) {
        this.normalLevelDescription = normalLevelDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VitalSign{" + "idVitalSign=" + idVitalSign + ", code='" + code + '\'' + ", description='" + description + '\'' + ", maxRange=" + maxRange + ", minRange=" + minRange + ", maxAge=" + maxAge + ", minAge=" + minAge + ", highLevelDescription='" + highLevelDescription + '\'' + ", lowLevelDescription='" + lowLevelDescription + '\'' + ", normalLevelDescription='" + normalLevelDescription + '\'' + ", status=" + status + '}';
    }
}
