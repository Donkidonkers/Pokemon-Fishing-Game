
public class LakeofRage extends Map{

	public char[][] getMap() {
		
		char[][] LakeOfRage = new char[][]{
			{ 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U' },
			{ 'U', 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'V', 'U', 'U' },
			{ 'U', 'U', 'V', 'V', 'D', 'D', 'D', 'D', 'D', 'U', 'U' },
			{ 'U', 'U', 'V', 'D', 'S', 'S', 'T', 'S', 'D', 'V', 'U' },
			{ 'U', 'V', 'D', 'D', 'S', 'S', 'S', 'S', 'D', 'V', 'U' },
			{ 'U', 'V', 'S', 'S', 'S', 'P', 'S', 'D', 'D', 'V', 'U' },
			{ 'U', 'V', 'D', 'D', 'S', 'S', 'S', 'D', 'D', 'V', 'U' },
			{ 'U', 'V', 'D', 'D', 'D', 'S', 'D', 'D', 'D', 'V', 'U' },
			{ 'U', 'V', 'V', 'D', 'D', 'D', 'D', 'D', 'V', 'V', 'U' },
			{ 'U', 'U', 'U', 'V', 'V', 'V', 'V', 'V', 'L', 'U', 'U' },
			{ 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U' }
            };
            
		return LakeOfRage;
	}
	
	public String getName() {
		String name = "Lake of Rage";
		return name;
	}
	public Item getBadge() {

		return new Item("Scale Badge", 0);
	}

	public Item getTreasure() {

		return new Item("Pearl", 1000);
	}

}
