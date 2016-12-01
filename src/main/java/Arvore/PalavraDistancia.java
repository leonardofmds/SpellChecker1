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
	
	public String getPalavra()
	{
		return Palavra;
	}

	public void setPalavra(String palavra)
	{
		Palavra = palavra;
	}

	public double getDistancia()
	{
		return Distancia;
	}

	public void setDistancia(double distancia)
	{
		Distancia = distancia;
	}

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
