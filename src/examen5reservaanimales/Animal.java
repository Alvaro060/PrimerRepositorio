package examen5reservaanimales;
import java.util.HashSet;
import java.util.List;

public class Animal implements Comparable<Animal>
{
	private String nombre;
	private HashSet<Animal> presas;



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Animal> getPresas() {
		return presas;
	}

	public void setPresas(HashSet<Animal> presas) {
		this.presas = presas;
	}

	public Animal(String nombre, List listaPresas)
	{
		this.nombre = nombre;
		//una solución
		//this.presas = (HashSet<Animal>) listaPresas;

		//otra
		//this.presas =new HashSet<Animal>(listaPresas);

		//otra más
		this.presas = new HashSet<Animal>();
		for(Object a:listaPresas)
			this.presas.add((Animal)a);

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
		Animal other = (Animal) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Animal otro) 
	{
		return this.nombre.compareTo(otro.nombre);
	}

	public String toString()
	{
		return this.nombre;
	}
	
    public String datos()
    {
    	String res="";
    	res+="            "+this.nombre+"\n";
    	res+="            (Depreda a: ";
    	for(Animal presa:this.presas)
    		res+=presa.nombre+" ";
    	
    	res+=")";
    	return res;
    }

}
