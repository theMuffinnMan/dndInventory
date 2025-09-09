import java.util.HashMap;
/**
 * Manament class for Character.
 * Manages and changes information about Character and Item.
 *
 * @Fleur
    17/6
 */

public class CharCol {
  // instance variables - replace the example below with your own
  private HashMap<Integer, Character> characterCollection;
  private int currCharId;
  private Character currChar;

  /**
   * Constructor for objects of class CharCol.
   */
  public CharCol() {
    // initialise instance variables
    characterCollection = new HashMap<Integer, Character>();
    
    //creates characters for collection
    Character c1 = new Character("Nadja", "img/charPlaceHold.jpg", 24, 15, 8, 25, 
        "Symbol of Urden", "img/urdenPlaceHold.jpg", "Plate Armour", 
        "img/armourPlaceHold.jpg", "Bell Greatsword", "img/greatswordPlaceHold.jpg");
    Character c2 = new Character("Micah", "img/micah.jpg", 20, 10, 16, 35,
        "Fireball Helmet", "img/helmet.jpg", "Catalyst", "img/catalyst.jpg", 
        "Moonbeam", "img/moonbeam.jpg");
    
    //puts character in collection
    this.characterCollection.put(1, c1);
    this.characterCollection.put(2, c2);
    
    //sets current character
    this.currCharId = 1;
    this.currChar = characterCollection.get(currCharId);
    
  }
  
  /**
   * Swap cahracters.
   */
  public void swapCharacter(int id) {
    //set current character id 
    this.currCharId = id;
    this.currChar = characterCollection.get(currCharId);
  }
  
  
  /**
   * Reuturns current character values.
   */
  public Character getCharacter() {
    return currChar;
  }
}
