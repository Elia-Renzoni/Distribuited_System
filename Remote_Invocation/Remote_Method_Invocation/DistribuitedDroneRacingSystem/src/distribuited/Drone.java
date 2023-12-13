package distribuited;

import java.util.Random;

public class Drone extends Thread {
	private String mission;
	private boolean missionStartedFlag;
	private final int droneId;
	private Random rdn = new Random();
	
	public Drone(String mission, boolean setUpMissionFlags) {
		super();
		this.droneId = rdn.nextInt();
		this.mission = mission;
		this.missionStartedFlag = setUpMissionFlags;
	}
	
	public int getDroneId() {
		return this.droneId;
	}
	
	public String getDestination() {
		return this.mission;
	}
	
	public void setDroneStateFlag(boolean newState) {
		this.missionStartedFlag = newState;
	}
	
	public void setDestination(String destination) {
		this.mission = destination;
	}

	@Override
	public void run() {
		UsefulDroneFunctions toCalls = (UsefulDroneFunctions) Naming.lookup("rmi://localhost:2000/DroneDistribuitedBuffer");
		toCalls.addDestination(this);
		toCalls.startNewMission(this.droneId);
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
		toCalls.endOfMission(this.droneId);
	}
}
