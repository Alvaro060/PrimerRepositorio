package examen2feria;


public class Artículo implements Comparable<Artículo>
{
	private String denominación;
	private String tamaño;
	
	public Artículo(String denominación, String tamaño) 
	{
		super();
		this.denominación = denominación;
		this.tamaño = tamaño;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominación == null) ? 0 : denominación.hashCode());
		result = prime * result + ((tamaño == null) ? 0 : tamaño.hashCode());
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
		Artículo other = (Artículo) obj;
		if (denominación == null) {
			if (other.denominación != null)
				return false;
		} else if (!denominación.equals(other.denominación))
			return false;
		if (tamaño == null) {
			if (other.tamaño != null)
				return false;
		} else if (!tamaño.equals(other.tamaño))
			return false;
		return true;
	}

public int compareTo(Artículo otro)
{
	int res;
	
	res = this.denominación.compareTo(otro.denominación);
	if(res == 0)
		res = this.tamaño.compareTo(otro.tamaño);
	return res;
}

public String toString()
{
	return this.denominación+" "+this.tamaño;
}

public String getDenominación() {
	return denominación;
}

public void setDenominación(String denominación) {
	this.denominación = denominación;
}

public String getTamaño() {
	return tamaño;
}

public void setTamaño(String tamaño) {
	this.tamaño = tamaño;
}

}
