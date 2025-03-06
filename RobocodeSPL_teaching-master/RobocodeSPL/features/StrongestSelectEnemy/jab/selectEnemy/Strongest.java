package jab.selectEnemy;

import java.util.Iterator;

import jab.module.BotInfo;
import jab.module.Module;
import jab.module.SelectEnemy;

/**
 * Select the enemy with more energy
 * 
 * @author jab
 */
public class Strongest extends SelectEnemy {

	public Strongest (Module bot) {
		super(bot);
	}

	public void select() {
		Iterator<BotInfo> iterator= bot.botsInfo.values().iterator();
		double maxEnergy= Double.MIN_VALUE;
		BotInfo selected=null;
		while (iterator.hasNext()){
			BotInfo e= iterator.next();
			if (maxEnergy<e.energy){
				selected=e;
				maxEnergy=e.energy;
			}				
		}
		bot.enemy = selected;
	}

}
