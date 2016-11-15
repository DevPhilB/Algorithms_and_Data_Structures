package problemset5;

/*
 * For Exercise 1
 * Code from slides
 */
class IntNode { // die Knotenklasse
  private int content; // Inhalt
  private IntNode next; // Nachfolger

  public IntNode(int i, IntNode n) { // Konstruktor
    content = i; // setzt Inhalt
    next = n; // und Nachfolger
  }

  public int getContent() { // gibt Inhalt raus
    return content;
  }

  public void setContent(int i) { // setzt Inhalt
    content = i;
  }

  public IntNode getNext() { // gibt Nachfolger raus
    return next;
  }

  public void setNext(IntNode n) { // setzt Nachfolger
    next = n;
  }
}
