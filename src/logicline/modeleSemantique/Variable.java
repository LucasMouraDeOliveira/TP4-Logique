package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

public class Variable extends Formule {

	protected String v;

	public Variable(String v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return v;
	}

	@Override
	public Set<String> variablesLibres() {
		Set<String> set = new HashSet<String>();
		set.add(v);
		return set;
	}

	@Override
	public Formule substitue(Substitution s) {
		return (s.get(v) != null)?s.get(v):this;
	}

	@Override
	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

	protected Formule negation() { 
		return new Non(this);
	}

	//déplace les non à l'intérieur des formules
	protected Formule entrerNegations() { 
		return negation();
	}
}
