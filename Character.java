import java.util.HashMap;
import ecs100.*;
/**
 * Instance of a character.
 * Stores all of the characters values and inventory hashmap.
 *
 * @Fleur
 * @version (a version number or a date)
 */
public class Character
{
    // instance variables - replace the example below with your own
    private String name;
    private int health;
    private int strength;
    private int intellegence;
    
    private int gold;
    
    private HashMap<Integer, Item> inventory;
    private static final int MAX_INV_SIZE = 4;
    private int currInvId;
    private Item currItem;
    

    /**
     * Constructor for objects of class character
     */
    public Character(String nm, int hp, int str, int intel, int gp, String item1Name)
    {
        // initialise instance variables
        name = nm;
        health = hp;
        strength = str;
        intellegence = intel;
        gold = gp;
        
        //inventory shennanegins
        inventory = new HashMap<Integer, Item>();
        Item i1 = new Item(item1Name);
        this.inventory.put(1, i1);
        this.currInvId = 1;
        this.currItem = inventory.get(currInvId);
        
    }
    
    /**
     * name getter
     */
    public String getName(){
        //returns gold value
        return name;
    }
    
    /**
     * health getter
     */
    public int getHp(){
        //returns health value
        return health;
    }
    
    /**
     * strength getter
     */
    public int getStrength(){
        //returns strength value
        return strength;
    }
    
    /**
     * intellegence getter
     */
    public int getIntel(){
        //returns intellegence value
        return intellegence;
    }
    
    /**
     * gold getter
     */
    public int getGold(){
        //returns gold value
        return gold;
    }
    
    /**
     * inventory getter
     */
    public HashMap<Integer, Item> getInv(){
        //returns all inv items
        return inventory;
    }
}
