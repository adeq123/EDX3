package LinkedList;

public class NodeDouble<E extends Comparable>{
    private E info;
    private NodeDouble<E> next;
    private NodeDouble<E> prev;
    
    public NodeDouble(){
	    this.next = null;
	    this.prev = null;
    }

    public NodeDouble(E info){
	    this.info = info;
	    this.next = null;
	    this.prev = null;
    }
    
    public E getInfo(){
	    return this.info;
    }
    
    public void setInfo(E info){
	    this.info = info;
    }
    
    public NodeDouble<E> getNext(){
	    return this.next;
    }

    public void setNext(NodeDouble<E> next){
	    this.next = next;
    }
    public NodeDouble<E> getPrev(){
	    return this.prev;
    }

    public void setPrev(NodeDouble<E> prev){
	    this.prev = prev;
    }
}
