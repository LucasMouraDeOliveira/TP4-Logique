package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

public class Equivalence extends Formule {
	
	protected Formule gauche, droite;

	public Equivalence(Formule fg, Formule fd) {
		gauche = fg;
		droite = fd;
	}

	@Override
	public String toString() {
		return "("+gauche.toString()+"⇔"+droite.toString()+")";
	}

	@Override
	public Set<String> variablesLibres() {
		Set<String> set = new HashSet<String>();
		set.addAll(gauche.variablesLibres());
		set.addAll(droite.variablesLibres());
		return set;
	}

	@Override
	public Formule substitue(Substitution s) {
		return new Equivalence(gauche.substitue(s), droite.substitue(s));
	}
	
	@Override
	protected Formule supprImplications(){
		return new Et(new Ou(new Non(gauche), droite), new Ou(gauche, new Non(droite)));
	}

	@Override
	public boolean valeur() throws VariableLibreException {
		return false;
	}

}
