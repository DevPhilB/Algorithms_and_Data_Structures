package problemset5;

/*
 * For Exercise 1
 * Code from slides
 */
public interface IntList {
  public boolean empty(); // leer?

  public void first(); // erstes Element wird aktuell

  public void last(); // letztes Element wird aktuell

  public boolean hasCurrent(); // aktuelles Element bekannt?

  public int get(); // liefert aktuelles Element

  public void insert(int i); // nach aktuellem El. einfuegen

  public boolean search(int i); // Suchen nach i

  public boolean setPos(int p); // setze aktuelle Position auf p

  public boolean insert(int i, int p); // als p-tes El. einfuegen

  public boolean delete(int p); // p-tes Element loeschen

  public void remove(); // aktuelles Element loeschen

  public void print(); // Ausgabe aller Elemente
}
