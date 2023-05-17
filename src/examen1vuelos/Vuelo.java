package examen1vuelos;


public class Vuelo 
{
	private LineaAerea linea;
	private Localidad destino;
	
	public Vuelo(LineaAerea linea, Localidad destino)
	{
		super();
		this.linea = linea;
		this.destino = destino;
	}
	public LineaAerea getLinea()
	{
		return linea;
	}
	public void setLinea(LineaAerea linea)
	{
		this.linea = linea;
	}
	public Localidad getDestino()
	{
		return destino;
	}
	public void setDestino(Localidad destino)
	{
		this.destino = destino;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((linea == null) ? 0 : linea.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if (destino == null)
		{
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (linea == null)
		{
			if (other.linea != null)
				return false;
		} else if (!linea.equals(other.linea))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "Vuelo [linea=" + linea + ", destino=" + destino + "]";
	}





}
