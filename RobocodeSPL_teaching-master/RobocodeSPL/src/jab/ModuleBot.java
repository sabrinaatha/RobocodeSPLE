package jab; 

import jab.gun.*; 
import jab.module.*; 
import jab.module.Module; 
import jab.movement.*; 
import jab.radar.*; 
import jab.selectEnemy.*; 
import jab.targeting.*; 
import java.awt.Color; 

public   class  ModuleBot  extends Module {
	

	protected void initialize() {
		// TODO Customize the colors here
		setBodyColor(Color.BLACK);
		setGunColor(Color.BLACK);
		setRadarColor(Color.BLACK);
		setScanColor(Color.BLUE);
		setBulletColor(Color.RED);
	}

	

	protected void selectBehavior() {
		radar = getSelectedRadar();
		movement = getSelectedMovement();
		targeting = getSelectedTargeting();
		selectEnemy = getSelectedSelectEnemy();
		gun = getSelectedGun();
	}

	
	protected Radar getSelectedRadar() {		
		return new NoRadar(this);
	}

	
	protected Targeting getSelectedTargeting() {		
		return new HeadOnTargeting(this);
	}

	
	protected Movement getSelectedMovement() {		
		return new Cornering(this);
	}

	
	protected SelectEnemy getSelectedSelectEnemy() {		
		return new Weakest(this);
	}

	
	protected Gun getSelectedGun() {		
		return new Maximum(this);
	}


}
