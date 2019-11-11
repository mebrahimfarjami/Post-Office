package ir.ac.kntu;

public class Menu {


    public static void printMainMenu(){
        System.out.println("1.Customer");
        System.out.println("2.Packages");
        System.out.println("3.Cities");
    }
    public static void printCustomerMenu(){
        System.out.println("1.Add Customer");
        System.out.println("2.Edit Customer");
    }
    public static void printCustomerEditMenu(){
        System.out.println("1.Edit Name");
        System.out.println("2.Edit ID");
    }
    public static void printPackagesMenu(){
        System.out.println("1.Add Packages");
        System.out.println("2.Edit Packages");
        System.out.println("3.Send Packages");
        System.out.println("4.Show Packages Status");
        System.out.println("5.Search By Locations");
        System.out.println("6.Airtransfer Packages");
        System.out.println("7.Landtransfer Packages");
        System.out.println("8.Seatransfer Packages");
        System.out.println("9.Search By Status");
    }
    public static void printPackagesEditMenu(){
        System.out.println("1.Edit Name");
        System.out.println("2.Edit Sender");
        System.out.println("3.Edit Receiver");
        System.out.println("4.Edit Origin City");
        System.out.println("5.Edit Destination City");
        System.out.println("6.Edit Weight");
        System.out.println("7.Edit Send Date");
        System.out.println("8.Edit Receive Date");
        System.out.println("9.Edit Transmition Type");
    }
    public static void printCitiesMenu(){
        System.out.println("1.Add Cities");
        System.out.println("2.Edit Cities");
        System.out.println("3.Change Current City");
    }
}
