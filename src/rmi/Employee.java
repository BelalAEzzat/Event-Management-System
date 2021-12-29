
package rmi;

import java.util.*;  

public class Employee extends User {
    
    private int Salary ;
    private String Departement ;

    public Employee(int Salary, String Departement, String Name, String Password, String Email_Address) {
        super(Name, Password, Email_Address);
        this.Salary = Salary;
        this.Departement = Departement;
    }
    
    public void NotifyUser(User U , String S)
    {
      
       Notifications.add(S);
       System.out.print("A notification has been sent to the user"); 
       
    }
    
    
  //  public void IssueMentainance(Venue V)
   // {
        // Change the Status of the Venue to Maintenance
        // V.setStatus("Maintenance");
    
        // Notify the users about it
        
  //  }
    
   // public void ReviewEventRequests(EventRequests)
   // {
    // The system should print out the list of requests and the employee
    // for(int i = 0 ; i <)
    
  //  }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String Departement) {
        this.Departement = Departement;
    }
}
