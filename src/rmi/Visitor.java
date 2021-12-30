package rmi;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitor extends User {

    private String EventAnnouncement;
    // Change from String Type to Events when it's completed.
    ArrayList<String> Invites;

    ArrayList<String> Accepted_Events;

    ArrayList<String> Visited_Events;

    @Override
    public String toString() {
        return "Visitor{" + "Invites=" + Invites + '}';  
    }

    Scanner sc = new Scanner(System.in);

    public Visitor(String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
        Invites = new ArrayList<String>();

        Accepted_Events = new ArrayList<String>();

        Visited_Events = new ArrayList<String>();
    }

    // Change from String Type to Event when it's completed.
    public void ManageInvites() {
        for (int i = 0; i < this.Invites.size(); i++) {
            System.out.println(i + "" + this.Invites.get(i) + "\n");
        }
        System.out.print("Enter the number of the event that you wish to manage \n");
        int choice = sc.nextInt();

        for (int i = 0; i < this.Invites.size(); i++) {
            if (choice == i) {
                System.out.println("Press 1 to Aceept , 2 to Decline");
                int choice2 = sc.nextInt();

                if (choice2 == 1) {
                    //Event E =  this.Invites.get(i).getEvent();
                    // Accepted_Events.add(E) ;
                    //E.Visitors(this);
                    System.out.println("You have accepted the invitation");
                } else if (choice2 == 2) {
                    System.out.println("You have declinted the invitation");
                } else {
                    System.out.println("You have entered a wrong number");
                }

            } else {
                System.out.println("The number you have entered doesn't refer to an invite");
                ManageInvites();
            }
        }
    }

    // Change from String Type to Event when it's completed.
    public void GiveFeedBack(String F) {

        // Print all the accepted events
        for (int i = 0; i < Accepted_Events.size(); i++) {
            System.out.println(i + "" + Accepted_Events.get(i));
        }

        System.out.println("");
        int choice3 = sc.nextInt();

        for (int i = 0; i < Accepted_Events.size(); i++) {
            if (choice3 == i)
            // Accepted_Events.get(i).feedback.add(F);
             ;

        }

        // Store it to Feedback class
    }

    public void ViewAllpublicEvents() {
        //retrieve from database

    }

    public void joinPublicEvent() {

        ViewAllpublicEvents();
        // Dependent on ViewpublicEvents

    }

}
