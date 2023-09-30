import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MobileDevicesDatabase extends DatabaseManager {

    public List<MobileDevice> getMobileDevice() {
        List<MobileDevice> mobileDevices = new ArrayList<>();
        try{
            String query = "SELECT * FROM mobile_devices;";

            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                int mobileDeviceId = result.getInt("mobile_device_id");
                String mobileBrand = result.getString("mobile_brand");
                String mobileType = result.getString("mobile_type");
                String mobileColour = result.getString("mobile_colour");

                MobileDevice mobileDevice = new MobileDevice(mobileDeviceId, mobileBrand, mobileType, mobileColour);

                mobileDevices.add(mobileDevice);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return mobileDevices;
    }

    public void insertMobileDevice(String mobileBrand, String mobileType, String mobileColour){

        String query = "INSERT INTO mobile_devices (mobile_brand, mobile_type, mobile_colour) VALUES (?, ?, ?);";

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, mobileBrand);
            stmt.setString(2, mobileType);
            stmt.setString(3, mobileColour);

            stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void updateMobileDevice(int mobileDeviceId, String mobileBrand, String mobileType, String mobileColour) {
        String query = "UPDATE mobile_devices SET mobile_brand = ?, mobile_type = ?, mobile_colour = ? " + "  WHERE mobile_device_id = ?; ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, mobileBrand);
            stmt.setString(2, mobileType);
            stmt.setString(3, mobileColour);
            stmt.setInt(4, mobileDeviceId);

            stmt.execute();

            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deleteMobileDevice(int mobileDeviceId) {
        String query = "DELETE FROM mobile_devices WHERE mobile_device_id = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, mobileDeviceId);

            stmt.execute();
            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }

}
