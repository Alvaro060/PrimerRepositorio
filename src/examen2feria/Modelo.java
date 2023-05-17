package examen2feria;

import java.util.*;

public class Modelo
{
	private ListaPrecios listaPrecios;
	private ListaSocios listaSocios;
	private HashMap<Socio,LinkedList<Consumición>> listaCuentas; 

	public Modelo()
	{
		this.listaPrecios = new ListaPrecios();
		this.listaSocios = new ListaSocios();
		this.listaCuentas = new HashMap<Socio,LinkedList<Consumición>>();
	}




	public boolean añadeArtículo(String nombre,  String tamaño, float precio) 
	{
		return this.listaPrecios.put(new Artículo(nombre,tamaño),precio)==null;
	}

	public boolean borraArtículo(String nombre, String tamaño) 
	{
		return this.listaPrecios.remove(new Artículo(nombre,tamaño))==null;
	}

	public  ListaSocios getListaSocios() 
	{
		return this.listaSocios;
	}

	public ListaPrecios getListaPrecios() 
	{
		return listaPrecios;
	}

	public boolean hayCuentaPendienteConEseArticulo(String art, String tamaño) 
	{
		//Si se hace con iteradores es más eficiente porque podemos parar los bucles, pero con foreach queda más claro, 
		//y tampoco son muy grandes estas colecciones. Lo que prefirais.
		boolean res=false;
		for(Socio s:this.listaCuentas.keySet())
			for(Consumición c:this.listaCuentas.get(s))
				if(c.getArtículo().equals(new Artículo(art,tamaño)))
					res= true;

		return res;

	}

	public void añadeConsumición(Socio socio, Artículo artículo, int cantidad) 
	{
		//si el socio no está, se añade vinculado a una lista de consumiciones vacía (que no asociado a null)
		if(!this.listaCuentas.containsKey(socio)) {
			this.listaCuentas.put(socio, new LinkedList<Consumición>());
		}
		this.listaCuentas.get(socio).add(new Consumición(artículo, cantidad));	
	}

	public LinkedList<Consumición> getListaConsumiciones(Socio socio) 
	{
		return this.listaCuentas.get(socio);
	}

	public String calculaTotalCuenta(Socio socio) 
	{
		String res="";
		float total =0.0F;
		if(this.listaCuentas.get(socio)!=null)
		{
			res+=socio+"\n";
			for(Consumición c:this.listaCuentas.get(socio))
			{
				res+=c.toString()+" x "+this.listaPrecios.get(c.getArtículo())+" = "+c.getCantidad()*this.listaPrecios.get(c.getArtículo())+"\n";
				total+=c.getCantidad()*this.listaPrecios.get(c.getArtículo());
			}
			res+="\nTOTAL...........:"+total;
		}
		return res;
	}


}
