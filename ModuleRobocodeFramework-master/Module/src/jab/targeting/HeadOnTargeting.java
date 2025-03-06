package jab.targeting;

import jab.module.Module;
import jab.module.Targeting;

/**
 * The simple startegy of aiming where you last saw the enemy
 * 
 * http://robowiki.net/wiki/Head-On_Targeting
 */
public class HeadOnTargeting extends Targeting {

	public HeadOnTargeting(Module bot) {
		super(bot);
	}

	public void target() {
		if (bot.enemy != null) {
			double absoluteBearing = bot.getHeadingRadians() + bot.enemy.bearingRadians;
			bot.setTurnGunRightRadians(
					robocode.util.Utils.normalRelativeAngle(absoluteBearing - bot.getGunHeadingRadians()));
		}
	}
}
