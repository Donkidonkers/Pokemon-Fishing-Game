import java.util.ArrayList;

public class Player {
	
	private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>(); 
	private String name;
	private int fame;
	private int xpos;
    private int ypos;
    private int money;
    private int moves;
    private int casts;
    private int face; // 1 is up, 2 is down, 3 is left, 4 is right
    private Bag rageBackpack;
    private Bag fioreBackpack;
    private Bag marineBackpack;
    private Bag routeBackpack;
    private Bag unionBackpack;
    Map location;
	public Player(){
    	name = "Fisherman";
        xpos = 5;
        ypos = 5; //This is the initial starting position of the player
        money = 0;
        face = 2;
        rageBackpack = new Bag();
        fioreBackpack = new Bag();
        marineBackpack = new Bag();
        routeBackpack = new Bag();
        unionBackpack = new Bag();
    }
    public Bag getBackpack() {
        if (this.getLocation() instanceof LakeofRage) {
            return rageBackpack;
        } else if (this.getLocation() instanceof UnionCave) {
            return unionBackpack;
        } else if (this.getLocation() instanceof Route199) {
            return routeBackpack;
        } else if (this.getLocation() instanceof MarineCave) {
            return marineBackpack;
        } else if (this.getLocation() instanceof FioreSea) {
            return fioreBackpack;
        }
        return rageBackpack;
    }
    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getCasts() {
        return casts;
    }

    public void setCasts(int casts) {
        this.casts = casts;
    }
    
    
    public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}
	
    public int getXPos(){
        return xpos;
    }
    
    public Rod getRod() {
        Rod r = new Rod("Old Rod", 0, 0, 0);
        for (Item i: this.getBackpack().getBag()) {
            if (i instanceof Rod && (i).getCost() > r.getCost()) {
                r = (Rod) i;
            }
        }
        return r;
    }
    
    public Boat getBoat() {
        Boat boat = new Boat("Rowboat", 0, 5);
        for (Pokemon p: pokemonList) {
            if (p.getName().equals("Lapras")) {
                return new Boat("Lapras", 0, 25);
            }
        }
        for (Item i: this.getBackpack().getBag()) {
            if (i instanceof Boat && (i).getCost() > boat.getCost()) {
                boat = (Boat) i;
            }
        }
        return boat;
    }
    
    public Tacklebox getTackleBox() {
        Tacklebox t = new Tacklebox("Basic Tackle Box", 0, 5);
        for (Item i: this.getBackpack().getBag()) {
            if (i instanceof Tacklebox && (i).getCost() > t.getCost()) {
                t = (Tacklebox) i;
            }
        }
        return t;
    }

    public int getYPos(){
        return ypos;
    }
    public void setXpos(int x) {
        moves -= Math.abs(x - getXPos());
        this.xpos = x;
    }
    public void setYpos(int y) {
        moves -= Math.abs(y - getYPos());
        this.ypos = y;
    }
    public void sell(Item i) {
        this.addMoney(i.getCost());
        this.getBackpack().getBag().remove(i);
    }
	public int getFame() {
		return fame;
	}
	public void setFame(int fame) {
		this.fame = fame;
	}
    public void buy(Item i) {
        if (i instanceof Boat && !i.getName().equals(this.getBoat().getName())){
            this.setMoves(((Boat) i).getMoves() - (this.getBoat().getMoves() - this.getMoves()));
        }
        this.getBackpack().add(i);
        this.money -= i.getCost();
    }
    public void give(Item i) {
        if (i instanceof Boat && !i.getName().equals(this.getBoat().getName())){
            this.setMoves(((Boat) i).getMoves() - (this.getBoat().getMoves() - this.getMoves()));
        } else if (i instanceof Tacklebox && !i.getName().equals(this.getTackleBox().getName())) {
            this.setMoves(((Tacklebox) i).getCasts() - (this.getTackleBox().getCasts() - this.getCasts()));
        }
        this.getBackpack().add(i);
    }
    public void resetPos(String map){  //MAP
        if(map.equals("Lake of Rage")) {
            xpos = 5;
            ypos = 5;
        }

        else if(map.equals("Union Cave")) {
            xpos = 10;
            ypos = 5;
        }

        else if(map.equals("Route199")) {
            xpos = 0;
            ypos = 0;
        }

        else if(map.equals("Fiore's Sea")) {
            xpos = 10;
            ypos = 0;
        }

        else if(map.equals("Marine Cave")) {
            xpos = 10;
            ypos = 5;
        }
        moves = getBoat().getMoves();
        casts = getTackleBox().getCasts();;
    }
	public int getFace() {
		// FACE is supposed to tell where the user is facing, if user is facing already in a certain 
		// direction like north/up, and you tell user to go up it will continue to do so. If not user
		// will face another direction.
		return face;
	}
	

	public void setFace(int face) {
		this.face = face;
	}	
	
	public void catchPokemon(Pokemon p) {
		for (Pokemon poke: pokemonList) {
            if (poke.getName().equals(p.getName())) {
                int fameGain = 0;
                if (p.getFame() == 10) {
                    fameGain += p.getFame() - 2 * p.getOwned();
                }
                else if (p.getFame() == 20) {
                    fameGain += p.getFame() - 5 * p.getOwned();
                }
                else if (p.getFame() == 30) {
                    fameGain += p.getFame() - 10 * p.getOwned();
                }
                if (fameGain < 0) fameGain = 0;
                fame += fameGain;
                poke.catchOne();
                return;
            }
        }
        pokemonList.add(p);
		fame+= p.getFame();
	}
    public int getMoney() {
        return money;
    }
    public void addMoney(int money) {
        this.money += money;
    }
    public ArrayList<String> getBadges() {
	    ArrayList<String> badgeList = new ArrayList<>();
	    for (Pokemon p: pokemonList) {
	        if (p.getName().equals("Red Gyarados") && !badgeList.contains("Scale Badge")) {
                badgeList.add("Scale Badge");
            }
            if (p.getName().equals("Lapras")&& !badgeList.contains("Shell Badge")) {
                badgeList.add("Shell Badge");
            }
            if (p.getName().equals("Feebas")&& !badgeList.contains("Coral Badge")) {
                badgeList.add("Coral Badge");
            }
            if (p.getName().equals("Manaphy")&& !badgeList.contains("Droplet Badge")) {
                badgeList.add("Droplet Badge");
            }
            if (p.getName().equals("Kyogre")&& !badgeList.contains("Legends Badge")) {
                badgeList.add("Legends Badge");
            }
        }
        return badgeList;
    }
    public ArrayList<Pokemon> getPokemon() {
	    return pokemonList;
    }
    public String getPokemonString() {
	    String list = "";
	    for (Pokemon p: pokemonList) {
            list+= p.getOwned() + " " + p.getName();
        }
        return list;
    }

    public Map getLocation() {
        return location;
    }
    public void setLocation(Map m) {
	    location = m;
    }
}