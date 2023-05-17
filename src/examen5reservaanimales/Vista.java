package examen5reservaanimales;

import java.awt.Window;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Vista
{
	private Principal controlador;
	private Ventana ventana;
	private DialogoNuevoAnimal dialogoNuevoAnimal;
	private DialogoNuevaArea dialogoNuevaArea;
	
	public Vista (Principal controlador)
	{
		this.controlador = controlador;

		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.ventana = new Ventana(this);
		this.dialogoNuevoAnimal = new DialogoNuevoAnimal(this);
		this.dialogoNuevaArea = new DialogoNuevaArea(this);
		this.ventana.setVisible(true);
		
	}

	public void nuevoAnimalPulsado()
	{
		this.dialogoNuevoAnimal.setLocationRelativeTo(this.ventana);
		this.dialogoNuevoAnimal.mostrar();
	}
	
	public void msg(Window padre, String msg)
	{
		JOptionPane.showMessageDialog(padre, msg,"Correcto",  JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void error(Window padre, String msg)
	{
		JOptionPane.showMessageDialog(padre, msg,"Error",  JOptionPane.ERROR_MESSAGE);
	}

	public boolean añadeAnimal(String nombre, Area area, List listaPresas)
	{
		boolean añadido = this.controlador.añadeAnimal(nombre,area,listaPresas);
		if(añadido)
		{
			this.dialogoNuevoAnimal.actualizaListaAnimales();
			this.ventana.actualizaComboAreas();
		}
		return añadido;
			
	}

	public void nuevaAreaPulsado()
	{
		this.dialogoNuevaArea.setLocationRelativeTo(this.ventana);
		this.dialogoNuevaArea.mostrar();
	}

	public boolean añadeÁrea(String nombre, float extensión)
	{
		boolean añadida = this.controlador.añadeÁrea(nombre,extensión);
		if(añadida)
		{
			this.ventana.actualizaComboAreas();
			this.dialogoNuevoAnimal.actualizaComboAreas();
		}
		
		return añadida;	
	}

	public void actualizaListadoAreasVentana()
	{
		this.ventana.actualizaComboAreas();
	}
	
	public Set<Area> getListaAreas()
	{
		return this.controlador.getlistaAreas();
	}
	
	public TreeSet<Animal> getListaAnimales()
	{
		return this.controlador.getListaAnimales();
	}

	public String getListadoArea(Area area)
	{
		return this.controlador.getListadoArea(area);
	}

	public Animal getAnimal(String nombre)
	{
		return this.controlador.getAnimal(nombre);
	}

	public void actualizaAnimal(Animal animalSeleccionado, List<Animal> presas)
	{
		this.controlador.actualizaAnimal(animalSeleccionado,presas);
	}

	public String getListadoTotal()
	{

		return this.controlador.getListadoTotal();
	}

	public String getListadoProblemas()
	{
		return this.controlador.getListadoProblemas();
	}
	
	public void actualizaListaAnimales()
	{
		this.dialogoNuevoAnimal.actualizaComboAreas();
		this.dialogoNuevoAnimal.actualizaListaAnimales();
	}
	
}
