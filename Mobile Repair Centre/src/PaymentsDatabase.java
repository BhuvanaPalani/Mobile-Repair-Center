import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDatabase extends DatabaseManager {
    public List<Payment> getPayments() {
        List<Payment> payments = new ArrayList<>();
        try{
            String query = "SELECT * FROM payments;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                int paymentId = result.getInt("payment_id");
                int repairJobId = result.getInt("repair_job_id");
                int amount = result.getInt("amount");
                String method = result.getString("method");
                String paymentStatus = result.getString("payment_status");

                Payment payment = new Payment(paymentId, repairJobId, amount, method, paymentStatus);

                payments.add(payment);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return payments;
    }

    public void insertPayment(int repairJobId, int amount, String method, String paymentStatus){

        String query = "INSERT INTO payments (repair_job_id, amount, method, payment_status) VALUES (?, ?, ?, ?);";

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, repairJobId);
            stmt.setInt(2, amount);
            stmt.setString(3, method);
            stmt.setString(4, paymentStatus);

            stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void updatePayment(int paymentId, int repairJobId, int amount, String method, String paymentStatus) {
        String query = "UPDATE payments SET repair_job_id = ?, amount = ?, method = ?, payment_status = ? " + "  WHERE payment_id = ?; ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, repairJobId);
            stmt.setInt(2, amount);
            stmt.setString(3, method);
            stmt.setString(4, paymentStatus);
            stmt.setInt(5, paymentId);

            stmt.execute();
            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    public void deletePayment(int paymentId) {
        String query = "DELETE FROM payments WHERE payment_id = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, paymentId);

            stmt.execute();
            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }



}



