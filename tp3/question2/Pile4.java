package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Object element() {
            return this.element;
        }
        
        public Maillon suivant() {
            return this.suivant;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            throw new IllegalArgumentException("Taille is <= 0 !!");
        
        capacite = taille;
        nombre = 0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        
        Maillon newM = new Maillon(o, null);
        
        if (stk == null)
            stk = newM;
        else {
            Maillon current = stk;
            while (current.suivant != null)
                current = current.suivant;
            current.suivant = newM;
        }
        nombre++;
    }

    public Object depiler() throws PileVideException {
        Object res = null;
        if (estVide())
            throw new PileVideException();
        
        // ONLY ONE ELEMENT
        if (stk.suivant() == null) {
            res = stk.element();
            stk = null;
            nombre--;
            return res;
        }
        
        // MORE THAN ONE ELEMENT
        Maillon current = stk;
        Maillon previous = null;
        while (current.suivant() != null) {
            previous = current;
            current = current.suivant();
        }
        res = current.element();
        previous.suivant = null;
        nombre--;
        return res;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Maillon iter = stk;
        while (iter.suivant() != null)
            iter = iter.suivant();
        return iter.element();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return (stk == null) ? true : false;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return (capacite == nombre) ? true : false;
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        Object[] resArr = new Object[nombre];
        Maillon current = stk;
        
        int j = 0;
        while (current != null) {
            resArr[j++] = current.element;
            current = current.suivant;
        }
        
        String res = "[";
        j = resArr.length - 1;
        for (int i = j; i >= 0; i--) {
            res += resArr[i];
            if (i > 0)
                res += ", ";
        }
        return res + "]";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if( !(o instanceof Pile4) ) return false;
        
        Pile4 p1 = this;
        Pile4 p2 = (Pile4) o;
        
        if ( (p1.capacite() != p2.capacite()) || (p1.taille() != p2.taille()) )
            return false;

        try {
            System.out.println("Same length");
            while (!p1.estVide() && !p2.estVide()) {
                Object d1 = p1.depiler();
                Object d2 = p2.depiler();
                System.out.println(d1 + "  " + d2);
                if (!d1.equals(d2))
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int capacite() {
        return capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}