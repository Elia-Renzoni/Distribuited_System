package distribuitedcomputingrmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	public static void main(String[] args) {
		final String NAME = "rmi://localhost:2300//MathematicalCalculate";
		try {
			MathematicalCalculate pointerCalculate = (MathematicalCalculate) Naming.lookup(NAME);
			System.out.println("Addizione : " + pointerCalculate.add(12, 45));
			System.out.println("Sottrazione : "  + pointerCalculate.sub(34, 1));
			System.out.println("Moltiplicazione : " + pointerCalculate.mul(45, 2));
			System.out.println("Divisione : " + pointerCalculate.div(12, 2));
		} catch (MalformedURLException ex) {
			System.out.println(ex);
		} catch (RemoteException ex) {
			System.out.println(ex);
		} catch (NotBoundException ex) {
			System.out.println(ex);
		} 
	}
}
