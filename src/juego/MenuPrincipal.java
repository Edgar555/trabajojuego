package juego;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class MenuPrincipal implements ActionListener {
	
	boolean firstRun = true;
	boolean[] windowOpen = new boolean[]{false, false, false, false, false, false, false};
	String[] tableroItems = new String[]{"Tablero tipo frances", "Tablero tipo ingles", "Tablero tipo Diamante"};
	String[] configuracionItems = new String[]{};
	int[] tableroShortcuts = new int[]{82, 66, 72};
	int[] configuracionShortcuts = new int[]{};

	
	public MenuPrincipal() {
		
		
	}
	
	public MenuBar menuCreate()
	  {
	    if (!this.firstRun) {
	      //Peg.Debug("Setting up menu");
	    }
	    MenuBar localMenuBar = new MenuBar();
	    for (int i = 0; i < 5; i++) {
	      this.windowOpen[i] = false;
	    }
	    Menu localMenu1 = new Menu("Tablero");
	    localMenuBar.add(localMenu1);
	    Menu localMenu2 = new Menu("configuracion");
	    localMenuBar.add(localMenu2);
	    Menu localMenu3 = new Menu("otros");
	    localMenuBar.add(localMenu3);
	    MenuItem localMenuItem;
	    int j;
	    for ( j = 0; j < this.tableroItems.length; j++)
	    {
	      localMenuItem = new MenuItem(this.tableroItems[j], new MenuShortcut(this.configuracionShortcuts[j]));
	      localMenuItem.addActionListener(this);
	      localMenu1.add(localMenuItem);
	    }
	    for (j = 0; j < this.configuracionItems.length; j++)
	    {
	      localMenuItem = new MenuItem(this.configuracionItems[j], new MenuShortcut(this.tableroShortcuts[j]));
	      localMenuItem.addActionListener(this);
	      localMenu2.add(localMenuItem);
	    }
	    if (!this.firstRun) {
	      //Peg.Debug("Menu Created Successfully");
	    }
	    return localMenuBar;
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	  

}
