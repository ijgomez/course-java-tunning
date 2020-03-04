package powerhoteles.alex.gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaAcceso extends JDialog {
	private boolean aceptado=false;

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField txtDriver = null;
	private JTextField txtURL = null;
	private JTextField txtUsuario = null;
	private JPasswordField txtClave = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JButton btnAceptar = null;
	private JButton btnCancelar = null;

	/**
	 * @return the aceptado
	 */
	public boolean isAceptado() {
		return aceptado;
	}

	/**
	 * @param owner
	 */
	public VentanaAcceso(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(513, 407);
		this.setModal(true);
		this.setContentPane(getJContentPane());
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(1, 23, 493, 30));
			jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel5.setFont(new Font("Verdana", Font.BOLD, 14));
			jLabel5.setText("DATOS DE ACCESO");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(16, 74, 96, 191));
			jLabel4.setIcon(new ImageIcon(getClass().getResource("/res/iconos/login.png")));
			jLabel4.setText("");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(131, 242, 47, 16));
			jLabel3.setText("Clave");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(131, 191, 47, 16));
			jLabel2.setText("Usuario");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(131, 132, 47, 16));
			jLabel1.setText("URL");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(131, 77, 47, 16));
			jLabel.setText("Driver :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getTxtDriver(), null);
			jContentPane.add(getTxtURL(), null);
			jContentPane.add(getTxtUsuario(), null);
			jContentPane.add(getTxtClave(), null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getBtnAceptar(), null);
			jContentPane.add(getBtnCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtDriver	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDriver() {
		if (txtDriver == null) {
			txtDriver = new JTextField();
			txtDriver.setBounds(new Rectangle(189, 76, 281, 20));
			//txtDriver.setText("oracle.jdbc.driver.OracleDriver");
			txtDriver.setText("com.mysql.jdbc.Driver");
		}
		return txtDriver;
	}

	/**
	 * This method initializes txtURL	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtURL() {
		if (txtURL == null) {
			txtURL = new JTextField();
			txtURL.setBounds(new Rectangle(189, 131, 281, 20));
			//txtURL.setText("jdbc:oracle:thin:@192.168.1.2:1521:TEST");
			txtURL.setText("jdbc:mysql://localhost/hoteles");
		}
		return txtURL;
	}

	/**
	 * This method initializes txtUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUsuario() {
		if (txtUsuario == null) {
			txtUsuario = new JTextField();
			txtUsuario.setBounds(new Rectangle(189, 186, 281, 20));
			txtUsuario.setText("hoteles");
		}
		return txtUsuario;
	}

	/**
	 * This method initializes txtClave	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtClave() {
		if (txtClave == null) {
			txtClave = new JPasswordField();
			txtClave.setBounds(new Rectangle(189, 241, 281, 20));
			txtClave.setText("hoteles");
		}
		return txtClave;
	}

	/**
	 * This method initializes btnAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setBounds(new Rectangle(124, 301, 125, 40));
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
			btnCancelar.setBounds(new Rectangle(261, 301, 125, 40));
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
	
	public String getDriver() {
		return txtDriver.getText();
	}
	public String getURL() {
		return txtURL.getText();
	}
	public String getUsuario() {
		return txtUsuario.getText();
	}
	public String getClave() {
		return new String(txtClave.getPassword());
	}
	
	private void aceptarPulsado() {
		aceptado = true;
		setVisible(false);
	}
	
	private void cancelarPulsado() {
		aceptado = false;
		setVisible(false);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
