import java.util.ArrayList;
import java.util.HashMap;
/**
 * Instance of a character.
 * Stores all of the characters values and inventory HashMap.
 *
 * @Fleur
    17/6
 */

public class Character {
  // instance variables - replace the example below with your own
  private String name;
  private String image;
  private int health;
  private int strength;
  private int intellegence;
  
  private int gold;
  
  private ArrayList<Item> inventory;
 
  private Item currItem;
  
  private Item handItem;

  /**
   * Constructor for objects of class character.
   */
  public Character(String nm, String img, int hp, int str, int intel, int gp, 
          String item1Name, String item1Img, String item2Name, String item2Img, 
          String itemHandName, String item3Img) {
    // initialise instance variables
    name = nm;
    image = img;
    health = hp;
    strength = str;
    intellegence = intel;
    gold = gp;
    
    //inventory 
    inventory = new ArrayList<Item>();
    //item creation
    Item i1 = new Item(item1Name, item1Img, 0);
    Item i2 = new Item(item2Name, item2Img, 1);
    //place items into HashMap
    this.inventory.add(i1);
    this.inventory.add(i2);
    
    // set hand item
    Item i3 = new Item(itemHandName, item3Img, 2);
    this.handItem = i3;
    
  }

  /**
   * Hand item setter.
   */
  public void setHand() {
    
    this.handItem.setId(this.currItem.getId());
    
    //remove current item from inventory
    this.inventory.set(this.currItem.getId(), this.handItem);
    
    //set hand item to hand
    this.handItem = this.currItem;
    
    this.currItem = this.inventory.get(this.handItem.getId());
  }
  
  /**
   * Current item setter.
   */
  
  public void setCurrItem(Item newItem) {
    //sets a current item
    this.currItem = newItem;
  }
  
  /**
   * Current item getter.
   */
  
  public Item getCurrItem() {
    //sets a current item
    return this.currItem;
  }
  
  /**
   * Hand item getter.
   */
  
  public Item getHand() {
    return handItem;
  }
  /**
   * Name getter.
   */

  public String getName() {
    //returns gold value
    return name;
  }
  /**
   * Image getter.
   */
  
  public String getImage() {
    //returns image file name
    return image;
  }
  /**
   * Health getter.
   */
  
  public int getHp() {
    //returns health value
    return health;
  }
  
  /**
   * Strength getter.
   */
  
  public int getStrength() {
    //returns strength value
    return strength;
  }
  
  /**
   * Intellegence getter.
   */
  
  public int getIntel() {
    //returns intellegence value
    return intellegence;
  }
  
  /**
   * Gold getter.
   */
  
  public int getGold() {
    //returns gold value
    return gold;
  }
  
  /**
   * Gold setter add.
   */
  
  public void addGold() {
    //add one gold
    this.gold++;
  }

  /**
   * Gold setter minus.
   */
  
  public void takeGold() {
    //check if gold is 0 or lower
    if (this.gold >= 1) {
      //take one gold
      this.gold--;
    }
  }
  
  /**
   * Gold setter.
   */
  
  public void editGoldSl(int newGold) {
    this.gold = newGold;
  }

  /**
   * Inventory getter.
   */
  
  public ArrayList<Item> getInv() {
    //returns inventory HashMap
    return inventory;
  }
}
