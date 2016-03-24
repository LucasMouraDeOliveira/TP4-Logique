package logicline.modeleSemantique;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Substitution {
	
	private Map<String, Formule> substitutions;
	
	public Substitution() {
		substitutions = new TreeMap<String, Formule>();
	}

	public Substitution(Substitution s)	{
		substitutions = new TreeMap<String, Formule>(s.substitutions);
	}

	@Override
	public String toString() {
		if (substitutions.isEmpty())
			return "[]";
		Iterator<Entry<String,Formule>> it = substitutions.entrySet().iterator();
		Map.Entry<String,Formule> pairs = it.next();
		String s = "[" + pairs.getKey() + " ← " + (pairs.getValue()).toString();
	    while(it.hasNext())
	    {
	    	pairs = it.next();
	    	s += ", " + pairs.getKey() + " ← " + (pairs.getValue()).toString();
	    }
		return s + "]";
	}

	public String ligneTable() {
		Iterator<Entry<String,Formule>> it = substitutions.entrySet().iterator();
		String s = "";
	    while(it.hasNext())
	    {
			Map.Entry<String,Formule> pairs = it.next();
			s += (pairs.getValue()).toString() + "\t|";
		}
		return s;
	}

	public void set(String v, Formule f) {
		substitutions.put(new String(v), f);
	}

	public Formule get(String v) {
		return substitutions.get(v);
	}

	public boolean isEmpty() {
		return substitutions.isEmpty();
	}

}