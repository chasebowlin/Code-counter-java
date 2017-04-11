import javax.swing.*;
import java.awt.*;

public class Driver {
    private static Code testCode;

    private static JFrame window;
    private static JLabel codeCount;
    private static JLabel singleCount;
    private static JLabel multiCount;
    private static JLabel javadocCount;
    private static JLabel filePath;
    
    public static void main(String[] args) {
        //pass in the code to the GUI
        createGUI();
    }
    
    private static void createGUI() {
        //get the path from the user
        String path = JOptionPane.showInputDialog("Enter in the file path with the file");


        //create the code object and pass in the file to be read
        testCode = new Code(path);
        //C:/Users/FGSPB/Desktop/test.java
        testCode.checkFile();

       
        filePath = new JLabel(testCode.getFilePath());
        codeCount = new JLabel("Code:  " + testCode.getCodeCounter());
        singleCount = new JLabel("Single:  " + testCode.getSingleLineCounter());
        multiCount = new JLabel("Multi line:  " + testCode.getMultiLineCounter());
        javadocCount = new JLabel("Javadoc:   " + testCode.getJavadocCounter());

        //create and set up the window
        window = new JFrame("Code counter results");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(5, 1));
        window.setVisible(true);
        window.setSize(300, 300);
        window.setLocation(500, 300);

       window.add(filePath);
       window.add(codeCount);
       window.add(singleCount);
       window.add(multiCount);
       window.add(javadocCount);

    }

    
}