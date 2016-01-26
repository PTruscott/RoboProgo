package rp.assignments.individual.ex1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSim {
	public static void main(String[] args) {		
		Result result = JUnitCore
                .runClasses(rp.assignments.individual.ex1.Ex1Tests.class);

        System.out.println(String.format("%d/%d tests successful",
                result.getRunCount() - result.getFailureCount(),
                result.getRunCount()));
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } 
	}
}
