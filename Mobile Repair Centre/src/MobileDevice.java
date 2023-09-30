public class MobileDevice {

    public int mobileDeviceId;
    public String mobileBrand;
    public String mobileColour;
    public String mobileType;

    public MobileDevice(int mobileDeviceId, String mobileBrand, String mobileColour, String mobileType) {
        this.mobileDeviceId = mobileDeviceId;
        this.mobileBrand = mobileBrand;
        this.mobileColour = mobileColour;
        this.mobileType = mobileType;
    }

    @Override
    public String toString() {
        return "MobileDevice{" +
                "mobileDeviceId=" + mobileDeviceId +
                ", mobileBrand='" + mobileBrand + '\'' +
                ", mobileColour='" + mobileColour + '\'' +
                ", mobileType='" + mobileType + '\'' +
                '}';
    }
}
