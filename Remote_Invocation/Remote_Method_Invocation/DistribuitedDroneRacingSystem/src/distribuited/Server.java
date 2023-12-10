package distribuited;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		try {
			PathAndMissions distibuitedObject = new PathAndMissions();
			Registry registry = LocateRegistry.createRegistry(2000);
			registry.bind("DroneDistribuitedBuffer", distibuitedObject);
			System.out.println("Server Listening");
			
			// now the server is listening to all the request
			while (true) {
				Remote stub = registry.lookup("DroneDistribuitedBuffer");
				// TODO
				// get the method call and the parameter passed
				// then create the Thread
			}
		} catch (RemoteException e) {
			System.out.println(e);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
}
