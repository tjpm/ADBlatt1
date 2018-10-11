
public class LinkedList<E> implements Liste<E>
{
	
	private DoppellinkKnoten<E> _listenkopf;
	private DoppellinkKnoten<E> _listenende;
	private int _anzahlitems;
	
	public LinkedList()
	{
		_listenkopf = new DoppellinkKnoten<E>(null, null, _listenende);
		_listenende = new DoppellinkKnoten<E>(null, _listenkopf, null);
		_listenkopf.setzeNachfolger(_listenende);
		_anzahlitems = 0;
		
	}
	

	@Override
	public void fuegeEin(E e, int position)
	{
		darfNichtNullSein(e);
        mussGueltigeEinfuegepositionSein(position);
        
        DoppellinkKnoten<E> aktuellerKnoten = _listenkopf;
        if(position > (gibLaenge()/2))
        {
        	aktuellerKnoten = _listenende;
        	for (int i = gibLaenge()-1; i >= position;--i)
            {
                aktuellerKnoten = aktuellerKnoten.gibVorgaenger();
            }
        }
        else
        {
        	
            for (int i = 0; i <= position;++i)
            {
                aktuellerKnoten = aktuellerKnoten.gibNachfolger();
            }
        }
        DoppellinkKnoten<E> neuerKnoten = new DoppellinkKnoten<E>(e,aktuellerKnoten.gibVorgaenger(),aktuellerKnoten);
        neuerKnoten.gibVorgaenger().setzeNachfolger(neuerKnoten);
        neuerKnoten.gibNachfolger().setzeVorgaenger(neuerKnoten);
        ++_anzahlitems;
        
	}

	private void darfNichtNullSein(E e)
	{
		if (e == null)
        {
            throw new IllegalArgumentException("Die Item-Referenz darf nicht null sein.");
        }
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
        
        DoppellinkKnoten<E> aktuellerKnoten = _listenkopf;
        if(position > (gibLaenge()/2))
        {
        	aktuellerKnoten = _listenende;
        	for (int i = gibLaenge()-1; i >= position;--i)
            {
                aktuellerKnoten = aktuellerKnoten.gibVorgaenger();
            }
        }
        else
        {
            for (int i = 0; i <= position;++i)
            {
                aktuellerKnoten = aktuellerKnoten.gibNachfolger();
            }
        }
        aktuellerKnoten.gibNachfolger().setzeVorgaenger(aktuellerKnoten.gibVorgaenger());
        aktuellerKnoten.gibVorgaenger().setzeNachfolger(aktuellerKnoten.gibNachfolger());
        --_anzahlitems;
	}

	@Override
	public boolean enthaelt(E e)
	{
		darfNichtNullSein(e);
        DoppellinkKnoten<E> aktuellerKnoten = _listenkopf;
        for (int i = 0; i< gibLaenge();++i)
        {
            aktuellerKnoten = aktuellerKnoten.gibNachfolger();
            if (e.equals(aktuellerKnoten.gibItem()))
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

        DoppellinkKnoten<E> knoten = _listenkopf;
        for (int i = 0; i <= position; ++i)
        {
            knoten = knoten.gibNachfolger();
        }

        return knoten.gibItem();
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

	
	private boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= gibLaenge());
    }

	@Override
	public int gibLaenge()
	{
		return _anzahlitems;
	}

	@Override
	public void leere()
	{
		_listenkopf.setzeNachfolger(_listenende);
        _listenende.setzeVorgaenger(_listenkopf);
        _anzahlitems = 0;
		
	}

}
