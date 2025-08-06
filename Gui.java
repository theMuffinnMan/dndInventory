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
    private Color myGold = new Color(245, 196, 61);
    private Color offWhite = new Color(251, 255, 235);
    private Color myBrown = new Color(140, 132, 84);
    
    //display sizes
    private final double ITEM_SIDE = 50;
    private final double ITEM_X = 410;
    private final double ITEM_Y = 125;
    
    
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

        this.draw();
    }
    
    /**
     * draw screen
     */
    public void draw(){
        // clear screen
        UI.clearGraphics();
        // background
        UI.setColor(offWhite);
        UI.fillRect(0,0, 550, 480);

        UI.setFontSize(50);
        UI.setColor(Color.black);
        UI.drawRect(0,0, 550, 480);
        
        // character
        UI.setColor(offWhite);
        UI.fillRect(110,30,200,350);
        UI.setColor(Color.black);
        UI.drawRect(110,30,200,350);
        UI.drawImage(this.charCol.getCharacter().getImage(), 115, 35, 190, 340);
        
        // inventory
        for(int i = 0; i < 3; i++){
            UI.setColor(offWhite);
            UI.fillRect(ITEM_X, ITEM_Y + i * (ITEM_SIDE + 5), ITEM_SIDE, ITEM_SIDE);
            UI.setColor(Color.black);
            UI.drawRect(ITEM_X, ITEM_Y + i * (ITEM_SIDE + 5), ITEM_SIDE, ITEM_SIDE);
        }
        
        //item images
        UI.setColor(Color.black);
        this.invImg();
        UI.setColor(offWhite);
        // hand item
        UI.fillRect(330,155, ITEM_SIDE, ITEM_SIDE);
        UI.setColor(Color.black);
        UI.drawRect(330,155, ITEM_SIDE, ITEM_SIDE);
        UI.drawImage(this.charCol.getCharacter().getHand().getImage(), 335, 160, ITEM_SIDE - 10, ITEM_SIDE - 10);
        
        //Stats
        UI.setColor(offWhite);
        UI.fillRect(10,90,90,ITEM_SIDE);
        UI.fillRect(10,165,90,ITEM_SIDE);
        UI.fillRect(10,240,90,ITEM_SIDE);
        UI.setColor(Color.black);
        UI.drawRect(10,90,90,ITEM_SIDE);
        UI.drawRect(10,165,90,ITEM_SIDE);
        UI.drawRect(10,240,90,ITEM_SIDE);
        // gold
        UI.setColor(offWhite);
        UI.fillRect(410, 30, 110, 35);
        UI.setColor(Color.black);
        UI.drawRect(410, 30, 110, 35);
        //gold up
        UI.setColor(Color.green);
        UI.fillRect(505, 35, 10, 10);
        UI.setColor(Color.black);
        UI.drawRect(505, 35, 10, 10);
        //gold down
        UI.setColor(Color.red);
        UI.fillRect(505, 50, 10, 10);
        UI.setColor(Color.black);
        UI.drawRect(505, 50, 10, 10);
        
        //name
        UI.setColor(offWhite);
        UI.fillRect(110, 385, 100, 30);
        UI.setColor(Color.black);
        UI.drawRect(110, 385, 100, 30);
        
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
        UI.drawString(this.charCol.getCharacter().getName(), 110, 410);
    }
    
    /**
     * draw inventory images
     */
    public void invImg(){
        //loop through inventory arraylist
        // prints in diff place depending on i value
        for ( int i = 0; i < charCol.getCharacter().getInv().size(); i++){
          UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), ITEM_X + 5, ITEM_Y + 5 + (i * (ITEM_SIDE + 5)), ITEM_SIDE - 10, ITEM_SIDE - 10);
        }
    }
    
    /**
     * doMouse
     * all clickable areas
     */
    public void doMouse(String action, double mouseX, double mouseY){
        try{
            if(action.equals("clicked") && mouseX > 505 && mouseX < 515 && mouseY > 35 && mouseY < 45){
                //Gold up button 
                this.charCol.getCharacter().addGold();
            }else if(action.equals("clicked") && mouseX > 505 && mouseX < 515 && mouseY > 50 && mouseY < 60){
                //Gold down button
                this.charCol.getCharacter().takeGold();
            }
            //checks mouse is in right place, and for highlight.
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && mouseY > ITEM_Y && mouseY < ITEM_Y + ITEM_SIDE){
                //item 1
                //swap item with hand item
                this.charCol.getCharacter().setHand(0, this.charCol.getCharacter().getInv().get(0));
            }
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && 
                    mouseY > ITEM_Y + ITEM_SIDE + 5 && mouseY < ITEM_Y + (2 * ITEM_SIDE) + 5){
                //item 2 475, 130, 40, 40
                //swap item with hand item
                this.charCol.getCharacter().setHand(1, this.charCol.getCharacter().getInv().get(1));
            }
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && 
                    mouseY > ITEM_Y + 2 * (ITEM_SIDE + 5) && mouseY < ITEM_Y + 2*(ITEM_SIDE + 5) + ITEM_SIDE) {
                //item 3 415, 190, 40, 40
                //swap item with hand item
                this.charCol.getCharacter().setHand(2, this.charCol.getCharacter().getInv().get(2));
            }
            this.draw();
            
        
            //item 3
            //item 4
            //hand item
        }
        catch(Exception e){
            //do nothing
        }
    }
     
    /**
     * main function
     */
    public static void main(String[] args){
        Gui gui = new Gui();
    }
}
