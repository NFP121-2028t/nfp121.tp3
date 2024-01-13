package question1;

/**
 * Décrivez votre classe PilePleineException ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

public class PileVideException extends Exception {
    public PileVideException(String e) { super(e); }
    public PileVideException() { super("Pile est vide!!"); }
}