package ir.ac.kntu;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;

public class Package {
    public static void sendPackages(Date currdate){
        for (int i = 0; i < packages.size(); i++) {
            if (currdate.getYear()>=packages.get(i).sendtime.getYear())
                packages.get(i).status= Status.notreceived;
            if (currdate.getMonth()>=packages.get(i).sendtime.getMonth())
                packages.get(i).status= Status.notreceived;
            if (currdate.getDay()>=packages.get(i).sendtime.getDay())
                packages.get(i).status= Status.notreceived;
        }
    }
    public static void printPackages(){
        for (int i = 0; i < packages.size(); i++) {
            System.out.println((i+1)+"."+packages.get(i).name);
        }
    }
    public static void showStatus(int item){
        System.out.println(packages.get(item-1).status);
    }

    public void changeCurrentcity(City city){
        currentcity=city;
    }

    public static Package searchByOriginAndDestination(City origin,City destination){
        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).origin==origin && packages.get(i).destination==destination)
                return packages.get(i);
        }
        return null;
    }
    public void searchAirtransfers(){
        ArrayList<Package> airtransfers = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).transmition==Transmition.airtransfer){
                airtransfers.add(packages.get(i));
            }
        }
        for (int i = 0; i < airtransfers.size(); i++) {
            System.out.println(airtransfers.get(i).name);
        }
    }

    public void searchLandtransfers(){
        ArrayList<Package> landtransfer = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).transmition==Transmition.landtransfer){
                landtransfer.add(packages.get(i));
            }
        }
        for (int i = 0; i < landtransfer.size(); i++) {
            System.out.println(landtransfer.get(i).name);
        }
    }

    public void searchSeatransfers(){
        ArrayList<Package> seatransfer = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).transmition==Transmition.seatransfer){
                seatransfer.add(packages.get(i));
            }
        }
        for (int i = 0; i < seatransfer.size(); i++) {
            System.out.println(seatransfer.get(i).name);
        }
    }
    public void searchByStatus(Status status){
        ArrayList<Package> spackages = new ArrayList<>();
        switch (status){
            case notreceived:
                for (int i = 0; i < packages.size(); i++) {
                    if (packages.get(i).status==Status.notreceived)
                        spackages.add(packages.get(i));
                }
            case notsent:
                for (int i = 0; i < packages.size(); i++) {
                    if (packages.get(i).status==Status.notsent)
                        spackages.add(packages.get(i));
                }
            case received:
                for (int i = 0; i < packages.size(); i++) {
                    if (packages.get(i).status==Status.received)
                        spackages.add(packages.get(i));
                }
        }
        for (int i = 0; i < spackages.size(); i++) {
            System.out.println(spackages.get(i).name);
        }
    }
    public enum Transmition{
        airtransfer,landtransfer,seatransfer
    }
    public enum Sendtype{
        special,normal
    }
    public enum Status{
        notsent,notreceived,received
    }

    private static ArrayList<Package> packages= new ArrayList<>();
    private String name;
    private Customer sender,receiver;
    private City origin,destination;
    private City currentcity;
    private int weight;
    private Date sendtime,receivetime;
    private Transmition transmition;
    private Sendtype sendtype;
    private Status status= Status.notsent;

    public static ArrayList<Package> getPackages() {
        return packages;
    }

    public static void setPackages(ArrayList<Package> packages) {
        Package.packages = packages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getSend() {
        return sendtime;
    }

    public void setSend(Date send) {
        this.sendtime = send;
    }

    public Date getReceive() {
        return receivetime;
    }

    public void setReceive(Date receive) {
        this.receivetime = receive;
    }

    public Transmition getTransmition() {
        return transmition;
    }

    public void setTransmition(Transmition transmition) {
        this.transmition = transmition;
    }

    public Package(){

    }

    public Package(String name, Customer sender, Customer receiver, City origin, City destination, int weight, Date send, Date receive, Transmition transmition) {
        packages.add(this);
        this.name = name;
        this.sender = sender;
        this.receiver = receiver;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.sendtime = send;
        this.receivetime = receive;
        this.transmition = transmition;
    }

}
