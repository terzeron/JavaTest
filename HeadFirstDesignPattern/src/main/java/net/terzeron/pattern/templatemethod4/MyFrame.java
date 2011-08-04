/**
 * 
 */
package net.terzeron.pattern.templatemethod4;

import java.awt.Graphics;

import javax.swing.JFrame;


/**
 * @author terzeron
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "painting";
		graphics.drawString(msg, 100, 100);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MyFrame myFrame = new MyFrame("head first design pattern");
	}
}
