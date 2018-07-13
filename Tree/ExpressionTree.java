/*This expression tree is a binary tree that represents 
  an arithmetic expression. The results are always doubles, 
  no int operations nor booleans/strings etc.
  -Example: 
     +
    / \
   3   *
      /  \
     2    10
  - Any node with children is treated like an operator.
  - Any node without children is treated like a value.

  Assumptions that can be made:
  - A TreeNode with no children must have a value. 
  - A TreeNode with children must have an operator.
  - For now all operators are binary: +, -, *, / 
  - We could add more operators like ^ for expt

*/

public class ExpressionTree{

    /*You must use hasChildren to determine 
      if the node is a value or an operator*/
    private class TreeNode{
	public char getOp(){/*implementation not shown*/}
	public double getValue(){/*implementation not shown*/}
	public TreeNode getLeft(){/*implementation not shown*/}
        public TreeNode getRight(){/*implementation not shown*/}   
        public boolean hasChildren(){/*implementation not shown*/}  

        /*there may be more methods and instance variables*/
    }

    private TreeNode root;

    /*there may be more methods and instance variables*/

    
    /*return the expression as a prefix notation string*/
    /* The sample tree would be: "+ 3 * 2 10"     */
    public String toStringPrefix(){ 
	/*you are to write this method*/
    }   

    /*return the value of the entire expression tree*/
    public double evaluate(){ 
	return evaluate(root); 
    }

    /*return the value of the specified expression tree*/
    public double evaluate( TreeNode localRoot){
	/*you are to write this method*/
    }

    /* 

  -Example: lets label the nodes with letters...
      +(a)
     / \
  3(b) *(c)
      / \
   2(d) 10(e)
       calling evaluate() would call evaluate(TreeNode) on node 0.
       
       How evaluate would work on each node:
       calling evaluate(Node a) would result in 23.0
       calling evaluate(Node b) would result in 3.0
       calling evaluate(Node c) would result in 20.0
       calling evaluate(Node d) would result in 2.0
       calling evaluate(Node e) would result in 10.0
    */    
}
