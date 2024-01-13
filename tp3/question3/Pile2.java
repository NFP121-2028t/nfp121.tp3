package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;
    
    
    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)
            throw new IllegalArgumentException("Taille est <= 0 !!");
        
        capacite = taille;
        stk = new Stack<T>();
        stk.ensureCapacity(capacite);
    }

    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk.add(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
       if (estVide())
           throw new PileVideException();
       return stk.peek();
    }
    
    
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile
    public int capacite() {
        return capacite;
    }
    
    public int taille() {
        return stk.size();
    }
    
    public boolean estVide() {
        return stk.isEmpty();
    }
    
    public boolean estPleine() {
        return (capacite() == taille()) ? true : false;
    }
    
    public boolean equals(Object o) {
        Pile2 p1 = this;
        Pile2 p2 = (Pile2) o;
        try {
            if (p1.capacite() == p2.capacite() && p1.taille() == p2.taille()) {
                while (!p1.estVide() && !p2.estVide()) {
                    Object d1 = p1.depiler();
                    Object d2 = p2.depiler();
                    if (!d1.equals(d2))
                        return false;
                }
            } else {
                return false;
            }
            return true;
        } catch(Exception e) { }
        return false;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    public String toString() {
        return stk.toString();
    }
    
} // Pile2