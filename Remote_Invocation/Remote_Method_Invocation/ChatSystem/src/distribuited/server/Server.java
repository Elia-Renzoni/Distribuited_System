package distribuited.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import distribuited.interfaces.initChatServices;

public class Server extends UnicastRemoteObject implements initChatServices {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> myChatRooms;
	
	public Server() throws RemoteException {
		super();
		this.myChatRooms = new LinkedList<>();
	}

	public static void main(String[] args) {
		try {
			Server myServer = new Server();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("ChatRoomSytem", myServer);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public int buildChatRoom() throws RemoteException {
		ChatRoom chatSpace = new ChatRoom();
		this.myChatRooms.add(chatSpace.getChatId());
		return chatSpace.getChatId();
	}

	@Override
	public List<Integer> viewChatRooms() throws RemoteException {
		return this.myChatRooms;
	}
}
