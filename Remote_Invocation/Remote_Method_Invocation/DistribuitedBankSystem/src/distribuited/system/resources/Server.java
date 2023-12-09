package distribuited.system.resources;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Set;

public class Server extends UnicastRemoteObject implements BankOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int balance;
	private int userId;
	private Random rdn = new Random();
	private Transaction tr;
	
	protected Server() throws RemoteException {
		super();
		this.userId = rdn.nextInt();
		this.tr = new Transaction();
	}

	@Override
	public int getUserId() throws RemoteException {
		return this.userId;
	}

	@Override
	public int getBalance() throws RemoteException {
		return this.getBalance();
	}

	@Override
	public void addMoney(int value) throws RemoteException {
		this.balance += value;
		this.tr.addTransaction("Add " + value + "Money");
	}

	@Override
	public void decrMoney(int value) throws RemoteException {
		this.balance -= value;
		this.tr.addTransaction("Decrease " + value + "Money");
	}

	@Override
	public Set<String> getTransactions() throws RemoteException {
		return this.tr.getSet();
	}

	@Override
	public void setBalance(int initValue) throws RemoteException {
		this.balance += initValue;
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("Server", server);
			System.out.println("Server listening");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

