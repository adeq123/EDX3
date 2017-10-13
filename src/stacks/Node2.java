package stacks;

public class Node2<E> {
    private E info;
    private Node2<E> next;

    public Node2() {
        info = null;
        next = null;
    }

    public Node2(E info) {
        setInfo(info);
    }

    public Node2(E info, Node2<E> next) {
        setInfo(info);
        setNext(next);
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Node2<E> getNext() {
        return next;
    }

    public void setNext(Node2<E> next) {
        this.next = next;
    }
}

