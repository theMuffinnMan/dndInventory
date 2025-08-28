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
    
    
    private String boxText1 = null;
    private String boxText2 = null;
    
    //display sizes
    private final double ITEM_SIDE = 50;
    private final double ITEM_X = 450;
    private final double ITEM_Y = 50;
    
    private final double GOLD_X = 330;
    
    //highlight swap trackers
    private boolean handLight = false;
    private boolean invLight = false;
    
    
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
        UI.addButton("Nadja", this::charNadja);
        UI.addButton("Mika", this::charMika);

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
        this.drawBox(110, 30, 200, 350);
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
        this.drawBox(GOLD_X,ITEM_Y + 55, ITEM_SIDE * 2, ITEM_SIDE * 2);
        UI.drawImage(this.charCol.getCharacter().getHand().getImage(), 335, ITEM_Y + 60, ITEM_SIDE * 2 - 10, ITEM_SIDE * 2 - 10);
        
        //text box under inventory
        this.drawBox(GOLD_X, 230, 170, ITEM_SIDE * 2);
        
        //Stats
        for( int i = 0; i < 3; i++){
            this.drawBox(10, ITEM_Y +(115 * i), 90, ITEM_SIDE);
        }

        // gold
        this.drawBox(this.GOLD_X, this.ITEM_Y, 110, 35);
        //gold up
        UI.setColor(Color.green);
        UI.fillRect(this.GOLD_X + 95, this.ITEM_Y + 5, 10, 10);
        UI.setColor(Color.black);
        UI.drawRect(this.GOLD_X + 95, this.ITEM_Y + 5, 10, 10);;
        //gold down
        UI.setColor(Color.red);
        UI.fillRect(this.GOLD_X + 95, this.ITEM_Y + 20, 10, 10);
        UI.setColor(Color.black);
        UI.drawRect(this.GOLD_X + 95, this.ITEM_Y + 20, 10, 10);
        
        //name
        this.drawBox(110, 385, 200, 30);
        
        //words
        UI.setFontSize(22);
        UI.setColor(Color.black);
        //stats
        UI.drawString("HP: " + this.charCol.getCharacter().getHp(), 15, ITEM_Y + 35);
        UI.drawString("STR: " + this.charCol.getCharacter().getStrength(), 15, ITEM_Y + 150);
        UI.drawString("INT: " + this.charCol.getCharacter().getIntel(), 15, ITEM_Y + 265);
        
        //gold
        UI.drawString("Gold: " + this.charCol.getCharacter().getGold(), (this.GOLD_X + 5), (this.ITEM_Y + 30));
        
        //name
        UI.drawString("Name: " + this.charCol.getCharacter().getName(), 110, 410);
        
        //text box
        try{
            UI.drawString(boxText1, GOLD_X + 10, 270);
        } 
        catch(Exception e){
            //do nothing
        }
        try{
            UI.drawString(boxText2, GOLD_X + 10, 310);
        } 
        catch(Exception e){
            //do nothing
        }
    }
    
    /**
     * swtiches character to najda
     */
    public void charNadja(){
        this.charCol.swapCharacter(1);
        this.boxText1 = null;
        this.boxText2 = null;
        this.draw();
    }
    
    /**
     * swtiches character to mika
     */
    public void charMika(){
        this.charCol.swapCharacter(2);
        this.boxText1 = null;
        this.boxText2 = null;
        this.draw();
    }
    
    /**
     * box drawer
     */
    public void drawBox(double x, double y, double width, double height){
        UI.setColor(offWhite);
        UI.fillRect(x,y ,width ,height);
        UI.setColor(Color.black);
        UI.drawRect(x,y ,width ,height);
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
            if(action.equals("clicked") && mouseX > GOLD_X + 95 && mouseX < GOLD_X + 105 && mouseY > ITEM_Y + 5 && mouseY < ITEM_Y + 15){
                //Gold up button 
                this.charCol.getCharacter().addGold();
            }else if(action.equals("clicked") && mouseX > GOLD_X + 95 && mouseX < GOLD_X + 105 && mouseY > ITEM_Y + 20 && mouseY < ITEM_Y + 30){
                //Gold down button
                this.charCol.getCharacter().takeGold();
            }
            //checks mouse is in right place, and for highlight.
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && mouseY > ITEM_Y && mouseY < ITEM_Y + ITEM_SIDE){
                //item 1
                //item text
                this.boxText1 = this.charCol.getCharacter().getInv().get(0).getName();
                this.boxText2 = null;
                //swap item with hand item
                this.charCol.getCharacter().setHand(0, this.charCol.getCharacter().getInv().get(0));
            }
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && 
                    mouseY > ITEM_Y + ITEM_SIDE + 5 && mouseY < ITEM_Y + (2 * ITEM_SIDE) + 5){
                //item 2 475, 130, 40, 40
                //item text
                this.boxText1 = this.charCol.getCharacter().getInv().get(1).getName();
                this.boxText2 = null;
                //swap item with hand item
                this.charCol.getCharacter().setHand(1, this.charCol.getCharacter().getInv().get(1));
            }
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && 
                    mouseY > ITEM_Y + 2 * (ITEM_SIDE + 5) && mouseY < ITEM_Y + 2*(ITEM_SIDE + 5) + ITEM_SIDE) {
                //item 3 415, 190, 40, 40
                //item text
                this.boxText1 = this.charCol.getCharacter().getInv().get(2).getName();
                this.boxText2 = null;
                //swap item with hand item
                this.charCol.getCharacter().setHand(2, this.charCol.getCharacter().getInv().get(2));
            }
            //hand item
            else if(action.equals("clicked") && mouseX > GOLD_X && mouseX < GOLD_X + ITEM_SIDE * 2 && 
                    mouseY > ITEM_Y + 55 && mouseY < ITEM_Y + 55 + ITEM_SIDE * 2){
                    //draw text in item box when clicked on
                    //GOLD_X,ITEM_Y + 55, ITEM_SIDE * 2, ITEM_SIDE * 2
                    this.boxText1 = this.charCol.getCharacter().getHand().getName();
                    this.boxText2 = null;
            }
            
            //stat clickables
            //hp
            else if(action.equals("clicked") && mouseX > 10 && mouseX < 90 && 
                    mouseY > ITEM_Y && mouseY < ITEM_Y + ITEM_SIDE){
                    //draw text in item box when clicked on
                    this.boxText1 = "Hit Points!";
                    this.boxText2 = "How healthly you are!";
            }
            //stregnth
            else if(action.equals("clicked") && mouseX > 10 && mouseX < 90 && 
                    mouseY > ITEM_Y + 115 && mouseY < ITEM_Y + ITEM_SIDE + 115){
                    //draw text in item box when clicked on
                    this.boxText1 = "Strength!";
                    this.boxText2 = "How strong you are!";
            }
            //intellegence
            else if(action.equals("clicked") && mouseX > 10 && mouseX < 90 && 
                    mouseY > ITEM_Y +(115 * 2) && mouseY < ITEM_Y +(115 * 2) + ITEM_SIDE){
                    //draw text in item box when clicked on
                    this.boxText1 = "Intellegence!";
                    this.boxText2 = "How smart you are!";
            }
            //gold
            else if(action.equals("clicked") && mouseX > GOLD_X && mouseX < GOLD_X + 110 && 
                    mouseY > ITEM_Y && mouseY < ITEM_Y + 35){
                    //draw text in item box when clicked on
                    this.boxText1 = "Gold!";
                    this.boxText2 = "How much money you have!";
            }
            //name and picture
            else if(action.equals("clicked") && mouseX > 110 && mouseX < 310 && 
                    mouseY > 30 && mouseY < 415){
                    //draw text in item box when clicked on
                    this.boxText1 = this.charCol.getCharacter().getName();
                    this.boxText2 = "That's you!";
            }
            this.draw();
            
        
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
