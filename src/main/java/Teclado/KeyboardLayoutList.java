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

	public void add(KeyboardLayout p)
	{
		if (layouts == null)
		{
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(p);
	}

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

	public List<KeyboardLayout> getList()
	{
		return layouts;
	}

	public void setList(List<KeyboardLayout> list)
	{
		if (layouts == null)
		{
			layouts = new ArrayList<KeyboardLayout>();
		}
		this.layouts = list;
	}

}
