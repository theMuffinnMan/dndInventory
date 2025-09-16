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
  private String ability;
  private int health;
  private int strength;
  private int intellegence;
  private int agility;
  
  private static final int STAT_MAX = 20;
  private static final int STAT_MIN = 8;
  private static final int HP_MAX = 100;
  
  private int gold;
  
  private ArrayList<Item> inventory;
 
  private Item currItem;
  
  private Item handItem;

  /**
   * Constructor for objects of class character.
   */
  public Character(String nm, String img, String abil,
          int hp, int str, int intel, int agil, int gp, 
          String item1Name, String item1Img, String item2Name, String item2Img, 
          String itemHandName, String item3Img) {
    // initialise instance variables
    this.name = nm;
    this.image = img;
    this.ability = abil;
    this.health = hp;
    this.strength = str;
    this.intellegence = intel;
    this.agility = agil;
    this.gold = gp;
    
    //inventory 
    this.inventory = new ArrayList<Item>();
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
    return this.image;
  }
  /**
   * Ability getter.
   */
  
  public String getAbility() {
    //returns image file name
    return this.ability;
  }
  /**
   * Health getter.
   */
  
  public int getHp() {
    //returns health value
    return health;
  }
  /**
   * Health setter add.
   */
  
  public void addHp() {
    //check if strength is 0 or lower
    if (this.strength < HP_MAX) {
      //take one strength
      this.health++;
    }
  }
  /**
   * Health setter minus.
   */
  
  public void takeHp() {
    //check if strength is 0 or lower
    if (this.health > 0) {
      //take one strength
      this.health--;
    }
  }
  
  /**
   * Strength getter.
   */
  
  public int getStrength() {
    //returns strength value
    return this.strength;
  }
  /**
   * strength setter add.
   */
  
  public void addStrength() {
    //check if strength is 20 
    if (this.strength < STAT_MAX) {
      //add one strength
      this.strength++;
    }
  }
  /**
   * Gold setter minus.
   */
  
  public void takeStrength() {
    //check if strength is 0 or lower
    if (this.strength > STAT_MIN) {
      //take one strength
      this.strength--;
    }
  }
  
  /**
   * Intellegence getter.
   */
  
  public int getIntel() {
    //returns intellegence value
    return this.intellegence;
  }
  /**
   * Intellegence setter add.
   */
  
  public void addInt() {
    //check if gold is 0 or lower
    if (this.intellegence < STAT_MAX) {
      //take one gold
      this.intellegence++;
    }
  }
  /**
   * Intellegence setter minus.
   */
  
  public void takeInt() {
    //check if gold is 0 or lower
    if (this.intellegence > STAT_MIN) {
      //take one gold
      this.intellegence--;
    }
  }
  
  /**
   * agility getter.
   */
  
  public int getAgil() {
    //returns intellegence value
    return this.agility;
  }
  /**
   * Agility setter add.
   */
  
  public void addAgil() {
    //check if gold is 0 or lower
    if (this.agility < STAT_MAX) {
      //add agility
      this.agility++;
    }
  }
  /**
   * Agility setter minus.
   */
  
  public void takeAgil() {
    //check if gold is 0 or lower
    if (this.agility > STAT_MIN) {
      //take one gold
      this.agility--;
    }
  }
  
  /**
   * Gold getter.
   */
  
  public int getGold() {
    //returns gold value
    return this.gold;
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
