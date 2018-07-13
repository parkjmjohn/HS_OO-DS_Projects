public class BSTree<T extends Comparable<T>> {   
    private class Node{
	T data;
	Node left;
	Node right;
	int height;

	public void setValue(T value) {
	    data = value;
	}

	public T getValue() {
	    return data;
	}

	public Node getRight(){
	    return right;
	}

	public Node getLeft(){
	    return left;
	}

	public void setLeft(Node n){
	    left = n;
	}

	public void setRight(Node n){
	    right = n;
	}
	
	public int height(){ 
	    return height(0);
	}

	public int height(int n) {
	    if (left!=null && right!=null) {
		if (left.height(n+1)>right.height(n+1)){
		    return left.height(n+1);
		}
		return right.height(n+1);
	    }
	    else if (left!=null) {
		return left.height(n+1);
	    }
	    else if (right!=null) {
		return right.height(n+1);
	    }
	    else {
		return n+1;
	    }
	}

        public void add(T newc){
            if (data == null) {
                data = newc;
            }
            else if (newc.compareTo(data) >= 0) {
		if (right == null) {
                    right = new Node();
                    right.setValue(newc);
                }
                else {
                    right.add(newc);
                }
            }
            else {
		if (left == null) {
                    left = new Node();
                    left.setValue(newc);
                }
                else {
                    left.add(newc);
                }
	    }
        }

	public String toString(){
	    return toString(root);
	}

	public String toString(Node n){
	    if (n==null){
		return " _"; 
	    }
	    return " "+n.getValue()+" "+toString(n.getLeft())+" "+toString(n.getRight());
	}

	public boolean contains(T value){
	    return contains(value, root);
	}

	private boolean contains(T value, Node n){
	    if(n == null){
		return false;
	    }
	    else if(n.getValue().compareTo(value) == 0){
		return true;
	    }
	    return contains(value,n.getLeft()) || contains(value,n.getRight());
	}

	public T remove(T value) {
	    if (value.compareTo(data)<0) {
		T ret = left.remove(value);
		if (left.getValue() == null) {
		    left = null;
		}
		return ret;
	    }else{
		T ret = right.remove(value);
		if (right.getValue() == null) {
		    right = null;
		}
		return ret;
	    }
	}	
    }

    private Node root;

    public BSTree() {
	root = new Node();
    }

    public int getHeight(){
	return getHeight(root, 0);
    }

    private int getHeight(Node n, int height){
	if(n==null){
	    return height;
	}
	int left = getHeight(n.getLeft(), height+1);
	int right = getHeight(n.getRight(), height+1);
	if(left>right){
	    return left;
	}
	return right;
    }

    public void add(T value){
        root.add(value);
    }
    public String toString(){
	if (root.getValue()!=null) {
	    return root.toString();
	}
	return " ";
    }

    public boolean contains(T value){
	if (root.getValue()==null) {
	    return false;
	}
	return root.contains(value);
    }
    
    public T remove(T child) {
	if (root.getValue() == null) {
	    return null;
	}
	return root.remove(child);
    }
}
