package distribuited.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface initChatServices extends Remote {
	int buildChatRoom() throws RemoteException;
	List<Integer> viewChatRooms() throws RemoteException; 
}
