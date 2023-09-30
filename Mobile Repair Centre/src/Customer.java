public class Customer {
        public int customerId;
        public String customerName;
        public String email;
        public String phoneNumber;

        public Customer(int customerId, String customerName, String email, String phoneNumber) {
            this.customerId = customerId;
            this.customerName = customerName;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerId=" + customerId +
                    ", name='" + customerName + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
}
