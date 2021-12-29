/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author pc
 */
public class Bank {

    private String Name;
    private int AccountNumber;

    public Bank(String Name, int AccountNumber) {
        this.Name = Name;
        this.AccountNumber = AccountNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void WithdrawMoney(String comment) {
        System.out.println("send money to" + AccountNumber + comment);
    }

    public void RefundMoney(String comment) {
        System.out.println("send money from" + AccountNumber + comment);
    }
}
