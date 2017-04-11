public class CodeState extends State {
	
	private static CodeState instance = null;
	
	private CodeState() {};
	
	public static CodeState getInstance() {
		if(instance == null) {
			instance = new CodeState();
		}
		
		return instance;
	}
	
	
	//checks for the generic character
	@Override
	public void character(Code c) {		
		//increment the code counter
		c.incrementCodeCounter();
		
	}
	
	//checks for forwardslash character
	@Override
	public void forwardslash(Code c) {		
		c.changeState(SlashState.getInstance());
	}
	
	//checks for star character
	@Override
	public void star(Code c){		
		c.incrementCodeCounter();

	}
	
	//checks for backslash character
	@Override
	public void backslash(Code c){		
		c.incrementCodeCounter();
	}
	
	//checks for quote character
	@Override
	public void quote(Code c){	
		c.incrementCodeCounter();	
		c.changeState(QuoteState.getInstance());
	}
	
	//checks for newline character
	@Override
	public void newLine(Code c) {
	}	
}