/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
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
public class MainMenuController {

    public UserMenu gui;
    public Registry r;
    public String email;
    public String Password;

    public MainMenuController(UserMenu gui, Registry r, String Email, String password) {
        this.gui = gui;
        this.r = r;
        this.email = Email;
        this.Password = password;
        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new ReserveEvent(gui, r, email, Password));
        gui.getjButton5().addActionListener(new ViewEvent(gui, r, email, Password));
        gui.getjButton4().addActionListener(new ViewNotificatios());
        gui.getjButton6().addActionListener(new Logout(gui, r));
    }

    private class ReserveEvent implements ActionListener {

        public UserMenu gui;
        public Registry r;
        public String Email;
        public String Password;

        public ReserveEvent(UserMenu gui, Registry r, String Email, String Password) {
            this.gui = gui;
            this.r = r;
            this.Email = Email;
            this.Password = Password;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.dispose();
            Event_Reservation n = new Event_Reservation();
            n.setLocationRelativeTo(null);
            n.setVisible(true);
            EventReservationController gui_controller = new EventReservationController(n, r);
        }
    }

    private static class ViewEvent implements ActionListener {

        public UserMenu gui;
        public Registry r;
        public String Email;
        public String Password;

        public ViewEvent(UserMenu gui, Registry r, String Email, String Password) {
            this.gui = gui;
            this.r = r;
            this.Email = Email;
            this.Password = Password;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.dispose();
            ViewEvents n = new ViewEvents();
            n.show();
            ViewEventsController a = new ViewEventsController(n, r, Email, Password);

        }

    }

    private class ViewNotificatios implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
            // choose Tools | Templates.
        }

    }

    private static class Logout implements ActionListener {

        public UserMenu gui;
        public Registry r;

        public Logout(UserMenu gui, Registry r) {
            this.gui = gui;
            this.r = r;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.dispose();
            newLogin n = new newLogin();
            n.show();
            LoginController a = new LoginController(n, r);

        }

    }
}
