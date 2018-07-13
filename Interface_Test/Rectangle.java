public class Rectangle extends Shape implements Area{

    private double length,width;

    public Rectangle(double length, double width, String name){
	super(name);
	this.length = length;
	this.width = width;
    }

    public double getLength(){
	return length;
    }

    public double getWidth(){
	return width;
    }

    public String toString(){
	return "Rectangle "+getName()+" that is "+length+" by "+width;
    }
}