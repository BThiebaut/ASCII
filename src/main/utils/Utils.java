package main.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utils {
	private static JFrame frame = new JFrame();
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static String askDialog(String message, String defaultValue){
		String result = JOptionPane.showInputDialog(frame,
                message, defaultValue);
		return result;
	}
	
	public static Date randomDate(){
		Calendar c1 = GregorianCalendar.getInstance();
		c1.set(randBetween(1945, 2016), randBetween(1, 12), randBetween(1, 31));
		return c1.getTime();
	}
	
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
