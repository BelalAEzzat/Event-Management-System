
package rmi;
import java.util.ArrayList;

public class Admin extends User {
    
    static Admin oneAdmin;
    
    private ArrayList<Event_Request> EventRequests;
    private ArrayList<Venue> Venues;
    private ArrayList<ThirdPartyCompany> ThirdPartyCompanies;
    @Override
    public String toString() {
        return "Admin{" + "EventRequests=" + EventRequests + '}';
    }

    public static Admin getOneAdmin() {
        return oneAdmin;
    }

    public ArrayList<Event_Request> getEventRequests() {
        return EventRequests;
    }

    public ArrayList<Venue> getVenues() {
        return Venues;
    }

    public static void setOneAdmin(Admin oneAdmin) {
        Admin.oneAdmin = oneAdmin;
    }

    public void setEventRequests(ArrayList<Event_Request> EventRequests) {
        this.EventRequests = EventRequests;
    }

    public void setVenues(ArrayList<Venue> Venues) {
        this.Venues = Venues;
    }

    public void setThirdPartyCompanies(ArrayList<ThirdPartyCompany> ThirdPartyCompanies) {
        this.ThirdPartyCompanies = ThirdPartyCompanies;
    }
    
    
     

    private Admin(String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
        Venues = new ArrayList<Venue>();
        EventRequests = new ArrayList<Event_Request>();
        ThirdPartyCompanies = new ArrayList<ThirdPartyCompany>();
        
    }

    public ArrayList<ThirdPartyCompany> getThirdPartyCompanies() {
        return ThirdPartyCompanies;
    }
    public void addVenue(Venue a){
        DB db=DB.getinstance();
        Venues.add(a);
        db.UpdateAdmin();
    }
     public void addEventRequests(Event_Request a){
        DB db=DB.getinstance();
        EventRequests.add(a);
        db.UpdateAdmin();
    }
      public void addThirdPartyCompanies(ThirdPartyCompany a){
          DB db=DB.getinstance();
        ThirdPartyCompanies.add(a);
        db.UpdateAdmin();
    }
   
   public static Admin getInstance(){
    
    if(oneAdmin == null){
        DB db=DB.getinstance();
        if(db.loginAdmin("admin@mail.com", "admin")!= null){
            oneAdmin = db.loginAdmin("admin@mail.com", "admin");
        }
        else{
            oneAdmin = new Admin("admin","admin","admin@mail.com");
            db.UpdateAdmin();
        }
    }
        return oneAdmin;
    }
}   
  
   // Venue Arraylist should be created first
   
  // public void addVenue(Venue V)
   //{
   // 
       //Veneus.add(V);
   //}
    
    

    