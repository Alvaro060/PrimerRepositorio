package examen1vuelos;

/**
 * Descripción del método o clase.
 * 
 * @param parametro1 Descripción del primer parámetro.
 * @param parametro2 Descripción del segundo parámetro.
 * @return Descripción del valor de retorno.
 * @throws ExcepcionTipo Descripción de la excepción lanzada (si corresponde).
 */

public class LineaAerea implements Comparable<LineaAerea>{
	private String nombre;
	private int numAviones;
	
	public LineaAerea(String nombre, int numAviones)
	{
		this.nombre = nombre;
		this.numAviones = numAviones;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getNumAviones()
	{
		return numAviones;
	}
	public void setNumAviones(int numAviones)
	{
		this.numAviones = numAviones;
	}

	@Override
	public String toString()
	{
		return nombre;
	}
	@Override
	public int compareTo(LineaAerea o) {
		return this.nombre.compareTo(o.nombre);
	}



}