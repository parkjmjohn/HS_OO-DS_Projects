public class KnightBoard{

    public int[][] board;
    //public int debug;

    public KnightBoard(int space){
<<<<<<< HEAD
	board = new int [space][space];}
    // debug = 0;

    public KnightBoard(int row,int col){
	board = new int[row][col];}
    //debug = 0 ;

    public boolean solve(){
	return helper(1, 0, 0);}

    public boolean helper(int pos, int row, int col){
	//System.out.println("Debug step: "+debug");
	if(row>=board.length||col>=board[0].length||row<0||col<0){
            return false;}

	for(int a = 0; a<board.length; a++){
            for(int b = 0; b<board[0].length;b++){
                if(board[a][b]>=pos){
                    board[a][b]=0;}}}

        
        if(pos == board.length * board[0].length+1){
	    return true;}
	else if(board[row][col]>0){
	    return false;}

	else{
	    board[row][col]=pos;
	    return (helper(pos+1,row+2,col+1)||
		    helper(pos+1,row+2,col-1)||
		    helper(pos+1,row-2,col+1)||
		    helper(pos+1,row-2,col-1)||
		    helper(pos+1,row+1,col+2)||
		    helper(pos+1,row+1,col-2)||
		    helper(pos+1,row-1,col+2)||
		    helper(pos+1,row-1,col-2));}}

    public void printSolution(){
	//debug=0;
	//System.out.println(debug);
	String ret = "";
	for(int q=0; q<board.length; q++){
	    ret += printhelper(q)+"\n\n";}
ret=		ret.substring(0, ret.length()-3);
	System.out.println(ret);}


    public String printhelper(int i){
	String ret = "\n";
	for(int q=0; q<board[0].length; q++){
	    ret += "   ";
      	    if(board[i][q]<10){
		ret += board[i][q] + "  ";}
	    else{
		ret += board[i][q] + " ";}}
	return ret;}

    public static void main(String[]args){
	KnightBoard n;
	if(args.length == 0){
	    System.out.println("Enter a digit 'x' for x by x, or 'x' & 'y' for x by y board");}
	if(args.length == 1){
	    n = new KnightBoard(Integer.parseInt(args[0]));}
	else{
		n = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));}
	    System.out.println(n.solve());
	    n.printSolution();}
=======
        board = new int [space][space];}
    // debug = 0;

    public KnightBoard(int row,int col){
        board = new int[row][col];}
    //debug = 0 ;

    public boolean solve(){
        return helper(1, 0, 0);}

    public boolean helper(int pos, int row, int col){
        //System.out.println("Debug step: "+debug");
        if(row>=board.length||col>=board[0].length||row<0||col<0){
            return false;}

        for(int a = 0; a<board.length; a++){
            for(int b = 0; b<board[0].length;b++){
                if(board[a][b]>=pos){
                    board[a][b]=0;}}}


        if(pos == board.length * board[0].length+1){
            return true;}
        else if(board[row][col]>0){
            return false;}

        else{
            board[row][col]=pos;
            return (helper(pos+1,row+2,col+1)||
                    helper(pos+1,row+2,col-1)||
                    helper(pos+1,row-2,col+1)||
                    helper(pos+1,row-2,col-1)||
                    helper(pos+1,row+1,col+2)||
                    helper(pos+1,row+1,col-2)||
                    helper(pos+1,row-1,col+2)||
                    helper(pos+1,row-1,col-2));}}

    public void printSolution(){
        //debug=0;
        //System.out.println(debug);
        String ret = "";
        for(int q=0; q<board.length; q++){
            ret += printhelper(q)+"\n\n";}
        ret = ret.substring(0, ret.length()-3);
        System.out.println(ret);}


    public String printhelper(int i){
        String ret = "\n";
        for(int q=0; q<board[0].length; q++){
            ret += "   ";
            if(board[i][q]<10){
                ret += board[i][q] + "  ";}
            else{
                ret += board[i][q] + " ";}}
        return ret;}

    public static void main(String[]args){
        KnightBoard n;
        if(args.length == 0){
            System.out.println("Enter a digit 'x' for x by x, or 'x' & 'y' for x by y board");}
        if(args.length == 1){
            n = new KnightBoard(Integer.parseInt(args[0]));}
        else{
                n = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));}
            System.out.println(n.solve());
            n.printSolution();}
>>>>>>> c6d62cf6f30f0ca330698b0ad76e8c7342358163
}
