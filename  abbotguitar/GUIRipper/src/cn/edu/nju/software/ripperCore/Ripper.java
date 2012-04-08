package cn.edu.nju.software.ripperCore;

public class Ripper {
	
	private RipperMonitor godHand;
	OperationConfig config;
	public Ripper(OperationConfig config) {
		// TODO Auto-generated constructor stub
		this.config=config;
	}
	
	public void mainRoutine() {
		// TODO Auto-generated method stub
		setup();
	}
	
	private void setup() {
		// TODO Auto-generated method stub
		godHand=new RipperMonitor(config);
		godHand.setup();
	}

	public RipperMonitor getGodHand() {
		return godHand;
	}
	public void setGodHand(RipperMonitor godHand) {
		this.godHand = godHand;
	}
	

}
