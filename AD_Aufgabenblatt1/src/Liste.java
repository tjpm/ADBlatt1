
public interface Liste<E>
{
	/**
     * Fuege einen Item an der Position <code>position</code> in die Itemliste
     * ein. Alle folgenden Eintraege werden um eine Indexposition verschoben.
     * Wenn <code>position</code> gleich der Laenge der Itemliste ist, dann
     * fuege das <code>Item</code> am Ende an.
     * 
     * @param Item
     *              Ein Item.
     * @param position
     *              Die Positon des Items. Der gueltige Bereich ist von 0 bis gibLaenge()-1.
     */
    public void fuegeEin(E e, int position);

    /**
     * Entferne das Item an der angegebenen Position. Alle folgenden Eintraege
     * werden um eine Indexposition verschoben.<br>
     * 
     * @param position
     *              Eine Position in der Liste. Der gueltige Bereich ist von 0 bis gibLaenge()-1.
     */
    public void entferne(int position);

    /**
     * Pruefe, ob ein Item in der Liste enthalten ist.
     * 
     * @param e
     *            Ein Item.
     * @return Liefert <code>true</code> wenn das Item in der Liste ist,
     *         ansonsten <code>false</code>.
     */
    public boolean enthaelt(E e);

    /**
     * Gib das Item an der angegebenen Position zurueck.
     * 
     * @param position
     *              Die Position des Items, das zurueckgeben werden soll.
     *              Der gueltige Bereich ist von 0 bis gibLaenge()-1.
     * @return Das Item auf der Position <code>position</code>.
     */
    public E gibItem(int position);

    /**
     * Gib die Laenge der Liste zurueck.
     * 
     * @return Anzahl der Items in der Liste.
     */
    public int gibLaenge();

    /**
     * Entferne alle Items aus der Liste.
     */
    public void leere();
}
