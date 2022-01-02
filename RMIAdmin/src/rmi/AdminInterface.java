/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pc
 */
public interface AdminInterface extends Remote {

    public String getVenueName(int index) throws RemoteException;

    public String getVenuelocation(int index) throws RemoteException;

    public int getVenueMAxCapacity(int index) throws RemoteException;

    public String ThirdPartyCopmanygetName(int index) throws RemoteException;

    public String ThirdPartyCopmanygetType(int index) throws RemoteException;

    public void AddVenue(String venueName, String venuelocation, int venueMAxCapacity) throws RemoteException;

    public Void UpdateAdmin() throws RemoteException;

    public int findIndexOfVenueByname(String N) throws RemoteException;

    public int getVenueSize() throws RemoteException;

    public int getThirdpartyCompanySize() throws RemoteException;
}
