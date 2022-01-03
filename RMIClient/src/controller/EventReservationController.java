package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import rmi.DBinterface;
import rmi.newLogin;
import rmi.UserMenu;
import rmi.Event_Reservation;
import rmi.ReserveeInterface;
import rmi.ViewEvents;

public class EventReservationController {

    public Event_Reservation gui;
    public Registry r;
    public String Email;
    public String Password;

    public EventReservationController(Event_Reservation gui, Registry r, String Email, String password) {
        this.gui = gui;
        this.r = r;
        this.Email = Email;
        this.Password = password;
  refill();
    }
    public void refill() {
        try {
            ReserveeInterface g = (ReserveeInterface) r.lookup("fac3");
            ArrayList<Integer> VID = new ArrayList<Integer>();
            g.Login(Email, Password);
            System.out.println(g.Test());
            VID = g.getEventsID();
            System.out.println(VID);
          

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
