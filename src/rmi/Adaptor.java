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
public class Adaptor {
    private Bank bank;

    public Adaptor(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public void WithdrawMoney(){
    if(bank.getName().equals("ahly")){
    bank.RefundMoney("from bank Ahly");
    }else if(bank.getName().equals("maser")){
    bank.WithdrawMoney("from bank maser");
    }else{
        System.out.println("this bank is not supported");
    }
    }
    public void RefundMoney(){
       if(bank.getName().equals("ahly")){
           bank.RefundMoney("to our bank ahly account:"+bank.getAccountNumber());
       }else if(bank.getName().equals("maser")){
        bank.RefundMoney("to our bank maser account:"+bank.getAccountNumber());
       
       }else{
           System.out.println("this bank isn't supported");
       }
    }
}
