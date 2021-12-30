/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.ArrayList;


public class Reservee extends User {

   public ArrayList<Integer> hostedEvents;
   public ArrayList<Integer> requestedEvents;
   public ArrayList<Integer> upcomingEvents;

   public Reservee(String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
        hostedEvents = new ArrayList<Integer>();
        requestedEvents = new ArrayList<Integer>();
        upcomingEvents = new ArrayList<Integer>();
    }
   
   public void requestEvent(Event event){
   
   
   
   }
   
    
}
