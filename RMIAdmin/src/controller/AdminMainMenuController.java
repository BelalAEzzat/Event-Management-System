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
import javax.swing.JOptionPane;
import rmi.newAdminMenu;
import rmi.AdminInterface;
import rmi.RMIAdmin;
import rmi.create_Service;
import rmi.add_Venue;
import rmi.newLogin;

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
            refill();
            refillArea();
            gui.getjComboBox1().addActionListener(new getcombobutnAct());
            gui.getjButton3().addActionListener(new saveBtn());
            gui.getjButton5().addActionListener(new addVenue());
            gui.getjButton7().addActionListener(new createService());
            gui.getjButton4().addActionListener(new logOut(gui));
            gui.getjButton6().addActionListener(new removeVenue(gui));
            gui.getjButton8().addActionListener(new DeleteCompany(gui));
            gui.getjButton1().addActionListener(new addCompanytoVenue(gui));
            gui.getjButton2().addActionListener(new removeCompanyfromVenue(gui));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void refill() {

        try {
            AdminInterface g = (AdminInterface) r.lookup("fac");
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

    public void refillArea() {

        try {
            AdminInterface g = (AdminInterface) r.lookup("fac");
            int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
            ArrayList<String> lst = g.getCompaniesOfVenueIndex(i);

            gui.getjTextArea1().setText(null);

            for (String s : lst) {
                if (!s.equals("")) {
                            gui.getjTextArea1().append(s + "\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    class getcombobutnAct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
                gui.getjTextField1().setText(g.getVenueName(i));
                gui.getjTextField2().setText(g.getVenuelocation(i));
                gui.getjTextField3().setText(String.valueOf(g.getVenueMAxCapacity(i)));

                ArrayList<String> lst = g.getCompaniesOfVenueIndex(i);
                gui.getjTextArea1().setText("");
                if (lst != null) {
                    for (String s : lst) {
                        if (!s.equals("")) {
                            gui.getjTextArea1().append(s + "\n");
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class saveBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
                String name = gui.getjTextField1().getText();
                String location = gui.getjTextField2().getText();
                int maxCapacity = Integer.valueOf(gui.getjTextField3().getText());

                g.updateVenue(i, name, location, maxCapacity);

                System.out.println("Saved!");
                 JOptionPane.showMessageDialog(gui, "saved successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class addVenue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                System.out.println("Adding venue");
                add_Venue g = new add_Venue();
                g.setVisible(true);
                g.setLocationRelativeTo(null);
                g.getSubmit().addActionListener(new read_add_venue(g));

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    class read_add_venue implements ActionListener {

        add_Venue gu;

        public read_add_venue(add_Venue gu) {

            this.gu = gu;

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("Saving Venue");
                String name = gu.getjTextField1().getText();
                String location = gu.getjTextField2().getText();
                int maxCapacity = Integer.valueOf(gu.getjTextField3().getText());

                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexOfVenueByname(name);
                if (i != -1) {
                    JOptionPane.showMessageDialog(gu, "Already Added");
                } else {
                    g.AddVenue(name, location, maxCapacity);
                    gu.dispose();
                    refill();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class createService implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                System.out.println("Adding Service");
                create_Service g = new create_Service();
                g.setVisible(true);
                g.setLocationRelativeTo(null);
                g.getjButton1().addActionListener(new read_create_service(g));

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    class read_create_service implements ActionListener {

        create_Service gu;

        public read_create_service(create_Service gu) {
            this.gu = gu;

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("Saving Service");
                String name = gu.getjTextField1().getText();
                String type = gu.getjTextField2().getText();

                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexofCompanyByName(name);
                System.out.println(i);
                if (i != -1) {
                    JOptionPane.showMessageDialog(gu, "Already Added");
                } else {
                    g.addCompany(name, type);
                    gu.dispose();
                    refill();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class logOut implements ActionListener {

        newAdminMenu gui;

        public logOut(newAdminMenu gui) {
            this.gui = gui;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                gui.dispose();

                newLogin guiX = new newLogin();
                guiX.setLocationRelativeTo(null); // This makes the window appears centered
                guiX.setVisible(true); // This shows the gui

                LoginController gui_controller = new LoginController(guiX, r);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class removeVenue implements ActionListener {

        newAdminMenu gui;

        public removeVenue(newAdminMenu gui) {
            this.gui = gui;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("Removing venue");
                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
                String vName = g.getVenueName(i);
                g.removeVenue(i);

                for (int j = 0; j < gui.getjComboBox1().getItemCount(); j++) {
                    if (vName.equals(gui.getjComboBox1().getItemAt(j))) {
                        gui.getjComboBox1().removeItemAt(j);
                    }
                }

                gui.getjTextField1().setText("");
                gui.getjTextField2().setText("");
                gui.getjTextField3().setText("");

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class DeleteCompany implements ActionListener {

        newAdminMenu gui;

        public DeleteCompany(newAdminMenu gui) {
            this.gui = gui;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("Removing Company");
                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexofCompanyByName((String) gui.getjComboBox2().getSelectedItem());
                String cName = g.getCompanybyIndex(i);
                g.removeCompany(i);

                for (int j = 0; j < gui.getjComboBox2().getItemCount(); j++) {
                    if (cName.equals(gui.getjComboBox2().getItemAt(j))) {
                        gui.getjComboBox2().removeItemAt(j);
                    }
                }

                gui.getjTextField1().setText("");
                gui.getjTextField2().setText("");
                gui.getjTextField3().setText("");

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    class removeCompanyfromVenue implements ActionListener {

        newAdminMenu gui;

        public removeCompanyfromVenue(newAdminMenu gui) {
            this.gui = gui;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("Removing Company");
                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
                int j = g.findIndexofCompanyByName((String) gui.getjComboBox2().getSelectedItem());
                g.removeCompanyByIndexs(i, j);
                refillArea();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    
    class addCompanytoVenue implements ActionListener{

        newAdminMenu gui;

        public addCompanytoVenue(newAdminMenu gui) {
            this.gui = gui;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("adding Company");
                AdminInterface g = (AdminInterface) r.lookup("fac");
                int i = g.findIndexOfVenueByname((String) gui.getjComboBox1().getSelectedItem());
                int r = g.addCompanyByVenueIndex(i, (String) gui.getjComboBox2().getSelectedItem());
                if(r == -1){
                    JOptionPane.showMessageDialog(gui, "Already Added");
                }
                
                refillArea();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
