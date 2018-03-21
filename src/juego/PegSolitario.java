package juego;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class PegSolitario extends Frame {

	/**
	 * 
	 */
	int[][] Pixels = new int[][] {
			{ 5, 7, 6, 5, 21, 23, 22, 23, 4, 4, 5, 6, 22, 21, 20, 22, 24, 24, 24, 24, 27, 27, 12, 13, 14, 15, 16, 16,
					12, 13, 20, 2, 25, 7, 20, 1, 1, 10, 17, 9, 8, 18, 19, 1 },
			{ 4, 4, 5, 6, 5, 5, 6, 7, 20, 22, 21, 22, 21, 22, 23, 23, 12, 13, 14, 15, 12, 16, 24, 24, 24, 24, 24, 27,
					27, 27, 2, 7, 20, 25, 25, 11, 17, 1, 1, 1, 1, 1, 1, 10 } };
	int[][] Pixels2 = new int[][] { { 1, 1, 26, 26, 26, 1, 1, 1, 26, 26, 26, 17, 18, 19, 10, 9, 8 },
			{ 9, 8, 10, 9, 8, 17, 18, 19, 17, 18, 19, 26, 26, 26, 26, 26, 26 } };
	int[][] playPixels = new int[][] { { 5, 4, 23, 24, 3, 22, 23, 4, 12, 13, 14, 15, 16, 27, 27, 27, 27, 27 },
			{ 3, 4, 4, 5, 22, 24, 23, 23, 27, 27, 27, 27, 27, 12, 13, 14, 15, 16 } };
	BufferedImage pegImg;
	BufferedImage holeImg;
	BufferedImage wallImg;
	static ImageIcon holeIcon;
	static ImageIcon pegIcon;
	private static final long serialVersionUID = 1L;
	static MenuPrincipal PegMenu = new MenuPrincipal();

	static PegSolitario Peg = new PegSolitario();

	public PegSolitario() {
		Frame frame = new Frame();
		setTitle("Juego Peg");
		setLayout(null);
		setBackground(Color.white);
		setSize(350, 375);
		setVisible(true);
		setMenuBar(PegMenu.menuCreate());
		pintar();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

	public void pintar() {
		this.wallImg = new BufferedImage(25, 25, 1);
		this.pegImg = new BufferedImage(28, 28, 2);
		Graphics2D grafico2D1 = this.pegImg.createGraphics();

		Color localColor = new Color(0, 0, 0, 0);
		grafico2D1.setColor(localColor);
		grafico2D1.setComposite(AlphaComposite.Src);
		grafico2D1.fill(new Rectangle2D.Float(20.0F, 20.0F, 100.0F, 20.0F));
		grafico2D1.setColor(new Color(0, 0, 139));
		grafico2D1.fillOval(1, 1, 26, 26);
		grafico2D1.setColor(Color.YELLOW);
		int i;
		for (i = 0; i < 3; i++) {
			grafico2D1.drawOval(3 - i, 3 - i, 22 + i * 2, 22 + i * 2);
		}
		for (i = 0; i < this.Pixels[0].length; i++) {
			grafico2D1.drawLine(this.Pixels[0][i], this.Pixels[1][i], this.Pixels[0][i], this.Pixels[1][i]);
		}
		for (i = 0; i < this.Pixels2[0].length; i++) {
			grafico2D1.drawLine(this.Pixels2[0][i], this.Pixels2[1][i], this.Pixels2[0][i], this.Pixels2[1][i]);
		}
		grafico2D1.setColor(new Color(80, 80, 80));
		for (i = 0; i < this.playPixels[0].length; i++) {
			grafico2D1.drawLine(this.playPixels[0][i], this.playPixels[1][i], this.playPixels[0][i],
					this.playPixels[1][i]);
		}
		this.holeImg = new BufferedImage(28, 28, 2);
		Graphics2D grafico2D2 = this.holeImg.createGraphics();

		grafico2D2.setColor(localColor);
		grafico2D2.setComposite(AlphaComposite.Src);
		grafico2D2.fill(new Rectangle2D.Float(20.0F, 20.0F, 100.0F, 20.0F));
		grafico2D2.setColor(new Color(80, 80, 80));
		grafico2D2.fillOval(1, 1, 26, 26);
		grafico2D2.drawLine(5, 4, 5, 4);
		grafico2D2.setColor(Color.WHITE);
		int j;
		for (j = 0; j < 3; j++) {
			grafico2D2.drawOval(3 - j, 3 - j, 22 + j * 2, 22 + j * 2);
		}
		for (j = 0; j < this.Pixels[0].length; j++) {
			grafico2D2.drawLine(this.Pixels[0][j], this.Pixels[1][j], this.Pixels[0][j], this.Pixels[1][j]);
		}
		for (j = 0; j < this.Pixels2[0].length; j++) {
			grafico2D2.drawLine(this.Pixels2[0][j], this.Pixels2[1][j], this.Pixels2[0][j], this.Pixels2[1][j]);
		}
		grafico2D2.setColor(new Color(80, 80, 80));
		for (j = 0; j < this.playPixels[0].length; j++) {
			grafico2D2.drawLine(this.playPixels[0][j], this.playPixels[1][j], this.playPixels[0][j],
					this.playPixels[1][j]);
		}
		Graphics2D localGraphics2D3 = this.wallImg.createGraphics();
		localGraphics2D3.setColor(Color.black);
		localGraphics2D3.fillRect(0, 0, 25, 25);
		localGraphics2D3.setColor(Color.white);
		localGraphics2D3.drawString("X", 8, 18);

		pegIcon = new ImageIcon(this.pegImg);
		holeIcon = new ImageIcon(this.holeImg);

	}

	public void windowClosing(WindowEvent evt) {
		System.exit(0);
	}

	public static void main(String[] paramArrayOfString) {

		Peg = new PegSolitario();

	}

}
