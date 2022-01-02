package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.AdminMainMenuController;
import controller.LoginController;

public class RMIAdmin {

    public static void main(String[] args) throws RemoteException{
         newLogin gui = new newLogin();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true); // This shows the gui
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1099);
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        LoginController gui_controller = new LoginController(gui, r);
        
    }
}
