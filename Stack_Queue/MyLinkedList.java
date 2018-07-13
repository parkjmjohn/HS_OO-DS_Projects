//Mr. K's code with just doubly linked list implemented
import java.util.*;
public class MyLinkedList <T> implements Iterable<T>{
    private LNode head;
    private LNode last;
    private int size;
    private class LNode {
        public LNode next;
	public LNode prev;
        public T value;
        public LNode(T data) {
            value = data;
        }
        public T getValue() {
            return value;
        }
        public LNode getNext() {
            return next;
        }
	public LNode getPrevious() {
	    return prev;
	}
        public void setValue(T data) {
            value = data;
        }
        public void setNext(LNode data) {
            next = data;
        }
	public void setPrevious(LNode data) {
	    prev = data;
	}
    }
    public int size() {
        return size;
    }
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
    public T get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LNode current = head;
        int i = 0;
        while(i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }
    public T set(int index,T newValue) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LNode current = head;
        int i = 0;
        while(i < index) {
            current = current.getNext();
            i++;
        }
        T ret = current.getValue();
        current.setValue(newValue);
        return ret;
    }
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T ret;
        if (index == 0) {
            ret = head.getValue();
            head = head.getNext();
	    if(head == null) {
		last = null;
	    }
	    else{
		head.setPrevious(null);
	    }
        } else {
            LNode current = head;
            int i = 0;
            while (i + 1 < index) {
                current = current.getNext();
                i++;
            }
            if (index + 1== size) {
                last = current;
            }
            ret = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
	    if(current.getNext() != null) {
		current.getNext().setPrevious(current);
	    }
        }
        size--;
        return ret;
    }
    public boolean add(int index, T value) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        LNode temp = new LNode(value);
        if(index == size()) {
            return add(value);
        }
        if(index == 0) {
            temp.setNext(head);
	    if(head != null) {
		head.setPrevious(temp);
	    }
            head = temp;
            size++;
            return true;
        }
        LNode current = head;
        int i = 0;
        while(i + 1 < index) {
            current = current.getNext();
            i++;
        }
        temp.setNext(current.getNext());
	if(temp.getNext() != null) {
	    temp.getNext().setPrevious(temp);
	}
        current.setNext(temp);
	temp.setPrevious(current);
        size++;
        return true;
    }
    public boolean add(T value) {
        if(head == null) {
            head = new LNode(value);
            last = head;
        }
        else {
            last.setNext(new LNode(value));
	    last.getNext().setPrevious(last);
            last = last.getNext();
        }
        size += 1;
        return true;
    }
    public int indexOf(T value) {
        LNode current = head;
        int i = 0;
        while(current != null) {
            if(current.getValue().equals(value)) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }
    public Iterator<T> iterator() {
        return new IteratorH();
    }
    private class IteratorH implements Iterator<T> {
        LNode next;
        public IteratorH() {
            next = head;
        }
        public boolean hasNext() {
	    return next != null;
	}
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = next.getValue();
            next = next.getNext();
            return value;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static double sumL(MyLinkedList<Double> data) {
        Double x;
        x = 0.0;
        Iterator<Double> a = data.iterator();
        while(a.hasNext()) {
            x += a.next();
        }
        return x.doubleValue();
    }
}
