/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.ArrayList;


public class Reservee extends User {

   public ArrayList<Event> hostedEvents;
   public ArrayList<Event_Request> requestedEvents;
   public ArrayList<Event> upcomingEvents;

   public Reservee(String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
        hostedEvents = new ArrayList<Event>();
        requestedEvents = new ArrayList<Event_Request>();
        upcomingEvents = new ArrayList<Event>();
    }

    public ArrayList<Event> getHostedEvents() {
        return hostedEvents;
    }

    public ArrayList<Event_Request> getRequestedEvents() {
        return requestedEvents;
    }

    public ArrayList<Event> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setHostedEvents(ArrayList<Event> hostedEvents) {
        this.hostedEvents = hostedEvents;
    }

    public void setRequestedEvents(ArrayList<Event_Request> requestedEvents) {
        this.requestedEvents = requestedEvents;
    }

    public void setUpcomingEvents(ArrayList<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }
   
   public void requestEvent(Event event){
   
   
   
   }
   
    
}
