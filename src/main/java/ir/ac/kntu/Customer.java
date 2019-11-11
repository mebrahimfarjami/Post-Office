package ir.ac.kntu;

import java.util.ArrayList;

public class Customer {
    private static ArrayList<Customer> customers= new ArrayList<>();
    private int id;
    private String name;

    public boolean searchCustomer(Customer customer){
        if (customers.contains(customer)){
            return true;
        }
        return false;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        Customer.customers = customers;
    }

    public Customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Customer(int id, String name) {
        customers.add(this);
        this.id = id;
        this.name = name;
    }
}
