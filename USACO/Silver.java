import java.io.*;
import java.util.Scanner;
public class Silver{

    private int[][]board;

    public Silver(int[][]i){
        board = i;}

    public int value(int a, int b){
        return board[a][b];
    }

    public int[][] create(int x){
        int[][] ret = new int[board.length][board[0].length];

        if(x == 0){
            return board;}

        for(int i = 0; i < board.length; i++){

            for(int k = 0; k < board[i].length; k++){
                if(board[i][k] == -1){
                    ret[i][k] = -1;
                }else{
                    int a = 0;

                    if(k!=board[0].length-1 && board[i][k+1]!=-1){
                        a+=board[i][k+1];}

                    if(i!=board.length-1 && board[i+1][k]!=-1){
                        a+=board[i+1][k];}

                    if(k!=0 && board[i][k-1]!=-1){
                        a+=board[i][k-1];}

                    if(i!=0 && board[i-1][k]!=-1){
                        a+=board[i-1][k];}
                    ret[i][k] = a;
                }}
        }
        board = ret;
        return create(x - 1);
    }

    public static void main(String[]args){
        try{
            Scanner input = new Scanner(new File("ctravel.in"));
            Scanner input1 = new Scanner(input.nextLine());

            int a = input1.nextInt();
            int b = input1.nextInt();

            int turns = input1.nextInt();
            int[][] ret = new int[a][b];

            for(int i = 0; i < a; i++){
                String j = new String(input.nextLine());
                for(int r = 0; r < b; r++){
                    if(j.charAt(r) == '.'){
                        ret[i][r]=0;
                    }else{
                        ret[i][r]=-1;
                    }
                }
            }

            Scanner v = new Scanner(input.nextLine());

            ret[v.nextInt()-1][v.nextInt()-1] = 1;

            Silver s = new Silver(ret);

            s.create(turns);

            System.out.println(s.value(v.nextInt()-1, v.nextInt()-1)+",7,Park,John");

        }catch(FileNotFoundException e){
            System.out.println("Que pasa amingo?");

        }}

}
