
public class Route199 extends Map{

	public char[][] getMap() {
		
		char[][] Route199 = new char[][]{
			{ 'P', 'S', 'S', 'S', 'S', 'D', 'D', 'U', 'U', 'U', 'U' },
			{ 'U', 'S', 'S', 'S', 'S', 'D', 'T', 'U', 'U', 'U', 'U' },
			{ 'U', 'S', 'S', 'S', 'S', 'D', 'D', 'U', 'U', 'U', 'U' },
			{ 'U', 'S', 'S', 'S', 'L', 'D', 'D', 'U', 'U', 'U', 'U' },
			{ 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'U', 'U', 'U', 'U' },
			{ 'U', 'D', 'D', 'D', 'D', 'D', 'D', 'U', 'U', 'U', 'U' },
			{ 'U', 'D', 'V', 'T', 'V', 'V', 'V', 'U', 'U', 'U', 'U' },
			{ 'U', 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'V', 'U', 'U' },
			{ 'U', 'U', 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'U', 'U' },
			{ 'U', 'U', 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'V', 'U' },
			{ 'U', 'U', 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'V', 'U' }
            };
            
        return Route199;
	}
	
	public String getName() {
		String name = "Route199";
		return name;
	}
	
	public Item getBadge() {

		return new Item("Coral Badge", 0);
	}

	public Item getTreasure() {

		return new Item("Big Pearl", 3000);
	}

	public Pokemon getRarePoke() {

		return new Pokemon("Feebas", 0);
	}
	
}
