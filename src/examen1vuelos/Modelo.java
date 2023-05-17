package examen1vuelos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Modelo
{
	private TreeMap<Localidad,HashSet<Vuelo>> conexiones;
	private TreeSet<LineaAerea> líneas;

	public Modelo()
	{
		this.conexiones = new TreeMap<Localidad,HashSet<Vuelo>>();
		this.líneas = new TreeSet<LineaAerea>();
	}

	public void añadirLínea(LineaAerea línea)
	{
		this.líneas.add(línea);
	}

	public void añadirLocalidad(Localidad localidad) {
	// añade al mapa de conexiones una nueva pareja con la localidad
	// pasada como parámetro y un nuevo conjunto de vuelos vacío. 

		conexiones.put(localidad, new HashSet<Vuelo>());
	}

	public void añadirVueloALocalidad(Localidad localidad, Vuelo vuelo) {
	// añade el vuelo pasado como parámetro al conjunto de vuelos asociado a
	// la localidad pasada como parámetro.
		if(conexiones.get(localidad)==null) {
			this.añadirLocalidad(localidad);
		}
		conexiones.get(localidad).add(vuelo);

	}

	public boolean hayErrores()
	// devuelve un boolean indicando si hay errores en los datos, es decir,
	// si hay algún vuelo con la misma localidad de origen que de destino.
	{
		boolean hayErrores=false;
		//más sencillo en cuanto a código pero menos eficiente:
//		for(Localidad l: conexiones.keySet()) {
//			for(Vuelo v:conexiones.get(l)) {
//				if(l.equals(v.getDestino())) {
//					hayErrores=true;
//				}
//			}
//		}
		
		//más eficiente:
		Iterator<Localidad> itOrigenes = conexiones.keySet().iterator();
		while(itOrigenes.hasNext() && !hayErrores) {
			Localidad l= itOrigenes.next();
			Iterator<Vuelo> itVuelosDest=conexiones.get(l).iterator();
			while(itVuelosDest.hasNext() && !hayErrores) {
				Vuelo v=itVuelosDest.next();
				if(l.equals(v.getDestino())) {
					hayErrores=true;
				}
			}
			
		}
		return hayErrores;
	}

	public int numVuelosALocsMillon(Localidad loc)
	// devuelve un entero con el número de vuelos que parten de la localidad
	// pasada como parámetro y llegan a localidades con más de 1.000.000 habs.
	{
		int numVuelos=0;
		for(Vuelo v: this.conexiones.get(loc)) {
			if(v.getDestino().getHabitantes()>1000000) {
				numVuelos++;
			}
		}
		return numVuelos;
	}

	public TreeSet<LineaAerea> lineasHasta(Localidad localidad){
	// devuelve un TreeSet con todas las líneas aéreas que tienen vuelos hacia
	// la localidad pasada como parámetro.
		TreeSet<LineaAerea> lineas=new TreeSet<>();
		for(HashSet<Vuelo> vuelos: this.conexiones.values()) {
			for(Vuelo v: vuelos) {
				if(v.getDestino().equals(localidad)) {
					lineas.add(v.getLinea());
				}
			}
		}
		return lineas;
	}

	public int totalAvionesDesde(Localidad localidad) {
	// devuelve un entero con la suma de todos los aviones que tienen las líneas
	// que hacen vuelos desde la localidad pasada como parámetro.
		int totalAviones=0;
		for(Vuelo v:this.conexiones.get(localidad)) {
			totalAviones+=v.getLinea().getNumAviones();
		}
		return totalAviones;
	}

	public boolean hayVuelosReciprocos()
	// devuelve un boolean indicando si existen dos ciudades entre las que hay 
	// vuelos en los dos sentidos.
	{
		boolean hayReciprocos=false;
		Set<Localidad> conjLocsOrigen= this.conexiones.keySet();
		for(Localidad l: conjLocsOrigen) {
			for(Vuelo v: this.conexiones.get(l)) {
				if(this.hayVueloDesdeHasta(v.getDestino(), l)) {
					hayReciprocos=true;
				}
			}
		}
		return hayReciprocos;
	}
	
	public boolean hayVueloDesdeHasta(Localidad origen, Localidad destino){
		boolean hay=false;
		for(Vuelo v:this.conexiones.get(origen)) {
			if(v.getDestino().equals(destino)) {
				hay=true;
			}
		}
		return hay;
	}

	public String toString()
	{
		String res="";
		for(Localidad l:this.conexiones.keySet())
		{
			res+="\nDesde: "+l.getNombre()+" hasta:\n";
			for(Vuelo v:this.conexiones.get(l))
				res+=v.getDestino().getNombre()+" con "+v.getLinea()+", ";
		}

		return res;
	}

}
