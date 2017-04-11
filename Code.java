import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class Code {
	//holds the current state
	private State currentState;
	
	//holds the path to the file being read
	String filePath;
	private int codeCounter;
	private int singleLineCounter;
	private int multiLineCounter;
	private int javadocCounter;
	
	//=================================================
	//takes in the string for the file path 
	public Code(String fp) {
		//stores the file path for later use
		setFilePath(fp);
		
		//set the current state to code state
		changeState(CodeState.getInstance());
	}
	//=================================================
	
	
	
	//=================================================
	//change the current state of the code to what it should be
	public void changeState(State c) {
		currentState = c;
	}
	//get the current state
	public State getCurrentState() {
		return currentState;
	}
	//=================================================
	
	
	
	//=================================================
	//set the filePath
	private void setFilePath(String fp) {
		filePath = fp;
	}
	//get the file path
	public String getFilePath() {
		return filePath;
	}
	//=================================================
	
	
	
	//=================================================
	//increment the code counter
	public void incrementCodeCounter() {
		codeCounter++;
	}
	//get the code counter 
	public int getCodeCounter() {
		return codeCounter;
	}
	//=================================================
	
	
	//=================================================
	//increment the single line counter
	public void incrementSingleLineCounter() {
		singleLineCounter++;
	}
	//get the single line counter
	public int getSingleLineCounter() {
		return singleLineCounter;
	}
	//=================================================
	
	
	//=================================================
	//increment the multiLineCounter
	public void incrementMultiLineCounter() {
		multiLineCounter++;
	}
	//get the multiLineCounter
	public int getMultiLineCounter() {
		return multiLineCounter;
	}
	//=================================================
	
	
	//=================================================
	//increment the javadocCounter
	public void incrementJavadocCounter() {
		javadocCounter++;
	}
	//get the javadocCounter
	public int getJavadocCounter() {
		return javadocCounter;
	}
	//=================================================
	
	
	//=================================================
	//read in a file and check the characters
	public void checkFile() {
		File file = new File(filePath);
		
		if(!file.exists()) {
			System.out.println("FILE DOES NOT EXIST");
			return;
		}
		if(!(file.isFile() && file.canRead())) {
			System.out.println(file.getName() + "cannot be read from");
			return;
		}
		//check the extension of the file to make sure
		//that it is a java file		
		try {
			FileInputStream fin = new FileInputStream(file);
			//holds the current char that is being read
			char current;
			
			while (fin.available() > 0) {

				current = (char) fin.read();
				
				
				//check for the individual characaters
				if(current == '*') {
					currentState.star(this);
				}
				else if (current == '/') {
					currentState.forwardslash(this);
				}
				else if (current == '\\') {
					currentState.backslash(this);
				}
				else if (current == '"') {
					currentState.quote(this);
				}
				else if (current == '\n' || current == '\r') {
					currentState.newLine(this);
				}
				else {
					currentState.character(this);
				}
				
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//=================================================
	
}