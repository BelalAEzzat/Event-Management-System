/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pc
 */
public interface ReserveeInterface extends Remote {

    public ArrayList<Integer> getEventsID()throws RemoteException;

    public String getEventName(int ID)throws RemoteException;

    public Date GetEventDate(int ID)throws RemoteException;

    public String getVenueName(int iD)throws RemoteException;

    public ArrayList<String> getvisitors(int ID)throws RemoteException;

    public Void KickVisior(String Email)throws RemoteException;

    public String SendAnnouncment(int ID, String Announcment)throws RemoteException;

    public ArrayList<Integer> getHostedEventIDs(String Email)throws RemoteException;

    public ArrayList<String> GetEventFeedback(int ID)throws RemoteException;
     public  void Login(String Email,String Password)throws RemoteException;
}
