package examen1vuelos;

public class Localidad implements Comparable<Localidad>
{
	private String nombre;
	private int habitantes;
	public Localidad(String nombre, int habitantes)
	{
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getHabitantes()
	{
		return habitantes;
	}
	public void setHabitantes(int habitantes)
	{
		this.habitantes = habitantes;
	}
	
	@Override
	public String toString()
	{
		return "Localidad [nombre=" + nombre + ", habitantes=" + habitantes + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public int compareTo(Localidad o) {
		return this.nombre.compareTo(o.nombre);
	}
	




}
