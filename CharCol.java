import java.util.HashMap;
/**
 * Manament class for Character.
 * Manages and changes information about Character and Item.
 *
 * @Fleur
 * @17/6
 */
public class CharCol
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Character> characterCollection;
    private int currCharId;
    private Character currChar;

    /**
     * Constructor for objects of class CharCol
     */
    public CharCol()
    {
        // initialise instance variables
        characterCollection = new HashMap<Integer, Character>();
        
        //creates characters for collection
        Character c1 = new Character("Nadja", "img/charPlaceHold.jpg", 24, 15, 8, 25, 
        "Symbol of Urden", "img/urdenPlaceHold.jpg", "Plate Armour", "img/armourPlaceHold.jpg", "Bell Greatsword", "img/greatswordPlaceHold.jpg");
        
        //puts character in collection
        this.characterCollection.put(1, c1);
        
        //sets current character
        this.currCharId = 1;
        this.currChar = characterCollection.get(currCharId);
        
    }
    
    
    
    /**
     * reuturns current character values.
     */
    public Character getCharacter(){
        return currChar;
    }
}
