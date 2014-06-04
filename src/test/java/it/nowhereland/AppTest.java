package it.nowhereland;

import it.nowhereland.utils.Cons;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testIntContents() {
        Cons<Integer> ints = Cons.empty().cons(1).cons(2);
        assertTrue( ints.toString().equals("[2,[1,[]]]") );
    }

    public void testIntSize() {
        Cons<Integer> ints = Cons.empty().cons(1).cons(2);
        assertTrue( ints.size() == 2 );
    }

    public void testIterator() {
        Cons<Integer> ints = Cons.empty().cons(1).cons(2);
        int j = 2; 
        for (Integer i: ints) {
            assertTrue( i.equals(j) ); 
            j--;
        }
    }
}
