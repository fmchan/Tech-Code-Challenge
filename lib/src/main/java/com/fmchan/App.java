/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.fmchan;

import java.util.Scanner;

public class App {
	private static Controller controller = new Controller();
	public static void main(String[] args) throws Exception {
        introduction();
		Scanner input = new Scanner(System.in);
		String cmd = new String();

		while (!String.valueOf(Constants.CMD_QUIT).equals(cmd)) {
			System.out.print("enter command: ");
			cmd = input.nextLine();
			System.out.println(controller.assign(cmd));
		}

		input.close();
    }

	public static void introduction() {
		System.out.println("""
			Drawing program
			C w h         -  create a new canvas of width w and height h
			L x1 y1 x2 y2 -  create a new line from (x1,y1) to (x2,y2)
			R x1 y1 x2 y2 -  create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2)
			B x y c       -  fill the entire area connected to (x,y) with 'colour' c
			Q             -  quit the program
		""");
	}
}