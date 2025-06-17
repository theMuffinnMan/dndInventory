import java.util.HashMap;
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
    private int health;
    private int strength;
    private int intellegence;
    
    private int gold;
    
    private HashMap<Integer, Item> inventory;
    private static final int MAX_INV_SIZE = 4;
    

    /**
     * Constructor for objects of class character
     */
    public Character(int hp, int str, int intel, int gp)
    {
        // initialise instance variables
        health = hp;
        strength = str;
        intellegence = intel;
        gold = gp;
        
        inventory = new HashMap<Integer, Item>();
        
    }
}
