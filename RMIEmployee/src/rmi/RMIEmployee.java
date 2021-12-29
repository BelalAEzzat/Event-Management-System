/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RMIEmployee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(500);

            // Search for the stub "calc"
            PaymentMethodInterface d = (PaymentMethodInterface) registry.lookup("calc");
            d.RefundMoney(0);
         
        } catch (NotBoundException | RemoteException ex) {
            System.out.println(ex);
        }
    }
    
    
}
