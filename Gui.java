import ecs100.*;
import java.util.HashMap;
/**
 * Display and user interaction.
 *
 * @Fleur
 * @17/6
 */
public class Gui
{
    // instance variables - replace the example below with your own
    private CharCol charCol;
    /**
     * Constructor for objects of class Gui
     */
    public Gui()
    {
        // initialise instance variables
        charCol = new CharCol();
        
        //Gui buttons
        UI.addButton("Veiw Stats", this::veiwStats);
    }
    
    /**
     * prints cahracter stats in text pane
     */
    public void veiwStats() {
        // prints current characters stats in the text pane.
        //prints name, health, strength, and intellegence
        UI.println("Name: " + charCol.getCharacter().getName());
        UI.println("Health: " + charCol.getCharacter().getHp());
        UI.println("Strength: " + charCol.getCharacter().getStrength());
        UI.println("Intellegence: " + charCol.getCharacter().getIntel());
        UI.println("Gold: " + charCol.getCharacter().getGold());
        
        //print inventory
        //loop through each item and print item
        UI.println("Inventory");
        for ( int i: charCol.getCharacter().getInv().keySet() ){
            UI.println(charCol.getCharacter().getInv().get(i).getName());
        }
    }
    
    /**
     * main function
     */
    public static void main(String[] args){
        Gui gui = new Gui();
    }
}
