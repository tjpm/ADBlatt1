import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackrechnerTest
{
	/**
     * Testet die Addition des Stackrechners.
     */
    @Test
    public void testeAddition()
    {
    	assertEquals(Stackrechner.rechne("(34+86)"), 120);
    	assertEquals(Stackrechner.rechne("(0+0)"), 0);
    	assertEquals(Stackrechner.rechne("(1000000+1000000)"), 2000000);
    	assertEquals(Stackrechner.rechne("(0+9999999)"), 9999999);
    	assertEquals(Stackrechner.rechne("(555555+0)"), 555555);
    	assertEquals(Stackrechner.rechne("(((555555+(0+5))+10)"), 555570);
    }
    
    /**
     * Testet die Subtraktion des Stackrechners.
     */
    @Test
    public void testeSubtraktion()
    {
    	assertEquals(Stackrechner.rechne("(34-86)"), -52);
    	assertEquals(Stackrechner.rechne("(0-0)"), 0);
    	assertEquals(Stackrechner.rechne("(1000000-999999)"), 1);
    	assertEquals(Stackrechner.rechne("(4644-454)"), 4190);
    	assertEquals(Stackrechner.rechne("(454-4644)"), -4190);
    	assertEquals(Stackrechner.rechne("(((555555-(0-5))-10)"), 555550);
    }
    
    /**
     * Testet die Multiplikation des Stackrechners.
     */
    @Test
    public void testeMultiplikation()
    {
    	assertEquals(Stackrechner.rechne("(34*86)"), 2924);
    	assertEquals(Stackrechner.rechne("(0*0)"), 0);
    	assertEquals(Stackrechner.rechne("(000*86)"), 0);
    	assertEquals(Stackrechner.rechne("(34*0)"), 0);
    	assertEquals(Stackrechner.rechne("(((555555*(1*5))*10)"), 27777750);
    }
    
    /**
     * Testet die Division des Stackrechners.
     */
    @Test
    public void testeDivision()
    {
    	assertEquals(Stackrechner.rechne("(34/86)"), 0);
    	assertEquals(Stackrechner.rechne("(20/5)"), 4);
    	assertEquals(Stackrechner.rechne("(0/5)"), 0);
    	assertEquals(Stackrechner.rechne("(20000000/89)"), 224719);
    	assertEquals(Stackrechner.rechne("(((555555/(5/1))/10)"), 11111);
    }
    
    /**
     * Testet die alle Operatoren zusammen des Stackrechners.
     */
    @Test
    public void testeAlles()
    {
    	assertEquals(Stackrechner.rechne("(((((555555/(5*2))/10)+89)-5)"), 5639);
    	assertEquals(Stackrechner.rechne("(((((6484*(5-2))/3)*33)-5954)"), 208018);
    	assertEquals(Stackrechner.rechne("(((((2135-(5+194))*910)/74)+64645)"), 88452);
    }
}
