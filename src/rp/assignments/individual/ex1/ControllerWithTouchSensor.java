package rp.assignments.individual.ex1;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;
import rp.systems.StoppableRunnable;

public class ControllerWithTouchSensor implements StoppableRunnable, TouchSensorListener  {

	private final DifferentialDriveRobot m_robot;
	private boolean running = false;
	private final DifferentialPilot pilot;
	private boolean bumped = false;

	public ControllerWithTouchSensor(DifferentialDriveRobot _robot) {
		m_robot = _robot;
		pilot = m_robot.getDifferentialPilot();
	}

	@Override
	public void run() {
		running = true;
		pilot.setTravelSpeed(0.40f);
		//pilot.setRotateSpeed(20);

		while (running) {
			float move = (float) 1.0;
			pilot.forward();

			while (pilot.isMoving() && !bumped) {
				Delay.msDelay(10);
			}

			if (bumped) {
				pilot.stop();
				pilot.travel(-move / 2);
				pilot.rotate(180);
				bumped = false;
			}
		}
	}

	@Override
	public void stop() {
		running = false;
		pilot.stop();
	}

	@Override
	public void sensorPressed(TouchSensorEvent _e) {
		bumped = true;
	}


	@Override
	public void sensorReleased(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorBumped(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

}
