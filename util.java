
import java.util.Scanner;
import java.io.IOException;

public class util {

    static Scanner kb = new Scanner(System.in);

    /**
     * Force the user to input a valid integer in a range of two integers
     * 
     * @param msg The message we want to print
     * @param min The minimum value accepted
     * @param max The maximum value accepted
     * @return The valid integer
     */
    public static int askIntRange(String msg, int min, int max) {
        fastPrint("" + msg + " (" + min + "/" + max + ") : ");
        while (!kb.hasNextInt()) {
            fastPrint("! Please enter a valid number : ");
            kb.next();
        }
        int result = kb.nextInt();
        kb.nextLine(); /* Delete '\n' char in 'kb' buffer */
        while (result < min || result > max) {
            fastPrint("! Please enter a number between " + min + " and " + max + " : ");
            while (!kb.hasNextInt()) {
                fastPrint("! Please enter a valid number : ");
                kb.next();
            }
            result = kb.nextInt();
            kb.nextLine(); /* Delete '\n' char in 'kb' buffer */
        }
        return result;
    }

    /**
     * Choose a random integer in a range of two integers
     * 
     * @param min The minimum value of the random integer
     * @param max The maximum value of the random integer
     * @return The random integer between min and max
     */
    public static int randomIntRange(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    /**
     * Check if a variable is an integer or not
     * 
     * @param item The variable we want to check
     * @return True or False if the variable is a valid integer or not
     */
    public static boolean isInt(String item) {
        try {
            Integer.parseInt(item);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Print a message and wait for the user to press 'Enter'
     */
    public static void enter() {
        fastPrint("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception ex) {
            fastPrint("! Unexpected 'read' error");
            sleep(1);
        }
    }

    /**
     * Lovely way to print a message like a typewriter The method waits 10 ms after
     * printing each char of the msg
     * 
     * @param msg The message we want to print
     */
    public static void fastPrint(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '\n') {
                System.out.println();
            } else {
                System.out.print(msg.charAt(i));
                sleep(0.01);
            }
        }
    }

    /**
     * Lovely way to print a message like a typewriter The method waits 100 ms after
     * printing each char of the msg Then waits 1 sec after the entire msg
     * 
     * @param msg
     */
    public static void slowPrint(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '\n') {
                System.out.println();
            } else {
                System.out.print(msg.charAt(i));
                sleep(0.1);
            }
        }
        sleep(1);
    }

    /**
     * Print "See you :) !" in the same way as slowPrint() I really don't know why I
     * didn't use the slowPrint() method but here we are lol Then clear the screen
     */
    public static void seeYou() {
        char[] msg = { 'S', 'e', 'e', ' ', 'y', 'o', 'u', ' ', ':', ')', ' ', '!' };
        for (int i = 0; i < msg.length; i++) {
            System.out.print(msg[i]);
            sleep(0.1);
        }
        sleep(1);
        clearScreen();
    }

    /**
     * The program waits a certain number of milliseconds before continuing
     * 
     * @param s The number of milliseconds
     */
    public static void sleep(double s) {
        int ms = (int) (s * 1000);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            fastPrint("! <error> ('sleep' method)");
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Clear the screen of the user (I'm sure this works on Windows, and I hope this
     * will work on Linux and MacOs too... I'm praying !)
     */
    public static void clearScreen() {
        String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("! <error> ('clearScreen' method)");
            sleep(1);
        }
    }
}
