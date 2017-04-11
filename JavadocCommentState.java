public class JavadocCommentState extends State {
	private static JavadocCommentState instance = null;
	
	private JavadocCommentState() {};
	
	public static JavadocCommentState getInstance() {
		if(instance == null) {
			instance = new JavadocCommentState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {		
		c.incrementJavadocCounter();
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {		
		c.incrementJavadocCounter();
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementJavadocCounter();
		
		c.changeState(JavaStarState.getInstance());
	}

	
	@Override
	//checks for backslash character
	public void backslash(Code c){
		c.incrementJavadocCounter();
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){
		c.incrementJavadocCounter();
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}