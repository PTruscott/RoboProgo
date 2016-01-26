package rp.assignments.individual.ex1;

import lejos.robotics.navigation.DifferentialPilot;
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

/**
 * 
 * Very empty example controller structure.
 * 
 * @author Nick Hawes
 *
 */
public class MyRobotController implements StoppableRunnable {
	
	private final DifferentialPilot m_pilot;
	
	public MyRobotController(DifferentialDriveRobot _robot) {
		m_pilot = _robot.getDifferentialPilot();
	}

	@Override
	public void run() {
		boolean running = true;
		while(running);
			for (int i = 0; i < 3; i++) {
				m_pilot.rotate(360/3);
				m_pilot.travel(1);
			}
		}	

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
