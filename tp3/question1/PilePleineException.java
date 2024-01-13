package question1;

/**
 * Décrivez votre classe PilePleineException ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

public class PilePleineException extends Exception {
    public PilePleineException(String e) { super(e); }
    public PilePleineException() { super("Pile est pleine!!"); }
}