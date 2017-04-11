public class PreTwoStarState extends State {
	private static PreTwoStarState instance = null;
	
	private PreTwoStarState() {};
	
	public static PreTwoStarState getInstance() {
		if(instance == null) {
			instance = new PreTwoStarState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {		
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		
		c.changeState(JavadocCommentState.getInstance());
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		c.incrementMultiLineCounter();
		
		c.changeState(CodeState.getInstance());
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		
		c.changeState(JavaStarState.getInstance());
		}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){		
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();

		c.changeState(JavadocCommentState.getInstance());
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){		
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();
		c.incrementJavadocCounter();

		c.changeState(JavadocCommentState.getInstance());
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}