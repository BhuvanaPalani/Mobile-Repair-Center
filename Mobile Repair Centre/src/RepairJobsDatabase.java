import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepairJobsDatabase extends DatabaseManager{

    public List<RepairJob> getRepairJobs() {
            List<RepairJob> repairJobs = new ArrayList<>();
            try {
                String query = "SELECT * FROM repair_jobs;";

                Statement stmt = conn.createStatement();

                ResultSet result = stmt.executeQuery(query);

                while (result.next()) {
                    int repairJobId = result.getInt("repair_job_id");
                    int customerId = result.getInt("customer_id");
                    int mobileDeviceId = result.getInt("mobile_device_id");
                    String startDate = result.getString("start_date");
                    String repairDescription = result.getString("repair_description");


                    RepairJob repairJob = new RepairJob(repairJobId, customerId, mobileDeviceId, startDate, repairDescription);

                    repairJobs.add(repairJob);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return repairJobs;
        }

        public void insertRepairJob(int customerId, int mobileDeviceId, String startDate, String repairDescription) {

            String query = "INSERT INTO repair_jobs (customer_id, mobile_device_id, start_date, repair_description) VALUES (?, ?, ?, ?);";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, customerId);
                stmt.setInt(2, mobileDeviceId);
                stmt.setString(3, startDate);
                stmt.setString(4, repairDescription);

                stmt.execute();

                stmt.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void updateRepairJob(int repairJobId, int customerId, int mobileDeviceId, String startDate, String repairDescription) {
            String query = "UPDATE repair_jobs SET customer_id = ?, mobile_device_id = ?, start_date = ?, repair_description = ? " + "  WHERE repair_job_id = ?; ";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, customerId);
                stmt.setInt(2, mobileDeviceId);
                stmt.setString(3, startDate);
                stmt.setString(4, repairDescription);
                stmt.setInt(5, repairJobId);

                stmt.execute();
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public void deleteRepairJob(int repairJobId) {
            String query = "DELETE  FROM repair_jobs WHERE repair_job_id = ? ";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, repairJobId);

                stmt.execute();
                stmt.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

