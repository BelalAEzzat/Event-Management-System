/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.security.Provider;
import java.util.ArrayList;


public class Event_Request {
   private Venue venue;
   private String Status;
   private String Descirption;
   private ArrayList<Service> services;
   private PaymentMethod paymentmethod;
   private int fees;

    public Event_Request(Venue venue, String Status, String Descirption, ArrayList<Service> services,  PaymentMethod paymentmethod, int fees) {
        this.venue = venue;
        this.Status = Status;
        this.Descirption = Descirption;
        this.services = services;
        this.paymentmethod = paymentmethod;
        this.fees = fees;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getStatus() {
        return Status;
    }

    public String getDescirption() {
        return Descirption;
    }

    public ArrayList<Service> getServices() {
        return services;
    }


    public PaymentMethod getPaymentmethod() {
        return paymentmethod;
    }

    public int getFees() {
        return fees;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setDescirption(String Descirption) {
        this.Descirption = Descirption;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Event_Request{" + "venue=" + venue + ", Status=" + Status + ", Descirption=" + Descirption + ", services=" + services + ", paymentmethod=" + paymentmethod + ", fees=" + fees + '}';
    }

    public void setPaymentmethod(PaymentMethod paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
   public void calcFees(){
       for(int i=0;i<services.size();i++){
          this.fees=+services.get(i).getPrice();
        }
   }
}
