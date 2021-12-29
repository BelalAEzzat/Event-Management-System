
package rmi;

import java.util.ArrayList;

abstract public class User {
    private String Name;
    private String Password;
    private String Email_Address;
    ArrayList<String> Notifications = new ArrayList<String>();

    public User(String Name, String Password, String Email_Address) {
        this.Name = Name;
        this.Password = Password;
        this.Email_Address = Email_Address;
    }

    public boolean Log_In() {

        return true;
    }

    public boolean Log_Out() {

        return true;
    }

    public boolean Change_Email() {

        return true;
    }

    public boolean Change_Password() {

        return true;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String Email_Address) {
        this.Email_Address = Email_Address;
    }

}
