import java.io.*;
import java.util.*;
public class Maze{

    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      
      3. When the file is not found, print an error and exit the program.
    */

    public Maze(String filename, boolean ani){
	animate = ani;
	startx = -1;
	starty = -1;
	try{
	    ArrayList<String> n = new ArrayList<String>();
	    Scanner input = new Scanner(new File(filename));

	    while(input.hasNextLine()){
		n.add(input.nextLine());
	    }

	    maze = new char[n.size()][n.get(0).length()];
	    for(int a = 0; a < n.size(); a++){
		String line = n.get(a);
		for(int b = 0; b < line.length(); b++){
		    maze[a][b] = line.charAt(b);
		    if(line.charAt(b) == 'S'){
			starty = a;
			startx = b;
		    }}
	    }
	}catch(FileNotFoundException E){
	    System.out.println("Que pasa?");
	}	
    }

    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }
	if(maze[y][x]=='E'){
	    return true;
	}else{
	    maze[y][x]='@';
	}
	if(maze[y][x-1]!='#'&&maze[y][x-1]!='.'&&maze[y][x-1]!='@'){
	    if(solve(x-1,y)){
		return true;
            }
        }
	if(maze[y-1][x]!='#'&&maze[y-1][x]!='.'&&maze[y-1][x]!='@'){
	    if(solve(x,y-1)){
                return true;
            }
        }
	if(maze[y][x+1]!='#'&&maze[y][x+1]!='.'&&maze[y][x+1]!='@'){
	    if(solve(x+1,y)){
		return true;
            }
	}
	if(maze[y+1][x]!='#'&&maze[y+1][x]!='.'&&maze[y+1][x]!='@'){
	    if(solve(x,y+1)){
		return true;
	    }
	}
	maze[y][x] = '.';
	return false;
    }

    //that's it
    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i % maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(32,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }

    //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    
    //END FREE STUFF


}
