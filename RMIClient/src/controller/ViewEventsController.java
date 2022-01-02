/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author pc
 */
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
import rmi.ViewEvents;
import rmi.ReserveeInterface;
/**
 * /**
 *
 * @author pc
 */
public class ViewEventsController {
    public UserMenu gui;
    public Registry r;
    public String email;
    public String Password;

    public ViewEventsController(UserMenu gui, Registry r, String Email, String password) {
        this.gui = gui;
        this.r = r;
        this.email=Email;
        this.Password=password;
        refill();
        // This registers the button with our action listener below (the inner class)
   
    }

    public void refill(){
    try {
            ReserveeInterface g = (ReserveeInterface) r.lookup("fac3");
            ArrayList<Integer> VID = new ArrayList<Integer>();
            g.Login(email, Password);
            VID=g.getEventsID();
            System.out.println(VID);
          
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
}
