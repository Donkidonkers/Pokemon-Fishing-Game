import java.util.Random;

/**
 * Created by unknown on 12/5/2017.
 */
public class Encounter {
    private Item i; // this holds the encounter, be it a pokemon or treasure
    public boolean gotAway = false;

    public Encounter(Map map, Player player) {
        Random rand = new Random();
        int chance1 = 0; // encounter chance
        int chance2 = 0; // capture chance
        switch (map.getMap()[player.getXPos()][player.getYPos()] + "") {
            case "T":
                // This means it's a treasure.
                if (map instanceof LakeofRage) {
                    i = new Item("Pearl", 1000);
                } else if (map instanceof UnionCave) {
                    i = new Item("Stardust", 2500);
                } else if (map instanceof Route199) {
                    i = new Item("Big Pearl", 3000);
                } else if (map instanceof FioreSea) {
                    i = new Item("Nugget", 4500);
                } else if (map instanceof FioreSea) {
                    i = new Item("Big Nugget", 10000);
                }
                chance1 = 25;
                chance2 = 100;
                break;
            case "S":
                // Shallow water, which means magikarp.
                if (map instanceof LakeofRage) {
                    i = new Pokemon("Magikarp", 10);
                } else if (map instanceof UnionCave) {
                    i = new Pokemon("Goldeen", 10);
                } else if (map instanceof Route199) {
                    i = new Pokemon("Remoraid", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Frillish", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Chinchou", 10);
                }
                chance1 = 50;
                chance2 = 40;
                break;
            case "D":
                // Deep water
                if (map instanceof LakeofRage) {
                    i = new Pokemon("Tentacool", 10);
                } else if (map instanceof UnionCave) {
                    i = new Pokemon("Horsea", 10);
                } else if (map instanceof Route199) {
                    i = new Pokemon("Quilfish", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Finneon", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Wailmer", 10);
                }
                chance1 = 25;
                chance2 = 20;
                break;
            case "V":
                if (map instanceof LakeofRage) {
                    i = new Pokemon("Staryu", 10);
                } else if (map instanceof UnionCave) {
                    i = new Pokemon("Shelder", 10);
                } else if (map instanceof Route199) {
                    i = new Pokemon("Carvanha", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Alomomora", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Relicanth", 10);
                }
                chance1 = 15;
                chance2 = 10;
                break;
            case "L":
                if (map instanceof LakeofRage) {
                    i = new Pokemon("Red Gyarados", 10);
                } else if (map instanceof UnionCave) {
                    i = new Pokemon("Lapras", 10);
                } else if (map instanceof Route199) {
                    i = new Pokemon("Feebas", 10);
                } else if (map instanceof FioreSea) {
                    i = new Pokemon("Manaphy", 10);
                } else if (map instanceof FioreSea && player.getBadges().size() >= 4) {
                    i = new Pokemon("Kyogre", 10);
                }
                if (player.getFame() >= 100)
                    chance1 = 0;
                else chance1 = 101; // this will make the encounter impossible if fame is not 100.
                chance2 = 10;
                break;
            case "P":
                for (int j = 0; j < player.getBackpack().getBag().size(); j++) {
                    Item i = player.getBackpack().getBag().get(j);
                    if (i.getName().contains("Nugget") || i.getName().contains("Pearl") || i.getName().contains("Stardust")) {
                        player.sell(i); // sell this item to the shop
                        j--;
                    }
                }
                i = new Item("PORT", 0);
                break;

        }
        chance1 -= player.getRod().getCaptureRate();
        chance2 -= player.getRod().getEncounterRate();
            // Below is the code for what happens if the pokemon is not encountered or captured.
            if (rand.nextInt(100) + 1 <= chance1) {
                i = null;
            }
            else if( rand.nextInt(100) + 1 <= chance2) {
                gotAway = true;
            }
    }
    public Item getEncounter() {
        return i;
    }
}



