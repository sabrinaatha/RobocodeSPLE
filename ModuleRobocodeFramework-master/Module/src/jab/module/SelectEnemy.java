package jab.module;

/**
 * Select enemy
 * 
 * @author jab
 */
public abstract class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
	}

}
