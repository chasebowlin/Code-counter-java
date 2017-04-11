public class PreStarState extends State {
	private static PreStarState instance = null;
	
	private PreStarState() {};
	
	public static PreStarState getInstance() {
		if(instance == null) {
			instance = new PreStarState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {		
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.changeState(MultilineCommentState.getInstance());
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.changeState(MultilineCommentState.getInstance());		
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.changeState(PreTwoStarState.getInstance());
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){		
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.changeState(MultilineCommentState.getInstance());
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){		
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.changeState(MultilineCommentState.getInstance());	
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}