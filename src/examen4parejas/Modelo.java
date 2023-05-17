package examen4parejas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Modelo {
	public static final int CORRECTO = 0;
	public static final int YA_EXISTE = 1;

	private LinkedHashSet<Persona> solicitantes;
	private HashMap<Persona, TreeMap<Persona, Persona>> gestoresParejas;

	public Modelo() {
		solicitantes = new LinkedHashSet<>();
		gestoresParejas = new HashMap<Persona, TreeMap<Persona, Persona>>();
	}

	public int anyadeSolicitante(String nombre, Sexo sexoSolicitante, Sexo sexoSolicitado, boolean gestor,
			List<String> aficiones) {
		Persona p= new Persona(nombre, sexoSolicitante, sexoSolicitado, gestor, aficiones);		
		return solicitantes.add(p)?CORRECTO:YA_EXISTE;
	}

	public Set<Persona> getListaGestores() {
		Set<Persona> solicitantesGestores=new HashSet<>();
		for (Persona persona : solicitantes) {
			if(persona.isGestor()) {
				solicitantesGestores.add(persona);
			}
		}
		return solicitantesGestores;
	}

	public Set<Persona> getListaSolicitantes() {
		return this.solicitantes;
	}

	public String getListadoAfinidades(String nombreSolicitante) {
		String listadoPersonasAfines="";
		Persona personaParam=getPersonaSolicitantePorNombre(nombreSolicitante);
		for (Persona persona : solicitantes) {
			if(persona.getSexoPropio().equals(personaParam.getSexoBuscado()) && persona.getSexoBuscado().equals(personaParam.getSexoPropio()) && !persona.equals(personaParam)) {
				listadoPersonasAfines+="Aficiones comunes de "+nombreSolicitante+" y "+persona.getNombre()+": "+persona.aficionesComunesCon(personaParam)+"\n";
			}
		}
		return listadoPersonasAfines;
	}

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja) {
		Persona gestor=this.getPersonaSolicitantePorNombre(nombreGestor);
		Persona solicitante=this.getPersonaSolicitantePorNombre(nombreSolicitante);
		Persona pareja=this.getPersonaSolicitantePorNombre(nombrePareja);
		if(!gestoresParejas.containsKey(gestor)) {
			gestoresParejas.put(gestor, new TreeMap<Persona, Persona>());
		}
		int puedoIncluirlo=CORRECTO;
		for(TreeMap<Persona,Persona> v : gestoresParejas.values()) {
			if(v.containsKey(solicitante) || 
					v.containsValue(solicitante) || 
					v.containsKey(pareja) || 
					v.containsValue(pareja)) {
				puedoIncluirlo=YA_EXISTE;
			}
		}
		if(puedoIncluirlo==CORRECTO) {
			gestoresParejas.get(gestor).put(solicitante, pareja);
		}
		return puedoIncluirlo;
	}

	private Persona getPersonaSolicitantePorNombre(String nombreSolicitante) {
		Persona personaParam=null;
		for (Persona personaP : solicitantes) {
			if(personaP.getNombre().equals(nombreSolicitante)) {
				personaParam=personaP;
			}
		}
		return personaParam;
	}
	
	public String getListadoSolicitantes() {
		String stringSolicitantes="";
		for (Persona persona : solicitantes) {
			stringSolicitantes+=persona+"\n";
		}
		return stringSolicitantes;
	}

	public String getListadoParejas() {
		String res = "";
		TreeMap<Persona, TreeMap<Persona, Persona>> mapaParejasOrdenado = new TreeMap<>(gestoresParejas);
		for (Persona gestor : mapaParejasOrdenado.keySet()) {
			if (mapaParejasOrdenado.get(gestor) != null && mapaParejasOrdenado.get(gestor).size() > 0) {
				res += "\nGestor.........:" + gestor.getNombre() + "\nParejas hechas.:";
				for (Persona p1 : mapaParejasOrdenado.get(gestor).keySet()) {
					res += "\n\t"+p1.getNombre() + " + " + mapaParejasOrdenado.get(gestor).get(p1).getNombre();
				}
			}
		}
		return res;
	}

}