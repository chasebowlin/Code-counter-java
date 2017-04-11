public class MultiStarState extends State {
	private static MultiStarState instance = null;
	
	private MultiStarState() {};
	
	public static MultiStarState getInstance() {
		if(instance == null) {
			instance = new MultiStarState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {
		c.incrementMultiLineCounter();
		c.changeState(MultilineCommentState.getInstance());
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {
		c.incrementMultiLineCounter();
		
		c.changeState(CodeState.getInstance());

	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementMultiLineCounter();
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){
		c.incrementMultiLineCounter();
		
		c.changeState(MultilineCommentState.getInstance());
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){
		c.incrementMultiLineCounter();
		
		c.changeState(MultilineCommentState.getInstance());
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}