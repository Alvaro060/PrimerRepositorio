package examen5reservaanimales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoNuevaArea extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private Vista vista;
	private JTextField campoNombreArea;
	private JTextField campoExtensión;


	public DialogoNuevaArea(Vista vista)
	{
		setResizable(false);
		this.vista = vista;
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/iconos/leon.jpg")));
		setTitle("A\u00F1adir Nueva \u00C1rea");
		this.vista = vista;
		setBounds(100, 100, 450, 161);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNombreDelrea = new JLabel("Nombre del \u00E1rea: ");
		campoNombreArea = new JTextField();
		campoNombreArea.setColumns(10);
		JLabel lblExtensin = new JLabel("Extensi\u00F3n:");
		campoExtensión = new JTextField();
		campoExtensión.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNombreDelrea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(campoNombreArea, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblExtensin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(campoExtensión, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelrea)
						.addComponent(campoNombreArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExtensin)
						.addComponent(campoExtensión, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonAñadir = new JButton("A\u00F1adir");
				botonAñadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						botonAñadirPulsado();
					}
				});
				botonAñadir.setActionCommand("OK");
				buttonPane.add(botonAñadir);
				getRootPane().setDefaultButton(botonAñadir);
			}
			{
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						botonCancelarPulsado();
					}
				});
	
				buttonPane.add(botonCancelar);
			}
		}
	}
	
	protected void botonAñadirPulsado()
	{
		if(this.campoNombreArea.getText().isEmpty())
			this.vista.error(this, "Debe escribir un nombre de área");
		else
		{
			try
			{
				float extensión = Float.parseFloat(this.campoExtensión.getText());
				if(this.vista.añadeÁrea(this.campoNombreArea.getText(),
						                 extensión)==false)
					this.vista.error(this, "Ese área ya estaba en la reserva");
				else
				{
					this.vista.msg(this, "Área almacenada.");
					this.setVisible(false);
				}
			}
			catch(NumberFormatException e)
			{
				this.vista.error(this, "Debe escribir un número en la extensión");
			}
		}
		
	}

	protected void botonCancelarPulsado()
	{
		this.setVisible(false);

	}

	public void mostrar()
	{
		this.campoNombreArea.setText("");
		this.campoExtensión.setText("");
		this.setVisible(true);

	}

}
