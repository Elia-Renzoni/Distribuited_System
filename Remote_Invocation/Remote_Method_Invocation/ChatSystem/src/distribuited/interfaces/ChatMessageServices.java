package distribuited.interfaces;

import java.rmi.RemoteException;

public interface ChatMessageServices extends ChatServices {
	void sendMessageToAll(String message) throws RemoteException;
}
