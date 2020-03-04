package powerhoteles.alex.gui;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import powerhoteles.alex.Hotel;
import powerhoteles.alex.HotelDAO;
import java.awt.Color;
import java.awt.Font;

public class Hoteles extends JFrame {
	private Connection con = null;
	private static final int HOTELES_PAGINA = 10;
	private List<Hotel> hoteles = new ArrayList<Hotel>();
	private int hotelActual = 0;

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel semaforo = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem mnuConectar = null;
	private JMenuItem mnuDesconectar = null;
	private JMenuItem mnuSalir = null;

	private JButton btnPrimero = null;

	private JButton btnPaginaAnterior = null;

	private JButton btnPaginaSiguiente = null;

	private JButton btnAnterior = null;

	private JButton btnSiguiente = null;

	private JButton btnUltimo = null;

	private JSlider selectorHotel = null;

	private JLabel lblSelectorHotel = null;
	private JLabel jLabel = null;
	private JTextField txtHotel = null;
	private JLabel jLabel1 = null;
	private JTextField txtDireccion = null;
	private JLabel jLabel2 = null;
	private JTextField txtPrecioIndividual = null;
	private JLabel jLabel21 = null;
	private JTextField txtPrecioDoble = null;
	private JMenu jMenu1 = null;
	private JMenuItem mnuBuscarPorPrecio = null;
	private PanelMapa panelMapa = null;

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			semaforo = new JLabel();
			semaforo.setBounds(new Rectangle(4, 11, 31, 50));
			semaforo.setIcon(new ImageIcon(getClass().getResource("/res/iconos/SROJO.gif")));
			semaforo.setText("");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(4, 418, 906, 57));
			jPanel.add(semaforo, null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Hoteles");
			jMenu.add(getMnuConectar());
			jMenu.add(getMnuDesconectar());
			jMenu.add(getMnuSalir());
		}
		return jMenu;
	}

	/**
	 * This method initializes mnuConectar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuConectar() {
		if (mnuConectar == null) {
			mnuConectar = new JMenuItem();
			mnuConectar.setText("Conectar");
			mnuConectar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					conectarPulsado();
				}
			});
		}
		return mnuConectar;
	}

	/**
	 * This method initializes mnuDesconectar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuDesconectar() {
		if (mnuDesconectar == null) {
			mnuDesconectar = new JMenuItem();
			mnuDesconectar.setText("Desconectar");
			mnuDesconectar.setEnabled(false);
			mnuDesconectar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					desconectarPulsado();
				}
			});
		}
		return mnuDesconectar;
	}

	/**
	 * This method initializes mnuSalir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuSalir() {
		if (mnuSalir == null) {
			mnuSalir = new JMenuItem();
			mnuSalir.setText("Salir");
			mnuSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return mnuSalir;
	}

	/**
	 * This method initializes btnPrimero	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPrimero() {
		if (btnPrimero == null) {
			btnPrimero = new JButton();
			btnPrimero.setBounds(new Rectangle(15, 22, 56, 57));
			btnPrimero.setIcon(new ImageIcon(getClass().getResource("/res/iconos/00_first.png")));
			btnPrimero.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					botonPrimeroPulsado();
				}
			});
		}
		return btnPrimero;
	}

	/**
	 * This method initializes btnPaginaAnterior	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPaginaAnterior() {
		if (btnPaginaAnterior == null) {
			btnPaginaAnterior = new JButton();
			btnPaginaAnterior.setBounds(new Rectangle(74, 22, 56, 57));
			btnPaginaAnterior.setIcon(new ImageIcon(getClass().getResource("/res/iconos/00_prevPage.png")));
			btnPaginaAnterior.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					botonPaginaAnteriorPulsado();
				}
			});
		}
		return btnPaginaAnterior;
	}

	/**
	 * This method initializes btnPaginaSiguiente	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPaginaSiguiente() {
		if (btnPaginaSiguiente == null) {
			btnPaginaSiguiente = new JButton();
			btnPaginaSiguiente.setBounds(new Rectangle(792, 22, 56, 57));
			btnPaginaSiguiente.setIcon(new ImageIcon(getClass().getResource("/res/iconos/00_nextPage.png")));
			btnPaginaSiguiente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					botonPaginaSiguientePulsado();
				}
			});
		}
		return btnPaginaSiguiente;
	}

	/**
	 * This method initializes btnAnterior	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAnterior() {
		if (btnAnterior == null) {
			btnAnterior = new JButton();
			btnAnterior.setBounds(new Rectangle(133, 22, 56, 57));
			btnAnterior.setIcon(new ImageIcon(getClass().getResource("/res/iconos/00_prev.png")));
			btnAnterior.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					botonAnteriorPulsado();
				}
			});
		}
		return btnAnterior;
	}

	/**
	 * This method initializes btnSiguiente	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton();
			btnSiguiente.setBounds(new Rectangle(732, 22, 56, 57));
			btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/res/iconos/00_next.png")));
			btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					botonSiguientePulsado();
				}
			});
		}
		return btnSiguiente;
	}

	/**
	 * This method initializes btnUltimo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnUltimo() {
		if (btnUltimo == null) {
			btnUltimo = new JButton();
			btnUltimo.setBounds(new Rectangle(853, 22, 56, 57));
			btnUltimo.setIcon(new ImageIcon(getClass().getResource("/res/iconos/00_last.png")));
			btnUltimo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					botonUltimoPulsado();
				}
			});
		}
		return btnUltimo;
	}

	/**
	 * This method initializes selectorHotel	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getSelectorHotel() {
		if (selectorHotel == null) {
			selectorHotel = new JSlider();
			selectorHotel.setBounds(new Rectangle(207, 58, 515, 21));
			selectorHotel.setPaintTicks(true);
			selectorHotel.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					hotelSeleccionado();
				}
			});
		}
		return selectorHotel;
	}

	/**
	 * This method initializes txtHotel	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtHotel() {
		if (txtHotel == null) {
			txtHotel = new JTextField();
			txtHotel.setBounds(new Rectangle(77, 102, 370, 20));
			txtHotel.setEditable(true);
			txtHotel.setForeground(Color.black);
			txtHotel.setFont(new Font("Dialog", Font.BOLD, 12));
			txtHotel.setEnabled(false);
		}
		return txtHotel;
	}

	/**
	 * This method initializes txtDireccion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextField();
			txtDireccion.setBounds(new Rectangle(566, 102, 341, 20));
			txtDireccion.setEditable(true);
			txtDireccion.setForeground(Color.black);
			txtDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
			txtDireccion.setEnabled(false);
		}
		return txtDireccion;
	}

	/**
	 * This method initializes txtPrecioIndividual	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPrecioIndividual() {
		if (txtPrecioIndividual == null) {
			txtPrecioIndividual = new JTextField();
			txtPrecioIndividual.setBounds(new Rectangle(143, 131, 127, 20));
			txtPrecioIndividual.setEditable(true);
			txtPrecioIndividual.setForeground(Color.black);
			txtPrecioIndividual.setFont(new Font("Dialog", Font.BOLD, 12));
			txtPrecioIndividual.setEnabled(false);
		}
		return txtPrecioIndividual;
	}

	/**
	 * This method initializes txtPrecioDoble	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPrecioDoble() {
		if (txtPrecioDoble == null) {
			txtPrecioDoble = new JTextField();
			txtPrecioDoble.setBounds(new Rectangle(392, 131, 119, 20));
			txtPrecioDoble.setEditable(true);
			txtPrecioDoble.setForeground(Color.black);
			txtPrecioDoble.setFont(new Font("Dialog", Font.BOLD, 12));
			txtPrecioDoble.setEnabled(false);
		}
		return txtPrecioDoble;
	}

	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Buscar");
			jMenu1.add(getMnuBuscarPorPrecio());
		}
		return jMenu1;
	}

	/**
	 * This method initializes mnuBuscarPorPrecio	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuBuscarPorPrecio() {
		if (mnuBuscarPorPrecio == null) {
			mnuBuscarPorPrecio = new JMenuItem();
			mnuBuscarPorPrecio.setText("Por Precio");
			mnuBuscarPorPrecio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscarPorPrecio();
				}
			});
		}
		return mnuBuscarPorPrecio;
	}

	/**
	 * This method initializes panelMapa	
	 * 	
	 * @return powerhoteles.alex.gui.PanelMapa	
	 */
	private PanelMapa getPanelMapa() {
		if (panelMapa == null) {
			panelMapa = new PanelMapa();
			panelMapa.setBounds(new Rectangle(16, 168, 361, 238));
		}
		return panelMapa;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Hoteles thisClass = new Hoteles();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Hoteles() {
		super();
		initialize();
		actualizarEstado();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(936, 540);
		this.setJMenuBar(getJJMenuBar());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/iconos/hotel.gif")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Hoteles");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				salir();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel21 = new JLabel();
			jLabel21.setBounds(new Rectangle(280, 135, 99, 16));
			jLabel21.setText("Precio Doble :");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(20, 135, 113, 16));
			jLabel2.setText("Precio Individual :");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(469, 102, 80, 16));
			jLabel1.setText("Dirección :");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(21, 102, 38, 16));
			jLabel.setText("Hotel :");
			lblSelectorHotel = new JLabel();
			lblSelectorHotel.setBounds(new Rectangle(409, 27, 117, 23));
			lblSelectorHotel.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getBtnPrimero(), null);
			jContentPane.add(getBtnPaginaAnterior(), null);
			jContentPane.add(getBtnPaginaSiguiente(), null);
			jContentPane.add(getBtnAnterior(), null);
			jContentPane.add(getBtnSiguiente(), null);
			jContentPane.add(getBtnUltimo(), null);
			jContentPane.add(getSelectorHotel(), null);
			jContentPane.add(lblSelectorHotel, null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getTxtHotel(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTxtDireccion(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getTxtPrecioIndividual(), null);
			jContentPane.add(jLabel21, null);
			jContentPane.add(getTxtPrecioDoble(), null);
			jContentPane.add(getPanelMapa(), null);
		}
		return jContentPane;
	}
	
	private void actualizarEstado() {
		mnuConectar.setEnabled( con == null );
		mnuDesconectar.setEnabled( con != null );
		mnuBuscarPorPrecio.setEnabled(con != null);
		
		btnAnterior.setEnabled(con != null && hotelActual > 0);
		btnPaginaAnterior.setEnabled( con != null && hotelActual > HOTELES_PAGINA );
		btnPrimero.setEnabled( con != null && hoteles.size() > 0 && hotelActual > 0);
		btnUltimo.setEnabled(con != null && hoteles.size() > 0 && hotelActual+1 < hoteles.size());
		btnSiguiente.setEnabled(con != null && hotelActual+1 < hoteles.size());
		btnPaginaSiguiente.setEnabled( con != null && hotelActual + HOTELES_PAGINA < hoteles.size());
		selectorHotel.setEnabled( con != null && hoteles.size() > 0);
		
		
		String icono = ((con==null)?"/res/iconos/SROJO.gif":"/res/iconos/SVERDE.gif");
		semaforo.setIcon(new ImageIcon(getClass().getResource(icono)));
	}
	
	private void conectarPulsado() {
		VentanaAcceso v = new VentanaAcceso(this);
		v.setVisible(true);
		if (!v.isAceptado()) return;
		try {
			Class.forName(v.getDriver());
			con = DriverManager.getConnection(
					v.getURL(),v.getUsuario(),v.getClave());
			actualizarEstado();
		} catch (Exception e) {
			mostrarExcepcion(e);
		}
		
	}
	
	private void desconectarPulsado() {
		try {
			con.close();
			con = null;
			actualizarEstado();
		} catch (SQLException e) {
			mostrarExcepcion(e);
		}
	}
	
	private void salir() {
			if (con != null) try {con.close(); } catch (SQLException e) {}
			System.exit(0);
	}
	
	private void mostrarExcepcion(Exception e) {
		JOptionPane.showOptionDialog(
				this, 
				"Error de tipo "+e.getClass()+" -\n"+e.getMessage(), 
				"Ha ocurrido un error", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
	
	private void buscarPorPrecio() {
		try{
			BusquedaHoteles v = new BusquedaHoteles(this);
			v.setVisible(true);
			if (!v.isAceptar()) return;
			HotelDAO dao = new HotelDAO(con);
			hoteles = dao.findByPrecio(v.getPrecioMinimo(), v.getPrecioMaximo(), v.getTipoHabitacion());
			hotelActual = 0;
			selectorHotel.setValue(0);
			selectorHotel.setMinimum(0);
			selectorHotel.setMaximum(hoteles.size());
			actualizarEstado();
			mostrarHotelActual();
		} catch (SQLException e) {
			mostrarExcepcion(e);
		}
		
	}
	private void mostrarHotelActual() {
		Hotel hotel = hoteles.get(hotelActual);
		lblSelectorHotel.setText("Hotel "+(hotelActual+1)+" de "+hoteles.size());
		txtHotel.setText(hotel.getNombre());
		txtPrecioDoble.setText(String.valueOf(hotel.getPrecioDoble()));
		txtPrecioIndividual.setText(String.valueOf(hotel.getPrecioIndividual()));
		txtDireccion.setText(hotel.getDireccion());
		panelMapa.setPosicionHotel(hotel.getPlanoX(), hotel.getPlanoY());
	}
	
	private void irAHotel(int n) {
		if (n >= 0 && n < hoteles.size()) {
			hotelActual = n;
			selectorHotel.setValue(hotelActual);
			actualizarEstado();
			mostrarHotelActual();
		}
	}
	
	private void botonPrimeroPulsado() {
		irAHotel(0);
	}
	private void botonAnteriorPulsado() {
		irAHotel(hotelActual-1);
	}
	private void botonPaginaAnteriorPulsado() {
		irAHotel(hotelActual-HOTELES_PAGINA);
	}
	private void botonSiguientePulsado() {
		irAHotel(hotelActual+1);
	}
	private void botonPaginaSiguientePulsado() {
		irAHotel(hotelActual+HOTELES_PAGINA);
	}
	private void botonUltimoPulsado(){
		irAHotel(hoteles.size()-1);
	}
	
	private void hotelSeleccionado() {
		irAHotel(selectorHotel.getValue());
	}
	
	
	
}  //  @jve:decl-index=0:visual-constraint="14,13"
