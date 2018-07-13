import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> data;

    public MyStack(){
	data = new MyLinkedList<T>();
    }
    public void push(T value){
	data.add(0, value);
    }
    public T pop(){
	if(data.size() == 0){
	    throw new NoSuchElementException();
	}
	return data.remove(0);
    }
    public T peek(){
	if(data.size() == 0){
	    throw new NoSuchElementException();
	}
	return data.get(0);
    }
    public boolean isEmpty(){
	return data.size()==0;
    }
    public String toString(){
	return data.toString();
    }
    public int size(){
	return data.size();
    }
}
