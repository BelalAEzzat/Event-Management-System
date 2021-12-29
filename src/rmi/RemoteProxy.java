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
public class RemoteProxy extends UnicastRemoteObject implements PaymentMethodInterface  {
    private PaymentMethod paymentmethod;
    

    public RemoteProxy(PaymentMethod paymentmethod)throws RemoteException {
        this.paymentmethod = paymentmethod;
    }
  
    
    @Override
    public void payFees(int amount) throws RemoteException {
        System.out.println("lol");    }


    
    public void RefundMoney(int amount) throws RemoteException {
        System.out.println("k");;
    }
    
}
