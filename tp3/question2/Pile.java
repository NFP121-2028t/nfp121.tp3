package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Arrays;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    
    private Object[] zone;
    private int ptr;
    
    public Pile(int taille) {
        if (taille > 0) {
            zone = new Object[taille];  ptr = -1;
        } else {
            throw new IllegalArgumentException("Taille est <= 0 !!");
        }
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException("Pile est pleine!");
        else
            zone[++ptr] = o;
    }

    public Object depiler() throws PileVideException {        
        if (estVide())
            throw new PileVideException("Pile est vide!");
        else {
            Object res = null;
            res = zone[ptr];
            zone[ptr--] = null;
            return res;
        }
        
    }

    public Object sommet() throws PileVideException {
        if(estVide()) throw new PileVideException("Pile est vide!!");
        return zone[ptr];
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        return ptr+1;
    }

    public boolean estVide() {
        return (ptr == -1) ? true : false;
    }

    public boolean estPleine() {
        return (taille() == capacite()) ? true : false;
    }

    public boolean equals(Object o) {
        Pile p1 = this, p2 = (Pile) o;
        if (p1.taille() == p2.taille())
            if(p1.capacite() == p2.capacite())
                if(Arrays.deepEquals(p1.zone, p2.zone))
                    return true;
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String res = "[";
        for (int i = ptr; i >= 0; i--) {
            res += zone[i];
            if (i > 0)
                res += ", ";
        }
        return res + "]";
    }
}