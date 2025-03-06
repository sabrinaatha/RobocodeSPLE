package tester;

import java.io.File;

import codesize.Codesize;
import codesize.Codesize.Item;

/**
 * Get code size
 * 
 * @author jab
 */
public class LaunchCodeSize {

	public static void main(String[] args) {
		File file = new File("bots/jab.ModuleBot_1.jar");
		
		// one way to obtain the results
		Codesize.main(new String[] { file.getAbsolutePath() });

		// another way to obtain the results
		Item item = Codesize.processZipFile(file);
		System.out.println("CodeSize: " + item.getCodeSize());
		System.out.println("ClassSize: " + item.getClassSize());
		System.out.println("ClassFiles: " + item.getNClassFiles());
		System.out.println("Location: " + item.getLocation());

		// General no restrictions
		// MiniBots 1499 bytes or less
		// MicroBots 749 bytes or less
		// NanoBots 249 bytes or less
		// Twin Duel 1999 bytes or less ( this means two instances of one bot
		// 1999 bytes, or instance of bot one + instance of bot two = 1999
		// bytes)
		// Teams no restrictions
	}

}
