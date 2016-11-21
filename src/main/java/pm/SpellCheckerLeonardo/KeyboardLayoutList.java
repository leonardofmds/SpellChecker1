package pm.SpellCheckerLeonardo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pm.SpellCheckerLeonardo.*;;

public class KeyboardLayoutList {
	
	private List<KeyboardLayout> layouts;

	public KeyboardLayoutList() {

	}

	public void add(KeyboardLayout p) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(p);
	}

	public KeyboardLayout getLayoutByName(String string) {
		return null;
	}

	public List<KeyboardLayout> getList() {
		return layouts;
	}

	public void setList(List<KeyboardLayout> list) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		this.layouts = list;
	}

	public Iterator<KeyboardLayout> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "\n";
				
		for (KeyboardLayout keyboardLayout : layouts) 
		{
			s+= keyboardLayout.toString();
		}
		
		
		return s;
	}

}