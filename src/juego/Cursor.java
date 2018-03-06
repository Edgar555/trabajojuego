package juego;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Cursor {
	
	public Cursor() {}
	
	public static Image crear(int[][] matriz1, int[][] matriz2, Color paramColor1, Color paramColor2)
	  {
		
		Color localColor = new Color(255, 255, 255, 0);
		
		if ((paramColor1.getRed() != 255) && (paramColor1.getGreen() != 255) 
				&& (paramColor1.getBlue() != 255) && (paramColor2.getRed() != 255) 
				&& (paramColor2.getGreen() != 255) && (paramColor2.getBlue() != 255)) {
			
		      localColor = new Color(0, 0, 0, 0);
		      
		    } else if ((paramColor1.getRed() != 0) && (paramColor1.getGreen() != 0) 
		    		&& (paramColor1.getBlue() != 0) && (paramColor2.getRed() != 0) 
		    		&& (paramColor2.getGreen() != 0) && (paramColor2.getBlue() != 0)) {
		    	
		      localColor = new Color(255, 255, 255, 0);
		      
		    } else {
		    	
		      localColor = new Color(1, 1, 1, 0);
		    }
		
		
		
		 BufferedImage Imagenlocal = new BufferedImage(32, 32, 2);
		 Graphics2D imagen2D = Imagenlocal.createGraphics();
		    
		 imagen2D.setColor(localColor);
		 imagen2D.setComposite(AlphaComposite.Src);
		 imagen2D.fill(new Rectangle2D.Float(0.0F, 0.0F, 32.0F, 32.0F));
		 
		 imagen2D.setColor(paramColor1);
		    for (int i = 0; i < matriz1[0].length; i++) {
		    	imagen2D.drawLine(matriz1[0][i], matriz1[1][i], matriz1[0][i], matriz1[1][i]);
		    }
		    imagen2D.setColor(paramColor2);
		    for (int i = 0; i < matriz2[0].length; i++) {
		    	imagen2D.drawLine(matriz2[0][i], matriz2[1][i], matriz2[0][i], matriz2[1][i]);
		    }
		    
		    return new ImageIcon(Imagenlocal).getImage();
		
		
	  }
	
	
	
}
