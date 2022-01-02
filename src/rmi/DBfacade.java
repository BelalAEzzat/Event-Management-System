/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author pc
 */
public class DBfacade extends UnicastRemoteObject implements DBinterface {

    DB db;

    public DBfacade() throws RemoteException {
        this.db = DB.getinstance();

    }

    @Override
    public boolean loginAdmin(String Email, String password) throws RemoteException {
        if (!(db.loginAdmin(Email, password) == null)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean loginEmployee(String Email, String password) throws RemoteException {
        if (db.loginemEmployee(Email, password) != null) {
               System.out.println("true");
            
            return true;
         
        }
        return false;
    }

    @Override
    public boolean loginClient(String Email, String password) throws RemoteException {
        if (db.loginVisitor(Email, password) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void registorEmployee(String Email, String password) throws RemoteException {
        Employee e=new Employee(0, "Main", "Null", password, Email);
        db.insertEmployee(e);
    }

}
