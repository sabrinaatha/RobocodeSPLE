package tester;

import java.io.File;

import robocode.Robocode;

public class LaunchRobocodeMelee {

	public static void main(String[] args) {
		File file = new File("sample_melee.battle");
		File robocodeFolder = new File("robocodes/r1");
		Robocode.main(new String[] { "-cwd", robocodeFolder.getAbsolutePath(), "-battle", file.getAbsolutePath(),
				"-tps", "12" });
	}

	// Usage: robocode [-?] [-help] [-cwd path] [-battle filename [-results
	// filename]
	// [-record filename] [-recordXML filename] [-replay filename]
	// [-tps tps] [-minimize] [-nodisplay] [-nosound]
	//
	// where options include:
	// -? or -help Prints out the command line usage of Robocode
	// -cwd <path> Change the current working directory
	// -battle <battle file> Run the battle specified in a battle file
	// -results <results file> Save results to the specified text file
	// -record <bin record file> Record the battle into the specified file as
	// binary
	//
	// -recordXML <xml rec file> Record the battle into the specified file as
	// XML
	// -replay <record file> Replay the specified battle record
	// -tps <tps> Set the TPS > 0 (Turns Per Second)
	// -minimize Run minimized when Robocode starts
	// -nodisplay Run with the display / GUI disabled
	// -nosound Run with sound disabled
	//
	// Java Properties include:
	// -DWORKINGDIRECTORY=<path> Set the working directory
	// -DROBOTPATH=<path> Set the robots directory (default is 'robots')
	// -DBATTLEPATH=<path> Set the battles directory (default is 'battles')
	// -DNOSECURITY=true|false Enable/disable Robocode's security manager
	// -Ddebug=true|false Enable/disable debugging used for preventing
	// robot timeouts and skipped turns, and allows an
	// an unlimited painting buffer when debugging robots
	// -DEXPERIMENTAL=true|false Enable/disable access to peer in robot
	// interfaces
	// -DPARALLEL=true|false Enable/disable parallel processing of robots turns
	// -DRANDOMSEED=<long number> Set seed for deterministic behavior of random
	// numbers

}
