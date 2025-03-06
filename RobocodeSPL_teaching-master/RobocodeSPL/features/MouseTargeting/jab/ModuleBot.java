package jab;

public class ModuleBot extends Module {
	protected Targeting getSelectedTargeting() {		
		return new MouseTargeting(this);
	}
}
