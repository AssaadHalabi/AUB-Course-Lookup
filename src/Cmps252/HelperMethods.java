/**
 * 
 */
package Cmps252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author student
 *
 */
public class HelperMethods {
	public static String extractRoom(String location) {
		int i = 0;
		while (i < location.length() && !Character.isDigit(location.charAt(i))) {
			i++ ;
			continue;
		} 
		int j = i;
		StringBuilder room = new StringBuilder();
		
		while (j<location.length()) {
			room.append(location.charAt(j));
			j++;
		}
		return room.toString();
	}
	public static String extractBuilding(String location) {
		
		int i = 0;
		while (i < location.length() && !Character.isDigit(location.charAt(i))) i++;
		int j = i;
		StringBuilder build = new StringBuilder();
		i=0;
		while (i<j) {
			build.append(location.charAt(i));
			i++;
		}
		return build.toString();
	}
	
	public static boolean containsRoom(String str) {
		return str.matches(".*\\d.*");
	}


	public static String fixSched(String sched) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < sched.length(); i++) {
			if (sched.charAt(i) == '.') {
				continue;
			}
			else {
				str.append(sched.charAt(i));
				str.append(' ');
			}
		}
		return str.toString();
	}
	public static String addChar(String str, char ch) {
		String s="";
		for (int i = 0; i < str.length(); i++) {
			if(i== 2) {
				s+=":";
			}
			s+=str.charAt(i);
			
		}
		return s;
	}
	
}
