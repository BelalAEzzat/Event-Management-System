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
import rmi.AdminInterface;
import rmi.newAdminMenu;
import rmi.newLogin;
import rmi.AdminInterface;

/**
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
        
        gui.getjButton3().addActionListener(new btn3lisnter);

    }
    public class btn3lisnter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
   try{
            String email = gui.getEmail_textfield().getText();
            String password = gui.getPass_textfield().getText();
            a = db.loginAdmin(email, password);       
            
            if(a !=null){
                new AdminMenu().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Wrong Username/Password");
            }
        
        }catch(Exception e){
            System.out.println(e);;
        }

        }
    
    
    }
}
