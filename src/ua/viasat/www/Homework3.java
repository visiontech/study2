package ua.viasat.www;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Homework3 {

	private static Scanner reader;

	private static char[] swapper(char m[], int a, int b) {// ЗАМЕНА ЕЛЕМЕНТОВ
		char temp;
		temp = m[a];
		m[a] = m[b];
		m[b] = temp;
		return m;
	}

	private static void printArr(char line[]) {
		System.out.println("\n` `  ` `  `  ` ` `");
		for (int i = 0; i < line.length; i++) {
			System.out.print(line[i] + " ");

		} System.out.print("\n═══════════════════");
	}

	public static void game() throws UnsupportedEncodingException,
			LineUnavailableException {

		char line[] = { '█', '_', '_', '_', '_', '_', '_', '_', '_', '_' };
		line[(int) ((Math.random() + 0.1) * 9)] = '+';
		int hp = 60;
		int fk_small = 20;
		int fk_large = 40;
		int fk_type = (((int) (Math.random() * 10)) % 4 == 0 ? 2 : 1);
		
		// System.out.println(fk_type);
		int id = 0;	
		String inv = "empty";
		while (id < line.length - 1) {
			System.out.print("a <--    H/P: "+hp+" \nd -->"+"    Bag: "+inv+"\n ͠͠ ͠ϟ ͠͠ ͠͠ϟ͠ ͠ ͠͠ ͠  ͠͠ϟ͠ ͠ ͠ ͠ϟ͠ ͠ ");
			//	System.out.println("\n H/P: " + hp);
				printArr(line);
			reader = new Scanner(System.in);
			String read = reader.nextLine();
			if (read.matches("[d,D,В,в]") && id < line.length - 1) {
				if (line[id + 1] != '+') {
					swapper(line, id, id + 1);
					id++;
					Player.tone(500, 50, 0.1);
					
					printArr(line);
				} else {
					swapper(line, id, id + 1);
					inv=fk_type==1?"small":"large";
					line[id] = '_';
					id++;
					Player.tone(500, 50, 0.1);
					printArr(line);
				}
			
			}
			if (read.matches("[1-2]") && inv != "empty") {

				switch (inv + read) {
				case "small1":
					hp += fk_small;
					inv = "empty";
					break;
				case "large2":
					hp += fk_large;
					inv = "empty";
					break;
				}
				Player.tone(500, 50, 0.1);
				printArr(line);
				//System.out.print("\n H/P: " + hp);
			}

			if (read.matches("[a,A,ф,Ф]") && id > 0) {
				swapper(line, id, id - 1);
				id--;
				Player.tone(500, 50, 0.1);
				printArr(line);
			//	System.out.print("\n H/P: " + hp);
			}
			System.out.print("\n H/P: " + hp + "    inventory: " + inv
					+ (inv != "" ? "+" : "")+"\n\n\n");
		}
		if (id == line.length - 1) {
			System.out.println("\n\n"
					+ " Game Over!!!");
			Player.playmelody();
		}
		
	}

	public static void main(String[] args) throws LineUnavailableException,
			IOException {
		// Player.playmelody();
		game();
		System.out.print("\n");

	}
}
