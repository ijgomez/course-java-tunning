package powerhoteles.alex.gui;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelMapa extends JPanel {

	private BufferedImage españa;
	private BufferedImage hotel;
	private static final long serialVersionUID = 1L;
	private int hotelX = -1;
	private int hotelY = -1;
	
	

	/**
	 * @param hotelX the hotelX to set
	 */
	public void setPosicionHotel(int hotelX,int hotelY) {
		this.hotelX = hotelX;
		this.hotelY = hotelY;
		repaint();
	}

	/**
	 * This is the default constructor
	 */
	public PanelMapa() {
		super();
		initialize();
		try {
			españa = ImageIO.read(getClass().getResource("/res/iconos/spain_provincias.jpg"));
			hotel = ImageIO.read(getClass().getResource("/res/iconos/hotel.gif"));
		} catch (IOException e){
			
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		double ratioAspecto = (double)españa.getWidth()/españa.getHeight();
		g.drawImage(españa,0,0,getWidth(),(int)(getWidth()/ratioAspecto),null);
		
		double factorEscala = (double)españa.getWidth()/getWidth();
		if (hotelX != -1) {
			g.drawImage(hotel,(int)(hotelX/factorEscala),(int)(hotelY/factorEscala),null);
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(311, 287);
		this.setLayout(new GridBagLayout());
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
