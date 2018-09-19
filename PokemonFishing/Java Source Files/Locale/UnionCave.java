
public class UnionCave extends Map{

	public char[][] getMap() {
		
		char[][] UnionCave = new char[][]{
			{ 'U', 'U', 'U', 'U', 'U', 'L', 'U', 'U', 'U', 'U', 'U' },
			{ 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'U', 'U' },
			{ 'U', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'U' },
			{ 'U', 'V', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'V', 'U' },
			{ 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'T', 'D', 'D', 'U' },
			{ 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'U' },
			{ 'U', 'D', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'D', 'U' },
			{ 'U', 'D', 'S', 'T', 'S', 'S', 'S', 'S', 'S', 'D', 'U' },
			{ 'U', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'U' },
			{ 'U', 'U', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'U', 'U' },
			{ 'U', 'U', 'U', 'U', 'U', 'P', 'U', 'U', 'U', 'U', 'U' }
            };
            
        return UnionCave;
	}
	
	public String getName() {
		String name = "Union Cave";
		return name;
	}
	
	public Item getBadge() {

		return new Item("Shell Badge", 0);
	}

	public Item getTreasure() {

		return new Item("Stardust", 2500);
	}
	
}
