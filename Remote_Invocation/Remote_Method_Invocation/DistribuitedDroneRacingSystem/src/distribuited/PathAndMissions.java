package distribuited;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PathAndMissions extends UnicastRemoteObject implements UsefulDroneFunctions {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Drone> queue;
	private ReentrantLock mutex;
	
	public PathAndMissions() throws RemoteException {
		super();
		this.queue = new LinkedList<>();
		this.mutex = new ReentrantLock();
	}
	
	@Override
	public void addDesination(Drone droneDestination) throws RemoteException {
		try {
			this.mutex.lock();
			this.queue.add(droneDestination);
			try {
				System.out.println("The Drone " + RemoteServer.getClientHost() + " Has added a new mission ");
			} catch (ServerNotActiveException e) {
				e.printStackTrace();
			}
		} finally {
			this.mutex.unlock();
		}
	}

	@Override
	public void startNewMission(int droneId) throws RemoteException {
		try {
			this.mutex.lock();
			for (var values : this.queue) {
				if (values.getDroneId() == droneId) {
					values.setDroneStateFlag(true);
					break;
				}
			}
			try {
				System.out.println("The Drone " + RemoteServer.getClientHost() + " Has started a mission");
			} catch (ServerNotActiveException e) {
				e.printStackTrace();
			}
		} finally {
			this.mutex.unlock();
		}
	}

	@Override
	public void endOfTheMission(int droneId) throws RemoteException {
		try {
			this.mutex.lock();
			for (var values : this.queue) {
				if (values.getDroneId() == droneId) {
					values.setDroneStateFlag(true);
					break;
				}
			}
			try {
				System.out.println("The Drone " + RemoteServer.getClientHost() + " Has end a mission");
			} catch (ServerNotActiveException e) {
				e.printStackTrace();
			}
		} finally {
			this.mutex.unlock();
		}
		
	}

	@Override
	public void exchangeInformation(String desination) throws RemoteException {
		try {
			this.mutex.lock();
			for (var value : this.queue) {
				if (value.equals(desination)) {
					value.setDestination("none");
				}
			}
		} finally {
			this.mutex.unlock();
		}
	}
}
