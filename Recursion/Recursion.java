public class Recursion implements hw01{

    public String name(){
        return "Park,John";
    }

    public double sqrt(double n){
        if(n<0){
            throw(new IllegalArgumentException("Ask Siri to compute 0/0"));
        }
        if(n==0){
            return 0;
        }
        return helper(n, 1);
    }

    public double helper(double n, double check){
        if(Math.abs((n-check*check)/n*100) <= 0.00000001){
            return check;
        }
        check=(n/check+check)/2;
        return helper(n, check);
    }

 //   public static void main(String args[]){
        // Recursion n=new Recursion();
        // System.out.println(n.sqrt(1.0));
        // System.out.println(n.sqrt(2.0));
        // System.out.println(n.sqrt(4.0));
        // System.out.println(n.sqrt(1.0E-7));
        // System.out.println(n.sqrt(-1.0));
        // System.out.println(n.sqrt(-100.0));
 //   }

}
