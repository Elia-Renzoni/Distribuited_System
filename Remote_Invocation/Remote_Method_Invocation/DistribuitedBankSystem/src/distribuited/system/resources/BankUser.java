package distribuited.system.resources;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BankUser {
	public static void main(String[] args) {
		try {
			BankOperation bank = (BankOperation) Naming.lookup("rmi://localhost:1099/Server");
			bank.setBalance(5000);
			for (int i = 0; i < 50; i++) {
				bank.addMoney(i + 300);
			}
			System.out.println(bank.getTransactions());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println(e);
		}
	}
}
