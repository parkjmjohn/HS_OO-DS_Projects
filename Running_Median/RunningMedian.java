public class RunningMedian{
    private MyHeap<Integer> max, min;
    private double median;

    public RunningMedian(){
	max = new MyHeap<Integer>(false);
	min = new MyHeap<Integer>(true);
	median = 0;
    }

    public double getMedian(){
	return median;
    }

    public void add(Integer value){
	if(value>median){
	    max.add(value);
	}else{
	    min.add(value);
	}
	this.calcMedian();
    }

    public void calcMedian(){
	if (max.size()-min.size() == 2){
	    min.add(max.delete());
	}else if (min.size()-max.size() == 2){
	    max.add(min.delete());
	}
	max.heapify();
	min.heapify();
	if (max.size()>min.size()){
	    median = (double) max.peek();
	}else if (min.size() > max.size()){
	    median = (double)min.peek();
	}else{
	    median = ((double)(min.peek()) + (double)max.peek()) / 2.0;
	}
    }
}
