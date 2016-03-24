package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

public class Et extends Formule{

	protected Formule gauche, droite;

	public Et(Formule fg, Formule fd) {
		gauche = fg;
		droite = fd;
	}

	@Override
	public String toString() {
		return "("+gauche.toString()+"∧"+droite.toString()+")";
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
		return new Et(gauche.substitue(s), droite.substitue(s));
	}

	@Override
	public boolean valeur() throws VariableLibreException {
		return gauche.valeur() && droite.valeur();
	}

	//Retourne la formule représentant la négation de this
	protected Formule negation() { 
		return new Ou(new Non(gauche), new Non(droite));
	}

	//déplace les non à l'intérieur des formules
	protected Formule entrerNegations() { 
		return new Ou((gauche.entrerNegations()), droite.entrerNegations());
	}

	//Retourne vrai si la formule contient un Et
	protected boolean contientEt() { 
		return true;
	}

}
