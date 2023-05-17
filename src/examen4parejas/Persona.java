package examen4parejas;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Persona implements Comparable<Persona>
{
	public static final boolean HOMBRE = true;
	public static final boolean MUJER = false;

	private String nombre;
	private Sexo sexoPropio;
	private Sexo sexoBuscado;
	private boolean esGestor;
	private LinkedList<String> aficiones=new LinkedList<>();

	public Persona(String nombre, Sexo sexoPropio, Sexo sexoBuscado, boolean esGestor, List<String> gustos)
	{
		this.nombre=nombre;
		this.sexoPropio=sexoPropio;
		this.sexoBuscado=sexoBuscado;
		this.esGestor=esGestor;
		this.aficiones.addAll(gustos);
	}
	
	public String aficionesComunesCon(Persona otra)
	{
	   String aficionesComunes="";
	   for(String gusto: aficiones) {
		   if(otra.aficiones.contains(gusto)) {
			   aficionesComunes+=gusto+", ";
		   }
	   }
	   return aficionesComunes;
	}
   
   @Override
	public String toString()
	{
	   String aficionesSt="";
	   for(String aficion: aficiones) {
		   aficionesSt+="\n              "+aficion;
	   }
		return "Nombre.......: "+nombre+"\r\n"
		   		+ "Sexo propio..: "+(sexoPropio==Sexo.HOMBRE?"Hombre":"Mujer")+"\r\n"
		   		+ "Sexo buscado.: "+(sexoBuscado==Sexo.HOMBRE?"Hombre":"Mujer")+"\r\n"
		   		+ "Es gestor....: "+esGestor+"\r\n"
		   		+ "Aficiones....: "+aficionesSt+"\n";
	}

	public boolean isGestor()
	{
		return esGestor;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public Sexo getSexoPropio()
	{
		return sexoPropio;
	}

	public Sexo getSexoBuscado()
	{
		return sexoBuscado;
	}

	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	
	
}
