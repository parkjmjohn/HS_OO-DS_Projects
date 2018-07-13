import java.util.*;
public class FrontierStack<T> implements Frontier<T>{
    private MyLinkedList<T> LNode;

    public FrontierStack(){
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
        return this.pop();
    }

    public boolean hasNext(){
        return !this.isEmpty();
    }

    public void add(T value){
        this.push(value);
    }

    public void push(T value){
        LNode.add(0, value);
    }

    public T pop(){
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
