/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author pc
 */
public class Feedback {
    String Feedback;
    String to;
    String Reservee;
    int ID;

    public Feedback(String Feedback, String to, String Reservee, int ID) {
        this.Feedback = Feedback;
        this.to = to;
        this.Reservee = Reservee;
        this.ID = ID;
    }

    public String getFeedback() {
        return Feedback;
    }

    public String getTo() {
        return to;
    }

    public String getReservee() {
        return Reservee;
    }

    public int getID() {
        return ID;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setReservee(String Reservee) {
        this.Reservee = Reservee;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
