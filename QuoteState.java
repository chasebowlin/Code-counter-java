public class QuoteState extends State {
	
	private static QuoteState instance = null;
	
	private QuoteState() {};
	
	public static QuoteState getInstance() {
		if(instance == null) {
			instance = new QuoteState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {		
		c.incrementCodeCounter();
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementCodeCounter();
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementCodeCounter();
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){		
		c.incrementCodeCounter();

		c.changeState(QuoteSlashState.getInstance());
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