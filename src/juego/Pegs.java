package juego;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Pegs {
	int maxx = 350;
	  int maxy = 375;
	  int ln = 0;
	  int selectedPeg1 = 67;
	  int selectedPeg2 = 67;
	  int moveablePegs = 0;
	  int tempNum = 0;
	  int numMoves = 0;
	  int lastBad = 67;
	  int CurrentHour = 0;
	  int CurrentMinute = 0;
	  int CurrentSecond = 0;
	  int StartHour = 0;
	  int StartMinute = 0;
	  int StartSecond = 0;
	  int minutes = 0;
	  int seconds = 0;
	  int readTime = 0;
	  int numPegs = 0;
	  int solutionNumPegs = 0;
	  int layoutSize = 0;
	  int layoutWidth = 0;
	  int initNumPegs = 0;
	  static int debugCount = 0;
	  String pegLevel = "(0)CROSS.txt";
	  String temp = "";
	  String tTime = "";
	  String[] rComponents;
	  static String[] debugArchive = new String['?'];
	  final String FOLDER = "C:\\Users\\unillanos\\Documents\\solitaire\\Data\\"; 
	  final String CURSOR = "Cursor.gif";
	  final String VARIABLE_FILE = "VariablesCache.txt";
	  final String SOLITAIRE_LEVEL = "(6)solitaire.txt";
	  boolean badPegClick = false;
	  boolean solutionHelp = true;
	  boolean initArray = false;
	  boolean startTimer = false;
	  boolean firstClick = false;
	  boolean exists = false;
	  static boolean debugFlag = false;
	  static boolean restart = false;
	 
	  static JButton[] solBtn = new JButton[67];
	  static JButton[] hole;
	  static ImageIcon holeIcon;
	  static ImageIcon pegIcon;
	  Color cursorExteriorColour = new Color(0, 0, 0);
	  Color cursorInteriorColour = new Color(0, 255, 255);
	  DecimalFormat fr = new DecimalFormat("00");
	  
	  
	  public void verificarfindeljuego()
	  {
	    this.moveablePegs = 0;
	    for (int i = 0; i < this.layoutWidth; i++) {
	      for (int j = 0; j < this.layoutWidth; j++)
	      {
	        this.tempNum = this.moveablePegs;
	        if (hole[(i * 10 + j)].getActionCommand().substring(0, 1).equals("P"))
	        {
	          if (i * 10 - 10 < 0) {
	            this.tempNum = this.tempNum;
	          } else if (i * 10 + j - 20 < 0) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j - 20)].getActionCommand().substring(0, 1).equals("X")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j - 20)].getActionCommand().substring(0, 1).equals("P")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j - 10)].getActionCommand().substring(0, 1).equals("P")) {
	            this.moveablePegs += 1;
	          }
	          if (i * 10 + 10 == this.layoutWidth * 10) {
	            this.tempNum = this.tempNum;
	          } else if (i * 10 + 20 == this.layoutWidth * 10) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j + 20)].getActionCommand().substring(0, 1).equals("X")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j + 20)].getActionCommand().substring(0, 1).equals("P")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j + 10)].getActionCommand().substring(0, 1).equals("P")) {
	            this.moveablePegs += 1;
	          }
	          if (j - 1 < 0) {
	            this.tempNum = this.tempNum;
	          } else if (j - 2 < 0) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j - 2)].getActionCommand().substring(0, 1).equals("X")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j - 2)].getActionCommand().substring(0, 1).equals("P")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j - 1)].getActionCommand().substring(0, 1).equals("P")) {
	            this.moveablePegs += 1;
	          }
	          if (j + 1 > this.layoutWidth - 1) {
	            this.tempNum = this.tempNum;
	          } else if (j + 2 > this.layoutWidth - 1) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j + 2)].getActionCommand().substring(0, 1).equals("X")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j + 2)].getActionCommand().substring(0, 1).equals("P")) {
	            this.tempNum = this.tempNum;
	          } else if (hole[(i * 10 + j + 1)].getActionCommand().substring(0, 1).equals("P")) {
	            this.moveablePegs += 1;
	          }
	          if (this.moveablePegs == this.tempNum)
	          {
	            //Debug("Peg: " + i * 10 + j + " Is Stranded");
	            if (this.selectedPeg1 == i * 10 + j) {
	              this.badPegClick = true;
	            }
	          }
	          else if ((this.moveablePegs != this.tempNum) && (this.selectedPeg1 == i * 10 + j))
	          {
	            this.badPegClick = false;
	          }
	        }
	      }
	    }
	    if (this.moveablePegs == 0)
	    {
	      //Debug("Lost Game");
	      JOptionPane.showMessageDialog(null, "YOU LOST!!! Level: " + this.pegLevel, "Gameover", 2);
	    }
	  }
	  
	  
	  public void verificarsolucion()
	  {
	    //Debug("Checking if you won...");
	    int i = 1;
	    for (int j = 0; j < solBtn.length; j++) {
	      if (solBtn[j].getActionCommand().equals(hole[j].getActionCommand())) {
	        this.temp = this.temp;
	      } else {
	        i = 0;
	      }
	    }
	    if (i == 1)
	    {
	      victoria();
	    }
	    else if (this.numPegs <= this.solutionNumPegs)
	    {
	      //Debug("Gameover");
	      JOptionPane.showMessageDialog(null, "YOU LOST!!! Level: " + this.pegLevel, "Gameover", 2);
	    }
	  }
	  
	  
	  public void victoria()
	  {
	    //Debug("You Won");
	    this.temp = null;
	    this.tTime = getTime();
	    while (this.temp == null)
	    {
	      this.temp = JOptionPane.showInputDialog(null, "YOU WON!!! Level: " + this.pegLevel + " Time: " + this.tTime + "\nEnter Name: ", "Congrats", 2);
	      if (Verify.allLetters(this.temp) == true) {
	        PegMenu.yourName = this.temp;
	      } else {
	        this.temp = null;
	      }
	    }
	    PegMenu.yourTime = (Integer.parseInt(this.tTime.substring(0, this.tTime.indexOf(":"))) * 60 + Integer.parseInt(this.tTime.substring(this.tTime.indexOf(":") + 1)));
	    PegMenu.yourLevel = this.pegLevel;
	    //Debug("Score: " + PegMenu.yourName + " Time:" + PegMenu.yourTime + " Level:" + PegMenu.yourLevel);
	    if (this.pegLevel.compareTo("(9)custom.txt") != 0) {
	      this.pegLevel = ("(" + (Integer.parseInt(this.pegLevel.substring(1, 2)) + 1) + ")" + PegMenu.levelItems[(Integer.parseInt(this.pegLevel.substring(1, 2)) + 1)].toLowerCase() + ".txt");
	    }
	    //Debug("Advancing To Next Level: " + this.pegLevel);
	    restartGame();
	    PegMenu.selectedLevel = Integer.parseInt(PegMenu.yourLevel.substring(1, 2));
	    if (PegMenu.yourName.equals("DEBUG"))
	    {
	      PegMenu.yourName = "";
	      PegMenu.yourTime = 0;
	      PegMenu.yourLevel = "";
	    }
	    else
	    {
	      PegMenu.Highscores();
	    }
	  }
	  
	  
	  
	  
}
