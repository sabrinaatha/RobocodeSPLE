package jab;

public class ModuleBot extends Module {
	protected Gun getSelectedGun() {		
		return new Maximum(this);
	}
}
