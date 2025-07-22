
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
    private String image;
    private int id;

    /**
     * Constructor for objects of class Item
     */
    public Item(String nm, String img, int key)
    {
        // initialise instance variables
        name = nm;
        image = img;
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
     * image getter
     */
    public String getImage(){
        //returns image file name
        return image;
    }
    
    /**
     * id getter
     */
    public int getId(){
        //returns items name
        return id;
    }
}