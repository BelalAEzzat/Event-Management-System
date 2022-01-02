/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

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

    public ArrayList<String> getCompaniesOfVenueIndex(int i) throws RemoteException;

    public void updateVenue(int i,String name,String location,int maxC) throws RemoteException;

    public int addCompanyByVenueIndex(int i,String Name) throws RemoteException;
    
    public void addCompany(String Name,String type) throws RemoteException;
    
    public void removeVenue(int i) throws RemoteException;
    
    public void removeCompany(int i) throws RemoteException;
    
    public String getCompanybyIndex(int i) throws RemoteException;
    
    public int findIndexofCompanyByName(String name) throws RemoteException;
    
    public void removeCompanyByIndexs(int i,int j) throws RemoteException;
}
