import java.util.Random;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
/**
 * The test class Maman15Tester.
 *
 * @author  Dan Peled
 * @version 2017a
 */
public class Maman15Tester
{
    /**
     * Default constructor for test class Maman15Tester
     */
    public Maman15Tester()
    {
    }
 
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
 
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
 
    @Test
    public void addToSetTest()
    {
        Set set1 = new Set();
        set1.addToSet(2);
        assertEquals(0, set1.numOfElements());
        set1.addToSet(1);
        set1.addToSet(3);
        set1.addToSet(5);
        set1.addToSet(5);
        set1.addToSet(5);
        set1.addToSet(5);
        set1.addToSet(5);
        set1.addToSet(5);
        assertEquals(3, set1.numOfElements());
        for(int i = 0; i < 101; i +=2)
            set1.addToSet(i);
        assertEquals(3, set1.numOfElements());
    }
 
    @Test
    public void equalsTest()
    {
        Set set2 = new Set();
        Set set3 = new Set();
        assertFalse(set3.equals(null));
        assertEquals(true, set3.equals(set2));
        set2.addToSet(1);
        set3.addToSet(3);
        assertEquals(false, set3.equals(set2));
        set2.addToSet(3);
        set3.addToSet(1);
        assertEquals(true, set3.equals(set2));
    }
 
    @Test
    public void subSetTest()
    {
        Set set1 = new Set();
        Set set2 = new Set();
        set2.addToSet(1);
        set2.addToSet(3);
        set2.addToSet(55);
        assertFalse(set1.subSet(null));
        assertEquals(true, set2.subSet(set1));
        set1.addToSet(87);
        assertEquals(false, set2.subSet(set1));
    }
 
    @Test
    public void isMemberTest()
    {
        Set set1 = new Set();
        set1.addToSet(87);
        set1.addToSet(65);
        set1.addToSet(2);
        set1.addToSet(47);
        assertEquals(true, set1.isMember(47));
        assertEquals(false, set1.isMember(2));
        for(int i=0; i<100; i++)
            set1.addToSet(i);
        Random rand = new Random();
        int num = rand.nextInt(100);
        assertEquals(num % 2 != 0, set1.isMember(num));
    }
 
    @Test
    public void removeFromSetTest()
    {
        Set set1 = new Set();
        for(int i=0; i<100; i++)
            set1.addToSet(i);
        set1.removeFromSet(5);
        set1.removeFromSet(85);
        set1.removeFromSet(85);
        assertEquals(48, set1.numOfElements());
        set1.removeFromSet(8);
        assertEquals(48, set1.numOfElements());
    }
 
    @Test
    public void isEmptyTest()
    {
        Set set1 = new Set();
        assertEquals(true, set1.isEmpty());
        set1.addToSet(1);
        assertEquals(false, set1.isEmpty());
        set1.removeFromSet(1);
        assertEquals(true, set1.isEmpty());
    }
 
    @Test
    public void unionTest()
    {
        Set set1 = new Set();
        Set set2 = new Set();
        Set res = new Set();
        set1.addToSet(1);
        set1.addToSet(3);
        set1.addToSet(5);
        set2.addToSet(7);
        set2.addToSet(9);
        set2.addToSet(11);
        res.addToSet(1);
        res.addToSet(3);
        res.addToSet(5);
        res.addToSet(7);
        res.addToSet(11);
        res.addToSet(9);
        assertEquals(null, set1.union(null));
        assertTrue(res.equals(set2.union(set1)));
        set2.addToSet(1);
        assertTrue(res.equals(set2.union(set1)));
    }
 
    @Test
    public void intersectionTest()
    {
        Set set1 = new Set();
        Set set2 = new Set();
        Set res = new Set();
        set1.addToSet(1);
        set1.addToSet(3);
        set1.addToSet(5);
        set1.addToSet(11);
        set1.addToSet(9);
        set1.addToSet(101);
        set2.addToSet(5);
        set2.addToSet(101);
        set2.addToSet(37);
        res.addToSet(5);
        res.addToSet(101);
        assertEquals(null, set1.intersection(null));
        Set inter = set1.intersection(set2);
        assertEquals(true, res.equals(inter));
        set1.addToSet(7);
        set2.addToSet(7);
        res.addToSet(7);
        inter = set2.intersection(set1);
        assertEquals(true, res.equals(inter));
    }
 
    @Test
    public void differenceTest()
    {
        Set set1 = new Set();
        Set set2 = new Set();
        Set res = new Set();
        set1.addToSet(1);
        set1.addToSet(3);
        set1.addToSet(5);
        set1.addToSet(11);
        set1.addToSet(9);
        set1.addToSet(101);
        set2.addToSet(5);
        set2.addToSet(101);
        set2.addToSet(37);
        res.addToSet(3);
        res.addToSet(11);
        res.addToSet(9);
        res.addToSet(1);
        assertEquals(null, set1.difference(null));
        assertTrue(res.equals(set1.difference(set2)));
        Set res2 = new Set();
        res2.addToSet(37);
        assertTrue(res2.equals(set2.difference(set1)));
    }
 
    @Test
    public void numOfElemntsTest()
    {
        Set set1 = new Set();
        assertEquals(0, set1.numOfElements());
        set1.addToSet(1);
        set1.addToSet(1);
        assertEquals(1, set1.numOfElements());
        set1.addToSet(57);
        set1.addToSet(65);
        assertEquals(3, set1.numOfElements());
        for(int i=0; i<100; i++)
            set1.addToSet(i);
        assertEquals(50, set1.numOfElements());
    }
 
    @Test
    public void toStringTest()
    {
        Set set1 = new Set();
        assertEquals("{}", set1.toString());
        IntNode p = null;
        for(int i = 1; i < 100; i += 2){
            set1.addToSet(i);
            p = new IntNode(i, p);
        }
        String toString = set1.toString();
        assertEquals('{', toString.charAt(0));
        assertEquals('}', toString.charAt(toString.length() - 1));
        toString = toString.substring(1, toString.length() - 1);
        String[] numbers = toString.split(",");
        for(String number : numbers){
            assertTrue(isLegal(number));
            int num = buildNum(number);
            assertTrue(isInList(p, num));
            if(p.getValue() == num)
                p = p.getNext();
            else{
                IntNode q = p;
                while(q.getNext() != null){
                    if(q.getNext().getValue() == num){
                        q.setNext(q.getNext().getNext());
                        break;
                    }
                    q = q.getNext();
                }
            }
        }
        assertEquals(null, p);
    }
 
    private static boolean isInList(IntNode list, int x)
    {
        IntNode p = list;
        while(p != null){
            if(p.getValue() == x)
                return true;
            p = p.getNext();
        }
        return false;
    }
 
    private static int getNumber(char c)
    {
        return (int)c - (int)'0';
    }
 
    private static boolean isLegal(String number)
    {
        if(hasSpace(number))
            return false;
        for(int i = 0; i < number.length(); i++)
            if(!isDigit(number.charAt(i)))
                return false;
        return true;
    }
 
    private static boolean hasSpace(String s)
    {
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' ')
                return true;
        }
        return false;
    }
 
    private static boolean isDigit(char c)
    {
        return c >= '0' && c <= '9';
    }
 
    private static int buildNum(String number)
    {
        int num = 0;
        for(int i = 0; i < number.length(); i++){
            num *= 10;
            num += getNumber(number.charAt(i));
        }
        return num;
    }
}