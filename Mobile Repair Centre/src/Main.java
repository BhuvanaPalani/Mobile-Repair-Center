import java.util.Scanner;

public class Main {
    private static Customer selectedCustomer = null;
    private static Payment selectedPayment = null;
    private static MobileDevice selectedMobileDevice = null;
    private static RepairJob selectedRepairJob = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var menuOption = 1;

        while (menuOption != 0) {
            menuOption = mainMenu();

            switch (menuOption) {
                case 1 -> showPayments();
                case 2 -> addPayment();
                case 3 -> updatePayment();
                case 4 -> deletePayment();
                case 5 -> showCustomers();
                case 6 -> addCustomer();
                case 7 -> updateCustomer();
                case 8 -> deleteCustomer();
                case 9 -> showMobileDevices();
                case 10 -> addMobileDevice();
                case 11 -> updateMobileDevice();
                case 12 -> deleteMobileDevice();
                case 13 -> showRepairJobs();
                case 14 -> addRepairJob();
                case 15 -> updateRepairJob();
                case 16 -> deleteRepairJob();



            }
        }

    }

    private static int mainMenu() {
        String selectedCustomerName = selectedCustomer == null ? "NONE" : selectedCustomer.customerName;
        String selectedPaymentStatus = selectedPayment == null ? "NONE" : selectedPayment.paymentStatus;
        String selectedMobileDeviceBrand = selectedMobileDevice == null ? "NONE" : selectedMobileDevice.mobileBrand;
        String selectedRepairJobDescription = selectedRepairJob == null ? "NONE" : selectedRepairJob.repairDescription;

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        int selection = 0;

        while (true) {
            try {
                System.out.println("Welcome To Mobile Repair Centre");
                System.out.println("Selected Customer: " + selectedCustomerName);
                System.out.println("Selected Payment: " + selectedPaymentStatus);
                System.out.println("Selected Mobile Device: " + selectedMobileDeviceBrand);
                System.out.println("Selected Repair Job: " + selectedRepairJobDescription);
                System.out.println("1: Show Payments");
                System.out.println("2: Add Payment");
                System.out.println("3: Update Payment");
                System.out.println("4: Delete Payment");
                System.out.println("5: Show Customers");
                System.out.println("6: Add Customer");
                System.out.println("7: Update Customer");
                System.out.println("8: Delete Customer");
                System.out.println("9: Show Mobile Devices");
                System.out.println("10: Add Mobile Device");
                System.out.println("11: Update Mobile Device");
                System.out.println("12: Delete Mobile Device");
                System.out.println("13: Show Repair Jobs");
                System.out.println("14: Add Repair Job");
                System.out.println("15: Update Repair Job");
                System.out.println("16: Delete Repair Job");
                System.out.println("17: Exit");

                System.out.println("Select A Option:");
                String input = scanner.next();

                selection = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("ENTER A NUMBER :");
            }
        }
        return selection;
    }

    private static void showPayments() {
        var paymentsDb = new PaymentsDatabase();
        var payments = paymentsDb.getPayments();

        for (var payment : payments) {
            System.out.println(payment);
        }
        System.out.print("Select payment Id: ");
        var paymentId = scanner.nextInt();

        for (var payment : payments) {
            if (paymentId == payment.paymentId) {
                selectedPayment = payment;
                break;
            }
        }
    }

    private static void addPayment() {
        System.out.print("Enter repair job Id: ");
        var repairJobId = scanner.nextInt();
        System.out.print("Enter payment amount: ");
        var amount = scanner.nextInt();
        System.out.print("Enter payment method: ");
        var method = scanner.next();
        System.out.print("Enter payment status: ");
        var paymentStatus = scanner.next();

        var paymentsDb = new PaymentsDatabase();

        paymentsDb.insertPayment(repairJobId, amount, method, paymentStatus);

        System.out.println("Payment created");

        pauseForInput();
    }

    private static void pauseForInput() {
        System.out.println("Press Enter To Continue");

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updatePayment() {
        System.out.print("Enter payment ID to update: ");
        var paymentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter repair job ID to update: ");
        var repairJobId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter amount to update: ");
        var amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new method: ");
        var method = scanner.next();
        System.out.print("Enter new payment status: ");
        var paymentStatus = scanner.next();

        var paymentsDb = new PaymentsDatabase();
        paymentsDb.updatePayment(paymentId, repairJobId, amount, method, paymentStatus);

        System.out.println("Payment updated");

        pauseForInput();
    }

    private static void deletePayment() {
        System.out.print("Enter payment ID to delete: ");
        var paymentId = scanner.nextInt();
        var paymentsDb = new PaymentsDatabase();
        paymentsDb.deletePayment(paymentId);
        System.out.println("Payment deleted");

        pauseForInput();
    }


    private static void showCustomers() {
        var customersDb = new CustomersDatabase();
        var customers = customersDb.getCustomers();

        for (var customer : customers) {
            System.out.println(customer);
        }
        System.out.print("Select customer Id: ");
        var customerId = scanner.nextInt();

        for (var customer : customers) {
            if (customerId == customer.customerId) {
                selectedCustomer = customer;
                break;
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        var customerName = scanner.next();
        System.out.print("Enter email: ");
        var email = scanner.next();
        System.out.print("Enter phone number: ");
        var phoneNumber = scanner.next();

        var customersDb = new CustomersDatabase();

        customersDb.insertCustomer(customerName, email, phoneNumber);

        System.out.println("Customer created");

        pauseForInput();
    }

    private static void updateCustomer() {
        System.out.print("Enter customer ID to update: ");
        var customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer name to update: ");
        var customerName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter new email: ");
        var email = scanner.next();
        System.out.print("Enter new phone number: ");
        var phoneNumber = scanner.next();

        var customerDb = new CustomersDatabase();
        customerDb.updateCustomer(customerId, customerName, email, phoneNumber);

        System.out.println("Customer updated");

        pauseForInput();
    }

    private static void deleteCustomer() {
        System.out.print("Enter customer ID to delete: ");
        var customerId = scanner.nextInt();
        var customerDb = new CustomersDatabase();
        customerDb.deleteCustomer(customerId);
        System.out.println("Customer deleted");

        pauseForInput();
    }

    private static void showMobileDevices() {
        var mobileDeviceDb = new MobileDevicesDatabase();
        var mobileDevices = mobileDeviceDb.getMobileDevice();

        for (var mobileDevice : mobileDevices) {
            System.out.println(mobileDevice);
        }
        System.out.print("Select mobile device Id: ");
        var mobileDeviceId = scanner.nextInt();

        for (var mobileDevice : mobileDevices) {
            if (mobileDeviceId == mobileDevice.mobileDeviceId) {
                selectedMobileDevice = mobileDevice;
                break;
            }
        }
    }




    private static void addMobileDevice() {
        System.out.print("Enter mobile brand: ");
        var mobileBrand = scanner.next();
        System.out.print("Enter mobile type: ");
        var mobileType = scanner.next();
        System.out.print("Enter mobile colour: ");
        var mobileColour = scanner.next();

        var mobileDevicesDb = new MobileDevicesDatabase();

        mobileDevicesDb.insertMobileDevice(mobileBrand, mobileType, mobileColour);

        System.out.println("Mobile Device created");

        pauseForInput();
    }

    private static void updateMobileDevice() {
        System.out.print("Enter mobile device ID to update: ");
        var mobileDeviceId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter mobile brand to update: ");
        var mobileBrand = scanner.next();
        scanner.nextLine();
        System.out.print("Enter mobile type to update: ");
        var mobileType = scanner.next();
        System.out.print("Enter mobile colour to update: ");
        var mobileColour = scanner.next();

        var mobileDeviceDb = new MobileDevicesDatabase();
        mobileDeviceDb.updateMobileDevice(mobileDeviceId, mobileBrand, mobileType, mobileColour);

        System.out.println("Mobile Device updated");

        pauseForInput();
    }

    private static void deleteMobileDevice() {
        System.out.print("Enter mobile device ID to delete: ");
        var mobileDeviceId = scanner.nextInt();
        var mobileDeviceDb = new MobileDevicesDatabase();
        mobileDeviceDb.deleteMobileDevice(mobileDeviceId);
        System.out.println("Customer deleted");

        pauseForInput();
    }



    private static void showRepairJobs() {
        var repairJobsDb = new RepairJobsDatabase();
        var repairJobs = repairJobsDb.getRepairJobs();

        for (var repairJob : repairJobs) {
            System.out.println(repairJob);
        }
        System.out.print("Select repair job Id: ");
        var repairJobId = scanner.nextInt();

        for (var repairJob : repairJobs) {
            if (repairJobId == repairJob.repairJobId) {
                selectedRepairJob = repairJob;
                break;
            }
        }
    }

    private static void addRepairJob() {
        System.out.print("Enter customer Id: ");
        var customerId = scanner.nextInt();
        System.out.print("Enter mobile device Id: ");
        var mobileDeviceId = scanner.nextInt();
        System.out.print("Enter start date: ");
        var startDate = scanner.next();
        System.out.print("Enter repair description: ");
        var repairDescription = scanner.next();

        var repairJobDb = new RepairJobsDatabase();

        repairJobDb.insertRepairJob(customerId, mobileDeviceId, startDate, repairDescription);

        System.out.println("Repair Job created");

        pauseForInput();
    }

    private static void updateRepairJob() {
        System.out.print("Enter repair device ID to update: ");
        var repairDeviceId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer ID to update: ");
        var customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter mobile device ID to update: ");
        var mobileDeviceId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter start date to update: ");
        var startDate = scanner.next();
        scanner.nextLine();
        System.out.print("Enter repair description to update: ");
        var repairDescription = scanner.next();

        var repairJobDb = new RepairJobsDatabase();
        repairJobDb.updateRepairJob(repairDeviceId, customerId, mobileDeviceId, startDate, repairDescription);

        System.out.println("Repair Job updated");

        pauseForInput();
    }

    private static void deleteRepairJob() {
        System.out.print("Enter repair job ID to delete: ");
        var repairJobId = scanner.nextInt();
        var repairJobDb = new RepairJobsDatabase();
        repairJobDb.deleteRepairJob(repairJobId);
        System.out.println("Repair Job deleted");

        pauseForInput();
    }



}










