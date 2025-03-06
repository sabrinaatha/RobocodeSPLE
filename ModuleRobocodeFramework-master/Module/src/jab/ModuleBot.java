package jab;

import jab.gun.*;
import jab.module.*;
import jab.module.Module;
import jab.movement.*;
import jab.radar.*;
import jab.selectEnemy.*;
import jab.targeting.*;

import java.awt.Color;

/**
 * Module Bot 1.0.0
 * 
 * @author jab
 */
public class ModuleBot extends Module {

	// TODO Initialize the parts that you will use
	Radar selectedRadar = new SpinningRadar(this);
	Movement selectedMovement = new Quiet(this);
	Targeting selectedTargeting = new HeadOnTargeting(this);
	SelectEnemy selectedSelectEnemy = new Closest(this);
	Gun selectedGun = new Maximum(this);

	protected void initialize() {
		// TODO Customize the colors here
		setBodyColor(Color.BLACK);
		setGunColor(Color.BLACK);
		setRadarColor(Color.BLACK);
		setScanColor(Color.BLUE);
		setBulletColor(Color.RED);
	}

	protected void selectBehavior() {
		// TODO You can change the parts here. You can also change the behavior
		// during the battle by just changing the parts
		radar = selectedRadar;
		movement = selectedMovement;
		targeting = selectedTargeting;
		selectEnemy = selectedSelectEnemy;
		gun = selectedGun;
	}
}
