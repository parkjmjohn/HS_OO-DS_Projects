import java.util.Arrays;

public class Quick{
    public static String name(){
	return "7,Park,John";
    }

    private static void swap(int[] ary, int a, int b){
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }
    //Partition and quickselect was remade after 3/9's class
    //Mr. K's code format I think, I remember what you wrote
    public static int partitionOld(int[] data, int left, int right){
	int index = left + (int)(Math.random()*(right - left + 1)); 
	int pos = data[index];
	swap(data, index, right);
	int ret = left;
	for(int i=left; i<right; i++){
	    if(data[i] < pos){
		swap(data, ret, i);
		ret++;
	    } 
	}
	swap(data, right, ret);
	return ret;
    }
    
    public static int quickSelect(int[] data, int k){
	return quickselect(data, k-1, 0, data.length-1);
    }
    //also tried to remake Mr. K's code
    private static int quickselect(int[] data, int k, int left, int right){
	if(left==right){
	    return data[left]; 
	}
	int index = partitionOld(data, left, right);
	if(k==index){
	    return data[k];
	}else if(k<index){
	    return quickselect(data, k, left, index-1);
	}else{
	    return quickselect(data, k, index+1, right);
	}
    }

    public static void quickSortOld(int[] data) {
        quickSortOld(data, 0, data.length - 1);
    }

    public static void quickSortOld(int[] data, int left, int right) {
        if (right-left > 0) {
            int index = partitionOld(data, left, right);
            quickSortOld(data, left, index - 1);
            quickSortOld(data, index+1, right);
        }
    }

    public static void printArray(int[] data) {
	String ret = "";
	for(int i=0; i<data.length; i++){
	    ret+=data[i];
	    if(i+1 != data.length){
		ret+=", ";
	    }
	}
	System.out.println(ret);
    }

    /////////////////////////////
    //////// NEW STUFF///////////
    /////////////////////////////

    //Was mentored by the knowledge of William Ostlund
    public static int[] partition(int[] data, int left, int right){
	int random = (int)(Math.random() * (right + 1 - left));;
	int index = data[left + random];
	int newone = right;
	int newtwo = left;
	swap(data, newone, left + random);
	right--;
	while(right > left){
	    if(data[left] >= index){
		swap(data, left, right);
		right--;
	    }
	    if(data[left] < index){
		left++;
	    }
	}
	int swap = left;
	if(data[left] >= index){
	    swap(data, newone, left);
	}
	if(data[left] < index){
	    swap(data, newone, left + 1);
	    swap++;
	}
	for(int i=newtwo; i<newone; i++){
	    if(data[i] == index){
		swap(data, i, swap);
		swap++;
	    }
	}
	int[] ret = new int[]{left,swap};
	return ret;
    }

    public static void quickSort(int[] data){
        helper(data, 0, data.length - 1);
    }

    public static void helper(int[] data, int left, int right){
	int[] index= partition(data, left, right);
	if(left>=right){
	    return;
	}
	helper(data, index[1], right);
	helper(data, left, index[0]);
    }
    
    public static void main(String[]args){
	//		int[] d = new int [40000];
	//	int[] c = new int [d.length];
	//
	//	for(int i = 0; i < d.length; i++){
	//	    d[i]= (int)(Math.random()*3);
	//	    c[i]= d[i];
	//	}
	//	quickSort(d); //or even your old quicksort!!!
	//Arrays.sort(c);
	//	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	int[]a = new int [4000000];
	int[]b = new int [4000000];
	for(int i = 0; i < a.length; i++){
	    a[i]= (int)(Math.random()*4);
	    b[i]=  Integer.MIN_VALUE + (int)(Math.random()*Integer.MAX_VALUE*2);
	}
	//Arrays.sort(a);
	//		quickSortOld(a);
	//			quickSort(a);

	//	Arrays.sort(b);
	//		quickSortOld(b);
			quickSort(b);
    }
}
