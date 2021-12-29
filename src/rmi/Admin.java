package rmi;

import java.util.ArrayList;

public class Admin extends User {

    public static Admin oneAdmin;
    // Change from String Type to EventRequests when it's completed.
    ArrayList<String> EventRequests = new ArrayList<String>();
    ArrayList<String> Veneues = new ArrayList<String>();

    @Override
    public String toString() {
        return "Admin{" + "EventRequests=" + EventRequests + '}';
    }

    private Admin(String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
    }

    public static Admin getInstance() {
        if (oneAdmin == null) {
            oneAdmin = new Admin("Zyad", "NotYourBussiness", "zyad184823@bue.edu.eg");
        }
        return oneAdmin;
    }

    // Venue Arraylist should be created first
    // public void addVenue(Venue V)
    //{
    // 
    //Veneus.add(V);
    //}
}
