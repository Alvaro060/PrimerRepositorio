package examen2feria;


public class Socio
{
	private String nombre;
	private int antigüedad;

	public Socio(String nombre, int antigüedad)
	{
		this.nombre = nombre;
		this.antigüedad = antigüedad;
	}

	public String toString()
	{
		return this.nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antigüedad;
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
		Socio other = (Socio) obj;
		if (antigüedad != other.antigüedad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	


}