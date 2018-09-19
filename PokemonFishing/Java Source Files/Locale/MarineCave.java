
public class MarineCave extends Map {

	public char[][] getMap() {
		
		char[][] MarineCave = new char[][]{
			{ 'U', 'V', 'V', 'D', 'V', 'L', 'V', 'V', 'V', 'V', 'U' },
			{ 'U', 'V', 'D', 'S', 'D', 'V', 'V', 'V', 'V', 'V', 'U' },
			{ 'U', 'D', 'S', 'U', 'S', 'D', 'D', 'D', 'D', 'D', 'U' },
			{ 'U', 'S', 'U', 'U', 'U', 'S', 'D', 'D', 'D', 'D', 'U' },
			{ 'U', 'D', 'S', 'U', 'S', 'D', 'D', 'S', 'D', 'D', 'U' },
			{ 'U', 'D', 'D', 'S', 'D', 'D', 'S', 'U', 'T', 'D', 'U' },
			{ 'U', 'D', 'D', 'D', 'D', 'S', 'U', 'U', 'U', 'S', 'U' },
			{ 'U', 'D', 'D', 'T', 'S', 'S', 'S', 'U', 'S', 'D', 'U' },
			{ 'U', 'D', 'D', 'S', 'S', 'S', 'S', 'S', 'D', 'D', 'U' },
			{ 'U', 'D', 'D', 'S', 'S', 'S', 'S', 'S', 'D', 'D', 'U' },
			{ 'U', 'D', 'D', 'S', 'S', 'P', 'S', 'S', 'D', 'D', 'U' },
            };
            
		return MarineCave;
	}
	
	public String getName() {
		String name = "Marine Cave";
		return name;
	}
	
	public Item getBadge() {
		
		return new Item("Legend Badge", 0);
	}

	public Item getTreasure() {
		
		return new Item("Big Nugget", 10000);
	}
	
}
