import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersDatabase extends DatabaseManager {

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        try{
            String query = "SELECT * FROM customers;";

            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                int customerId = result.getInt("customer_id");
                String customerName = result.getString("customer_name");
                String email = result.getString("email");
                String phoneNumber = result.getString("phone_number");

                Customer customer = new Customer(customerId, customerName, email, phoneNumber);

                customers.add(customer);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return customers;
    }

    public void insertCustomer( String customerName, String email, String phoneNumber){

        String query = "INSERT INTO customers (customer_name, email, phone_number) VALUES (?, ?, ?);";

        try{
            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setString(1, customerName);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);

            stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void updateCustomer(int customerId, String customerName, String email, String phoneNumber) {
        String query = "UPDATE customers SET customer_name = ?, email = ?, phone_number = ? " + "  WHERE customer_id = ?; ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, customerName);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setInt(4, customerId);

            stmt.execute();
            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    public void deleteCustomer(int customerId) {
        String query = "DELETE  FROM customers WHERE customer_id = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, customerId);

            stmt.execute();
            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }

}
