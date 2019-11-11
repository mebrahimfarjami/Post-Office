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
        boolean exit = true;
        while (exit) {
            Menu.printMainMenu();
            option = input.nextInt();
            processMainInput(option);
        }
    }

    private static void processMainInput(int item) {
        switch (item) {
            case 1:
                Menu.printCustomerMenu();
                option = input.nextInt();
                processCustomerInput(option);
            case 2:
                Menu.printPackagesMenu();
                option = input.nextInt();
                processPackageInput(option);
            case 3:
                Menu.printCitiesMenu();
                option=input.nextInt();
                processCitiesInput(option);
        }
    }

    private static void processCitiesInput(int item) {
        switch (item){
            case 1:
                System.out.println("Enter City Name");
                String cityname= input.nextLine();
                System.out.println("Enter City Cordinates");
                int x=input.nextInt(),y=input.nextInt();
                Cordinate cordinate = new Cordinate(x,y);
                City city = new City(cityname,cordinate);

            case 3:

        }
    }

    private static void processPackageInput(int item) {
        switch (item) {
            case 1:
                int i;
                System.out.println("Enter Package's Name");
                String packagename = input.nextLine();
                System.out.println("Enter Sender's Name");
                String sendername = input.nextLine();
                for (i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName() == sendername) {
                        break;
                    }
                }
                Customer sender = Customer.getCustomers().get(i);

                System.out.println("Enter Receiver's Name");
                String receivername = input.nextLine();
                for (i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName() == receivername) {
                        break;
                    }
                }
                Customer receiver = Customer.getCustomers().get(i);

                System.out.println("Enter Origin City's Name");
                String origincityname = input.nextLine();
                for (i = 0; i < City.getCities().size(); i++) {
                    if (City.getCities().get(i).getName() == origincityname) {
                        break;
                    }
                }
                City origincity = City.getCities().get(i);

                System.out.println("Enter Destination City's Name");
                String destinationcityname = input.nextLine();
                for (i = 0; i < City.getCities().size(); i++) {
                    if (City.getCities().get(i).getName() == destinationcityname) {
                        break;
                    }
                }
                City destinationcity = City.getCities().get(i);

                System.out.println("Enter Package's Weight");
                int weight = input.nextInt();

                System.out.println("Enter Package's Send Time");
                int sendyear = input.nextInt(), sendmonth = input.nextInt(), sendday = input.nextInt();
                Date senddate = new Date(sendyear, sendmonth, sendday);

                System.out.println("Enter Package's Receive Time");
                int receiveyear = input.nextInt(), receivemonth = input.nextInt(), receiveday = input.nextInt();
                Date receivedate = new Date(receiveyear, receivemonth, receiveday);

                System.out.println("Enter Package's Transmition Type");
                String transmition = input.nextLine();
                Package.Transmition transmition1 = Package.Transmition.airtransfer;
                switch (transmition) {
                    case "airtransfer":
                        transmition1 = Package.Transmition.airtransfer;
                    case "landtransfer":
                        transmition1 = Package.Transmition.landtransfer;
                    case "seatransfer":
                        transmition1 = Package.Transmition.seatransfer;
                }
                Package apackage = new Package(packagename, sender, receiver, origincity, destinationcity, weight, senddate, receivedate, transmition1);
            case 2:
                int j;
                Package.printPackages();
                System.out.println("Enter Package's Name");
                String editpackagename = input.nextLine();
                for (j = 0; j < Package.getPackages().size(); j++) {
                    if (Package.getPackages().get(j).getName() == editpackagename) {
                        break;
                    }
                }
                Package editpackage = Package.getPackages().get(j);
                Menu.printPackagesEditMenu();
                option = input.nextInt();
                processPackagesEditMenu(option, editpackage);
            case 3:
                System.out.println("Enter Current Date");
                int day=input.nextInt(),month=input.nextInt(),year=input.nextInt();
                Date currdate = new Date(year,month,day);
                Package.sendPackages(currdate);
            case 4:
                Package.printPackages();
                System.out.println("Enter Package's Name");
                int statpackage = input.nextInt();
                Package.showStatus(statpackage);
            case 5:
                System.out.println("Enter Origin and Destination Cities");
                System.out.println("Origin");
                String origin=input.nextLine();
                int x1=input.nextInt(),y1=input.nextInt();
                Cordinate origincordinate= new Cordinate(x1,y1);
                City origincitysearch=new City(origin,origincordinate);
                System.out.println("Destination");
                String destination=input.nextLine();
                int x=input.nextInt(),y=input.nextInt();
                Cordinate destcordinate= new Cordinate(x,y);
                City destcitysearch=new City(destination,destcordinate);
                System.out.println(Package.searchByOriginAndDestination(origincitysearch,destcitysearch).getName());
        }
    }

    private static void processPackagesEditMenu(int item, Package editpackage) {
        int i;
        switch (item) {
            case 1:
                System.out.println("Enter New Name");
                String newname = input.nextLine();
                editpackage.setName(newname);
            case 2:
                System.out.println("Enter New Sender's Name");
                String newsendername = input.nextLine();
                for (i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName() == newsendername) {
                        break;
                    }
                }
                Customer newsender = Customer.getCustomers().get(i);
                editpackage.setSender(newsender);

            case 3:
                System.out.println("Enter New Receiver's Name");
                String newreceivername = input.nextLine();
                for (i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName() == newreceivername) {
                        break;
                    }
                }
                Customer newreceiver = Customer.getCustomers().get(i);
                editpackage.setReceiver(newreceiver);

            case 4:
                System.out.println("Enter New Origin City's Name");
                String neworigincityname = input.nextLine();
                for (i = 0; i < City.getCities().size(); i++) {
                    if (City.getCities().get(i).getName() == neworigincityname) {
                        break;
                    }
                }
                City neworigincity = City.getCities().get(i);
                editpackage.setOrigin(neworigincity);

            case 5:
                System.out.println("Enter New Destination City's Name");
                String newdestinationcityname = input.nextLine();
                for (i = 0; i < City.getCities().size(); i++) {
                    if (City.getCities().get(i).getName() == newdestinationcityname) {
                        break;
                    }
                }
                City newdestinationcity = City.getCities().get(i);
                editpackage.setDestination(newdestinationcity);

            case 6:
                System.out.println("Enter New Weight");
                int newweitght= input.nextInt();
                editpackage.setWeight(newweitght);
            case 7:
                System.out.println("Enter Package's New Send Time");
                int newsendyear = input.nextInt(), newsendmonth = input.nextInt(), newsendday = input.nextInt();
                Date newsenddate = new Date(newsendyear, newsendmonth, newsendday);
                editpackage.setSend(newsenddate);
            case 8:
                System.out.println("Enter Package's New Receive Time");
                int newreceiveyear = input.nextInt(), newreceivemonth = input.nextInt(), newreceiveday = input.nextInt();
                Date newreceivedate = new Date(newreceiveyear, newreceivemonth, newreceiveday);
            case 9:
                System.out.println("Enter Package's New Transmition Type");
                String newtransmition = input.nextLine();
                Package.Transmition newtransmition1 = Package.Transmition.airtransfer;
                switch (newtransmition) {
                    case "airtransfer":
                        newtransmition1 = Package.Transmition.airtransfer;
                    case "landtransfer":
                        newtransmition1 = Package.Transmition.landtransfer;
                    case "seatransfer":
                        newtransmition1 = Package.Transmition.seatransfer;
                }
                editpackage.setTransmition(newtransmition1);
        }
    }

    private static void processCustomerInput(int item) {
        int i;
        switch (item) {

            case 1:
                System.out.println("Enter Customer's Name");
                String name = input.nextLine();
                System.out.println("Enter Customer's ID");
                int id = input.nextInt();
                Customer customer = new Customer(id, name);
            case 2:
                System.out.println("Enter Customer's Name");
                String cusname = input.nextLine();
                for ( i = 0; i < Customer.getCustomers().size(); i++) {
                    if (Customer.getCustomers().get(i).getName()==cusname)
                        break;
                }
                Customer editcustomer = Customer.getCustomers().get(i);
                Menu.printCustomerEditMenu();
                option = input.nextInt();
                processCustomerEdit(option,editcustomer);
        }
    }

    private static void processCustomerEdit(int item,Customer editcustomer) {
        switch (item){
            case 1:
                System.out.println("Enter New Name");
                String newname = input.nextLine();
                editcustomer.setName(newname);
            case 2:
                System.out.println("Enter New ID");
                int newid = input.nextInt();
                editcustomer.setId(newid);
        }
    }
}
