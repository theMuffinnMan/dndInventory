
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
    private int id;

    /**
     * Constructor for objects of class Item
     */
    public Item(String nm, int key)
    {
        // initialise instance variables
        name = nm;
        id = key;
    }
    
    /**
     * name getter
     */
    public String getName(){
        //returns items name
        return name;
    }
    
    /**
     * id getter
     */
    public int getId(){
        //returns items name
        return id;
    }
}