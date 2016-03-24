package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

public class Implique extends Formule {

	protected Formule gauche, droite;

	public Implique(Formule fg, Formule fd) {
		gauche = fg;
		droite = fd;
	}

	@Override
	public String toString() {
		return "("+gauche.toString()+"⇒"+droite.toString()+")";
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
		return new Implique(gauche.substitue(s), droite.substitue(s));
	}
	
	@Override
	protected Formule supprImplications(){
		return new Ou(new Non(gauche), droite);
	}

	@Override
	public boolean valeur() throws VariableLibreException {
		//TODO Auto-generated method stub
		return false;
	}
	
}
