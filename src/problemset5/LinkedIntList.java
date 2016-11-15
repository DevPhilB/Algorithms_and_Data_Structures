package problemset5;

/*
 * For Exercise 1
 * Code from slides
 */
class LinkedIntList implements IntList {
  @SuppressWarnings("unused")
  private IntNode head, predecessor, current;

  public LinkedIntList() { // Konstruktor
    head = predecessor = current = null;
  }

  public boolean empty() { // leer?
    return head == null;
  }

  public void first() { // erstes Element
    current = head; // wird aktuell
    predecessor = null;
  }

  @Override
  public void last() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean hasCurrent() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int get() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void insert(int i) {
    // TODO Auto-generated method stub
  }

  @Override
  public boolean search(int i) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean setPos(int p) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean insert(int i, int p) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean delete(int p) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void remove() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void print() {
    // TODO Auto-generated method stub
  }
}
// ...
