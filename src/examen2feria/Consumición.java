package examen2feria;


public class Consumición
{
	private Artículo artículo;
	private int cantidad;

	public Consumición(Artículo artículo, int cantidad)
	{
		this.artículo = artículo;
		this.cantidad = cantidad;
	}

	public Artículo getArtículo() {
		return artículo;
	}

	public void setArtículo(Artículo artículo) {
		this.artículo = artículo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "    " + artículo + "\t" + cantidad ;
	}




}
