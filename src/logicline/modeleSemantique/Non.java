package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

public class Non extends Formule {

	protected Formule formule;

	public Non(Formule formule) {
		this.formule = formule;
	}

	@Override
	public String toString() {
		return "¬("+formule.toString()+")";
	}

	@Override
	public Set<String> variablesLibres() {
		Set<String> set = new HashSet<String>();
		set.addAll(formule.variablesLibres());
		return set;
	}

	@Override
	public Formule substitue(Substitution s) {
		return new Non(formule.substitue(s));
	}

	@Override
	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

	protected Formule negation() { 
		return formule;
	}

	//déplace les non à l'intérieur des formules
	protected Formule entrerNegations() { 
		return formule.entrerNegations();
	}

	//Retourne vrai si la formule contient un Et
	protected boolean contientEt() { 
		return formule.contientEt();
	}

}