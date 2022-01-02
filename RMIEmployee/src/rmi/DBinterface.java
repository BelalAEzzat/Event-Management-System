/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.RemoteException;

/**
 *
 * @author pc
 */
public interface DBinterface extends Remote {
    public boolean loginAdmin(String Email, String password) throws RemoteException ;
    public boolean loginEmployee(String Email, String password) throws RemoteException;
    public boolean loginClient(String Email, String password) throws RemoteException;
}
