package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Admin extends UnicastRemoteObject implements AdminInterface {

    public static Admin oneAdmin;

    ArrayList<Event_Request> EventRequests;
    public ArrayList<Venue> Venues;
    public ArrayList<ThirdPartyCompany> ThirdPartyCompanies;
    private String Name,  Password,  Email_Address;


    public ArrayList<Venue> getVenues()throws RemoteException {
        return Venues;
    }

    private Admin() throws RemoteException{
    

    }

    public void setName(String Name) throws RemoteException{
        this.Name = Name;
    }

    public void setPassword(String Password) throws RemoteException{
        this.Password = Password;
    }

    public void setEmail_Address(String Email_Address)throws RemoteException{
        this.Email_Address = Email_Address;
    }

    public String getName() throws RemoteException{
        return Name;
    }

    public String getPassword() throws RemoteException{
        return Password;
    }

    public String getEmail_Address()throws RemoteException {
        return Email_Address;
    }

    public ArrayList<ThirdPartyCompany> getThirdPartyCompanies()throws RemoteException {
        return ThirdPartyCompanies;
    }

    public void addVenue(Venue a) throws RemoteException{
        DB db = DB.getinstance();
        Venues.add(a);
        db.UpdateAdmin();
    }

    public void addEventRequests(Event_Request a) throws RemoteException{
        DB db = DB.getinstance();
        EventRequests.add(a);
        db.UpdateAdmin();
    }

    public void addThirdPartyCompanies(ThirdPartyCompany a) throws RemoteException{
        DB db = DB.getinstance();
        ThirdPartyCompanies.add(a);
        db.UpdateAdmin();
    }

    public static Admin getInstance()throws RemoteException {

        if (oneAdmin == null) {
            DB db = DB.getinstance();
            if (db.loginAdmin("admin@mail.com", "admin") != null) {
                oneAdmin = db.loginAdmin("admin@mail.com", "admin");
            } else {
                oneAdmin = new Admin("admin", "admin", "admin@mail.com");
                db.UpdateAdmin();
            }
        }
        return oneAdmin;
    }

    @Override
    public String getVenueName(int index) throws RemoteException{
        return Venues.get(index).getVenueName();
    }

    @Override
    public String getVenuelocation(int index)throws RemoteException {
        return Venues.get(index).getVenuelocation();
    }

    @Override
    public int getVenueMAxCapacity(int index) throws RemoteException{
        return Venues.get(index).getVenueMAxCapacity();
    }

    @Override
    public String ThirdPartyCopmanygetName(int index)throws RemoteException {
        return ThirdPartyCompanies.get(index).getName();
    }

    @Override
    public String ThirdPartyCopmanygetType(int index) throws RemoteException{
        return ThirdPartyCompanies.get(index).getType();
    }

    @Override
    public void AddVenue(String venueName, String venuelocation, int venueMAxCapacity) throws RemoteException{
        Venue v= new Venue(venueName, venuelocation, venueMAxCapacity);
        Venues.add(v);
    }

    @Override
    public Void UpdateAdmin()throws RemoteException {
        DB db=DB.getinstance();
        db.UpdateAdmin();
        return null;
    }

    

}
