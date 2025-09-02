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
    private final double ITEM_X = 510;
    private final double ITEM_Y = 50;
    
    private final double GOLD_X = 330;
    
    //highlight swap trackers
    private boolean invLight = false;
    private boolean handLight = false;
    
    
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
        UI.fillRect(0,0, 600, 480);

        UI.setFontSize(50);
        UI.setColor(Color.black);
        UI.drawRect(0,0, 600, 480);
        
        // character
        this.drawBox(110, 30, 200, 350, Color.black);
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
        this.drawBox(GOLD_X,ITEM_Y + 55, ITEM_SIDE * 2, ITEM_SIDE * 2, Color.black);
        UI.drawImage(this.charCol.getCharacter().getHand().getImage(), 335, ITEM_Y + 60, ITEM_SIDE * 2 - 10, ITEM_SIDE * 2 - 10);
        
        //text box under inventory
        this.drawBox(GOLD_X, 230, 230, ITEM_SIDE * 2, Color.black);
        
        //Stats
        for( int i = 0; i < 3; i++){
            this.drawBox(10, ITEM_Y +(115 * i), 90, ITEM_SIDE, Color.black);
        }

        // gold
        this.drawBox(this.GOLD_X, this.ITEM_Y, 110, 35, Color.black);
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
        this.drawBox(110, 385, 200, 30, Color.black);
        
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
        
        //inventory highlights
        try{
            this.drawHighlight();
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
    public void drawBox(double x, double y, double width, double height, Color color){
        UI.setColor(color);
        UI.drawRect(x,y ,width ,height);
    }
    
    /**
     * highlight checker
     */
    public void drawHighlight(){
        // checks what the current item or current highlight is on
        //based on where highlight is supposed to be drawhighlight will draw the highlight in the correct place
        // will be able to set and unset the highlight
        //item 1
        if(this.charCol.getCharacter().getCurrItem().getId() == 0 
            && this.invLight == true){
            this.drawBox(ITEM_X - 10, ITEM_Y - 10, ITEM_SIDE + 20, ITEM_SIDE + 20, Color.green);
        }
        //item 2
        else if(this.charCol.getCharacter().getCurrItem().getId() == 1
            && this.invLight == true){
            this.drawBox(ITEM_X - 10 , ITEM_Y - 10 + (ITEM_SIDE + 5), ITEM_SIDE + 20, ITEM_SIDE + 20, Color.green);
        }
        //item 3
        else if(this.charCol.getCharacter().getCurrItem().getId() == 2
            && this.invLight == true){
            this.drawBox(ITEM_X - 10, ITEM_Y - 10 + 2 * (ITEM_SIDE + 5), ITEM_SIDE + 20, ITEM_SIDE + 20, Color.green);
        }
        //hand item
        else if(this.handLight == true){
            this.drawBox(GOLD_X - 5 ,ITEM_Y + 50, ITEM_SIDE * 2 + 10, ITEM_SIDE * 2 + 10, Color.green);
        }
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
                this.draw();
            }else if(action.equals("clicked") && mouseX > GOLD_X + 95 && mouseX < GOLD_X + 105 && mouseY > ITEM_Y + 20 && mouseY < ITEM_Y + 30){
                //Gold down button
                this.charCol.getCharacter().takeGold();
                this.draw();
            }
            //checks mouse is in right place, and for highlight.
            //item 1
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && mouseY > ITEM_Y && mouseY < ITEM_Y + ITEM_SIDE){
                if(this.invLight == false && this.handLight == false){
                    //item text
                    this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(0));
                    this.boxText1 = this.charCol.getCharacter().getCurrItem().getName();
                    this.boxText2 = null;
                    this.invLight = true;
                    this.draw();
                }
                //if highlithed item is clicked again
                else if(this.invLight == true){
                    //remove highlight
                    this.invLight = false;
                    this.draw();
                }
                //if different item is clicked for highlight
                else if(this.invLight == true){
                    //swap highlight
                }
                else{
                    //swap item with hand item

                    this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(0));
                    this.charCol.getCharacter().setHand();

                    this.invLight = false;
                    this.handLight = false;
                    this.draw();
                }
            }
            //item 2
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && 
                    mouseY > ITEM_Y + ITEM_SIDE + 5 && mouseY < ITEM_Y + (2 * ITEM_SIDE) + 5){
                if(this.invLight == false && this.handLight == false){
                    //item text
                    this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(1));
                    this.boxText1 = this.charCol.getCharacter().getCurrItem().getName();
                    this.boxText2 = null;
                    this.invLight = true;
                    this.draw();
                }
                //if highlithed item is clicked again
                else if(this.invLight == true){
                    //remove highlight
                    this.invLight = false;
                    this.draw();
                }
                //if different item is clicked for highlight
                else if(this.invLight == true){
                    //swap highlight
                }
                else{
                    //swap item with hand item
                    
                    this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(1));
                    this.charCol.getCharacter().setHand();

                    this.invLight = false;
                    this.handLight = false;
                    this.draw();
                }
            }
            //item 3
            else if(action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE && 
                    mouseY > ITEM_Y + 2 * (ITEM_SIDE + 5) && mouseY < ITEM_Y + 2*(ITEM_SIDE + 5) + ITEM_SIDE) {
                if(this.invLight == false && this.handLight == false){
                    //item text
                    this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(2));
                    this.boxText1 = this.charCol.getCharacter().getCurrItem().getName();
                    this.boxText2 = null;
                    this.invLight = true;
                    this.draw();
                }
                //if highlithed item is clicked again
                else if(this.invLight == true){
                    //remove highlight
                    this.invLight = false;
                    this.draw();
                }
                //if different item is clicked for highlight
                else if(this.invLight == true){
                    //swap highlight
                }
                else{
                    //swap item with hand item
                    this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(2));
                    this.charCol.getCharacter().setHand();

                    this.invLight = false;
                    this.handLight = false;
                    this.draw();
                }
            }
            //hand item
            else if(action.equals("clicked") && mouseX > GOLD_X && mouseX < GOLD_X + ITEM_SIDE * 2 && 
                mouseY > ITEM_Y + 55 && mouseY < ITEM_Y + 55 + ITEM_SIDE * 2){
                //draw text in item box when clicked on
                if(this.handLight == false && this.invLight == false){
                    this.boxText1 = this.charCol.getCharacter().getHand().getName();
                    this.boxText2 = null;                         
                    this.handLight = true;
                    this.draw();
                }
                else if(this.handLight == true && this.invLight == false){
                    //remove highlight
                    this.handLight = false;
                    this.draw();
                }else{
                    //swaphand
                    this.handLight = false;
                    this.invLight = false;
                    this.charCol.getCharacter().setHand();
                    this.draw();
                }
            }
            else if(action.equals("clicked") && mouseX > 10 && mouseX < 90 && 
                    mouseY > ITEM_Y && mouseY < ITEM_Y + ITEM_SIDE){
                //draw text in item box when clicked on
                this.boxText1 = "Hit Points!";
                this.boxText2 = "How healthly you are!";
                this.draw();
            }
            //stregnth
            else if(action.equals("clicked") && mouseX > 10 && mouseX < 90 && 
                    mouseY > ITEM_Y + 115 && mouseY < ITEM_Y + ITEM_SIDE + 115){
                //draw text in item box when clicked on
                this.boxText1 = "Strength!";
                this.boxText2 = "How strong you are!";
                this.draw();
            }
            //intellegence
            else if(action.equals("clicked") && mouseX > 10 && mouseX < 90 && 
                    mouseY > ITEM_Y +(115 * 2) && mouseY < ITEM_Y +(115 * 2) + ITEM_SIDE){
                //draw text in item box when clicked on
                this.boxText1 = "Intellegence!";
                this.boxText2 = "How smart you are!";
                this.draw();
            }
            //gold
            else if(action.equals("clicked") && mouseX > GOLD_X && mouseX < GOLD_X + 110 && 
                    mouseY > ITEM_Y && mouseY < ITEM_Y + 35){
                //draw text in item box when clicked on
                this.boxText1 = "Gold!";
                this.boxText2 = "How rich you are!";
                this.draw();
            }
            //name and picture
            else if(action.equals("clicked") && mouseX > 110 && mouseX < 310 && 
                    mouseY > 30 && mouseY < 415){
                //draw text in item box when clicked on
                this.boxText1 = this.charCol.getCharacter().getName();
                this.boxText2 = "That's you!";
                this.draw();
            }
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
