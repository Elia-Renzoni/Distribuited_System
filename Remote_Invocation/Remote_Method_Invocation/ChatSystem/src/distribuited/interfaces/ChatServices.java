package distribuited.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServices extends Remote {
	String connectToChatRoom(String clientName) throws RemoteException;
	List<Integer> viewAllChatRoom() throws RemoteException;
}
