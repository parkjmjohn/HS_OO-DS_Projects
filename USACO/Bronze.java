import java.util.*;
import java.io.*;
public class Bronze{

    public static void main(String[]args){
	try{
	    BufferedReader input = new BufferedReader(new FileReader("makelake.in"));	    
	    int n, e, c, r;
	    String juan = input.readLine();
	    n = Integer.parseInt(juan.split(" ")[3]);
	    e = Integer.parseInt(juan.split(" ")[2]);
	    c = Integer.parseInt(juan.split(" ")[1]);
	    r = Integer.parseInt(juan.split(" ")[0]);
	    int[][] init = new int[n][3];
	    int[][] pos = new int[r][c];
	      
	    for(int a = 0; a < r; a++){
		String next = input.readLine();
		for(int b = 0; b < c; b++){
		    pos[a][b] = Integer.parseInt(next.split(" ")[b]);
		}
	    }

	    for(int a = 0; a < n; a++){
		String next = input.readLine();
		
		for(int b = 0; b < 2; b++){
		    init[a][b] = Integer.parseInt(next.split(" ")[b])-1;}

		init[a][2]=Integer.parseInt(next.split(" ")[2]);
		int max=max(pos, init[a][0], init[a][1]);
		
		for(int y = init[a][0]; y < init[a][0]+3; y++){
	
		    for(int z = init[a][1]; z < init[a][1]+3; z++){
			if(pos[y][z]>=max-init[a][2]){
			    pos[y][z]=max-init[a][2];
			}}}
	    }

	    int con = 0;
	    for(int a=0; a<r; a++){
		for(int b=0; b<c; b++){
		    if(pos[a][b] <= e){
			con = con + e - pos[a][b];
		    }}
	    }
	    int i = con * 72 * 72;
	    System.out.println(i+",7,Park,John");
	}

	catch(Exception e){
	    System.out.println(e);}
    }
    
    public static int max(int[][] num, int y, int z){
	int top = 0;

	for(int i = y; i < y+3; i++){
	    for(int q=z; q < z+3; q++){
		top = Math.max(top, num[i][q]);
	    }
	}
	return top;
    }
}
