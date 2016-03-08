package rp.assignments.individual.ex2;

import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class WallDistance implements StoppableRunnable {
	
	boolean running;
	private final DifferentialPilot m_pilot;
	private final RangeFinder range;
	private final Float maxDist;
	private Float optDist;
	
	public WallDistance(DifferentialDriveRobot _robot, RangeFinderDescription _desc, RangeFinder _ranger, Float _maxDistance) {
		running = false;
		m_pilot = _robot.getDifferentialPilot();
		range = _ranger;
		maxDist = _maxDistance;
		optDist = maxDist/3;
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			Delay.msDelay(150);
			System.out.println(range.getRange());
			Double speed = (double)-(optDist-range.getRange());
			speed = (Math.abs(speed) <= m_pilot.getMaxTravelSpeed()) ? speed : Math.signum(speed) * m_pilot.getMaxTravelSpeed();
			if (m_pilot.getMaxTravelSpeed() < speed) speed = m_pilot.getMaxTravelSpeed();
			if (-m_pilot.getMaxTravelSpeed() > speed) speed = -m_pilot.getMaxTravelSpeed();
			m_pilot.setTravelSpeed(Math.abs(speed));
			if (speed > 0) {
				m_pilot.forward();
			}
			else {
				m_pilot.backward();
			}	
			m_pilot.forward();
		}
	}

	@Override
	public void stop() {
		running = false;		
	}
}
