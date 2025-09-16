import ecs100.UI;
import ecs100.UIFileChooser;
import java.awt.Color;
import java.util.HashMap;
/**
 * Display and user interaction.
 *
 * @Fleur
    17/6
 */

public class Gui {
  // instance variables - replace the example below with your own
  private CharCol charCol;
  //colours
  private Color myGold = new Color(245, 196, 61);
  private Color offWhite = new Color(251, 255, 235);
  private Color myBrown = new Color(140, 132, 84);
  
  
  private String boxText1 = null;
  private String boxText2 = null;
  
  //display sizes
  private static final double ITEM_SIDE = 50;
  private static final double ITEM_X = 510;
  
  private static final double GOLD_X = 330;
  
  //highlight swap trackers
  private boolean invLight = false;
  private boolean handLight = false;
  
  
  /**
   * Constructor for objects of class Gui.
   */
  
  public Gui() {
    // initialise instance variables
    charCol = new CharCol();
    
    //Gui
    //mouse interactions
    UI.setMouseListener(this::doMouse);
    UI.addButton("Nadja", this::charNadja);
    UI.addButton("Micah", this::charMicah);

    this.draw();
  }
  
  /**
   * Draw screen.
   */
  
  public void draw() {
    // clear screen
    UI.clearGraphics();
    // background
    UI.setColor(offWhite);
    UI.fillRect(0, 0, 600, 480);

    UI.setFontSize(50);
    UI.setLineWidth(2);
    UI.setColor(Color.black);
    UI.drawRect(0, 0, 600, 480);
    
    // character
    this.drawBox(110, 30, 200, 350, Color.black);
    UI.drawImage(this.charCol.getCharacter().getImage(), 115, 35, 190, 340);
    
    // inventory
    for (int i = 0; i < 3; i++) {
      UI.setColor(offWhite);
      UI.fillRect(ITEM_X, ITEM_SIDE + i * (ITEM_SIDE + 5), ITEM_SIDE, ITEM_SIDE);
      UI.setColor(Color.black);
      UI.drawRect(ITEM_X, ITEM_SIDE + i * (ITEM_SIDE + 5), ITEM_SIDE, ITEM_SIDE);
    }
    
    //item images
    UI.setColor(Color.black);
    this.invImg();
    UI.setColor(offWhite);
    // hand item
    this.drawBox(GOLD_X, ITEM_SIDE + 55, ITEM_SIDE * 2, ITEM_SIDE * 2, Color.black);
    UI.drawImage(this.charCol.getCharacter().getHand().getImage(), 335,
        ITEM_SIDE + 60, ITEM_SIDE * 2 - 10, ITEM_SIDE * 2 - 10);
    
    //text box under inventory
    this.drawBox(GOLD_X, 230, 230, ITEM_SIDE * 2, Color.black);
    
    // SPECIAL ABILITY
    this.drawBox(GOLD_X + 85, ITEM_SIDE * 7, ITEM_SIDE, ITEM_SIDE, Color.black);
    UI.drawImage("img/ability.jpg",
                GOLD_X + 85, ITEM_SIDE * 7, ITEM_SIDE, ITEM_SIDE);
    
    //Stats
    for (int i = 0; i < 4; i++) {
      this.drawBox(10, 35 + (100 * i), 90, ITEM_SIDE + 25, Color.black);
    }

    //stats up
    for (int i = 0; i < 4; i++) {
      UI.setColor(Color.green);
      UI.fillRect(70, 85 + (100 * i), 15, 15);
      this.drawBox(70, 85 + (100 * i), 15, 15, Color.black);
    }
    
    // stats down
    for (int i = 0; i < 4; i++) {
      UI.setColor(Color.red);
      UI.fillRect(30, 85 + (100 * i), 15, 15);
      this.drawBox(30, 85 + (100 * i), 15, 15, Color.black);
    }
    
    // gold
    this.drawBox(this.GOLD_X, this.ITEM_SIDE, 110, 35, Color.black);
    //gold up
    UI.setColor(Color.green);
    UI.fillRect(this.GOLD_X + 95, this.ITEM_SIDE + 5, 10, 10);
    UI.setColor(Color.black);
    UI.drawRect(this.GOLD_X + 95, this.ITEM_SIDE + 5, 10, 10);;
    //gold down
    UI.setColor(Color.red);
    UI.fillRect(this.GOLD_X + 95, this.ITEM_SIDE + 20, 10, 10);
    UI.setColor(Color.black);
    UI.drawRect(this.GOLD_X + 95, this.ITEM_SIDE + 20, 10, 10);
    
    //name
    this.drawBox(110, 385, 200, 30, Color.black);
    
    //words
    UI.setFontSize(22);
    UI.setColor(Color.black);
    
    //stats
    UI.drawString("HP: " + this.charCol.getCharacter().getHp(), 15, ITEM_SIDE + 25);
    UI.drawString("STR: " + this.charCol.getCharacter().getStrength(), 15, ITEM_SIDE + 125);
    UI.drawString("INT: " + this.charCol.getCharacter().getIntel(), 15, ITEM_SIDE + 225);
    UI.drawString("AGL: " + this.charCol.getCharacter().getAgil(), 15, ITEM_SIDE + 325);
    
    //gold
    UI.drawString("Gold: " + this.charCol.getCharacter().getGold(),
        (this.GOLD_X + 5), (this.ITEM_SIDE + 30));
    
    //name
    UI.drawString("Name: " + this.charCol.getCharacter().getName(), 110, 410);
    
    //text box
    try {
      UI.drawString(boxText1, GOLD_X + 10, 270);
    } catch (Exception e) {
      //do nothing
    }
    try {
      UI.drawString(boxText2, GOLD_X + 10, 310);
    } catch (Exception e) {
      //do nothing
    }
    
    //inventory highlights
    try {
      this.drawHighlight();
    } catch (Exception e) {
      //do nothing
    }
  }
  
  /**
   * Swtiches character to najda.
   */
  
  public void charNadja() {
    this.charCol.swapCharacter(1);
    this.boxText1 = null;
    this.boxText2 = null;
    this.draw();
  }
  
  /**
   * Swtiches character to Micah.
   */
  
  public void charMicah() {
    this.charCol.swapCharacter(2);
    this.boxText1 = null;
    this.boxText2 = null;
    this.draw();
  }
  
  /**
   * Box drawer.
   */
  
  public void drawBox(double x, double y, double width, double height, Color color) {
    UI.setColor(color);
    UI.drawRect(x, y, width, height);
  }
  
  /**
   * Highlight checker.
   */
  
  public void drawHighlight() {
    // checks what the current item or current highlight is on
    //based on where highlight is supposed to be drawhighlight 
    //will draw the highlight in the correct place
    // will be able to set and unset the highlight
    //item 1
    UI.setLineWidth(10);
    //hand item
    if (this.handLight == true) {
      this.drawBox(GOLD_X - 5, ITEM_SIDE + 50, ITEM_SIDE * 2 + 10, ITEM_SIDE * 2 + 10, Color.blue);
    } else if (this.charCol.getCharacter().getCurrItem().getId() == 0 
          && this.invLight == true) {
      //item 1
      this.drawBox(ITEM_X - 5, ITEM_SIDE - 5, ITEM_SIDE + 10, ITEM_SIDE + 10, Color.blue);
    } else if (this.charCol.getCharacter().getCurrItem().getId() == 1
          && this.invLight == true) {
      //item 2
      this.drawBox(ITEM_X - 5, ITEM_SIDE - 5 + (ITEM_SIDE + 5), ITEM_SIDE + 10, 
          ITEM_SIDE + 10, Color.blue);
    } else if (this.charCol.getCharacter().getCurrItem().getId() == 2
          && this.invLight == true) {
      //item 3
      this.drawBox(ITEM_X - 5, ITEM_SIDE - 5 + 2 * (ITEM_SIDE + 5), ITEM_SIDE + 10,
          ITEM_SIDE + 10, Color.blue);
    }
  }
  
  /**
   * Draw inventory images.
   */
  
  public void invImg() {
    //loop through inventory arraylist
    // prints in diff place depending on i value
    for (int i = 0; i < charCol.getCharacter().getInv().size(); i++) {
      UI.drawImage(this.charCol.getCharacter().getInv().get(i).getImage(), ITEM_X + 5, 
          ITEM_SIDE + 5 + (i * (ITEM_SIDE + 5)), ITEM_SIDE - 10, ITEM_SIDE - 10);
    }
  }
  
  /**
   * Controls mouse control for the gui.
   * doMouse
   * all clickable areas
   */
  
  public void doMouse(String action, double mouseX, double mouseY) {
    try {
      if (action.equals("clicked") && mouseX > GOLD_X + 95 
          && mouseX < GOLD_X + 105 && mouseY > ITEM_SIDE + 5 
          && mouseY < ITEM_SIDE + 15) {
        //Gold up button 
        this.charCol.getCharacter().addGold();
        this.draw();
      } else if (action.equals("clicked") && mouseX > GOLD_X + 95 
          && mouseX < GOLD_X + 105 && mouseY > ITEM_SIDE + 20 
          && mouseY < ITEM_SIDE + 30) {
        //Gold down button---
        this.charCol.getCharacter().takeGold();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 70 
          && mouseX < 85 && mouseY > 85 
          && mouseY < ITEM_SIDE * 2) {
        //Hp up
        //70, 85 + (100 * i), 15, 15
        this.charCol.getCharacter().addHp();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 30
          && mouseX < 45 && mouseY > 85 
          && mouseY < ITEM_SIDE * 2) {
        //Hp down
        this.charCol.getCharacter().takeHp();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 70
          && mouseX < 85 && mouseY > 185 
          && mouseY < ITEM_SIDE * 4) {
        //str up
        this.charCol.getCharacter().addStrength();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 30
          && mouseX < 45 && mouseY > 185 
          && mouseY < ITEM_SIDE * 4) {
        //str down
        this.charCol.getCharacter().takeStrength();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 70 
          && mouseX < 85 && mouseY > 285 
          && mouseY < ITEM_SIDE *  6) {
        //int up
        this.charCol.getCharacter().addInt();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 30
          && mouseX < 45 && mouseY > 285 
          && mouseY < ITEM_SIDE * 6) {
        //int down
        this.charCol.getCharacter().takeInt();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 70 
          && mouseX < 85 && mouseY > 385
          && mouseY < ITEM_SIDE * 8) {
        //agil up
        this.charCol.getCharacter().addAgil();
        this.draw();
      } else if (action.equals("clicked") && mouseX > 30
          && mouseX < 45 && mouseY > 385 
          && mouseY < ITEM_SIDE * 8) {
        //agil down
        this.charCol.getCharacter().takeAgil();
        this.draw();
      } else if (action.equals("clicked") && mouseX > ITEM_X 
          && mouseX < ITEM_X + ITEM_SIDE && mouseY > ITEM_SIDE 
          && mouseY < ITEM_SIDE + ITEM_SIDE) {
        //checks mouse is in right place, and for highlight.
        //item 1
        if (this.invLight == false && this.handLight == false) {
          //item text
          this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(0));
          this.boxText1 = this.charCol.getCharacter().getCurrItem().getName();
          this.boxText2 = null;
          this.invLight = true;
          this.draw();
        } else if (this.invLight == true) {
          //if highlithed item is clicked again
          //remove highlight
          this.invLight = false;
          this.draw();
        } else if (this.invLight == true) {
          //if different item is clicked for highlight
          //swap highlight
        } else {
          //swap item with hand item

          this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(0));
          this.charCol.getCharacter().setHand();

          this.invLight = false;
          this.handLight = false;
          this.draw();
        }
      } else if (action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE  
          && mouseY > ITEM_SIDE + ITEM_SIDE + 5 && mouseY < ITEM_SIDE + (2 * ITEM_SIDE) + 5) {
        if (this.invLight == false && this.handLight == false) {
          //item 2
          //item text
          this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(1));
          this.boxText1 = this.charCol.getCharacter().getCurrItem().getName();
          this.boxText2 = null;
          this.invLight = true;
          this.draw();
        } else if (this.invLight == true) {
          //if highlithed item is clicked again
          //remove highlight
          this.invLight = false;
          this.draw();
        } else if (this.invLight == true) {
          //if different item is clicked for highlight
          //swap highlight
        } else {
          //swap item with hand item
          
          this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(1));
          this.charCol.getCharacter().setHand();

          this.invLight = false;
          this.handLight = false;
          this.draw();
        }
      } else if (action.equals("clicked") && mouseX > ITEM_X && mouseX < ITEM_X + ITEM_SIDE 
          && mouseY > ITEM_SIDE + 2 * (ITEM_SIDE + 5) && mouseY < ITEM_SIDE + 2 * (ITEM_SIDE + 5) 
          + ITEM_SIDE) {
        //item 3
        if (this.invLight == false && this.handLight == false) {
          //item text
          this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(2));
          this.boxText1 = this.charCol.getCharacter().getCurrItem().getName();
          this.boxText2 = null;
          this.invLight = true;
          this.draw();
        } else if (this.invLight == true) {
          //if highlithed item is clicked again
          //remove highlight
          this.invLight = false;
          this.draw();
        } else if (this.invLight == true) {
          //if different item is clicked for highlight
          //swap highlight
        } else {
          //swap item with hand item
          this.charCol.getCharacter().setCurrItem(this.charCol.getCharacter().getInv().get(2));
          this.charCol.getCharacter().setHand();

          this.invLight = false;
          this.handLight = false;
          this.draw();
        }
      } else if (action.equals("clicked") && mouseX > GOLD_X && mouseX < GOLD_X + ITEM_SIDE * 2  
          && mouseY > ITEM_SIDE + 55 && mouseY < ITEM_SIDE + 55 + ITEM_SIDE * 2) {
        //hand item
        //draw text in item box when clicked on
        if (this.handLight == false && this.invLight == false) {
          this.boxText1 = this.charCol.getCharacter().getHand().getName();
          this.boxText2 = null;             
          this.handLight = true;
          this.draw();
        } else if (this.handLight == true && this.invLight == false) {
          //remove highlight
          this.handLight = false;
          this.draw();
        } else {
          //swaphand
          this.handLight = false;
          this.invLight = false;
          this.charCol.getCharacter().setHand();
          this.draw();
        }
      } else if (action.equals("clicked") && mouseX > 10 && mouseX < ITEM_SIDE * 2  
          && mouseY > 35 && mouseY < ITEM_SIDE * 2 + 10) {
        //draw text in item box when clicked on
        //10, 35 + (100 * i), 90, ITEM_SIDE + 25
        this.boxText1 = "Hit Points!";
        this.boxText2 = "How healthly you are!";
        this.draw();
      } else if (action.equals("clicked") && mouseX > 10 && mouseX < ITEM_SIDE * 2 
          && mouseY > 135 && mouseY < ITEM_SIDE * 4 + 10) {
        //stregnth
        //draw text in item box when clicked on
        this.boxText1 = "Strength!";
        this.boxText2 = "How strong you are!";
        this.draw();
      } else if (action.equals("clicked") && mouseX > 10 && mouseX < ITEM_SIDE * 2 
          && mouseY > 235 && mouseY < ITEM_SIDE * 6 + 10) {
        //intellegence
        //draw text in item box when clicked on
        this.boxText1 = "Intellegence!";
        this.boxText2 = "How smart you are!";
        this.draw();
      } else if (action.equals("clicked") && mouseX > 10 && mouseX < ITEM_SIDE * 2 
          && mouseY > 335 && mouseY < ITEM_SIDE * 8 + 10) {
        //agility
        //draw text in item box when clicked on
        this.boxText1 = "Agility!";
        this.boxText2 = "How fast you are!";
        this.draw();
      } else if (action.equals("clicked") && mouseX > GOLD_X && mouseX < GOLD_X + 110 
          && mouseY > ITEM_SIDE && mouseY < ITEM_SIDE + 35) {
        //gold
        //draw text in item box when clicked on
        this.boxText1 = "Gold!";
        this.boxText2 = "How rich you are!";
        this.draw();
      } else if (action.equals("clicked") && mouseX > 110 && mouseX < 310  
          && mouseY > 30 && mouseY < 415) {
        //name and picture
        //draw text in item box when clicked on
        this.boxText1 = this.charCol.getCharacter().getName();
        this.boxText2 = "That's you!";
        this.draw();
      } else if (action.equals("clicked") && mouseX > GOLD_X + 80 
          && mouseX < GOLD_X + 130 
          && mouseY > ITEM_SIDE * 7 && mouseY < ITEM_SIDE * 8) {
        //special ability
        //draw text in item box when clicked on
        UI.setFontSize(12);
        this.boxText1 = "Special Ability!";
        this.boxText2 = this.charCol.getCharacter().getAbility();
        this.draw();
      }
    } catch (Exception e) {
      //do nothing
    }
  }
}
