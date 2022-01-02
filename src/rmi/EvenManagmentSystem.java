/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class EvenManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try {
            // My remote object [Skeleton]
            AdminInterface c = Admin.getInstance();
            
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(2000);
            
            //Add my object to the RMI Registry
            registry.bind("calc", c);
            System.out.println("My calculator is ready...");   
        } catch (Exception ex) {
           System.out.println("Exception occured");
        }      
     // Here we create our remote object
      
        
    }
}
