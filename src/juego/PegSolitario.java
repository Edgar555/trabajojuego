package juego;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PegSolitario extends Frame {

	int maxx = 350;
	int maxy = 375;
	int seleccionarPeg1 = 67;
	int seleccionarPeg2 = 67;
	int solucionNumeroPegs = 0;
	int tamañoLayout = 0;
	int anchoLayout = 0;
	String[] componentes;

	boolean initArray = false;
	static JButton[] hole;
	DecimalFormat fr = new DecimalFormat("00");
	int[][] pegPixels = new int[][] {
			{ 5, 7, 6, 5, 21, 23, 22, 23, 4, 4, 5, 6, 22, 21, 20, 22, 24, 24, 24, 24, 27, 27, 12, 13, 14, 15, 16, 16,
					12, 13, 20, 2, 25, 7, 20, 1, 1, 10, 17, 9, 8, 18, 19, 1 },
			{ 4, 4, 5, 6, 5, 5, 6, 7, 20, 22, 21, 22, 21, 22, 23, 23, 12, 13, 14, 15, 12, 16, 24, 24, 24, 24, 24, 27,
					27, 27, 2, 7, 20, 25, 25, 11, 17, 1, 1, 1, 1, 1, 1, 10 } };
	int[][] pegPixels2 = new int[][] { { 1, 1, 26, 26, 26, 1, 1, 1, 26, 26, 26, 17, 18, 19, 10, 9, 8 },
			{ 9, 8, 10, 9, 8, 17, 18, 19, 17, 18, 19, 26, 26, 26, 26, 26, 26 } };
	int[][] playPixels = new int[][] { { 5, 4, 23, 24, 3, 22, 23, 4, 12, 13, 14, 15, 16, 27, 27, 27, 27, 27 },
			{ 3, 4, 4, 5, 22, 24, 23, 23, 27, 27, 27, 27, 27, 12, 13, 14, 15, 16 } };
	BufferedImage imagenPeg;
	BufferedImage imagenCirculo;
	BufferedImage wallImg;
	static ImageIcon circuloIcon;
	static ImageIcon pegIcon;
	String temporal = "";
	int numPegs = 0;
	int initNumPegs = 0;
	int linea = 0;
	private static final long serialVersionUID = 1L;
	static MenuPrincipal PegMenu = new MenuPrincipal();

	static PegSolitario Peg = new PegSolitario();

	public PegSolitario() {
		setTitle("Juego Peg");
		setLayout(null);
		setBackground(Color.white);
		setSize(350, 375);
		setVisible(true);
		setMenuBar(PegMenu.menuCreate());
		cargarTablero();
		setIconos();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

	public void cargarTablero() {

		this.linea = 0;
		try {
			BufferedReader localBufferedReader;

			localBufferedReader = new BufferedReader(new FileReader("../trabajojuego/datos/LevelButaca"));

			while (localBufferedReader.ready()) {
				this.temporal = localBufferedReader.readLine();
				if (this.temporal.indexOf("PEGS:") == 0) {
					this.numPegs = Integer.parseInt(this.temporal.substring(5));
					this.initNumPegs = this.numPegs;
					System.out.println(this.temporal);
					this.linea -= 1;
				} else {
					if (!this.initArray) {
						this.componentes = new String[this.temporal.length()];
						this.initArray = true;
						this.anchoLayout = this.componentes.length;
					}
					this.componentes[this.linea] = this.temporal;
					System.out.println(this.temporal);
					if ((this.linea + 1 == this.anchoLayout) && (localBufferedReader.ready() == true)) {
						System.exit(0);
					}
				}
				this.linea += 1;
			}
			localBufferedReader.close();
		if (this.anchoLayout != this.linea) {
			System.exit(0);
		}
		this.tamañoLayout = ((this.componentes.length - 1) * 10 + this.componentes.length);
		hole = new JButton[this.tamañoLayout];
		this.maxx = (this.anchoLayout * 50);
		this.maxy = (this.anchoLayout * 50 + 25);
		for (int i = 0; i < this.tamañoLayout; i++) {
			hole[i] = new JButton();
		}
		
		setLayout(new GridLayout(this.anchoLayout, this.anchoLayout));

		for (int i = 0; i < this.anchoLayout; i++) {
			for (int j = 0; j < this.anchoLayout; j++) {

				if (this.componentes[i].substring(j, j + 1).equals("X")) {
					hole[(i * 10 + j)].setText(" ");
					hole[(i * 10 + j)].setEnabled(false);
					hole[(i * 10 + j)].setBackground(Color.black);
					add(hole[(i * 10 + j)]);
				}
				if (this.componentes[i].substring(j, j + 1).equals("O")) {
					hole[(i * 10 + j)].setIcon(circuloIcon);
					hole[(i * 10 + j)].setBackground(new Color(80, 80, 80));
					hole[(i * 10 + j)].setActionCommand("O" + (i * 10 + j));
					hole[(i * 10 + j)].addKeyListener(new KeyAdapter() {
					});
					add(hole[(i * 10 + j)]);
				}
				if (this.componentes[i].substring(j, j + 1).equals("P")) {
					hole[(i * 10 + j)].setIcon(pegIcon);
					hole[(i * 10 + j)].setBackground(new Color(80, 80, 80));
					hole[(i * 10 + j)].setActionCommand("P" + (i * 10 + j));
					hole[(i * 10 + j)].addKeyListener(new KeyAdapter() {
					});
					add(hole[(i * 10 + j)]);
				}
			}
		}

		} catch (Exception Exception) {
			System.out.println(" Error: " + Exception);
			System.exit(0);
		}
	}

	

	public void setIconos() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (hole[(i * 10 + j)].getActionCommand().substring(0, 1).equals("P")) {
					hole[(i * 10 + j)].setIcon(pegIcon);
					hole[(i * 10 + j)].setBackground(new Color(80, 80, 80));
				} else if (hole[(i * 10 + j)].getActionCommand().substring(0, 1).equals("O")) {
					hole[(i * 10 + j)].setIcon(circuloIcon);
					hole[(i * 10 + j)].setBackground(new Color(80, 80, 80));
				} else if (hole[(i * 10 + j)].getActionCommand().substring(0, 1).equals("X")) {
					hole[(i * 10 + j)].setBackground(Color.black);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		String str = paramActionEvent.getActionCommand();
		if (str.equals("Restart")) {
		} else if (str.equals("Exit")) {

			System.exit(0);
		}
	}

	public void windowClosing(WindowEvent evt) {
		System.exit(0);
	}

	public static void main(String[] paramArrayOfString) {

		Peg = new PegSolitario();

	}

}
