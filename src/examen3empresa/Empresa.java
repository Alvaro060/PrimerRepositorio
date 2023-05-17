package examen3empresa;


public class Empresa implements Comparable<Empresa>
{
	private String nombre;
	private float compras;
	public Empresa(String nombre, float compras)
	{
		super();
		this.nombre = nombre;
		this.compras = compras;
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
		Empresa other = (Empresa) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



	public int compareTo(Empresa otra)
	{
		return this.nombre.compareTo(otra.nombre);
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public float getCompras()
	{
		return compras;
	}
	public void setCompras(float compras)
	{
		this.compras = compras;
	}

	@Override
	public String toString()
	{
		return  nombre ;
	}


}
