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
    
    private double gold;
    
    private HashMap<Integer, Item> inventory;
    private static final int MAX_INV_SIZE = 4;
    private int currInvId = 2;
    private Item currItem;
    
    private Item handItem;

    /**
     * Constructor for objects of class character
     */
    public Character(String nm, int hp, int str, int intel, double gp, String item1Name, String item2Name, String itemHandName)
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
        Item i1 = new Item(item1Name, 1);
        Item i2 = new Item(item2Name, 2);
        //place items into HashMap
        this.inventory.put(1, i1);
        this.inventory.put(2, i2);
        
        // set hand item
        Item i3 = new Item(itemHandName, 3);
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
     * hand item setter
     */
    public void setHand(){
        //remove current item from inventory
        this.inventory.remove(this.currItem.getId());
        
        //add hand to inventory
        this.inventory.put(this.getHand().getId(), this.getHand());
        
        //set current item to hand
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
    public double getGold(){
        //returns gold value
        return gold;
    }
    
    /**
     * gold setter add
     */
    public void addGold(){
        //add one gold
        this.gold++;
    }

    /**
     * gold setter minus
     */
    public void takeGold(){
        //take one gold
        this.gold--;
    }
    
    /**
     * gold setter
     */
    public void editGoldSl(double newGold){
        this.gold = newGold;
    }

    /**
     * inventory getter
     */
    public HashMap<Integer, Item> getInv(){
        //returns inventory HashMap
        return inventory;
    }
}
