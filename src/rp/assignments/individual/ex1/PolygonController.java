package rp.assignments.individual.ex1;

import lejos.robotics.navigation.DifferentialPilot;
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class PolygonController implements StoppableRunnable {
	
	Float sideLength;
	int numSides;
	boolean running;
	private final DifferentialPilot m_pilot;
	
	public PolygonController(DifferentialDriveRobot _robot, Float i, int numSides) {
		this.sideLength = i;
		this.numSides =numSides;
		running = false;
		m_pilot = _robot.getDifferentialPilot();
	}

	@Override
	public void run() {
		running = true;
		if (running) {
			for (int i = 0; i < numSides; i++) {
				m_pilot.travel(sideLength);
				m_pilot.rotate(360/numSides);
			}
		}
	}

	@Override
	public void stop() {
		running = false;		
	}
}
