
public abstract class Map {
	
	public abstract char[][] getMap();
	public abstract Item getBadge(); // IDK. I have no idea where would the proper place Badge would be.
	public abstract Item getTreasure(); // This can be here no problem.
	public abstract String getName();
	
	private int xpos;
	private int ypos;
	
	public int getXpos() {
		return xpos;
	}
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	public int getYpos() {
		return ypos;
	}
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	
}
