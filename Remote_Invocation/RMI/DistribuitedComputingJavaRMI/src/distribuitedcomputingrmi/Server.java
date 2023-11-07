package distribuitedcomputingrmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server implements Remote {
	public static void main(String[] args) {
		final String NAME = "rmi://localhost:1099/MathematicalCalculate";
		try {
			LocateRegistry.createRegistry(1099);	// accetta tutte le richieste di chiamata nella porta 1099
			CalculateEngine obj = new CalculateEngine();
			Naming.rebind(NAME, obj);
			System.out.println("Associazione Creata");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
