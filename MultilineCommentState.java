public class MultilineCommentState extends State {
	private static MultilineCommentState instance = null;
	
	private MultilineCommentState() {};
	
	public static MultilineCommentState getInstance() {
		if(instance == null) {
			instance = new MultilineCommentState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {
		c.incrementMultiLineCounter();
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {

		c.incrementMultiLineCounter();

	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementMultiLineCounter();
		
		c.changeState(MultiStarState.getInstance());
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){
		c.incrementMultiLineCounter();
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){
		c.incrementMultiLineCounter();	
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}