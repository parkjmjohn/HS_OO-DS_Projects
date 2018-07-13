import java.util.*;

public class MyLinkedList <T> implements Iterable <T> {
    private LNode head;
    private LNode last;
    private int size;

    //Mr. K's implemented LNODE
    private class LNode {
	//instance variables
        public LNode next;
        public T value;

        public LNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public LNode getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(LNode next) {
            this.next = next;
        }
    }

    public boolean add(T value){
	return this.add(size, value);        
   }
    
    //K's
    public String toString(){
        String ans = "[";
        LNode p = head;
        while(p != null){
            ans += p.getValue();
            if(p.getNext()!= null){
                ans+=", ";
            }
            p = p.getNext();
        }
        return ans+ "]";
    }

    public int size(){
        return size;
    }

    //Added IndexOutOfBoundsException
    public T get(int index){
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LNode p = head;
        for(int i = 0; i < index; i++) {
            p = p.getNext();
	}
        return p.getValue();
    }

    //Added IndexOutOfBoundsException
    public T set(int index, T newValue){
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LNode p = head;
	T a = get(index);
        for(int i = 0; i < index; i++) {
            p = p.getNext();
        }
        p.setValue(newValue);
        return a;
    }

    //Added IndexOutOfBoundsException
    public T remove(int index){
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }
        T newp;
        if(index == 0) {
            newp = head.getValue();
            head = head.getNext();
        }else{
            LNode p = head;
            for(int i = 0; i+1<index; i++){
		p = p.getNext();
	    }
            if(index+1 == size) {
                last = p;
            }
            newp = p.getNext().getValue();
            p.setNext(p.getNext().getNext());
        }
        size--;
        return newp;
    }

    //Added IndexOutOfBoundsException
    public boolean add(int index, T value){
	if(index<0||index>size){
	    throw(new IndexOutOfBoundsException());
	}else if(index == size){
	    add(value);
	    return true;
	}else if(index == 0){
	    LNode p = new LNode(value);
	    p.setNext(head);
	    head = p;
	    size++;
	    return true;
	}else{
	    LNode newp = head;
	    for(int i = index; i>1; i--){
		newp = newp.getNext();
	    }
	    LNode ensue = newp.getNext();
	    LNode indextwo = new LNode(value);
	    indextwo.setNext(ensue);
	    newp.setNext(indextwo);
	    size++;
	    return true;
	}
    }

    public int indexOf(T value){
        LNode p = head;
        for (int i  = 0; i<size; i++) {
            if(p.getValue().equals(value)) {
                return i;
            }
            p = p.getNext();
	}
        return -1;
    }


    //Extracted Iterators 
    public Iterator<T> iterator(){
        return new IteratorH();
    }

    private class IteratorH implements Iterator<T>{
        LNode next;
        public IteratorH() {
            next = head;
        }

        public boolean hasNext(){
            if(next==null) {
                return false;
            }else{
                return true;
            }
        }

        public void remove(){
	    throw new UnsupportedOperationException();
        }

        public T next(){
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = next.getValue();
            next = next.getNext();
            return value;
        }
    }


    //Charles Zhang's Aid
    public static double sumL(MyLinkedList<Double> data) {
        Double i;
        i = 0.0;
        Iterator<Double> d = data.iterator();
        while(d.hasNext()) {
            i+=d.next();
        }
        return i.doubleValue();
    }
}


// Mr. K's Code for later assignments use, just for possible efficiency 
//import java.util.*;
//public class MyLinkedList<T> implements Iterable<T>{
//  private class LNode{
//	private T value;
//	private LNode next;
//	public LNode(T v){
//	    value = v;
//	}
//	public T getValue(){
//	    return value;
//	}
//	public LNode getNext(){
//	    return next;
//	}
//	public T setValue(T v){
//	    T old = value;
//	    value = v;
//	    return old;
//	}
//	public void setNext(LNode n){
//	    next = n;
//	}
//	public String toString(){
//	    return value.toString();
//	}
//  }
//
//  LNode head;
//  LNode tail;
//  int size;
//  
//  public Iterator<T> iterator(){
//	//This uses an anonymous class! You don't need to know this.
//	return new Iterator<T>()
//	    {
//		private LNode current = head;
//
//		public boolean hasNext(){
//		    return current != null;
//		}
//		public T next(){
//		    if(!hasNext()){
//			throw new NoSuchElementException();
//		    }
//		    T value = current.getValue();
//		    current = current.getNext();
//		    return value;
//		}
//		public void remove(){
//		    throw new UnsupportedOperationException();
//		}
//	    };
//  } 
//public String toString(){
//	String ans = "[";
//	LNode p = head;
//	while(p!=null){
//	    ans += p.getValue();
//	    if(p.getNext()!=null){
//		ans += ", ";
//	    }
//	    p = p.getNext();
//	}
//	return ans+"]";
//  }
//  public String toString(boolean b){
    //	return toString()+" head: "+head +", tail: "+tail;
//    }
//  private LNode getNth(int index){
//	//check bounds before calling this method!
//	LNode temp = head;
//	while(index > 0){
//	    temp = temp.getNext();
//	    index --;
//	}
//	return temp;
//  }
//  public boolean add(T value){
//	if(head == null){
//	    head = new LNode(value);
//	    tail = head;
//	}else{
//	    tail.setNext(new LNode(value));
//	    tail = tail.getNext();
//	}
//	size++;
//	return true;
//  }
//  public T remove(int index){
//	if(index < 0 || index >= size()){
//	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
//	}
//	LNode temp;
//	if(index == 0){
//	    temp = head;
//	    head = head.getNext();
//	    size--;
//	    if(head == null){
//		tail = null;
//	    }
//	    return temp.getValue();
//	}else{
//	    LNode p = getNth(index-1);
//	    temp = p.getNext();
//	    if(tail == temp){
//		tail = p;
//	    }
//	    p.setNext(p.getNext().getNext());
//	    size --;
//	    return temp.getValue();
//	}
//  }
//  public boolean add(int index, T value){
//	if(index < 0 || index > size()){
//	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
//	}
//	LNode temp = new LNode(value); 
//	if(index == 0){
//	    temp.setNext(head);
//	    head = temp;
//	    if(size==0){
//		tail = head;
//	    }
//	}else{ 
//	    LNode p = getNth(index-1);
//	    temp.setNext(p.getNext());
//	    p.setNext(temp);
//	    if(tail.getNext() != null){
//		tail=tail.getNext();
//	    }
//	}
//	size++;
//	return true;
//  }
    
//  public int size(){
//	return size;
//  }
//  
//  public T get(int index){
//	if(index < 0 || index >= size()){
//	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
//	}
//	return getNth(index).getValue();
//  }
//
//  public T set(int index, T newValue){
//	if(index < 0 || index >= size()){
//	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
//	}
//	return getNth(index).setValue(newValue);
//  }
//
//  public int indexOf(T target){
//	LNode temp = head;
//	int index = 0;
//	while(temp != null){
//	    if(temp.getValue().equals(target)){
//		return index;
//	    }
//	    index++;
//	    temp = temp.getNext();
//	}
//	return -1;
//	//    }
    //}
