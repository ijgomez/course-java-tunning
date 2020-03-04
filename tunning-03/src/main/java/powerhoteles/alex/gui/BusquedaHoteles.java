package powerhoteles.alex.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import powerhoteles.alex.TipoHabitacion;
import javax.swing.JToggleButton;

public class BusquedaHoteles extends JDialog {
	private boolean aceptar;
	private TipoHabitacion tipoHabitacion;

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton btnAceptar = null;
	private JButton btnCancelar = null;

	private JLabel jLabel = null;

	private JTextField txtPrecioMinimo = null;

	private JLabel jLabel1 = null;

	private JTextField txtPrecioMaximo = null;

	private JLabel lblErrorMinimo = null;

	private JLabel lblErrorMaximo = null;
	private JToggleButton btnHabitacionIndividual = null;
	private JToggleButton btnHabitacionDoble = null;
	/**
	 * @param owner
	 */
	public BusquedaHoteles(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(426, 289);
		this.setModal(true);
		this.setTitle("Búsqueda de hoteles por precio");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblErrorMaximo = new JLabel();
			lblErrorMaximo.setBounds(new Rectangle(231, 68, 166, 30));
			lblErrorMaximo.setText("JLabel");
			lblErrorMaximo.setIcon(new ImageIcon(getClass().getResource("/res/iconos/error.png")));
			lblErrorMaximo.setVisible(false);
			lblErrorMinimo = new JLabel();
			lblErrorMinimo.setBounds(new Rectangle(230, 10, 166, 30));
			lblErrorMinimo.setIcon(new ImageIcon(getClass().getResource("/res/iconos/error.png")));
			lblErrorMinimo.setText("JLabel");
			lblErrorMinimo.setVisible(false);
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 75, 115, 16));
			jLabel1.setText("Precio Máximo :");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 17, 115, 16));
			jLabel.setText("Precio Mínimo :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnAceptar(), null);
			jContentPane.add(getBtnCancelar(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getTxtPrecioMinimo(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTxtPrecioMaximo(), null);
			jContentPane.add(lblErrorMinimo, null);
			jContentPane.add(lblErrorMaximo, null);
			jContentPane.add(getBtnHabitacionIndividual(), null);
			jContentPane.add(getBtnHabitacionDoble(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes btnAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setBounds(new Rectangle(83, 195, 115, 42));
			btnAceptar.setText("Aceptar");
			btnAceptar.setIcon(new ImageIcon(getClass().getResource("/res/iconos/aceptar_peq.gif")));
			btnAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					aceptarPulsado();
				}
			});
		}
		return btnAceptar;
	}

	/**
	 * This method initializes btnCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setBounds(new Rectangle(212, 195, 121, 42));
			btnCancelar.setText("Cancelar");
			btnCancelar.setIcon(new ImageIcon(getClass().getResource("/res/iconos/cancelar_peq.gif")));
			btnCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cancelarPulsado();
				}
			});
		}
		return btnCancelar;
	}
	
	private boolean validar() {
		boolean hayErrores = false;
		lblErrorMaximo.setVisible(false);
		lblErrorMinimo.setVisible(false);
		txtPrecioMaximo.setBackground(Color.white);
		txtPrecioMinimo.setBackground(Color.white);
		try {
			Double.parseDouble(txtPrecioMaximo.getText());
		} catch (NumberFormatException e) {
			hayErrores = true;
			lblErrorMaximo.setText("Debe ser un número");
			lblErrorMaximo.setVisible(true);
			txtPrecioMaximo.setBackground(new Color(255,221,222));
			txtPrecioMaximo.requestFocus();
		}		
		try {
			Double.parseDouble(txtPrecioMinimo.getText());
		} catch (NumberFormatException e) {
			hayErrores = true;
			lblErrorMinimo.setText("Debe ser un número");
			lblErrorMinimo.setVisible(true);
			txtPrecioMinimo.setBackground(new Color(255,221,222));
			txtPrecioMinimo.requestFocus();
		}

		return !hayErrores;

	}
	
	private void aceptarPulsado() {
		if (validar()) {
			aceptar = true;
			if (btnHabitacionDoble.isSelected() && btnHabitacionIndividual.isSelected()) 
				tipoHabitacion = TipoHabitacion.INDISTINTA;
			else if (btnHabitacionDoble.isSelected())
				tipoHabitacion = TipoHabitacion.DOBLE;
			else
				tipoHabitacion = TipoHabitacion.INDIVIDUAL;
				
			
			setVisible(false);
		}
	}
	
	private void cancelarPulsado() {
		aceptar = false;
		setVisible(false);
	}

	/**
	 * This method initializes txtPrecioMinimo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPrecioMinimo() {
		if (txtPrecioMinimo == null) {
			txtPrecioMinimo = new JTextField();
			txtPrecioMinimo.setBounds(new Rectangle(153, 15, 69, 20));
			txtPrecioMinimo.setHorizontalAlignment(JTextField.RIGHT);
			txtPrecioMinimo.setText("0");
		}
		return txtPrecioMinimo;
	}

	/**
	 * This method initializes txtPrecioMaximo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPrecioMaximo() {
		if (txtPrecioMaximo == null) {
			txtPrecioMaximo = new JTextField();
			txtPrecioMaximo.setBounds(new Rectangle(154, 73, 69, 20));
			txtPrecioMaximo.setText("100");
			txtPrecioMaximo.setHorizontalAlignment(JTextField.RIGHT);
		}
		return txtPrecioMaximo;
	}

	/**
	 * @return the aceptar
	 */
	public boolean isAceptar() {
		return aceptar;
	}
	
	public double getPrecioMinimo() {
		return Double.parseDouble(txtPrecioMinimo.getText());
	}
	public double getPrecioMaximo() {
		return Double.parseDouble(txtPrecioMaximo.getText());
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	/**
	 * This method initializes btnHabitacionIndividual	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getBtnHabitacionIndividual() {
		if (btnHabitacionIndividual == null) {
			btnHabitacionIndividual = new JToggleButton();
			btnHabitacionIndividual.setBounds(new Rectangle(137, 118, 53, 54));
			btnHabitacionIndividual.setIcon(new ImageIcon(getClass().getResource("/res/iconos/individual.gif")));
		}
		return btnHabitacionIndividual;
	}

	/**
	 * This method initializes btnHabitacionDoble	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getBtnHabitacionDoble() {
		if (btnHabitacionDoble == null) {
			btnHabitacionDoble = new JToggleButton();
			btnHabitacionDoble.setBounds(new Rectangle(215, 118, 53, 54));
			btnHabitacionDoble.setIcon(new ImageIcon(getClass().getResource("/res/iconos/matrimonio.gif")));
		}
		return btnHabitacionDoble;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
