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
        Admin a = Admin.getInstance();
        DB db = DB.getinstance();
        db.insertAdmin(a);
        Admin b = db.loginAdmin("zyad184823@bue.edu.eg", "NotYourBussiness");
        Venue e = new Venue("sdfasdfa", "aas", 0);
        a.addVenue(e);
        System.out.println();
    }
}
