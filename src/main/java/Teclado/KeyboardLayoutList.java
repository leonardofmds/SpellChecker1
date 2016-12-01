package Teclado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pm.SpellCheckerLeonardo.*;;

public class KeyboardLayoutList 
{

	private List<KeyboardLayout> layouts;

	public KeyboardLayoutList()
	{

	}
	/**
	 * Adiciona Layout de teclado a lista de layouts
	 * @param p
	 */
	public void add(KeyboardLayout p)
	{
		if (layouts == null)
		{
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(p);
	}
	/**
	 * Retorna o Layout de teclado de acordo com o nome do modelo
	 * @param nomeLayout
	 * @return KeyboardLayout
	 */
	public KeyboardLayout getLayoutByName(String nomeLayout)
	{
		KeyboardLayout layout = new KeyboardLayout();
		for (KeyboardLayout keyboardLayout : layouts) 
		{
			if (keyboardLayout.getModel().equals(nomeLayout)) 
			{
				layout = keyboardLayout;
				return layout;
			}
		}
		return null;
	}
	/**
	 * Retorna a lista de KeyboardLayout
	 * @return List<KeyboardLayout>
	 */
	public List<KeyboardLayout> getList()
	{
		return layouts;
	}
	/**
	 * Seta a lista de teclados;
	 * @param List<KeyboardLayout> list
	 */
	public void setList(List<KeyboardLayout> list)
	{
		if (layouts == null)
		{
			layouts = new ArrayList<KeyboardLayout>();
		}
		this.layouts = list;
	}

}
