package question2;

/**
 * Classe-test Pile4Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile4Test extends junit.framework.TestCase {
    private question2.Pile4 pile41;
    private question2.Pile4 pile42;
    private question2.Pile4 pile43;


    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        pile41 = new question2.Pile4();
        pile42 = new question2.Pile4();
        pile43 = new question2.Pile4(24);
    }

    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, pile41.capacite());
    }

    public void test_Pile_estPleine() throws Exception {
        Pile4 p = new question2.Pile4(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        Pile4 p = new question2.Pile4(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile_estVide() throws Exception {
        Pile4 p = new question2.Pile4(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        Pile4 pile1 = new question2.Pile4(3);
        assertEquals("toString incorrect (1)? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect (2)? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect (3)? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect (4)? ", "[3, 5, 4]", pile1.toString());
    }

    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile4(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());
    }

    public void test_Pile_equals() throws Exception {
        pile41.empiler(3);
        pile41.empiler(2);
        pile41.empiler(1);

        pile42.empiler(3);
        pile42.empiler(2);
        pile42.empiler(1);

        assertTrue("égalité de deux piles (1)? ", pile41.equals(pile42));
        assertTrue("égalité de deux piles (2)? ", pile42.equals(pile41));
        assertTrue("égalité de deux piles (3)? ", pile41.equals(pile41));

        pile42.empiler(1);
        assertFalse("égalité de deux piles (4)? ", pile41.equals(pile42));
    }
}
