package distribuited;

import java.util.Random;

public class Drone {
	private String mission;
	private boolean missionStartedFlag;
	private final int droneId;
	private Random rdn = new Random();
	
	public Drone(String mission, boolean setUpMissionFlags) {
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
}
