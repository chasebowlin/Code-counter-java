public class SlashState extends State {
	private static SlashState instance = null;
	
	private SlashState() {};
	
	public static SlashState getInstance() {
		if(instance == null) {
			instance = new SlashState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {		
		c.incrementCodeCounter();
		c.incrementCodeCounter();
		c.changeState(CodeState.getInstance());
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementSingleLineCounter();
		c.incrementSingleLineCounter();

		c.changeState(SinglelineCommentState.getInstance());
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.changeState(PreStarState.getInstance());
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){		
		c.incrementCodeCounter();

		c.changeState(CodeState.getInstance());
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){		
		c.incrementCodeCounter();

		c.changeState(CodeState.getInstance());
		
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}