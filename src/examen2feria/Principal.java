package examen2feria;

import java.util.LinkedList;

public class Principal
{
	private Modelo modelo;
	private VentanaPpal vista;
	
	public static void main(String args[])
	{
		new Principal();
	}
	
	public Principal()
	{
		this.modelo = new Modelo();
		this.vista = new VentanaPpal(this);
		this.vista.setVisible(true);
		
		
		////CREACION DE LOS DATOS DE PRUEBA
		
		modelo.getListaSocios().add(new Socio("Álvarez Caballero, Fernando Javier",0));
		modelo.getListaSocios().add(new Socio("Berenguer Borrego, Fernando",0));
		modelo.getListaSocios().add(new Socio("Cabanillas Gálvez, Ezequiel",0));
		modelo.getListaSocios().add(new Socio("Campano Laborda, José Antonio",0));
		modelo.getListaSocios().add(new Socio("Carmona Montiel, Miguel",0));
		modelo.getListaSocios().add(new Socio("Castañeda Castaño, Alejandro ",0));
		modelo.getListaSocios().add(new Socio("Cervilla Campoy, Sergio",0));
		modelo.getListaSocios().add(new Socio("De la Fuente Campaña, Antonio",0));
		modelo.getListaSocios().add(new Socio("Domínguez Bermúdez, Marina Pilar",0));
		modelo.getListaSocios().add(new Socio("Domínguez González, Adrián",0));
		modelo.getListaSocios().add(new Socio("García Alves, Diego",0));
		modelo.getListaSocios().add(new Socio("García Moreno, José María",0));
		modelo.getListaSocios().add(new Socio("Garrido Hernández, Juan Manuel",0));
		modelo.getListaSocios().add(new Socio("Garrocho Prados, Manuel",0));
		modelo.getListaSocios().add(new Socio("Hernando Ortega, Iván",0));
		modelo.getListaSocios().add(new Socio("Herrera Pozas, David",0));
		modelo.getListaSocios().add(new Socio("Iglesias García, Javier Manuel",0));
		modelo.getListaSocios().add(new Socio("Mallén Rodríguez, Juan",0));
		modelo.getListaSocios().add(new Socio("Menacho Pantoja, Fernando David",0));
		modelo.getListaSocios().add(new Socio("Núñez Tocón, Alejandro",0));
		modelo.getListaSocios().add(new Socio("Ocampos Buendía, David",0));
		modelo.getListaSocios().add(new Socio("Pérez Vilches, Luis",0));
		modelo.getListaSocios().add(new Socio("Rodríguez Martínez, Juan Antonio",0));
		modelo.getListaSocios().add(new Socio("Sánchez Verdugo, Álvaro",0));
		modelo.getListaSocios().add(new Socio("Serrano García, Valme María",0));
		
		modelo.añadeArtículo("Coca Cola","Grande",1.2F);
		modelo.añadeArtículo("Coca Cola","Mediano",1.0F);
		modelo.añadeArtículo("Coca Cola","Pequeño",0.9F);
		modelo.añadeArtículo("Manzanilla","Mediano",4.2F);
		modelo.añadeArtículo("Tortilla","Grande",4.2F);
		modelo.añadeArtículo("Jamón","Mediano",9.0F);
		modelo.añadeArtículo("Jamón","Grande",10.2F);
		modelo.añadeArtículo("Jamón","Pequeño",6.5F);
		modelo.añadeArtículo("Rebujito","Grande",12.0F);
		
		this.vista.actualizaComboSocios();
		this.vista.actualizaComboArtículos();
		
		/// FIN DE LA CREACION DE DATOS DE PRUEBA
	}

	public boolean añadeArtículo(String nombre, float precio, String tamaño) 
	{
		return this.modelo.añadeArtículo(nombre,tamaño,precio);
	}

	public boolean borraArtículo(String nombre, String tamaño) 
	{
		return this.modelo.borraArtículo(nombre,tamaño);
	}

	public ListaSocios getListaSocios() 
	{
		return this.modelo.getListaSocios();
	}

	public ListaPrecios getListaPrecios() 
	{
		return this.modelo.getListaPrecios();
	}

	public boolean hayCuentaPendienteConEseArticulo(String art,String tamaño) 
	{
		return this.modelo.hayCuentaPendienteConEseArticulo(art,tamaño);
	}

	public void añadeConsumición(Socio socio, Artículo artículo,int cantidad) 
	{
		this.modelo.añadeConsumición(socio, artículo, cantidad);
	}

	public LinkedList<Consumición> getListaConsumiciones(Socio socio) 
	{
		return this.modelo.getListaConsumiciones( socio);
	}

	public String calculaTotal(Socio socio) 
	{
		return this.modelo.calculaTotalCuenta(socio);
	}
}

	
