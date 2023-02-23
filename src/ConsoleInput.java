
//Class for inputs

import java.util.Scanner;

public class ConsoleInput{

    public static int getIntInput(){ //Method for integer input
        return new Scanner(System.in).nextInt();
    }

    public static char getCharacterInput(){ //Method for character input
        return new Scanner(System.in).next().charAt(0);
    }

    public static String getStringInput(){ //Method for string input
        return new Scanner(System.in).nextLine();
    }

}