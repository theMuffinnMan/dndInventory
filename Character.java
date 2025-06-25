import java.util.HashMap;
import ecs100.*;
/**
 * Instance of a character.
 * Stores all of the characters values and inventory HashMap.
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
    
    private Item handItem;

    /**
     * Constructor for objects of class character
     */
    public Character(String nm, int hp, int str, int intel, int gp, String item1Name, String item2Name, String itemHandName)
    {
        // initialise instance variables
        name = nm;
        health = hp;
        strength = str;
        intellegence = intel;
        gold = gp;
        
        //inventory 
        inventory = new HashMap<Integer, Item>();
        //item creation
        Item i1 = new Item(item1Name);
        Item i2 = new Item(item2Name);
        //place items into HashMap
        this.inventory.put(1, i1);
        this.inventory.put(2, i2);
        
        // set hand item
        Item i3 = new Item(itemHandName);
        this.handItem = i3;
        
    }
    
      /**
       * find a card based off the cards name.
     * set the current instance card if found
  
     * @return true or false
     */
    public boolean findItem(String name) {
      //search for the card
      for (int itemId : inventory.keySet()) {
        if (inventory.get(itemId).getName().toLowerCase().equals(name.toLowerCase())) {
          this.currItem = inventory.get(itemId);
          return true;
        }
      }
      return false;
    }
    
    /**
     * ItemIdSetter
     */
    public void setInvId(){
        this.currInvId++;
    }

    /**
     * hand item setter
     */
    public void setHand(){
        //removes the current hand item from the hand
        //removes current item from inventory
        this.inventory.remove(this.currItem);
        //adds hand item to inventory
        this.setInvId();
        
        this.inventory.put(this.currInvId, this.getHand());
        
        //adds current item to hand
        this.handItem = this.currItem;
        
    }
    
    /**
     * hand item getter
     */
    
    public Item getHand(){
        return handItem;
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
        //returns inventory HashMap
        return inventory;
    }
}
