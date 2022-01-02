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
import rmi.newLogin ;
import rmi.UserMenu;
/**
 * 
         *
         * @author pc
         */

public class LoginController {

    newLogin gui;
    Registry r;

    public LoginController(newLogin gui, Registry r) {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)

        gui.getjButton1().addActionListener(new btn3lisnter());
        gui.getjButton2().addActionListener(new btn2lisnet());
    }

    public class btn3lisnter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                DBinterface g = (DBinterface) r.lookup("fac2");

                String email = gui.getEmail_textfield().getText();
                String password = gui.getPass_textfield().getText();
                boolean a = g.loginClient(email, password);
                System.out.println(a);
                if (a == true) {
                    gui.dispose();
                    UserMenu x=new UserMenu();
                    x.show();
                    MainMenuController m=new MainMenuController(x, r, email, password);

                } else {
                    JOptionPane.showMessageDialog(gui, "Wrong Username/Password");
                }

            } catch (Exception e) {
                System.out.println(e);;
                
            }

        }

    }
    public class btn2lisnet implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {   
            try {
                DBinterface g = (DBinterface) r.lookup("fac2");
                String email = gui.getEmail_textfield().getText();
                String password = gui.getPass_textfield().getText();
                if(email.equals("")||password.equals("")){
                JOptionPane.showMessageDialog(gui, "Insert Email/Password");
                
                }else{
                g.registorClient(email, password);
                JOptionPane.showMessageDialog(gui, "you are now registerd");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
}
