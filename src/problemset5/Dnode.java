package problemset5;

/*
 * For Exercise 1
 * Code from slides
 */
/*******************************************************
 * Ein Knoten (Dnode) hat ein Object als Inhalt und (zwei Verweise auf) weitere Dnode Knoten. Damit
 * kann man doppelt verkettete Listen erzeugen.
 ******************************************************/
class Dnode {
  private Object content; // sollen aussen nicht
  private Dnode linkA, linkB; // bekannt sein

  public Dnode(Object o) { // Konstruktor, Inhalt wird uebergeben
    content = o; // lege Inhalt ab
    linkA = linkB = null; // trage leere Verweise ein
  }

  public Object getContent() { // Schnittstelle fuer Herausgabe
    return content; // des Inhalts
  }

  public Dnode getSingle() { // gibt Verbindung != null
    return getNext(null); // heraus
  }

  public Dnode getNext(Dnode dn) { // gibt Verbindung != dn
    if (linkA == dn)
      return linkB; // heraus
    else
      return linkA;
  }

  public void connect(Dnode dn) { // muss zum Verbinden mit dn
    if (linkA == null)
      linkA = dn; // mindestens einen
    else
      linkB = dn; // link == null haben
  }

  public void disconnect(Dnode dn) { // Dnode muss zum Loesen
    if (linkA == dn)
      linkA = null; // von dn einen
    else
      linkB = null; // link == dn haben
  }
}// class Dnode
