package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
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
    private ArrayList<String> ServicesChosen;
    

    public EventReservationController(Event_Reservation gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        try{
            ReserveeInterface g = (ReserveeInterface) r.lookup("fac3");
            for(String s:g.getVenues()){
                gui.getjComboBox1().addItem(s);
            }
            
            for(String s:g.getCompanies()){
                gui.getjComboBox3().addItem(s);
            }
            
            
            
            gui.getButton1().addActionListener(new ReserveEvent());
            gui.getjButton1().addActionListener(new add());
            
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
    private class ReserveEvent implements ActionListener {
        private String vName;
        private String nameChosen;
        private boolean isPublic;
        private int cardNumber;
        private int CCV;
        private Date dateChosen;
        private String bank;
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
            ReserveeInterface g = (ReserveeInterface) r.lookup("fac3");
            vName = (String)gui.getjComboBox1().getSelectedItem();
            nameChosen = gui.getjTextField1().getText();
            isPublic = gui.getjCheckBox1().isSelected();
            cardNumber = Integer.valueOf(gui.getjTextField4().getText());
            CCV = Integer.valueOf(gui.getjTextField5().getText());
            dateChosen = gui.getjCalendar1().getDate();
            bank = (String)gui.getjComboBox2().getSelectedItem();
            
            g.reserveEvent(vName,ServicesChosen,bank,cardNumber,CCV,isPublic,dateChosen);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
  
    private class add implements ActionListener {
    
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
            
                String service = (String)gui.getjComboBox3().getSelectedItem();
                ServicesChosen.add(service);
                gui.getjTextArea2().append(service+"\n");

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

}
