import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    private MyLinkedList<T> LNode;

    public FrontierQueue(){
        LNode = new MyLinkedList<T>();
    }

    public int size(){
        return LNode.size();
    }

    public boolean isEmpty(){
        return LNode.size()==0;
    }

    public String toString(){
        return LNode.toString();
    }

    public T next(){
        return this.dequeue();
    }

    public boolean hasNext(){
        return !this.isEmpty();
    }

    public void add(T value){
        this.enqueue(value);
    }

    public void enqueue(T value){
        LNode.add(value);
    }

    public T dequeue(){
        if(LNode.size()==0){
            throw new NoSuchElementException();
        }
        return LNode.remove(0);
    }

    public T peek(){
        if(LNode.size()==0){
            throw new NoSuchElementException();
        }
        return LNode.get(0);
    }
}
