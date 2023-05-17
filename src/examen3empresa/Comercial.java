package examen3empresa;


public class Comercial implements Comparable<Comercial>
{
	private String nombre;
	private float ventas;
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int compareTo(Comercial otro)
	{
		return this.nombre.compareTo(otro.nombre);
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
		Comercial other = (Comercial) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public float getVentas()
	{
		return ventas;
	}
	public void setVentas(float ventas)
	{
		this.ventas = ventas;
	}
	public Comercial(String nombre, float ventas)
	{
		super();
		this.nombre = nombre;
		this.ventas = ventas;
	}

	@Override
	public String toString()
	{
		return nombre;
	}
}
