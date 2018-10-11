import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<E> implements Liste<E>
{
	 // In diesem Array sind die Referenzen auf die enthaltenen Items abgelegt.
    // Die Laenge des Arrays entspricht der Kapazitaet der Liste und muss daher
    // nicht separat gespeichert werden.
    private E[] _itemArray;
    // Die Kardinalitaet der Liste.
    private int _anzahlItems;
    private int _kapazitaet;
    // Die Anfangskapazitaet einer neuen Liste.
    private static final int ANFANGSKAPAZITAET = 10;
    
	public ArrayList()
    {
		
        this(ANFANGSKAPAZITAET);
    }
    /**
     * Initialisiert eine neue <code>ArrayListe</code>.
     * @Param anfangskapazitaet die Startkapazitaet der Liste.
     */
    
	public ArrayList(int anfangskapazitaet)
    {
		initialisiereArray(anfangskapazitaet);
		_anzahlItems = 0;
    }

	@SuppressWarnings("unchecked")
	public void initialisiereArray(int kapazitaet) {
		_kapazitaet = kapazitaet;
		_itemArray = (E[]) new Object[_kapazitaet];
	}
	
	@Override
	public void fuegeEin(E e, int position)
	{
		darfNichtNullSein(e);
        mussGueltigeEinfuegepositionSein(position);
        if (gibLaenge() == _kapazitaet)
        {
            _kapazitaet *=2;
            _itemArray = Arrays.copyOf(_itemArray,_kapazitaet);
        }
        
        for (int i = gibLaenge()-1; i >= position;--i)
        {
        	_itemArray[i+1]=_itemArray[i];
        }
        
        _itemArray[position]= e;
        ++_anzahlItems;		
	}

	private void darfNichtNullSein(E e)
	{
		if (e == null)
        {
            throw new IllegalArgumentException("Die Item-Referenz darf nicht null sein.");
        }
		
	}
	
	private boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= gibLaenge());
    }
	
	private void mussGueltigeEinfuegepositionSein(int position)
	{
		if (!istGueltigeEinfuegeposition(position))
        {
            throw new IndexOutOfBoundsException(
                position + " ist keine gueltige Einfuegeposition");
        }
		
	}
	@Override
	public void entferne(int position)
	{
		mussGueltigePositionSein(position);
        if (!(position == gibLaenge()))
        {
            for (int i = position; i < gibLaenge()-1;++i)
            {
            	_itemArray[i]=_itemArray[i+1];
            }
        }
        _itemArray[gibLaenge()-1] = null;
        --_anzahlItems;
	}

	@Override
	public boolean enthaelt(E e)
	{
		darfNichtNullSein(e);
        for(Object item : _itemArray)
        {
            if (e.equals(item))
            {
                return true;
            }
        }
        return false;
	}

	@Override
	public E gibItem(int position)
	{
		mussGueltigePositionSein(position);
        return _itemArray[position];
	}

	private boolean istGueltigePosition(int position)
    {
        return (position >= 0) && (position < gibLaenge());
    }
	
	private void mussGueltigePositionSein(int position)
	{
		if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
        }
	}
	
	@Override
	public int gibLaenge()
	{
		return _anzahlItems;
	}

	@Override
	public void leere()
	{
		_anzahlItems = 0;
		initialisiereArray(ANFANGSKAPAZITAET);
	}

}
