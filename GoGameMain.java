//coded by: Tera Benoit main method to run gui.
import java.awt.*;
import javax.swing.*;
public class GoGameMain {
	public static void main(String[] args){
	   GameUI goFrame = new GameUI();
	   goFrame.setTitle("Go Game");
	   goFrame.setSize(800, 600);
	   goFrame.setLocationRelativeTo(null);
	   goFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   goFrame.setVisible(true);
	}
}