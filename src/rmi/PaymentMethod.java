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
public class PaymentMethod  {
   private int CardNumber;
   private int CVCCode;
   private String BankName;
   
    public PaymentMethod(int CardNumber, int CVCCode, String BankName) {
        this.CardNumber = CardNumber;
        this.CVCCode = CVCCode;
        this.BankName = BankName;
    }

  
    public int getCardNumber(){
        return CardNumber;
    }

    public int getCVCCode() {
        return CVCCode;
    }

    public String getBankName(){
        return BankName;
    }

    public void setCardNumber(int CardNumber) {
        this.CardNumber = CardNumber;
    }

    public void setCVCCode(int CVCCode) {
        this.CVCCode = CVCCode;
    }

    public void setBankName(String BankName){
        this.BankName = BankName;
    }
   public void WithDrawMoney(int amount){
      System.out.println("withdraw");

   }
   
   public String RefundMoney(int amount){
       return "anaa";
   }

    public String PayFees(int amount) {
  return "anaa";
    }

    public String payFees(int amount) {
         return "anaa";
    }
}
