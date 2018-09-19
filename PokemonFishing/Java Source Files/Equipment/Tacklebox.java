
public class Tacklebox extends Item {
	private int casts;
	
	public Tacklebox(String name, int cost, int casts){
		super(name, cost);
		this.casts = casts;
	}
        
	public void viewStats(){
		System.out.println("Equipped:" +getName()+ " Casts:" +casts+ "Cost: "+getCost());
	}
	public int getCasts() {
		return casts;
	}
}
