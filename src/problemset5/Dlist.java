package problemset5;

/*
 * For Exercise 1
 * Code from slides
 */
class Dlist {
  private Dnode head, tail; // Anfang, Ende der Liste

  public Dlist() { // Konstruktor,
    head = tail = null; // erzeugt leere Liste
  }

  public boolean empty() { // leer, falls head == null,
    return head == null; // (dann auch tail == null)
  }

  public Dlist pushHead(Object o) { // Einfuegen am Kopf
    Dnode h = head; // das alte head
    head = new Dnode(o); // das neue head mit Inhalt
    if (tail == null) { // falls Dlist vorher leer
      tail = head; // jetzt 1 Knoten
    } else { // sonst:
      head.connect(h); // verbinde head mit h
      h.connect(head); // und umgekehrt
    }
    return this; // erlaubt Kaskadieren
  }

  public Dlist pushTail(Object o) { // wird mithilfe von reverse ()
    reverse().pushHead(o); // auf pushHead() reduziert
    return reverse(); // erlaubt Kaskadieren
  }

  public Object popHead() { // Entfernen am Kopf
    Dnode h = head; // zu loeschendes El.
    head = head.getSingle(); // head auf naechtes El.
    if (head == null) { // wenn Dlist leer
      tail = null;
    } else {
      head.disconnect(h); // Verbindung loesen
    }
    return h.getContent(); // Rueckgabewert
  }

  public Object popTail() { // wird mithilfe von reverse ()
    Object o = reverse().popHead(); // auf popHead() reduziert
    reverse();
    return o;
  }

  public Dlist concat(Dlist dl) { // hinter this haenge dl
    if (dl.head != null) { // falls dl nicht leer
      if (head == null) { // falls this leer:
        head = dl.head; // head kopieren
      } else { // sonst:
        tail.connect(dl.head); // verbinden
        dl.head.connect(tail);
      }
      tail = dl.tail; // neues Listenende
    } // sonst: fertig
    return this; // erlaubt Kaskadieren
  }

  public Dlist reverse() { // Invertieren durch
    Dnode h = head; // Vertauschen von
    head = tail; // head und tail
    tail = h;
    return this; // erlaubt Kaskadieren
  }
}// class Dlist
