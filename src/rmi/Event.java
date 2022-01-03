/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author pc
 */
public class Event implements subject {
    private int eventID;
    private String eventName;
    private Date eventDate;
    private Event_Request eventRequest;
    private Reservee eventHost;
    private boolean Public;
    private String eventAnnouncement;
    private Venue evetVenue;

    private ArrayList<Visitor> visitors = new ArrayList();
    private ArrayList<Feedback> feedback = new ArrayList();
    private ArrayList<Service> ThirdPartyCompany = new ArrayList();
    private List<Observer> observers = new ArrayList<Observer>();

    public Event(int eventID, String eventName, Date eventDate, Event_Request eventRequest, Reservee eventHost,
            boolean Public, String eventAnnouncement, Venue evetVenue) {
        this.eventID = eventID;
        this.eventName = eventName;
        // this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.eventRequest = eventRequest;
        this.eventHost = eventHost;
        this.Public = Public;
        this.eventAnnouncement = eventAnnouncement;
        this.evetVenue = evetVenue;
        observers = new ArrayList<Observer>();
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventRequest(Event_Request eventRequest) {
        this.eventRequest = eventRequest;
    }

    public void setEventHost(Reservee eventHost) {
        this.eventHost = eventHost;
    }

    public void setPublic(boolean Public) {
        this.Public = Public;
    }

    public void setEvetVenue(Venue evetVenue) {
        this.evetVenue = evetVenue;
    }

    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void setFeedback(ArrayList<Feedback> feedback) {
        this.feedback = feedback;
    }

    public void setThirdPartyCompany(ArrayList<Service> ThirdPartyCompany) {
        this.ThirdPartyCompany = ThirdPartyCompany;
    }

    public ArrayList<Service> getThirdPartyCompany() {
        return ThirdPartyCompany;
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public Event_Request getEventRequest() {
        return eventRequest;
    }

    public Reservee getEventHost() {
        return eventHost;
    }

    public boolean isPublic() {
        return Public;
    }

    public String getEventAnnouncement() {
        return eventAnnouncement;
    }

    public Venue getEvetVenue() {
        return evetVenue;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public ArrayList<Feedback> getFeedback() {
        return feedback;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void invite() {
        boolean existuser = false;
        int invitedUserIndex = -1;
        String invitedUserName;
        int inviteduserID;
        System.out.println("pls enter the name of user you want to invite :");
        Scanner inviteduserObj = new Scanner(System.in);
        String inviteduser;
        inviteduser = inviteduserObj.nextLine();
        if (inviteduser.equals(eventHost.getName())) {
            System.out.println("you cant invite yourself ");
        } else {
            for (int i = 0; i < visitors.size(); i++) {
                invitedUserIndex = -1;
                invitedUserName = visitors.get(i).getName();
                if (inviteduser.equals(visitors.get(i).getName())) {
                    invitedUserIndex = i;
                    // inviteduserID=visitors.get(i).getUserID() -1;
                    existuser = true;
                    break;
                }
            }

            if (existuser) {
                Invite inv = new Invite(this, eventHost, Visitor.get(invitedUserIndex));
                Visitor.get(invitedUserIndex).invites.add(inv);
                System.out.println(invitedUserName + " has been invited ");
                existuser = false;
            } else {
                System.out.println("There is no user called " + inviteduser);
            }
        }
    }

    public void kickVisitor() {
        boolean existuser = false;
        int invitedUserIndex = -1;
        int invitedUserName;
        int inviteduserID;
        System.out.println("pls enter the name of user you want to kick :");
        Scanner inviteduserObj = new Scanner(System.in);
        String inviteduser;
        inviteduser = inviteduserObj.nextLine();
        if (inviteduser.equals(eventHost.getName())) {
            System.out.println("you cant invite yourself ");
        } else {
            if (inviteduser.equals(visitors.get(i).getName())) {
                // inviteduserID=visitors.get(i).getUserID() -1;
                existuser = true;
                invitedUserIndex = visitors.indexOf(inviteduser);
                invitedUserName = visitors.get(invitedUserIndex).getName();
                break;
            }

            if (existuser) {
                visitors.remove(invitedUserIndex);
                int invitationIndex = visitors.get(invitedUserIndex).getAcceptedInvites(indexOf(eventName));
                visitors.get(invitedUserIndex).getAcceptedInvites().remove(invitationIndex);
                System.out.println(invitedUserName + " has been kicked ");
                existuser = false;
            } else {
                System.out.println("There is no visitor called " + inviteduser);
            }
        }

    }

    public void requestService(Service s) {
    }

    //////////////// oberver////////////
    public void setEventAnnouncement(String eventAnnouncement) {
        this.eventAnnouncement = eventAnnouncement;
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void registerObserver(event.managment.system.Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void notifyAllObservers(event.managment.system.Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void registerObserver(rmi.Observer o) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyAllObservers(rmi.Observer o) {
        // TODO Auto-generated method stub

    }
}
