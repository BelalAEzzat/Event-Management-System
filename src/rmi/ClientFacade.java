/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pc
 */
public class ClientFacade extends UnicastRemoteObject implements ReserveeInterface {

    Reservee r;
    Visitor V;

    public ClientFacade() throws RemoteException {
        r = new Reservee("", "", "");
        V = new Visitor("", "", "");
    }

    @Override
    public ArrayList<Integer> getEventsID() throws RemoteException {

        return r.getUpcomingEvents();
    }

    @Override
    public String getEventName(int ID) throws RemoteException {
        DB db = DB.getinstance();
        Event a = db.findEventByID(ID);
        return a.getEventName();

    }

    @Override
    public Date GetEventDate(int ID) throws RemoteException {
        DB db = DB.getinstance();
        Event a = db.findEventByID(ID);
        return a.getEventDate();
    }

    @Override
    public String getVenueName(int iD) throws RemoteException {
        DB db = DB.getinstance();
        Event a = db.findEventByID(iD);
        return a.getEvetVenue().getVenueName();
    }

    @Override
    public ArrayList<String> getvisitors(int ID) throws RemoteException {
        DB db = DB.getinstance();
        Event a = db.findEventByID(ID);
        ArrayList<String> n = new ArrayList<>();
        for (int i = 0; i < a.getVisitors().size(); i++) {
            n.add(a.getVisitors().get(i).getEmail_Address());
        }
        return n;
    }

    @Override
    public Void KickVisior(String Email, int ID) throws RemoteException {
        DB db = DB.getinstance();
        Event a = db.findEventByID(ID);
        for (int i = 0; i < a.getVisitors().size(); i++) {
            if (a.getVisitors().get(i).getName().equals(Email)) {
                a.getVisitors().remove(i);
            }

        }
        return null;
    }

    @Override
    public String SendAnnouncment(int ID, String Announcment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> getHostedEventIDs(String Email) throws RemoteException {
        return r.getHostedEvents();
    }

    @Override
    public ArrayList<String> GetEventFeedback(int ID) throws RemoteException {
           DB db = DB.getinstance();
        Event a = db.findEventByID(ID);
        ArrayList<String> n = new ArrayList<>();
        for (int i = 0; i < a.getFeedback().size(); i++) {
            n.add(a.getFeedback().get(i).getFeedback());
        }
        return n;
    }

    @Override
    public void Login(String Email, String Password) throws RemoteException {
        DB db = DB.getinstance();
        r = db.LoginReservee(Email, Password);
        V = db.loginVisitor(Email, Password);
        System.out.println(r.getUpcomingEvents());

    }

    @Override
    public String Test() throws RemoteException {
        String s="test";
        return s;
    }
}
