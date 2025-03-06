package jab.gun;

import jab.module.Gun;
import jab.module.Module;
import robocode.Bullet;
import robocode.Rules;

/**
 * Fire bullet with a maximum power
 */
public class Maximum extends Gun {

	public Maximum(Module bot) {
		super(bot);
	}

	public void fire() {
		if (bot.enemy != null) {
			// Fire with less energy than the energy I have
			double bulletPower = Math.min(Rules.MAX_BULLET_POWER, bot.getEnergy() - 0.01);
			// Do not fire if the enemy does not have energy
			if (bot.enemy.energy == 0) {
				bulletPower = 0;
			}
			bot.bulletPower = bulletPower;
			// Only try to fire when the gun heat is 0
			if (bot.getGunHeat() == 0) {
				Bullet b = bot.setFireBullet(bulletPower);
				bot.registerBullet(b);
			}
		}
	}
}