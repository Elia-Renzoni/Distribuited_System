package distribuitedcomputingrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.MathematicalCalculate;

public class CalculateEngine extends UnicastRemoteObject implements MathematicalCalculate {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculateEngine() throws RemoteException {
		super();
	}

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int div(int num1, int num2) {
		return num1 / num2;
	}

	@Override
	public int mul(int num1, int num2) {
		return num1 * num2;
	}
	
}
