
public class DoppellinkKnoten<E>
{

    // Der vorherige Knoten
    private DoppellinkKnoten<E> _vorgaenger;

    // Der nachfolgende Knoten
    private DoppellinkKnoten<E> _nachfolger;

    // Das Element des Knotens, ein Item
    private E _element;

    /**
     * Erzeuge einen neuen Knoten ohne Element und Verkettungsinformationen.
     */
    public DoppellinkKnoten()
    {
    }

    /**
     * Erzeuge einen neuen Knoten und setze gleich Vorgaenger, Nachfolger und
     * Element.
     * 
     * @param element
     *            Das Element, das der Knoten tragen soll
     * @param vorgaenger
     *            Der vorherige Knoten
     * @param nachfolger
     *            Der naechste Knoten
     */
    public DoppellinkKnoten(E element, DoppellinkKnoten<E> vorgaenger,
            DoppellinkKnoten<E> nachfolger) {
   
        _element = element;
        _vorgaenger = vorgaenger;
        _nachfolger = nachfolger;
    }

    /**
     * Gib den nachfolgenden Knoten zurueck.
     * 
     * @return den Nachfolgerknoten
     */
	public DoppellinkKnoten<E> gibNachfolger()
    {
        return _nachfolger;
    }

    /**
     * Setze den nachfolgenden Knoten.
     * 
     * @param nachfolger
     *            der Nachfolgerknoten.
     */
    public void setzeNachfolger(DoppellinkKnoten<E> nachfolger)
    {
    	_nachfolger = nachfolger;
    }

    /**
     * Gib den vorherigen Knoten zurueck.
     * 
     * @return den Vorgaenger dieses Knotens
     */
	public DoppellinkKnoten<E> gibVorgaenger()
    {
    	
        return _vorgaenger;
    }

    /**
     * Setze den Vorgaenger dieses Knotens.
     * 
     * @param vorgaenger
     *            der Vorgaengerknoten.
     */
    public void setzeVorgaenger(DoppellinkKnoten<E> vorgaenger)
    {
    	_vorgaenger = vorgaenger;
    }

    /**
     * Gib das (Daten-)Element dieses Knotens.
     * 
     * @return das gespeicherte Item dieses Knotens.
     */
    public E gibItem()
    {
        return _element;
    }

    /**
     * Setze das (Daten-)Element dieses Knotens.
     * 
     * @param element
     *            Ein Item.
     */
    public void setzeItem(E element)
    {
        _element = element;
    }
    

}
