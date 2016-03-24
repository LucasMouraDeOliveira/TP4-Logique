package logicline.modeleSemantique;

public class NotFNCException extends Exception 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 276399348805476175L;

	public NotFNCException() 
    {
		super("La formule n'est pas en FNC ");
    }
    
    public NotFNCException(Formule f) 
    {
		super("La formule n'est pas en FNC : " + f.toString());
    }
}