package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;
import java.util.ListIterator;
import java.util.Arrays;

public class Pile2 implements PileI {
    // par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    // la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille > 0) {
            capacite = taille;
            stk = new Stack<Object>();
            stk.ensureCapacity(taille);
        } else
            throw new IllegalArgumentException("Taille est <= 0 !!!");
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        else
            stk.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        else
            return stk.pop();
    }

    public Object sommet() throws PileVideException {
       if (estVide())
           throw new PileVideException();
       else
           return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return (capacite() == taille()) ? true : false;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String res = "[";
        ListIterator it = stk.listIterator(stk.size());
        while(it.hasPrevious()) {
            res += it.previous();
            if (it.hasPrevious())
                res += ", ";
        }
        return res + "]";
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

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return capacite;
    }
} // Pile2.java