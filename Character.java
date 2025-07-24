import java.util.HashMap;
import java.util.ArrayList;
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
    private String image;
    private int health;
    private int strength;
    private int intellegence;
    
    private int gold;
    
    private ArrayList<Item> inventory;
    private static final int MAX_INV_SIZE = 4;
    private int currInvId = 2;
    private Item currItem;
    
    private Item handItem;

    /**
     * Constructor for objects of class character
     */
    public Character(String nm, String img, int hp, int str, int intel, int gp, 
                    String item1Name, String item1Img, String item2Name, String item2Img, String itemHandName, String item3Img)
    {
        // initialise instance variables
        name = nm;
        image = img;
        health = hp;
        strength = str;
        intellegence = intel;
        gold = gp;
        
        //inventory 
        inventory = new ArrayList< Item>();
        //item creation
        Item i1 = new Item(item1Name, item1Img, 1);
        Item i2 = new Item(item2Name, item2Img, 2);
        //place items into HashMap
        this.inventory.add(i1);
        this.inventory.add(i2);
        
        // set hand item
        Item i3 = new Item(itemHandName, item3Img, 3);
        this.handItem = i3;
        
    }
    
      /**
       * find a card based off the cards name.
     * set the current instance card if found
  
     * @return true or false
     */
    public boolean findItem(int key) {
      //search for the item
      for (int itemId = 0; itemId < inventory.size(); itemId++) {
        if (inventory.get(itemId).equals(key)) {
          this.currItem = inventory.get(itemId);
          return true;
        }
      }
      return false;
    }

    /**
     * hand item setter
     */
    public void setHand(int key, Item swapItem){
        //remove current item from inventory
        this.inventory.set(key, this.handItem);
        
        //set current item to hand
        this.handItem = swapItem;
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
     * image getter
     */
    public String getImage(){
        //returns image file name
        return image;
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
        //check if gold is 0 or lower
        if(this.gold >= 1){
            //take one gold
            this.gold--;
        }
    }
    
    /**
     * gold setter
     */
    public void editGoldSl(int newGold){
        this.gold = newGold;
    }

    /**
     * inventory getter
     */
    public ArrayList< Item> getInv(){
        //returns inventory HashMap
        return inventory;
    }
}
