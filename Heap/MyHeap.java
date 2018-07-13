import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;
    
    public MyHeap(){
	size = 0;
	data = (T[])new Comparable[2];
	isMax = true;
    }

    public MyHeap(T[] array){
	size = array.length;
	data = array;
	isMax = true;
	heapify();
    }

	//last
    public MyHeap(boolean isMa){
	size = 0;
	data = (T[])new Comparable[2];
	isMax = isMa;
    }

    public MyHeap(T[] array, boolean isMa){
	size = array.length;
	data = array;
	isMax = isMa;
	heapify();
    }

    //Helper functions
    private boolean compare(T x, T y) {
	if(isMax){
	    return x.compareTo(y)>=0;
	}else{
	    return x.compareTo(y)<=0;
	}
    }

    private void swap(int x, int y){
	T temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }    

    public int size(){
	return size;
    }

    public T[] data(){
	return data;
    }

	/**pushDown
      precondition: datas[k]'s children are valid heaps
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data[k] and is a valid heap
	**/
    private void pushDown(int k){
	if (k<size/2 && compare(data[2*k], data[k]) && compare(data[2*k+1], data[k])){
	    if (compare(data[2*k+1], data[2*k])){
		swap(2*k+1,k);
		pushDown(2*k+1);
	    }else{
		swap(2*k, k);
		pushDown(2*k);	
	    }
	}
    }

	/**pushUp
      precondition: data is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data is a valid heap
	**/
    //Mr. K's push up 
   private void pushUp(int k){
	if(k>1 && compare(data[k],data[k/2])){
	    swap(k/2, k);
	    pushUp(k/2);
	}
    }
    

    private void heapify(){
	size = data.length;
	doubleSize();
	data[size] = data[0];
	data[0] = null;
	for(int i=size/2; i>0; i--){
	    pushDown(i);
	}
    }
    
    public T delete(){
	if(size == 0){
	    throw new NoSuchElementException("Empty");
	}
	T ret = data[1];
	data[1] = data[size];
	pushDown(1);
	size--;
	return ret;
    }
    
    public void add(T x){
	size++;
	if(data.length <= size){
	    doubleSize();
	}
	data[size] = x;
	pushUp(size);
    }
    
    private void doubleSize(){
        T[] temp = (T[])new Comparable[2*data.length];
        for(int i=0; i<data.length; i++){
            temp[i]=data[i];
        }
        data = temp;
    }
    
    public String toString(){
        String ret = "[";
        for(int i=1; i<size; i++){
            ret+=data[i];
            if(i<size - 1){
                ret+=", ";
            }
        }
        return ret+ "]";
    }

    public T peek() {
	if(size==0){
	    throw new NoSuchElementException();
	}else{
	    return data[1];
	}
    }
}
