
/**
 * Item class.
 * Stores information about the characters items.
 *
 * @Fleur
 * @17/6
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;

    /**
     * Constructor for objects of class Item
     */
    public Item(String nm)
    {
        // initialise instance variables
        name = nm;
    }
    
    /**
     * name getter
     */
    public String getName(){
        //returns items name
        return name;
    }
}