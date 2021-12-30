

package rmi;
import java.util.ArrayList;

public class Admin extends User {
    
 public static Admin oneAdmin;
    // Change from String Type to EventRequests when it's completed.
    ArrayList<String> EventRequests;
    ArrayList<Venue> Venues;
    ArrayList<ThirdPartyCompany> ThirdPartyCompanies;
    
    @Override
    public String toString() {
        return "Admin{" + "EventRequests=" + EventRequests + '}';
    }

    public ArrayList<Venue> getVenues() {
        return Venues;
    }
    
    
     

    private Admin(String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
        Venues = new ArrayList<Venue>();
        EventRequests = new ArrayList<String>();
        EventRequests.add("saaas");
        ThirdPartyCompanies = new ArrayList<ThirdPartyCompany>();
    }

    public ArrayList<ThirdPartyCompany> getThirdPartyCompanies() {
        return ThirdPartyCompanies;
    }
    
   
   public static Admin getInstance(){
    if(oneAdmin == null){
    oneAdmin = new Admin("admin" , "admin" , "admin@mail.com");
    }
    return oneAdmin;
    }
   
  
   // Venue Arraylist should be created first
   
  // public void addVenue(Venue V)
   //{
   // 
       //Veneus.add(V);
   //}
    
    

    
}
