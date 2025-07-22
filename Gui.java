import ecs100.*;
import java.util.HashMap;
import java.awt.Color;
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
    //colours
    private Color beige = new Color(251, 234, 157);
    /**
     * Constructor for objects of class Gui
     */
    public Gui()
    {
        // initialise instance variables
        charCol = new CharCol();
        
        //Gui
        //mouse interactions
        UI.setMouseListener(this::doMouse);
        //view options
        UI.addButton("Veiw Stats1", this::veiwStats1);
        UI.addButton("Veiw Stats2", this::veiwStats2);
        UI.addButton("Veiw Stats3", this::veiwStats3);
        
        //swap hand items
        UI.addButton("Swap Hand", this::swapHand);
        
        this.draw();
    }
    
    /**
     * draw screen
     */
    public void draw(){
        // clear screen
        UI.clearGraphics();
        // background
        UI.setColor(beige);
        UI.fillRect(0,0, 700, 700);
        
        // character
        UI.setColor(Color.white);
        UI.fillRect(100,30,200,350);
        UI.drawImage(this.charCol.getCharacter().getImage(), 105, 35, 190, 340);
        
        // inventory
        //item 1
        UI.fillRect(410, 125, 50, 50);
        //item 2
        UI.fillRect(470, 125, 50, 50);
        //item 3
        UI.fillRect(410, 185, 50, 50);
        //item 4
        UI.fillRect(470, 185, 50, 50);
        //item images
        UI.setColor(Color.black);
        this.invImg();
        UI.setColor(Color.white);
        // hand item
        UI.fillRect(330,155, 50, 50);
        UI.drawImage(this.charCol.getCharacter().getHand().getImage(), 335, 160, 40, 40);
        
        //Stats
        UI.fillRect(10,90,80,50);
        UI.fillRect(10,165,80,50);
        UI.fillRect(10,240,80,50);
        // gold
        UI.fillRect(410, 30, 110, 35);
        //gold up
        UI.setColor(Color.green);
        UI.fillRect(505, 35, 10, 10);
        //gold down
        UI.setColor(Color.red);
        UI.fillRect(505, 50, 10, 10);
        
        //words
        UI.setFontSize(22);
        UI.setColor(Color.black);
        //stats
        UI.drawString("HP: " + this.charCol.getCharacter().getHp(), 15, 125);
        UI.drawString("STR: " + this.charCol.getCharacter().getStrength(), 15, 200);
        UI.drawString("INT: " + this.charCol.getCharacter().getIntel(), 15, 275);
        
        //gold
        UI.drawString("Gold: " + this.charCol.getCharacter().getGold(), 415, 60);
        
        //name
        UI.drawString(this.charCol.getCharacter().getName(), 100, 410);
    }
    
    /**
     * draw inventory images
     */
    public void invImg(){
        //loop through inventory hashmap
        // prints in diff place depending on i value
        for ( int i: charCol.getCharacter().getInv().keySet()){
            if(i==1) {
                //Position 1
                UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), 415, 130, 40, 40);
            }else if(i==2){
                //Position 2
                UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), 475, 130, 40, 40);
            }else if(i==3){
                //Position 3
                UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), 415, 190, 40, 40);
            }else{
                //Position 4
                UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), 475, 190, 40, 40);
            }
        }
    }
    
    /**
     * doMouse
     * all clickable areas
     */
    public void doMouse(String action, double mouseX, double mouseY){
        if(action.equals("clicked") && mouseX > 505 && mouseX < 515 && mouseY > 35 && mouseY < 45){
            //Gold up button 
            this.charCol.getCharacter().addGold();
            this.draw();
        }else if(action.equals("clicked") && mouseX > 505 && mouseX < 515 && mouseY > 50 && mouseY < 60){
            this.charCol.getCharacter().takeGold();
            this.draw();
        }
        //Gold down button
        //item 1
        //item 2
        //item 3
        //item 4
        //hand item
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
     * main function
     */
    public static void main(String[] args){
        Gui gui = new Gui();
    }
}
