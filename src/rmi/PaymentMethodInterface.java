/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pc
 */
public interface PaymentMethodInterface extends Remote{
    public void payFees(int amount)throws RemoteException;
    public void RefundMoney(int amount)throws RemoteException;
    
}
