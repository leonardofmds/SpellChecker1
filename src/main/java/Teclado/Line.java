package Teclado;

public class Line
{

	private String content;
	private double offset;

	public Line()
	{

	}
	/**
	 * Retorna String contendo os caracteres da linha
	 * @return
	 */
	public String getContent()
	{
		return content;
	}
	/**
	 * Seta contúdo da linha do teclado
	 * @param content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	/**
	 * retorna offset da linha
	 * @return
	 */
	public double getOffset()
	{
		return offset;
	}
	/**
	 * Seta offset da linha
	 * @param offset
	 */
	public void setOffset(double offset)
	{
		this.offset = offset;
	}

}
