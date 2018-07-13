public class Sorts{	
    public static String name() {
	return "7,Park,John";}
    
    public String printer(int[] data) {
	String ret="";
	for (int i=0; i<data.length; i++) {
	    ret+=data[i] + ", ";
	}
	return ret.substring(0, ret.length()-2);}
    
    public static void mergesort(int[] data) {
	data = helper(data);}

    private static int[] helper(int[] data) {
	if(data.length <= 1){
	    return data;}
	int[] data1 = new int[data.length/2];
	int[] data2 = new int[data.length - data1.length];
	for(int a=0; a<data.length; a++) {
	    if(a<data1.length){
		data1[a] = data[a];
	    }else{
		data2[a-data1.length]=data[a];
	    }}
	int[] ret = merge(helper(data1), helper(data2));
	for (int b=0; b<ret.length; b++) {
	    data[b] = ret[b];}
	return data;}

    private static int[] merge(int[] data1, int[] data2) {
	int[] ans = new int[data1.length + data2.length];
	int q=0, r=0, s=0;
	while(q<data1.length && r<data2.length) {
	    if(data1[q] > data2[r]) {
		ans[s] = data1[q];
		s++;
		q++;
	    }else{
		ans[s] = data2[r];
		s++;
		r++;}}
	if(q==data1.length) {
	    for(int a=r; a<data2.length; a++) {
		ans[s] = data2[a];
		s++;}
	}else{
	    for(int b=q; b<data1.length; b++) {
		ans[s] = data1[b];
		s++;}}
	return ans;}
            
    //    public static void main(String[] args) {
    //	int[] test1 = {3, 1};
    //	int[] test2 = {1, 2, 0, 125, 125, 5};
    //	int[] test3 = {1000, 99, -192, 1250 -125};
    //	Sorts.mergesort(test1);	
    //	Sorts.mergesort(test2);
    //	Sorts.mergesort(test3);
    //	Sorts n = new Sorts();
    //	System.out.println(n.printer(test1));
    //	System.out.println(n.printer(test2));
    //	System.out.println(n.printer(test3));
    //     }
}
