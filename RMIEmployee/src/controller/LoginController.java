/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

import rmi.DBinterface;
import rmi.newLogin;
       

public class LoginController {

    newLogin gui;
    Registry r;

    public LoginController(newLogin gui, Registry r) {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)

        gui.getjButton4().addActionListener(new btn3lisnter());

    }

    public class btn3lisnter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                DBinterface g = (DBinterface) r.lookup("fac2");

                String email = gui.getEmail_textfield().getText();
                String password = gui.getPass_textfield().getText();
                boolean a = g.loginEmployee(email, password);
                System.out.println(a);
                if (a == true) {
                    gui.dispose();
                    

                } else {
                    JOptionPane.showMessageDialog(gui, "Wrong Username/Password");
                }

            } catch (Exception e) {
                System.out.println(e);;
            }

        }

    }
}
