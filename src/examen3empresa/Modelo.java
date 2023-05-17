package examen3empresa;

import java.util.*;

public class Modelo
{
	private HashMap<Comercial, TreeSet<Empresa>> asignaciones;
	private Vector<Visita> visitas;

	public Modelo()
	{
		this.asignaciones = new HashMap<Comercial,TreeSet<Empresa>>();
		this.visitas = new Vector<Visita>();
	}

	public void añadeComercial(Comercial c)
	{
		// añade al mapa de asignaciones una nueva pareja con el comercial pasado como 
		// parámetro y un conjunto nuevo vacío de empresas asignadas.
		this.asignaciones.put(c, new TreeSet<Empresa>());
	}

	public void asignaEmpresaAComercial(Comercial c, Empresa e)
	{
		// asigna la empresa pasada como parámetro al conjunto de empresas que tiene asignadas
		// el comercial pasado como parámetro.
		if(!this.asignaciones.containsKey(c))
			this.añadeComercial(c);
		this.asignaciones.get(c).add(e);
	}

	public void añadeVisita(Visita visita)
	{
		this.visitas.add(visita);
	}

	public boolean hayErrores()
	{
		// Devuelve true si hay alguna visita hecha por un comercial a una empresa que NO estaba
		// asignada a ese comercial. Devuelve false en otro caso.
		for(Visita v:this.visitas)
			if(!this.asignaciones.get(v.getComercial()).contains(v.getEmpresa()))
				return true;
		return false;
	}

	public float totalComprasPorComercial(Comercial c)
	{
		// Devuelve el total de compras hechas por las empresas asignadas al comercial
		// pasado como parámetro.
		float total=0;
		
		for(Empresa e:this.asignaciones.get(c))
			total+=e.getCompras();
		
		return total;
	}

	public float totalVentasPorEmpresa(Empresa e)
	{
		// Devuelve el total de ventas hechas por todos los comerciales asignados a 
		// la empresa pasada como parámetro.
		float total = 0;
		
		for(Comercial c:this.asignaciones.keySet())
			if(this.asignaciones.get(c).contains(e))
				total += c.getVentas();
		
		return total;
	}

	public TreeSet<Comercial> comercialesQueVisitaronEnElMes(int mes)
	{
		// Devuelve un TreeSet con todos los comerciales que hicieron alguna visita 
		// en el mes pasado como parámetro.
		
		TreeSet<Comercial> arbol = new TreeSet<Comercial>();
		
		for(Visita v:this.visitas)
			if(v.getMes() == mes)
				arbol.add(v.getComercial());
		
		return arbol;
	}

	public TreeSet<String> nombresDeEmpresasNoVisitadas()
	{
		// Devuelve un TreeSet con todas las empresas que no han recibido ninguna visita.
		TreeSet<String> arbol = new TreeSet<String>();
		
		for(TreeSet<Empresa> t:this.asignaciones.values())
		{
			for(Empresa e:t)
			{
				boolean visitada = false;
				for(Visita v:this.visitas)
					if(v.getEmpresa().equals(e))
						visitada = true;
				if(!visitada)
					arbol.add(e.getNombre());
			}	
		}
	
		return arbol;
	}


	public TreeMap<Comercial, LinkedList<Visita>> mapaVisitasPorComercial()
	{
		// Devuelve un mapa con todos los comerciales como claves, y el valor asociado a 
		// cada comercial es una LinkedList de las visitas que ha hecho ese comercial.
		TreeMap<Comercial, LinkedList<Visita>> mapa = new TreeMap<Comercial, LinkedList<Visita>>();
		
		for(Comercial c:this.asignaciones.keySet())
		{
			LinkedList<Visita> lista = new LinkedList<Visita>();
			for(Visita v:this.visitas)
				if(v.getComercial().equals(c))
			       lista.add(v);
			mapa.put(c, lista);
		}
		return mapa;
	}

}
