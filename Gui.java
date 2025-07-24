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
        UI.fillRect(0,0, 1000, 1000);
        
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
        for ( int i = 0; i < charCol.getCharacter().getInv().size(); i++){
            if(i==0) {
                //Position 1
                UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), 415, 130, 40, 40);
            }else if(i==1){
                //Position 2
                UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), 475, 130, 40, 40);
            }else if(i==2){
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
        try{
            if(action.equals("clicked") && mouseX > 505 && mouseX < 515 && mouseY > 35 && mouseY < 45){
                //Gold up button 
                this.charCol.getCharacter().addGold();
            }else if(action.equals("clicked") && mouseX > 505 && mouseX < 515 && mouseY > 50 && mouseY < 60){
                //Gold down button
                this.charCol.getCharacter().takeGold();
            }
            //checks mouse is in right place, and for highlight.
            else if(action.equals("clicked") && mouseX > 410 && mouseX < 460 && mouseY > 125 && mouseY < 175){
                //item 1
                //swap item with hand item
                this.charCol.getCharacter().setHand(0, this.charCol.getCharacter().getInv().get(0));
            }
            else if(action.equals("clicked") && mouseX > 470 && mouseX < 520 && mouseY > 125 && mouseY < 175){
                //item 2 475, 130, 40, 40
                //swap item with hand item
                this.charCol.getCharacter().setHand(1, this.charCol.getCharacter().getInv().get(1));
            }
            else if(action.equals("clicked") && mouseX > 410 && mouseX < 460 && mouseY > 185 && mouseY < 235){
                //item 3 415, 190, 40, 40
                //swap item with hand item
                this.charCol.getCharacter().setHand(2, this.charCol.getCharacter().getInv().get(2));
            }
            else if(action.equals("clicked") && mouseX > 470 && mouseX < 520 && mouseY > 185 && mouseY < 235){
                //item 4 475, 190, 40, 40
                //swap item with hand item
                this.charCol.getCharacter().setHand(3, this.charCol.getCharacter().getInv().get(3));
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
