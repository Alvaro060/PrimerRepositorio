package examen4parejasintento;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Modelo 
{
	public static final int CORRECTO = 0;
	public static final int YA_EXISTE = 1;

	private LinkedHashSet<Persona> solicitantes;
	private  HashMap<Persona, TreeMap<Persona,Persona>> gestoresParejas;

	public Modelo()
	{
		solicitantes=new LinkedHashSet<>();
		gestoresParejas=new HashMap<Persona, TreeMap<Persona,Persona>> ();
	}

	public int anyadeSolicitante(String nombre, Sexo sexoSolicitante, Sexo sexoSolicitado, boolean gestor,
			List<String> aficiones)
	{
		return 0;
	}

	public Set<Persona> getListaGestores()
	{
		return new HashSet<>();
	}

	public Set<Persona> getListaSolicitantes()
	{
		return this.solicitantes;
	}

	public String getListadoAfinidades(String nombreSolicitante)
	{
		return "getListadoAfinidades";
	}

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja)
	{
		return 0;
	}

	public String getListadoSolicitantes()
	{
		return "getListadoSolicitantes";
	}

	public String getListadoParejas()
	{
		return "getListadoParejas";
	}

}
