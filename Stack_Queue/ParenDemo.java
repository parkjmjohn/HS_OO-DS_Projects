public class ParenDemo{
    public static boolean isMatching(String s){
	if(!isEqual(s)){
	    return false;}
	MyStack<Character> data = new MyStack<Character>();
        for (int i=0; i<s.length(); i++){
	    char at = s.charAt(i);
	    if(at=='(' || at=='[' || at=='{' || at=='<'){
		data.push(at);
	    }else{
		if(at==']'){
		    if(!data.isEmpty() && data.peek()=='['){
			data.pop();
		    }else{
			return false;
		    }
		}
		else if(at==')'){
		    if(data.size()!=0 && data.peek()=='('){
			data.pop();
		    }else{
			return false;
		    }
		}
		else if(at=='>'){
		    if(data.size()!=0 && data.peek()=='<'){
			data.pop();
		    }else{
			return false;
		    }
		}
		else if(at=='}'){
		    if(!data.isEmpty() && data.peek()== '{'){
			data.pop();
		    }else{
			return false;
		    }}}}
	return data.isEmpty();
    }

    public static boolean isEqual(String s){
	int one = 0, two = 0, three = 0, four = 0;
	int onee = 0, twoo = 0, threee = 0, fourr = 0;
	for(int i = 0; i<s.length(); i++){
	    if(s.charAt(i)==('{')){
		one++;	   }
	    if(s.charAt(i)==('[')){
		two++;	    }
	    if(s.charAt(i)==('<')){
		three++;	    }
	    if(s.charAt(i)==('(')){
		four++;	    }
	    if(s.charAt(i)==('}')){
		onee++;	    }
	    if(s.charAt(i)==(']')){
		twoo++;	    }
	    if(s.charAt(i)==('>')){
		threee++;    }
	    if(s.charAt(i)==(')')){
		fourr++;	    }
	}    
	return one==onee && two==twoo && three==threee && four==fourr;
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }

}
