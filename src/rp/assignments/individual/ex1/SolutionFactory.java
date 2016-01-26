package rp.assignments.individual.ex1;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.EventBasedTouchSensor;
import rp.systems.StoppableRunnable;

public class SolutionFactory {

    public static StoppableRunnable createEquilateralTriangleController(DifferentialDriveRobot _robot, Float _sideLength) {
    	PolygonController p = new PolygonController(_robot, _sideLength, 3); 
    	return p;
    }
    public static StoppableRunnable createSquareController( DifferentialDriveRobot _robot, Float _sideLength) {
    	PolygonController p = new PolygonController(_robot, _sideLength, 4); 
    	return p;
    }
    
    public static StoppableRunnable createDecagonController( DifferentialDriveRobot _robot, Float _sideLength) {
    	PolygonController p = new PolygonController(_robot, _sideLength, 10); 
    	return p;
    }
    
    public static ControllerWithTouchSensor createBumperController(DifferentialDriveRobot _robot) {
    	ControllerWithTouchSensor c = new ControllerWithTouchSensor(_robot);
    	return c;
    }
    
    public static EventBasedTouchSensor createVirtualBumper(RangeFinderDescription _desc, RangeFinder _ranger, Float _touchRange)  {
    	VirtualBumper b = new VirtualBumper(_desc, _ranger, _touchRange);
    	return b;
    }

}