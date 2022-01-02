/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author pc
 */
public class AdminFacade extends UnicastRemoteObject implements AdminInterface {

    public AdminFacade() throws RemoteException {
        a = Admin.getInstance();
    }
    Admin a;

    @Override
    public String getVenueName(int index) throws RemoteException {
        return a.Venues.get(index).getVenueName();
    }

    @Override
    public String getVenuelocation(int index) throws RemoteException {
        return a.Venues.get(index).getVenuelocation();
    }

    @Override
    public int getVenueMAxCapacity(int index) throws RemoteException {
        return a.Venues.get(index).getVenueMAxCapacity();
    }

    @Override
    public String ThirdPartyCopmanygetName(int index) throws RemoteException {
        return a.ThirdPartyCompanies.get(index).getName();
    }

    @Override
    public String ThirdPartyCopmanygetType(int index) throws RemoteException {
        return a.ThirdPartyCompanies.get(index).getType();
    }

    @Override
    public void AddVenue(String venueName, String venuelocation, int venueMAxCapacity) throws RemoteException {
        Venue v = new Venue(venueName, venuelocation, venueMAxCapacity);
        a.Venues.add(v);
    }

    @Override
    public Void UpdateAdmin() throws RemoteException {
        DB db = DB.getinstance();
        db.UpdateAdmin();
        return null;
    }

    @Override
    public int findIndexOfVenueByname(String N) throws RemoteException {
        for (int i = 0; i < a.Venues.size(); i++) {

            if (N.equals(a.Venues.get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getVenueSize() throws RemoteException {
        return a.Venues.size();
    }

    @Override
    public int getThirdpartyCompanySize() throws RemoteException {
        return a.ThirdPartyCompanies.size();
    }
}
