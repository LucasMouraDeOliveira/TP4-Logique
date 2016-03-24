package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

public class Constante extends Formule {
	
	protected boolean b;

	public Constante(boolean b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return b?"T":"⊥";
	}

	@Override
	public Set<String> variablesLibres() {
		return new HashSet<String>();
	}

	@Override
	public Formule substitue(Substitution s) {
		return this;
	}

	@Override
	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
