/*
 * POKEMON 	    FAME       LOCALE       Depth Enc.     Encounter R. Capture R.
 *
 * MAGIKARP  - 10% (-2%)  Lake of Rage - Shallow Water -     50%          40%
 * TENTACOOL - 20% (-5%)  Lake of Rage - Deep Water    -     25%          20%
 * STARYU    - 30% (-10%) Lake of Rage - Very D Water  -     15%          10%
 * 
 * RED GYARADOS           Lake of Rage - Legendary	   -	100%		  10%   SCALE BADGE
 * 
 * GOLDEEN   - 10% (-2%)  Union Cave   - Shallow Water -     50%          40%
 * HORSEA    - 20% (-5%)  Union Cave   - Deep Water    -     25%          20%
 * SHELDER   - 30% (-10%) Union Cave   - Very D Water  -     15%          10%
 * 
 * LAPRAS				  Union Cave   - Legendary	   -	100%		  10%   SHELL BADGE
 * 
 * REMORAID  - 10% (-2%)  Route119     - Shallow Water -     50%          40%
 * QUILFISH  - 20% (-5%)  Route119     - Deep Water    -     25%          20%
 * CARVANHA  - 30% (-10%) Route119     - Very D Water  -     15%          10%
 * 
 * FEEBAS				  Route 119    - Legendary	   -	100%		  10%   CORAL BADGE
 * 
 * FRILLISH  - 10% (-2%)  Fiore's Sea  - Shallow Water -     50%          40%
 * FINNEON   - 20% (-5%)  Fiore's Sea  - Deep Water    -     25%          20%
 * ALOMOMORA - 30% (-10%) Fiore's Sea  - Very D Water  -     15%          10%
 * 
 * MANAPHY				  Fiore�s Sea  - Legendary	   -	100%		  10%   DOPLET BADGE
 * 
 * CHINCHOU  - 10% (-2%)  Marine Cave  - Shallow Water -     50%          40%
 * WAILMER   - 20% (-5%)  Marine Cave  - Deep Water    -     25%          20%
 * RELICANTH - 30% (-10%) Marine Cave  - Very D Water  -     15%          10%
 * 
 * KYOGRE				  Marine Cave  - Legendary	   -	100%		  10%   LEGEND BADGE
 * 
 * Only one instance of a Rare Pok�mon is available in each
 *	Locale; once captured, they can no longer be captured again. Also, by capturing the Rare Pok�mon of a Locale, you
 *	earn the fishing badge of that Locale. 
 * 
 */
public class Pokemon extends Item{
	

	private int fame;
	private int owned;
	
	// money shouldn't be here. If anything, it should be in person since its like User getting money
	// Also you could just check in switch case "case"P" - if(treasure==true) <user has treasure> sell and +1000
	// to inventory. (Since in the spec it says to sell immediately anyways). 
	
	// Also in Driver, there's "enc.getPokemon" idk what to do about that one tbh. no idea.
	public Pokemon(String name, int fame) {
		super(name, 0);
		this.fame = fame;
		this.owned = 1;
	}
	
	public String getName() {
		return super.getName();
	}
	public int getFame() {
		return fame;
	}

	public int getOwned() {
		return owned;
	}
	public void catchOne() {
			this.owned++;
	}
	
}