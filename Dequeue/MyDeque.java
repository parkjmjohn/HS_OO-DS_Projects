import java.util.*;
import java.io.*;
public class MyDeque<T>{
    private T[] data;
    private int size;
    public int start;
    public int end;

    @SuppressWarnings("unchecked")
        public MyDeque(){
        data = (T[]) new Object[10];
        size = 0;
        start = 0;
        end = 0;
    }

    @SuppressWarnings("unchecked")
        private void grow(){
        T[] newData = (T[]) new Object[data.length * 2];

        for(int x = start;x<data.length;x++){
            newData[x] = data[x];
        }
        for(int j = 0; j<start;j++){
            newData[data.length + j]=data[j];
        }
        end = start + size-1;
        data = newData;
    }

    public String toString(){
        String ans = "{";
        for(int x = 0; x<data.length; x++){
            ans += data[x] + ", ";
        }
        return ans.substring(0, ans.length() - 2)+"}";
    }

    public int size(){
        return size;
    }

    public void addFirst(T value){
        if((start == 0 && end == data.length-1 ||end + 1 == start)){
            grow();
            addFirst(value);
        }else{
            if(size == 0){
                data[start] = value;
            }else if(start == 0){
                data[data.length-1]=value;
                start = data.length-1;
            }else{
                data[start-1]=value;
                start--;
            }
            size++;
        }
    }

    public void addLast(T value){
        if(size == data.length){
            grow();
        }
        if(end < data.length-1){
            end++;
        }
        else if(end == data.length-1){
            end=0;
        }
        size++;
        data[end] = value;
    }

    public T removeFirst(){
        if(size<1){
            throw new NoSuchElementException();
        }else{
            T ret = data[start];
            data[start]=null;
            if(start == data.length-1){
                start = 0;
            }else{
                start++;
            }
            size--;
            return ret;
        }
    }

    public T removeLast(){
        if(size < 1) {
            throw new NoSuchElementException();
        }else{
            T ret = data[end];
            data[end]=null;
            if(end==0){
                end = data.length-1;
            }else{
                end--;
            }
            size--;
            return ret;
        }
    }

    public T getFirst(){
        if(size < 1) {
            throw new NoSuchElementException();
        }
        return data[start];
    }

    public T getLast(){
        if(size < 1) {
            throw new NoSuchElementException();
        }
        return data[end];
    }
}
