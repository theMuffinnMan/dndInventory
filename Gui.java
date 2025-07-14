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
        //view options
        UI.addButton("Veiw Stats1", this::veiwStats1);
        UI.addButton("Veiw Stats2", this::veiwStats2);
        UI.addButton("Veiw Stats3", this::veiwStats3);
        
        //swap hand items
        UI.addButton("Swap Hand", this::swapHand);
        
        //gold edit options
        UI.addButton("Add Gold", this::addGold);
        UI.addButton("Take Gold", this::takeGold);
        
    }
    
    /**
     * prints cahracter stats in text pane
     */
    public void veiwStats1() {
        // prints current characters stats in the text pane.
        UI.clearText();
        //prints name, health, strength, and intellegence
        UI.println("Name: " + charCol.getCharacter().getName());
        UI.println("Health: " + charCol.getCharacter().getHp());
        UI.println("Strength: " + charCol.getCharacter().getStrength());
        UI.println("Intellegence: " + charCol.getCharacter().getIntel());
        UI.println("Gold: " + charCol.getCharacter().getGold());
        
        //print hand
        UI.println("Hand Item: " + charCol.getCharacter().getHand().getName());
        
        //print inventory
        //loop through each item and print item
        UI.print("Inventory: ");
        for ( int i: charCol.getCharacter().getInv().keySet()){
            UI.print(charCol.getCharacter().getInv().get(i).getName());
            if ( i < charCol.getCharacter().getInv().size()){
                UI.print(", ");
            }
        }
    }
    
    /**
     * prints cahracter stats in text pane displays inventroy before stats
     */
    public void veiwStats2() {
        // prints current characters stats in the text pane.
        //clears textpane
        UI.clearText();
        UI.println("Name: " + charCol.getCharacter().getName());
        
        //print hand
        UI.println("Hand Item: " + charCol.getCharacter().getHand().getName());
        
        //print inventory
        //loop through each item and print item
        UI.print("Inventory: ");
        for ( int i: charCol.getCharacter().getInv().keySet()){
            UI.print(charCol.getCharacter().getInv().get(i).getName());
            if ( i < charCol.getCharacter().getInv().size()){
                UI.print(", ");
            }
        }
        //prints name, health, strength, and intellegence
        UI.println();
        UI.println("Health: " + charCol.getCharacter().getHp());
        UI.println("Strength: " + charCol.getCharacter().getStrength());
        UI.println("Intellegence: " + charCol.getCharacter().getIntel());
        UI.println("Gold: " + charCol.getCharacter().getGold());
    }
    
    /**
     * prints cahracter stats in text pane
     */
    public void veiwStats3() {
        // prints current characters stats in the text pane.
        UI.clearText();
        //prints name, health, strength, and intellegence
        UI.println("Name: " + charCol.getCharacter().getName());
        UI.println("Gold: " + charCol.getCharacter().getGold());
        UI.println("Health: " + charCol.getCharacter().getHp());
        UI.println("Strength: " + charCol.getCharacter().getStrength());
        UI.println("Intellegence: " + charCol.getCharacter().getIntel());
        
        //print hand
        UI.println("Hand Item: " + charCol.getCharacter().getHand().getName());
        
        //print inventory
        //loop through each item and print item
        UI.print("Inventory: ");
        for ( int i: charCol.getCharacter().getInv().keySet()){
            UI.print(charCol.getCharacter().getInv().get(i).getName());
            if ( i < charCol.getCharacter().getInv().size()){
                UI.print(", ");
            }
        }
    }
    
    /**
     * chose inventory item to swap with hand item
     */
    public void swapHand() {
        UI.clearText();
        //find item that will be swapped
        // allows user to enter the name of a card
        String cardName = UI.askString("Which Item do you want to swap?: ");
        // search for card
        if (this.charCol.getCharacter().findItem(cardName.toLowerCase().trim())) {
          // tell the user the item is found
          UI.println("Item swapped!");
          
          //swap items
          this.charCol.getCharacter().setHand();

        } else {
          UI.println("This character doesnt have that item!");
        }
    }
    
    /**
     * add gold button
     */
    public void addGold(){
        UI.clearText();
        this.charCol.getCharacter().addGold();
        UI.println("Gold is now " + this.charCol.getCharacter().getGold());
    }
    
    /**
     * take gold button
     */
    public void takeGold(){
        UI.clearText();
        this.charCol.getCharacter().takeGold();
        UI.println("Gold is now " + this.charCol.getCharacter().getGold());
    }
    
    /**
     * main function
     */
    public static void main(String[] args){
        Gui gui = new Gui();
    }
}
