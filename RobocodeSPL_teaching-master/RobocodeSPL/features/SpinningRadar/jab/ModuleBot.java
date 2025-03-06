package jab;

public class ModuleBot extends Module {
	protected Radar getSelectedRadar() {		
		return new SpinningRadar(this);
	}
}
