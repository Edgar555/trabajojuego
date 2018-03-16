package juego;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;

public class PegSolitario extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static MenuPrincipal PegMenu = new MenuPrincipal();
	
	static PegSolitario Peg = new PegSolitario();
	
	public PegSolitario() {
		Frame frame = new Frame();
	    setTitle("Juego Peg");
	    setLayout(null);
	    setBackground(Color.white);
	    setSize(350,375 );
	    setVisible(true);
	    setMenuBar(PegMenu.menuCreate());
	    
	    addWindowListener(new WindowAdapter(){
	    	  public void windowClosing(WindowEvent we){
	    	    System.exit(0);
	    	  }
	    	});
	    
	   
		
	}
	
	 public void windowClosing( WindowEvent evt ) { 
	    	System.exit( 0 ); 
	    	} 
	 
	 public static void main(String[] paramArrayOfString)
	  {
	   
	    Peg = new PegSolitario();
	    
	  }

}
