/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class EvenManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DB db = DB.getinstance();
        Date g=new Date(5,3, 2000);
        Event_Request rq=new Event_Request(null, "sadf", "asdf", null, null, 0);
        Employee e = new Employee(0, "aas", "asd", "emp", "emp");
        Venue xm=new Venue("Asfed", "asdf", 0);
        Reservee mk= db.LoginReservee("belal", "belal");
        Event a=new Event( 43,"name", g, rq, mk, true, "asdf", xm);
        db.insertEvent(a);
     
        try {
            // My remote object [Skeleton]
            AdminInterface facade = new AdminFacade();
            DBinterface facade2 = new DBfacade();
            ReserveeInterface facade3=new ClientFacade();

            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);

            //Add my object to the RMI Registry
            registry.bind("fac", facade);
            registry.bind("fac2", facade2);
            registry.bind("fac3", facade3);

            System.out.println("My facade is ready...");
        } catch (Exception ex) {
            System.out.println("Exception occured here ");
        }
    }
}
