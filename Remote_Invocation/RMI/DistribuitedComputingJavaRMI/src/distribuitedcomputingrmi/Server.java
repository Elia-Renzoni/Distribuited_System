package distribuitedcomputingrmi;

import java.rmi.Naming;
import java.rmi.Remote;

public class Server implements Remote {
	public static void main(String[] args) {
		final String NAME = "rmi://localhost:2300//MathematicalCalculate";
		try {
			Naming.rebind(NAME, new CalculateEngine());
			System.out.println("Associazione Creata");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
