
public class JavaStarState extends State {
	private static JavaStarState instance = null;
	
	private JavaStarState() {}
	
	public static JavaStarState getInstance() {
		if(instance == null) {
			instance = new JavaStarState();
		}
		
		return instance;
	}
	
	@Override
	public void character(Code c) {
		c.incrementJavadocCounter();
		
		c.changeState(JavadocCommentState.getInstance());
	}
	
	@Override
	//checks for forwardslash character
	public void forwardslash(Code c) {
		c.incrementJavadocCounter();
		
		c.changeState(CodeState.getInstance());
	}
	
	@Override
	//checks for star character
	public void star(Code c){
		c.incrementJavadocCounter();
	}
	
	@Override
	//checks for backslash character
	public void backslash(Code c){
		c.incrementJavadocCounter();
		
		c.changeState(JavadocCommentState.getInstance());
	}
	
	@Override
	//checks for quote character
	public void quote(Code c){
		c.incrementJavadocCounter();
		
		c.changeState(JavadocCommentState.getInstance());
		
	}
	
	@Override
	//checks for newline character
	public void newLine(Code c) {
	}	
}