package tester;

import java.io.File;

import robowiki.runner.RoboRunner;

public class LaunchRoboRunnerTeams {

	public static void main(String[] args) {
		File file = new File("data/jab.ModuleTeam 1.xml.gz");
		if (file.exists()) {
			file.delete();
		}
		// 1 seasons, 1 thread
		RoboRunner runner = new RoboRunner("jab.ModuleTeam 1", "sample_teams.rrc", 1, 1, false, false);
		runner.runBattles();
		runner.shutdown();
	}

}
