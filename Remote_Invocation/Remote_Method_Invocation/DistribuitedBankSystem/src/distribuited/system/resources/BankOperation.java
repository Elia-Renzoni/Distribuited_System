package distribuited.system.resources;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface BankOperation extends Remote {
	int getUserId() throws RemoteException;
	int getBalance() throws RemoteException;
	void setBalance(int initValue) throws RemoteException;
	void addMoney(int value) throws RemoteException;
	void decrMoney(int value) throws RemoteException;
	Set<String> getTransactions() throws RemoteException; 
}
