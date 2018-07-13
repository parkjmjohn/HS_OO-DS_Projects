import java.util.*;
public class Driver {
    public static void main(String[]args) {
	String maze = "data3.dat";
	BetterMaze n = new BetterMaze(maze);

	n.setAnimate(true);

	System.out.println(n.solveBFS());

	//System.out.println(m.solveDFS());

	System.out.println(Arrays.toString(n.solutionCoordinates()));

	System.out.println(n);
    }
}
