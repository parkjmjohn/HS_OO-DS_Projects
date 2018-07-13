import java.io.*;
import java.util.Scanner;

public class BetterMaze{
    private class Node{
        private Node end;
        private int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;}
        public void setEnd(Node end){
            this.end = end;}
        public int row(){return x;}
        public int col(){return y;}
        public Node getEnd(){return end;}
        public boolean hasEnd(){return end!=null;}
    }

    private boolean completed;
    private char[][] maze;
    private int[] solution;
    private int startRow, startCol;
    private Node end;
    private Frontier<Node> placesToGo;
    private boolean animate;

    public int[] solutionCoordinates(){
	if(end==null){return null;}
	Frontier<Integer> pos = new FrontierStack<Integer>();
	Node noder = end;
	pos.add(end.col());
	pos.add(end.row());
	int i = 0;
	while (noder.hasEnd()){
	    Node m = noder.getEnd();
	    int row = m.row();
	    int col = m.col();
	    pos.add(col);
	    pos.add(row);
	    noder = m;
	    i+=2;
	}
	int[] ret = new int[i];
	for(i = 0; i < ret.length; i++){
	    ret[i] = pos.next();
	}
	solution = ret;
	return ret;
    }    

    public boolean solveBFS(){
        placesToGo = new FrontierQueue<Node>();
        return this.solve();
    }

    public boolean solveDFS(){
        placesToGo = new FrontierStack<Node>();
        return this.solve();
    }

    private boolean solve(){
	completed = false;
	placesToGo.add(new Node(startRow, startCol));
	while (placesToGo.hasNext()){
	    Node noder = placesToGo.next();
	    int row = noder.row();
	    int col = noder.col();
	    if(noder.getEnd() != null){
		maze[noder.getEnd().row()] [noder.getEnd().col()] = 'X';
	    }
	    maze[row][col] = 'x';
	    if(animate){
		System.out.println(this);
		wait(50);
	    }
	    if(maze[row - 1][col] == 'E'){
		maze[startRow][startCol] = '@';
		end = new Node(row - 1, col);
		end.setEnd(noder);
		Node last = end;
		maze[row - 1][col] = '@';
		answerVis(last);
		return true;}
            if(maze[row + 1][col] == 'E'){
		maze[startRow][startCol] = '@';
		end = new Node(row + 1, col);
		end.setEnd(noder);
		Node last = end;
		maze[row + 1][col] = '@';
		answerVis(last);
		return true;}
	    if(maze[row][col - 1] == 'E'){
		maze[row][col - 1] = '@';
		maze[startRow][startCol] = '@';
		end = new Node(row, col - 1);
		end.setEnd(noder);
		Node last = end;
		answerVis(last);
		return true;}
	    if(maze[row][col + 1] == 'E'){
		maze[row][col+1] = '@';
		maze[startRow][startCol] = '@';
		end = new Node(row, col + 1);
		end.setEnd(noder);
		Node last = end;
		answerVis(last);
		return true;}
	    if(maze[row + 1][col] == ' '){
		Node newnode = new Node(row + 1, col);
		newnode.setEnd(noder); 
		placesToGo.add(newnode);}
	    if(maze[row - 1][col] == ' '){
		Node newnode = new Node(row - 1, col);
		newnode.setEnd(noder);
		placesToGo.add(newnode);}
            if(maze[row][col - 1] == ' '){
		Node newnode = new Node(row, col - 1);
		newnode.setEnd(noder);
		placesToGo.add(newnode);}
	    if(maze[row][col + 1] == ' '){
		Node newnode = new Node(row, col + 1);
		newnode.setEnd(noder);
		placesToGo.add(newnode);}
	    if(maze[row][col + 1] != ' ' && maze[row][col - 1] != ' ' &&
	       maze[row - 1][col] != ' ' && maze[row + 1][col] != ' '){
		maze[row][col] = '.';}
	}
	return false;
    }

    public void printArray(int[]args){
        for(int i =0; i<args.length; i++){
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public BetterMaze(String filename){
        animate = false;
        int maxc = 0;
        int maxr = 0;
        startRow = -1;
        startCol = -1;
        //read the whole maze into a single string first
        String ans = "";
        try{
            Scanner in = new Scanner(new File(filename));

            //keep reading next line
            while(in.hasNext()){
                String line = in.nextLine();
                if(maxr == 0){
                    //calculate width of the maze
                    maxc = line.length();
                }
                //every new line add 1 to the height of the maze
                maxr++;
                ans += line;
            }
        }
        catch(Exception e){
            System.out.println("File: " + filename + " could not be opened.");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(maxr+" "+maxc);
        maze = new char[maxr][maxc];
        for(int i = 0; i < ans.length(); i++){
            char c = ans.charAt(i);
            maze[i / maxc][i % maxc] = c;
            if(c == 'S'){
                startCol = i % maxc;
                startRow = i / maxc;
            }
        }
    }

    public boolean answerVis(Node m){
        maze[startRow][startCol] = '@';
        while(m.hasEnd()){
            Node k = m.getEnd();
            int row = m.row();
            int col = m.col();
            maze[row][col] = '@';
            m = k;
        }
        System.out.println(this);
        completed = true;
        return true;
    }





    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }


    public String toString(){
        int maxr = maze.length;
        int maxc = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
        }
        for(int i = 0; i < maxc * maxr; i++){
            if(i % maxc == 0 && i != 0){
                ans += color(37,40) + "\n";
            }
            char c =  maze[i / maxc][i % maxc];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(33,40)+c;
            }
        }
        //nice animation string
        if(animate){
            return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
        }else{
            return ans + color(37,40) + "\n";
        }
    }







}
