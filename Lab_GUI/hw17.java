public class hw17{
    private int C, F;

    public hw17(int c, int f){
	C=c;
	F=f;
    }
			      
    public static double CtoF(double t){
	return t*(9/5)+32;
    }
    public static double FtoC(double t){
	return (t-32)*(5/9);
    }
}
