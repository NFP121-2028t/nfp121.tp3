package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;
import java.util.ListIterator;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {
    private Vector<Object> v;

    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        if (taille > 0)
            v = new Vector<Object>(taille);
        else
            throw new IllegalArgumentException("Taille is <= 0!!!");
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        else
            v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        else
            return v.remove(taille() - 1);
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        else
            return v.elementAt(taille() - 1);
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return (taille() == capacite()) ? true : false;
    }

    public String toString() {
        String res = "[";
        ListIterator it = v.listIterator(v.size());
        while(it.hasPrevious()) {
            res += it.previous();
            if (it.hasPrevious())
                res += ", ";
        }
        return res + "]";
    }

    public boolean equals(Object o) {
        Pile3 p1 = this;
        Pile3 p2 = (Pile3) o;
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
}