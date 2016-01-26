package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobotPC;
import rp.robotics.testing.TestViewer;
import rp.robotics.testing.ZoneSequenceTestWithSim;

public class VisualTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Ex1Tests tests = new Ex1Tests();
		ZoneSequenceTestWithSim<DifferentialDriveRobotPC, ?> test = tests.createVirtualBumperTest();
		TestViewer demo = new TestViewer(test, test.getSimulation());
		demo.run();
	}
}
