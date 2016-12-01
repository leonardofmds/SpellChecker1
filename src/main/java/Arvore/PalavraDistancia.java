package Arvore;

public class PalavraDistancia implements Comparable<PalavraDistancia>
{
	private String Palavra;
	private double Distancia;
	
	public PalavraDistancia(String palavra, double distancia)
	{
		this.Palavra = palavra;
		this.Distancia = distancia;
	}
	/**
	 * Retorna a Palavra
	 * @return
	 */
	public String getPalavra()
	{
		return Palavra;
	}
	/**
	 * seta a Palavra
	 * @param palavra
	 */
	public void setPalavra(String palavra)
	{
		Palavra = palavra;
	}
	/**
	 * Retorna a distância da palavra
	 * @return
	 */
	public double getDistancia()
	{
		return Distancia;
	}
	/**
	 * Seta a distância da palavra
	 * @param distancia
	 */
	public void setDistancia(double distancia)
	{
		Distancia = distancia;
	}
	/**
	 * Método implementado pela interface Comparable para poder usar a função sort da classe Collections. 
	 */
	public int compareTo(PalavraDistancia outraPalavra)
	{
		if (this.Distancia < outraPalavra.Distancia)
		{
			return -1;
		}
		if (this.Distancia > outraPalavra.Distancia)
		{
			return 1;
		}
		return 0;
	}
}
