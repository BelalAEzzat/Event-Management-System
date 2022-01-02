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
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < r.getUpcomingEvents().size(); i++) {
            a.add(r.getUpcomingEvents().get(i).getEventID());
        }
        return a;
    }

    @Override
    public String getEventName(int ID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date GetEventDate(int ID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getVenueName(int iD) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getvisitors(int ID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void KickVisior(String Email) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String SendAnnouncment(int ID, String Announcment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> getHostedEventIDs(String Email) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> GetEventFeedback(int ID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Login(String Email, String Password)throws RemoteException {
        DB db = DB.getinstance();
        r = db.LoginReservee(Email, Password);
        V = db.loginVisitor(Email, Password);
        System.out.println(r.getUpcomingEvents());

    }
}
