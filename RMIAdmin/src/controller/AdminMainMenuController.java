/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import rmi.newAdminMenu;
import rmi.AdminInterface;

/**
 *
 * @author pc
 */
public class AdminMainMenuController {

    newAdminMenu gui;
    Registry r;

    public AdminMainMenuController(newAdminMenu gui, Registry r) {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        try {
            AdminInterface g = (AdminInterface) r.lookup("fac");

            gui.getjTextField1().setText(g.getVenueName(0));
            gui.getjTextField2().setText(g.getVenuelocation(0));
            gui.getjTextField3().setText(String.valueOf(g.getVenueMAxCapacity(0)));

        } catch (Exception e) {

        }
        gui.getjComboBox1().addActionListener(new getcombobutnAct());

    }

    public void refill() {
       
        try { 
             AdminInterface g = (AdminInterface) r.lookup("fac");
            ArrayList<String> Vnames=new ArrayList<String>();
            for (int i = 0; i < gui.getjComboBox1().getItemCount(); i++) {
              Vnames.add(gui.getjComboBox1().getItemAt(i));
                }
            
            for(int j=0;j<g.getVenueSize();j++)
                    if (!Vnames.contains(g.getVenueName(j))) {
                    gui.getjComboBox1().addItem(g.getVenueName(j));
                    }
            ArrayList<String> Tnames=new ArrayList<String>();
            for (int i = 0; i < gui.getjComboBox2().getItemCount(); i++) {
              Tnames.add(gui.getjComboBox2().getItemAt(i));
                }
               for(int j=0;j<g.getThirdpartyCompanySize();j++)
                    if (!Tnames.contains(g.ThirdPartyCopmanygetName(j))) {
                    gui.getjComboBox2().addItem(g.ThirdPartyCopmanygetName(j));
                    }
        } catch (Exception e) {
        }
    }

    class getcombobutnAct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

        }

    }

}
