package rp.assignments.individual.ex1;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.EventBasedTouchSensor;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;
import java.util.ArrayList;

public class VirtualBumper implements EventBasedTouchSensor {
	
	RangeFinderDescription rangeDesc;
	RangeFinder rangeFinder;
	Float touchRange;
	Thread bumperThread;
	ArrayList<TouchSensorListener> listenerList;

	public VirtualBumper(RangeFinderDescription _desc, RangeFinder _ranger, Float _touchRange) {
		rangeDesc = _desc;
		rangeFinder = _ranger;
		touchRange = _touchRange;
		listenerList = new ArrayList<>();
		//creates a new thread which when started runs the run method
		bumperThread = new Thread(() -> run());
		bumperThread.setDaemon(true);
		bumperThread.start();
		
	}
	
	public void run() {
		boolean running = true;
		boolean pressed = false;
		while (running){
			//if the sensor is already pressed
			if (pressed){
				//checks if the sensor is released
				if (!isPressed()) {
					//steps through the listeners, informing them of release.
					for (TouchSensorListener l : listenerList) {
					    l.sensorReleased(new TouchSensorEvent(100.00F, 0.00F));	
					    l.sensorBumped(new TouchSensorEvent(100.00F, 0.00F));
					}
				    pressed = false;
				}
			}
			else {
				//checks if the sensor is now pressed
				if (isPressed()) {
					//informs listeners of pressed sensor
					for (TouchSensorListener l : listenerList) {
						l.sensorPressed(new TouchSensorEvent(0.00F, 100.00F));
					}
					pressed = true;
				}
			}
		}
	}
	
	@Override
	/**
	 * checks to see if the nearest object is in range of the 
	 * threshold including noise.
	 */
	public boolean isPressed() {
		boolean inRange = false;
		if ((touchRange + rangeDesc.getNoise()) > rangeFinder.getRange()) {
			inRange = true;
		}
		return inRange;
	}
	
	@Override
	/**
	 * adds a listener to the list.
	 * @param _listener a new listener to add
	 */
	public void addTouchSensorListener(TouchSensorListener _listener) {
		listenerList.add(_listener);
	}
}