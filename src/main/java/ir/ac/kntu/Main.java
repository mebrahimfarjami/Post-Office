package ir.ac.kntu;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.Scanner;

/**
 * @author yourname
 */
public class Main {
    static Scanner input = new Scanner(System.in);
   static int option;
    public static void main(String[] args) {
        boolean exit=true;
        while (exit){
            Menu.printMainMenu();
            option=input.nextInt();
            processMainInput(option);
        }
    }

    private static void processMainInput(int item) {
        switch (item){
            case 1:
                Menu.printCustomerMenu();
                option=input.nextInt();
                processCustomerInput(option);
            case 2:
                Menu.printPackagesMenu();
                option=input.nextInt();
                processPackageInput(option);
        }
    }

    private static void processPackageInput(int item) {
        switch(item){
            case 1:
                int i;
                System.out.println("Enter Package's Name");
                String packagename = input.nextLine();
                System.out.println("Enter Sender's Name");
                String sendername = input.nextLine();
                for (i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName()==sendername){
                        break;
                    }
                }
                Customer sender= Customer.getCustomers().get(i);

                System.out.println("Enter Receiver's Name");
                String receivername = input.nextLine();
                for (i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName()==receivername){
                        break;
                    }
                }
                Customer receiver = Customer.getCustomers().get(i);

                System.out.println("Enter Origin City's Name");
                String origincityname = input.nextLine();
                for (i = 0; i < City.getCities().size(); i++) {
                    if (City.getCities().get(i).getName()==origincityname){
                        break;
                    }
                }
                City origincity = City.getCities().get(i);

                System.out.println("Enter Destination City's Name");
                String destinationcityname = input.nextLine();
                for (i = 0; i < City.getCities().size(); i++) {
                    if (City.getCities().get(i).getName()==destinationcityname){
                        break;
                    }
                }
                City destinationcity = City.getCities().get(i);

                System.out.println("Enter Package's Weight");
                int weight = input.nextInt();

                System.out.println("Enter Package's Send Time");
                int sendyear=input.nextInt(),sendmonth=input.nextInt(),sendday=input.nextInt();
                Date senddate = new Date(sendyear,sendmonth,sendday);

                System.out.println("Enter Package's Receive Time");
                int receiveyear=input.nextInt(),receivemonth=input.nextInt(),receiveday=input.nextInt();
                Date receivedate = new Date(receiveyear,receivemonth,receiveday);

                System.out.println("Enter Package's Transmition Type");
                String transmition = input.nextLine();
                Package.Transmition transmition1= Package.Transmition.airtransfer;
                switch (transmition){
                    case "airtransfer":
                        transmition1 = Package.Transmition.airtransfer;
                    case "landtransfer":
                        transmition1 = Package.Transmition.landtransfer;
                    case "seatransfer":
                        transmition1 = Package.Transmition.seatransfer;
                }
                Package apackage = new Package(packagename,sender,receiver,origincity,destinationcity,weight,senddate,receivedate,transmition1);

        }
    }

    private static void processCustomerInput(int item) {
        switch (item){
            case 1:
                System.out.println("Enter Customer's Name");
                String name=input.nextLine();
                System.out.println("Enter Customer's ID");
                int id=input.nextInt();
                Customer customer = new Customer(id,name);
            case 2:

        }
    }
}
