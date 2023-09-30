public class RepairJob {

    public int repairJobId;
    public int customerId;
    public int mobileDeviceId;
    public String startDate;
    public String repairDescription;


    public RepairJob(int repairJobId, int customerId, int mobileDeviceId, String startDate, String repairDescription) {
        this.repairJobId = repairJobId;
        this.customerId = customerId;
        this.mobileDeviceId = mobileDeviceId;
        this.startDate = startDate;
        this.repairDescription = repairDescription;
    }

    @Override
    public String toString() {
        return "RepairJob{" +
                "repairJobId=" + repairJobId +
                ", customerId=" + customerId +
                ", mobileDeviceId=" + mobileDeviceId +
                ", startDate='" + startDate + '\'' +
                ", repairDescription='" + repairDescription +
                '}';
    }
}
