/*
 *  BOAT	 		  COST	   	  MOVES
 *  
 *  Row Boat 	  Starting Boat     5
 *  Speed Boat 		  3500 	       10
 *  Sharpedo Boat	  5000 	       15
 *  Lapras 		  CANT BE BOUGHT   25
 * 
 */
public class Boat extends Item {
	private int moves;
	Item engine;
    public Boat(String name, int cost, int moves){
    	super(name, cost);
		this.moves = moves;
    }
        // Matthew, I'm confused on where the Speed/ Sharpedo boat would be? same with Rod and Tacklebox
	public void viewStats(){
        System.out.println("Equipped:" +super.getName()+ " Moves:" +getMoves()+ "Cost: "+super.getCost());
    }
	public int getMoves() {
		if (engine != null && engine.getName().equals("Team Aqua Engine"))
			return moves * 2;
		return moves;
	}
	public boolean addEngine(Item eng) {
		if (getName().equals("Lapras"))
			return false;
		this.engine = eng;
		return true;
	}
}
