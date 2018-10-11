import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayListTest
{
	private Integer[] _testObjekte;

    public ArrayListTest()
    {
        _testObjekte = new Integer[10000];
        
        for (int i = 0; i < 10000; i++)
        {
            Integer o = new Integer(i);
            _testObjekte[i] = o;
        }
    }
    
    /**
     * Erzeugt eine neue TitelListe.
     * 
     * @return Eine leere Liste.
     */
    public Liste<Integer> erzeugeListe()
    {
        return new ArrayList<Integer>();
    }    
    /**
     * Testet die Methode enthaelt(String) der Liste.
     */
    @Test
    public void testeEnthaelt()
    {
        Liste<Integer> liste = erzeugeListe();
        for (int i = 0; i < 10; i++)
        {
        	liste.fuegeEin(_testObjekte[i], liste.gibLaenge());
        }

        assertTrue("Liste soll das Test-Object 0 enthalten", liste
                .enthaelt(_testObjekte[0]));
        assertTrue("Liste soll das Test-Object 2 enthalten", liste
                .enthaelt(_testObjekte[2]));
        assertTrue("Liste soll das Test-Object 9 enthalten", liste
                .enthaelt(_testObjekte[9]));

        Integer wrongObject = new Integer(123456);
        assertFalse(
                "Liste darf nicht das Object '123456' enthalten",
                liste.enthaelt(wrongObject));
    }
    
    /**
     * Testet die Methode gibLaenge der Liste.
     */
    @Test
    public void testeGibLaenge()
    {
        Liste<Integer> liste = erzeugeListe();
        assertEquals(0, liste.gibLaenge());

        for (int i = 0; i < 10; i++)
        {
        	liste.fuegeEin(_testObjekte[i], liste.gibLaenge());
            assertEquals(i + 1, liste.gibLaenge());
        }

        assertEquals(10, liste.gibLaenge());
    }
    
    /**
     * Testet die Methode fuegeEin(Titel, int) der Liste. Dabei wird getestet,
     * ob sich Elemente mittig in die Liste einfuegen lassen.
     */
    @Test
    public void testeFuegeEin()
    {
    	long anfang = 0;
    	long zufall = 0;
    	long ende = 0;
    	
    	for (int p = 0; p < 10; ++p) {
    		
    	
	    	Liste<Integer> liste = erzeugeListe();
	    	long time = System.currentTimeMillis();
	        for (int i = 0; i < 10000; i++)
	        {
	            liste.fuegeEin(_testObjekte[i], 0);
	        }
	        
	        time = System.currentTimeMillis() - time;
	        anfang += time;
	        liste.leere();
	        time = System.currentTimeMillis();
	        for (int i = 0; i < 10000; i++)
	        {
	        	int  n = (int) (Math.random() * liste.gibLaenge());
	        	liste.fuegeEin(_testObjekte[i], n);
	        }
	        
	        time = System.currentTimeMillis() - time;
	        zufall += time;
	        liste.leere();
	        time = System.currentTimeMillis();
	        
	        
	        for (int i = 0; i < 10000; i++)
	        {
	        	liste.fuegeEin(_testObjekte[i], liste.gibLaenge());
	        }
	        
	        time = System.currentTimeMillis() - time;
	        ende += time;        
    	}
    	System.out.println("ArrayList Zeit am Anfang einfügen: " + anfang/10 + " Millisekunden");
    	System.out.println("ArrayList Zeit zufällig einfügen: " + zufall/10 + " Millisekunden");
    	System.out.println("ArrayList Zeit am Ende einfügen: " + ende/10 + " Millisekunden");
    	System.out.println();
    }
    
    /**
     * Testet die Methode fuegeEin(Titel, int) der Liste. Dabei wird getestet,
     * ob sich Elemente mittig in die Liste einfuegen lassen.
     */
    @Test
    public void testeLoesche()
    {
    	long anfang = 0;
    	long zufall = 0;
    	long ende = 0;
    	
    	for (int p = 0; p < 10; ++p) {
    		
	    	Liste<Integer> liste = erzeugeListe();
	        for (int i = 0; i < 10000; i++)
	        {
	            liste.fuegeEin(_testObjekte[i], 0);
	        }
	        long time = System.currentTimeMillis();
	        for (int i = 0; i < 1000; i++)
	        {
	            liste.entferne(i);
	        }
	        time = System.currentTimeMillis() - time;
	        anfang += time;
	        liste.leere();
	        for (int i = 0; i < 10000; i++)
	        {
	            liste.fuegeEin(_testObjekte[i], 0);
	        }
	        time = System.currentTimeMillis();
	        for (int i = 0; i < 1000; i++)
	        {
	        	int  n = (int) (Math.random() * liste.gibLaenge());
	        	liste.entferne(n);
	        }
	        
	        time = System.currentTimeMillis() - time;
	        zufall += time;
	        liste.leere();
	        for (int i = 0; i < 10000; i++)
	        {
	            liste.fuegeEin(_testObjekte[i], 0);
	        }
	        time = System.currentTimeMillis();
	        
	        
	        for (int i = 9999; i > 8999; i--)
	        {
	        	liste.entferne(i);
	        }
	        
	        time = System.currentTimeMillis() - time;
	        ende += time;
    	}

    	System.out.println("ArrayList Zeit am Anfang löschen: " + anfang/10 + " Millisekunden");
    	System.out.println("ArrayList Zeit zufällig löschen: " + zufall/10 + " Millisekunden");
    	System.out.println("ArrayList Zeit am Ende löschen: " + ende/10 + " Millisekunden");
    	System.out.println();
    }
    
}
