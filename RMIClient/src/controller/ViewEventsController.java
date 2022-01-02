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
        // This registers the button with our action listener below (the inner class)
   
    }

    public void refill(){
    try {
            DBinterface g = (DBinterface) r.lookup("fac2");
            ArrayList<String> Vnames = new ArrayList<String>();
            for (int i = 0; i < gui.getjComboBox1().getItemCount(); i++) {
                Vnames.add(gui.getjComboBox1().getItemAt(i));
            }

            for (int j = 0; j < g.getVenueSize(); j++) {
                if (!Vnames.contains(g.getVenueName(j))) {
                    gui.getjComboBox1().addItem(g.getVenueName(j));
                }
            }

            ArrayList<String> Tnames = new ArrayList<String>();
            for (int i = 0; i < gui.getjComboBox2().getItemCount(); i++) {
                Tnames.add(gui.getjComboBox2().getItemAt(i));
            }
            for (int j = 0; j < g.getThirdpartyCompanySize(); j++) {
                if (!Tnames.contains(g.ThirdPartyCopmanygetName(j))) {
                    gui.getjComboBox2().addItem(g.ThirdPartyCopmanygetName(j));
                }
            }

            int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
            gui.getjTextField1().setText(g.getVenueName(i));
            gui.getjTextField2().setText(g.getVenuelocation(i));
            gui.getjTextField3().setText(String.valueOf(g.getVenueMAxCapacity(i)));

        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
}
