public class QuoteSlashState extends State {
	private static QuoteSlashState instance = null;
	
	private QuoteSlashState() {};
	
	public static QuoteSlashState getInstance() {
		if(instance == null) {
			instance = new QuoteSlashState();
		}
		
		return instance;
	}
	
	public void character(Code c) {
		c.incrementCodeCounter();
		
		c.changeState(QuoteState.getInstance());
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementCodeCounter();
		
		c.changeState(QuoteState.getInstance());

	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementCodeCounter();
		
		c.changeState(QuoteState.getInstance());
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){		
		c.incrementCodeCounter();

		c.changeState(QuoteState.getInstance());
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){		
		c.incrementCodeCounter();
		c.changeState(QuoteState.getInstance());
		
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	

}