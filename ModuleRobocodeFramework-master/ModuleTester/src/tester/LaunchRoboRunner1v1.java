package tester;

import java.io.File;

import robowiki.runner.RoboRunner;

public class LaunchRoboRunner1v1 {

	public static void main(String[] args) {
		File file = new File("data/jab.ModuleBot 1.xml.gz");
		if (file.exists()) {
			file.delete();
		}
		// 10 seasons, 1 thread
		RoboRunner runner = new RoboRunner("jab.ModuleBot 1", "sample_1v1.rrc", 10, 1, false, false);
		runner.runBattles();
		runner.shutdown();
	}

	// hint to execute
	// java -cp
	// lib/roborunner-1.2.3.jar;lib/guava-12.0.1.jar;robocodes/r1/libs/robocode.jar
	// robowiki.runner.RoboRunner -bot jab.micro.Sanguijuela 0.8 -c
	// sample_1v1.rrc -seasons 5

}
