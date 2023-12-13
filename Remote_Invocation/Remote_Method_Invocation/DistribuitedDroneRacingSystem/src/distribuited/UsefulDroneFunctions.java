package distribuited;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsefulDroneFunctions extends Remote {
	void createInternalThread(Drone drone) throws RemoteException;
	void addDesination(Drone droneDesination) throws RemoteException; // add a new item to the Queue
	void startNewMission(int droneId) throws RemoteException; // change the flag
	void endOfTheMission(int droneId) throws RemoteException;	// change the flag
	void exchangeInformation(String destination) throws RemoteException; // helping system between drones
}
