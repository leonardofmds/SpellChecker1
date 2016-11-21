package pm.SpellCheckerLeonardo;

import java.util.ArrayList;
import java.util.Iterator;

import pm.SpellCheckerLeonardo.*;

public class KeyboardLayout implements Iterable{
	
	private String model;
	private ArrayList<Line> lines;
	
	public KeyboardLayout()
	{
		lines = new ArrayList<Line>();
	}

	public void prepareDistances() {
		// TODO Auto-generated method stub
		
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
	public void addLine(Line line)
	{
		lines.add(line);
	}

	public double getNominalDistance(char c, char d) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getInsertDeleteDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMaximumDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
