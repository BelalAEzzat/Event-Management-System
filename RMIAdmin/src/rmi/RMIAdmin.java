package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.AdminMainMenuController;

public class RMIAdmin {

    public static void main(String[] args) throws RemoteException{
         newAdminMenu gui = new newAdminMenu();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true); // This shows the gui
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1099);
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        AdminMainMenuController gui_controller = new AdminMainMenuController(gui, r);
        
    }
}
