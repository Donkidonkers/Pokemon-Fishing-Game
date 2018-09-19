/*
 * 	  ROD 			 COST		 ENOUNTER R.     CAPTURE R.
 * 
 *  OLD ROD	      Starting Rod      +0%            +0%
 *  GOOD ROD         3000           +10%           +5%
 *  SUPER ROD        8000           +15%           +20%
 *  MASTER ROD      20 000          +20%           +40%
 * 
 */
public class Rod extends Item {

	private float encounter;
	private float capture;
	Item lure;
	Item reel;
	Item line;
	
    public Rod(String name, int cost, float capture, float encounter){
		super(name, cost);
    	this.encounter = encounter;
    	this.capture = capture;
    	line = new Item("Default", 0);
		lure = new Item("Default", 0);
		reel = new Item("Default", 0);
    }
	
	public void viewStats(){
        System.out.println("Equipped:" + getName() + " Encounter Rate:" + getEncounterRate() + "Cost: "+ getCost());
    }
	//
	public float getEncounterRate() {
		float encounterRate = encounter;
		switch(lure.getName()) {
			case "Great Lure":
				encounterRate += 5;
				break;
			case "Ultra Lure":
				encounterRate += 10;
				break;
			case "Master Lure":
				encounterRate += 30;
				break;
		}
		switch(reel.getName()) {
			case "Great Reel":
				encounterRate += 10;
				break;
			case "Ultra Reel":
				encounterRate += 18;
				break;
			case "Master Reel":
				encounterRate += 21;
				break;
		}
		switch(line.getName()) {
			case "Great Line":
				encounterRate += 10;
				break;
			case "Ultra Line":
				encounterRate += 10;
				break;
			case "Master Line":
				encounterRate += 10;
				break;
		}
		return encounterRate;
	}
	public float getCaptureRate() {
		float captureRate = capture;
		switch(lure.getName()) {
			case "Great Lure":
				captureRate += 5;
				break;
			case "Ultra Lure":
				captureRate += 5;
				break;
			case "Master Lure":
				captureRate += 7;
		}
		switch(reel.getName()) {
			case "Great Reel":
				captureRate += 10;
				break;
			case "Ultra Reel":
				captureRate += 18;
				break;
			case "Master Reel":
				captureRate += 21;
		}
		switch(line.getName()) {
			case "Great Line":
				captureRate += 10;
				break;
			case "Ultra Line":
				captureRate += 15;
				break;
			case "Master Line":
				captureRate += 25;
		}
		return captureRate;
	}

	public boolean attachLine(Item line) {
		this.line = line;
		return true;
	}
	public boolean attachReel(Item reel) {
		this.reel = reel;
		return true;

	}
	
	public boolean attachLure(Item lure) {
		this.lure = lure;
		return true;
	}
}
