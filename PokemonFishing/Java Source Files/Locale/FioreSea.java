
public class FioreSea extends Map{
	
	public char[][] getMap() {
		
		char[][] FioreSea = new char[][]{
			{ 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'L' },
			{ 'V', 'V', 'V', 'V', 'V', 'V', 'S', 'U', 'S', 'V', 'V' },
			{ 'D', 'D', 'D', 'D', 'D', 'S', 'U', 'U', 'U', 'S', 'V' },
			{ 'S', 'S', 'U', 'S', 'S', 'D', 'S', 'U', 'S', 'D', 'V' },
			{ 'S', 'U', 'U', 'U', 'S', 'D', 'D', 'D', 'D', 'D', 'V' },
			{ 'D', 'D', 'U', 'D', 'D', 'D', 'T', 'D', 'D', 'D', 'V' },
			{ 'T', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'V' },
			{ 'S', 'S', 'S', 'S', 'S', 'D', 'D', 'D', 'D', 'D', 'V' },
			{ 'S', 'S', 'S', 'S', 'S', 'D', 'D', 'D', 'D', 'D', 'D' },
			{ 'S', 'S', 'S', 'S', 'S', 'D', 'D', 'D', 'D', 'D', 'V' },
			{ 'P', 'S', 'S', 'S', 'S', 'D', 'D', 'D', 'D', 'D', 'U' }
            };
            
		return FioreSea;
	}
	
	public String getName() {
		String name = "Fiore's Sea";
		return name;
	}
	public Item getBadge() {
		
		return new Item("Droplet Badge", 0);
	}

	public Item getTreasure() {
		
		return new Item("Nugget", 4500);
	}
	
}
