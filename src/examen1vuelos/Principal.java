package examen1vuelos;


public class Principal
{
	private Modelo modelo;

	public static void main(String[] args)
	{
		new Principal();
	}

	public Principal()
	{
		this.modelo = new Modelo();

		this.añadeDatosDePrueba();
		
      //PARA MOSTRAR EL MODELO. DESCOMENTAR PARA VERLO.
      //		System.out.println(this.modelo);
		//APARTADO HAY ERRORES
		System.out.println("¿Hay errores (vuelo de ciudad a sí misma)? (debe salir false): "+this.modelo.hayErrores());
		this.modelo.añadirVueloALocalidad(new Localidad("Washington D. C. ",692700),
				                          new Vuelo(new LineaAerea("Lufthansa",260),
				                        		    new Localidad("Washington D. C. ",692700)));
		System.out.println("¿Hay errores (vuelo de ciudad a sí misma)? (debe salir true): "+this.modelo.hayErrores());

		// APARTADO A CUANTAS LOCALIDADES CON MAS DE 1.000.000 HABS TIENE VUELOS UNA LOCALIDAD DADA  
		System.out.println("La localidad Washington D. C. tiene "+
		     this.modelo.numVuelosALocsMillon(new Localidad("Washington D. C. ",692700))+" vuelos a localidades de mas de 1.000.000 habs.");
		System.out.println("La localidad Miami tiene "+
			     this.modelo.numVuelosALocsMillon(new Localidad("Miami",454279))+" vuelos a localidades de mas de 1.000.000 habs.");

		// APARTADO LINEAS AEREAS QUE TIENEN COMO DESTINO  A UNA LOCALIDAD DADA
		System.out.println("A la localidad Berlín vuelan las líneas aéreas :"+
		                   this.modelo.lineasHasta(new Localidad("Berlín",3645000)) );
		
		// APARTADO NUM TOTAL DE AVIONES DE LAS LINEAS QUE TIENEN VUELOS QUE SALEN DE UNA LOCALIDAD
		System.out.println("Suma de todos los aviones de todas las líneas que vuelan desde Frankfurt: "+
		                    this.modelo.totalAvionesDesde(new Localidad("Frankfurt",753056)));
		
		// APARTADO EXISTEN DOS CIUDADES A,B QUE TENGAN VUELOS DE A->B Y DE B->A?
		System.out.println("¿Existen al menos dos ciudades que tengan vuelos en los dos sentidos?"+
		                    this.modelo.hayVuelosReciprocos());
		
	}

	private void añadeDatosDePrueba()
	{
		LineaAerea l01 = new LineaAerea("Iberia", 148);
		LineaAerea l02 = new LineaAerea("American Airlines",950);
		LineaAerea l03 = new LineaAerea("Delta Air Lines",850);
		LineaAerea l04 = new LineaAerea("United Airlines",745);
		LineaAerea l05 = new LineaAerea("Southwest Airlines",697);
		LineaAerea l06 = new LineaAerea("British Airways",255);
		LineaAerea l07 = new LineaAerea("Air France",213);
		LineaAerea l08 = new LineaAerea("Ryanair",413);
		LineaAerea l09 = new LineaAerea("Emirates",257);
		LineaAerea l10 = new LineaAerea("Lufthansa",260);
		LineaAerea l11 = new LineaAerea("Turkish Airlines",329);

        this.modelo.añadirLínea(l01);
        this.modelo.añadirLínea(l02);
        this.modelo.añadirLínea(l03);
        this.modelo.añadirLínea(l04);
        this.modelo.añadirLínea(l05);
        this.modelo.añadirLínea(l06);
        this.modelo.añadirLínea(l07);
        this.modelo.añadirLínea(l08);
        this.modelo.añadirLínea(l09);
        this.modelo.añadirLínea(l10);
        this.modelo.añadirLínea(l11);
		
		Localidad c01 =new Localidad("Boston",685000);
		Localidad c02 =new Localidad("Chicago",2710000);
		Localidad c03 =new Localidad("Los Ángeles",3967000); 	
		Localidad c04 =new Localidad("Miami",454279); 	
		Localidad c05 =new Localidad("Nueva York",8419000);
		Localidad c06 =new Localidad("San Francisco",875000);
		Localidad c07 =new Localidad("Washington D. C. ",692700);
		Localidad c08 =new Localidad("Ciudad de México",8855000);
		Localidad c09 =new Localidad("Berlín",3645000);
		Localidad c10 =new Localidad("Dusseldorf",619294);
		Localidad c11 =new Localidad("Frankfurt",753056);
		Localidad c12 =new Localidad("Hamburgo",1841000);
		Localidad c13 =new Localidad("Múnich",1472000);
		Localidad c14 =new Localidad("Stuttgart",635000);
		Localidad c15 =new Localidad("Viena",1897000);
		Localidad c16 =new Localidad("Bruselas",1209000);
		Localidad c17 =new Localidad("Split",349000);
		Localidad c18 =new Localidad("Zagreb",806000);
		Localidad c19 =new Localidad("Copenhague",1970000);
		
		this.modelo.añadirLocalidad(c01);
		this.modelo.añadirLocalidad(c02);
		this.modelo.añadirLocalidad(c03);
		this.modelo.añadirLocalidad(c04);
		this.modelo.añadirLocalidad(c05);
		this.modelo.añadirLocalidad(c06);
		this.modelo.añadirLocalidad(c07);
		this.modelo.añadirLocalidad(c08);
		this.modelo.añadirLocalidad(c09);
		this.modelo.añadirLocalidad(c10);
		this.modelo.añadirLocalidad(c11);
		this.modelo.añadirLocalidad(c12);
		this.modelo.añadirLocalidad(c13);
		this.modelo.añadirLocalidad(c14);
		this.modelo.añadirLocalidad(c15);
		this.modelo.añadirLocalidad(c16);
		this.modelo.añadirLocalidad(c17);
		this.modelo.añadirLocalidad(c18);
		this.modelo.añadirLocalidad(c19);

		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l01,c15));
		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l04,c05));
		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l05,c13));
		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l05,c14));
		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l08,c08));
		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l10,c19));
		this.modelo.añadirVueloALocalidad(c01, new Vuelo(l11,c16));
		this.modelo.añadirVueloALocalidad(c02, new Vuelo(l05,c19));
		this.modelo.añadirVueloALocalidad(c02, new Vuelo(l08,c13));
		this.modelo.añadirVueloALocalidad(c02, new Vuelo(l11,c04));
		this.modelo.añadirVueloALocalidad(c03, new Vuelo(l02,c09));
		this.modelo.añadirVueloALocalidad(c03, new Vuelo(l03,c05));
		this.modelo.añadirVueloALocalidad(c03, new Vuelo(l09,c04));
		this.modelo.añadirVueloALocalidad(c03, new Vuelo(l09,c15));
		this.modelo.añadirVueloALocalidad(c03, new Vuelo(l11,c13));
		this.modelo.añadirVueloALocalidad(c03, new Vuelo(l11,c18));
		this.modelo.añadirVueloALocalidad(c04, new Vuelo(l05,c14));
		this.modelo.añadirVueloALocalidad(c04, new Vuelo(l08,c08));
		this.modelo.añadirVueloALocalidad(c04, new Vuelo(l09,c15));
		this.modelo.añadirVueloALocalidad(c04, new Vuelo(l10,c03));
		this.modelo.añadirVueloALocalidad(c04, new Vuelo(l10,c06));
		this.modelo.añadirVueloALocalidad(c05, new Vuelo(l01,c19));
		this.modelo.añadirVueloALocalidad(c05, new Vuelo(l03,c03));
		this.modelo.añadirVueloALocalidad(c05, new Vuelo(l07,c07));
		this.modelo.añadirVueloALocalidad(c05, new Vuelo(l07,c13));
		this.modelo.añadirVueloALocalidad(c05, new Vuelo(l08,c17));
		this.modelo.añadirVueloALocalidad(c05, new Vuelo(l10,c18));
		this.modelo.añadirVueloALocalidad(c06, new Vuelo(l02,c03));
		this.modelo.añadirVueloALocalidad(c06, new Vuelo(l02,c05));
		this.modelo.añadirVueloALocalidad(c06, new Vuelo(l06,c19));
		this.modelo.añadirVueloALocalidad(c06, new Vuelo(l09,c07));
		this.modelo.añadirVueloALocalidad(c06, new Vuelo(l10,c01));
		this.modelo.añadirVueloALocalidad(c06, new Vuelo(l10,c16));
		this.modelo.añadirVueloALocalidad(c07, new Vuelo(l07,c10));
		this.modelo.añadirVueloALocalidad(c07, new Vuelo(l09,c12));
		this.modelo.añadirVueloALocalidad(c07, new Vuelo(l10,c14));
		this.modelo.añadirVueloALocalidad(c08, new Vuelo(l01,c19));
		this.modelo.añadirVueloALocalidad(c08, new Vuelo(l02,c15));
		this.modelo.añadirVueloALocalidad(c08, new Vuelo(l05,c03));
		this.modelo.añadirVueloALocalidad(c08, new Vuelo(l10,c09));
		this.modelo.añadirVueloALocalidad(c08, new Vuelo(l10,c17));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l03,c08));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l08,c11));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l08,c16));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l08,c17));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l09,c03));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l10,c02));
		this.modelo.añadirVueloALocalidad(c09, new Vuelo(l10,c10));
		this.modelo.añadirVueloALocalidad(c10, new Vuelo(l02,c19));
		this.modelo.añadirVueloALocalidad(c10, new Vuelo(l04,c09));
		this.modelo.añadirVueloALocalidad(c10, new Vuelo(l07,c05));
		this.modelo.añadirVueloALocalidad(c10, new Vuelo(l11,c06));
		this.modelo.añadirVueloALocalidad(c10, new Vuelo(l11,c08));
		this.modelo.añadirVueloALocalidad(c10, new Vuelo(l11,c16));
		this.modelo.añadirVueloALocalidad(c11, new Vuelo(l01,c03));
		this.modelo.añadirVueloALocalidad(c11, new Vuelo(l02,c17));
		this.modelo.añadirVueloALocalidad(c11, new Vuelo(l03,c02));
		this.modelo.añadirVueloALocalidad(c11, new Vuelo(l10,c09));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l01,c07));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l01,c11));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l07,c16));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l08,c14));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l09,c08));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l09,c09));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l10,c05));
		this.modelo.añadirVueloALocalidad(c12, new Vuelo(l10,c10));
		this.modelo.añadirVueloALocalidad(c13, new Vuelo(l01,c10));
		this.modelo.añadirVueloALocalidad(c13, new Vuelo(l05,c16));
		this.modelo.añadirVueloALocalidad(c13, new Vuelo(l06,c02));
		this.modelo.añadirVueloALocalidad(c13, new Vuelo(l06,c04));
		this.modelo.añadirVueloALocalidad(c13, new Vuelo(l07,c12));
		this.modelo.añadirVueloALocalidad(c13, new Vuelo(l07,c19));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l01,c18));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l02,c04));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l03,c08));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l05,c10));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l06,c17));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l07,c02));
		this.modelo.añadirVueloALocalidad(c14, new Vuelo(l10,c12));
		this.modelo.añadirVueloALocalidad(c15, new Vuelo(l02,c19));
		this.modelo.añadirVueloALocalidad(c15, new Vuelo(l04,c18));
		this.modelo.añadirVueloALocalidad(c15, new Vuelo(l10,c13));
		this.modelo.añadirVueloALocalidad(c16, new Vuelo(l03,c13));
		this.modelo.añadirVueloALocalidad(c16, new Vuelo(l04,c07));
		this.modelo.añadirVueloALocalidad(c16, new Vuelo(l04,c12));
		this.modelo.añadirVueloALocalidad(c16, new Vuelo(l05,c11));
		this.modelo.añadirVueloALocalidad(c16, new Vuelo(l11,c14));
		this.modelo.añadirVueloALocalidad(c17, new Vuelo(l08,c19));
		this.modelo.añadirVueloALocalidad(c17, new Vuelo(l09,c10));
		this.modelo.añadirVueloALocalidad(c17, new Vuelo(l11,c03));
		this.modelo.añadirVueloALocalidad(c17, new Vuelo(l11,c11));
		this.modelo.añadirVueloALocalidad(c18, new Vuelo(l01,c16));
		this.modelo.añadirVueloALocalidad(c18, new Vuelo(l04,c19));
		this.modelo.añadirVueloALocalidad(c19, new Vuelo(l01,c12));
		this.modelo.añadirVueloALocalidad(c19, new Vuelo(l05,c05));
		this.modelo.añadirVueloALocalidad(c19, new Vuelo(l08,c09));
	}
}