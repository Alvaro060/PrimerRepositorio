package examen5reservaanimales;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Principal
{
	Vista vista;
	Reserva modelo;

	public static void main(String[] args)
	{
		new Principal();
	}

	private void añadeDatosDePrueba()
	{
		Area pradera = new Area("Pradera", 3.4F);
		Area lago = new Area("Orilla del lago", 4.2F);
		Area bosque = new Area("Bosque", 5.4F);
		
		
		this.modelo.añadeÁrea("Pradera", 3.4F);
		this.modelo.añadeÁrea("Orilla del lago", 4.2F);
		this.modelo.añadeÁrea("Bosque", 5.4F);
		
		this.modelo.añadeAnimal("León", pradera, new LinkedList<Animal>());
		this.modelo.añadeAnimal("Hiena", pradera, new LinkedList<Animal>());
		this.modelo.añadeAnimal("Elefante", pradera, new LinkedList<Animal>());
		
		this.modelo.añadeAnimal("Gacela", lago, new LinkedList<Animal>());
		this.modelo.añadeAnimal("Ñu", lago, new LinkedList<Animal>());	
		this.modelo.añadeAnimal("Cocodrilo", lago, new LinkedList<Animal>());
		
		this.modelo.añadeAnimal("Gorila", bosque, new LinkedList<Animal>());
		this.modelo.añadeAnimal("Tigre", bosque, new LinkedList<Animal>());	

		
		this.vista.actualizaListadoAreasVentana();
		this.vista.actualizaListaAnimales();
		
		
		
	
		
	}

	public Principal()
	{
		this.modelo = new Reserva();
		this.vista = new Vista(this);
		
		/***********************************/
		
		this.añadeDatosDePrueba();
		
		/***********************************/ 
	}

	public boolean añadeAnimal(String nombre, Area area, List listaPresas)
	{
		return this.modelo.añadeAnimal(nombre,area,listaPresas);
	}

	public boolean añadeÁrea(String nombre, float extensión)
	{
		return this.modelo.añadeÁrea(nombre,extensión);
	}

	public Set<Area> getlistaAreas()
	{
		return this.modelo.getListaAreas();
	}


	public TreeSet<Animal> getListaAnimales()
	{
		return this.modelo.getListaAnimales();
	}

	public String getListadoArea(Area area)
	{
		return this.modelo.getListadoArea(area);
	}

	public Animal getAnimal(String nombre)
	{
		return this.modelo.getAnimal(nombre);
	}

	public void actualizaAnimal(Animal animalSeleccionado, List<Animal> presas)
	{
		this.modelo.actualizaAnimal(animalSeleccionado,presas);
		
	}

	public String getListadoTotal()
	{
		return this.modelo.getListadoTotal();
	}

	public String getListadoProblemas()
	{
		return this.modelo.getListadoProblemas();
	}
}
