package auxi;

public class Node<E> {
  public E element;
  public Node<E> next;

  public Node(E element, Node<E> next) {
    this.element = element;
    this.next = next;
  }
  
}
