public class SinglelineCommentState extends State {
	private static SinglelineCommentState instance = null;
	
	private SinglelineCommentState() {};
	
	public static SinglelineCommentState getInstance() {
		if(instance == null) {
			instance = new SinglelineCommentState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {		
		c.incrementSingleLineCounter();
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementSingleLineCounter();
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementSingleLineCounter();
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){		
		c.incrementSingleLineCounter();
	}
	
	@Override
	//checks for quoractehar
	public void quote(Code c){		
		c.incrementSingleLineCounter();		
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {		
		c.changeState(CodeState.getInstance());
	}	
}