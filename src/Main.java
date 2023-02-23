/*
 * @Title: Student Grade Recording Application
 * @Author : Zeus A. Tenerife
 * @DateCreated: 01/03/2023
 */

import static java.lang.System.out;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        //File Path
        String directory = "D:\\Users\\Babo\\Documents\\2nd Year 1st sem Programming\\OOP1-Final Project\\Tenerife,ZA_OOP1FinalProject\\Student Grade Recording Application";
        String fileName = "StudentFile.txt";
        String fileName2 = "StudentList.txt";

        //Create File
        FileManip file = new FileManip();
        file.createNewFile(directory, fileName, fileName2);

        //Load File from StudentFile.txt and store it in an ArrayList
        FileManip.loadFile(directory, fileName2);
        StudentRecordManager.getStudentsFromFileManip(FileManip.getStudents());

        //Variables needed for loop controls
        boolean quit = false;
        char choice;

        //PROGRAM HEADER AND MAIN MENU
        mainMenu();
        choice = ConsoleInput.getCharacterInput();

        do{
            switch (choice){
                case 'a':
                case 'A':
                    StudentRecordManager.addStudent();
                    break;
                case 'b':
                case 'B':
                    StudentRecordManager.updateStudent();
                    break;
                case 'c':
                case 'C':
                    StudentRecordManager.deleteStudent();
                    break;
                case 'd':
                case 'D':
                    StudentRecordManager.viewStudents();
                    break;
                case 'e':
                case 'E':
                    StudentRecordManager.viewStudentRanking();
                    break;
                case 'f':
                case 'F':
                    StudentRecordManager.viewTopNStudents();
                    break;
                case 'x':
                case 'X':
                    quit = true;
                    out.println("\n--PROGRAM TERMINATED--");
                    break;
                default:
                    out.println("\nInvalid Input");
                    break;
            }

            //Save Student Record
            saveFiles(directory, fileName, fileName2);
            
            if(quit){ //Break the loop if the user wants to quit the program
                break;
            }

            do{
                out.println("\nPress 'Y' to return to Main Menu or 'N' to Quit Application");
                choice = ConsoleInput.getCharacterInput();
                if(choice == 'y' || choice == 'Y'){
                    mainMenu();
                    choice = ConsoleInput.getCharacterInput();
                    break;
                }else if(choice == 'n' || choice == 'N'){
                    quit = true;
                    out.println("--PROGRAM TERMINATED--");
                    break;
                }else{
                    out.println("Invalid Input");
                }
            }while(true);


            }while (!quit);
        
    }

    public static void mainMenu(){ //Main Menu method
        out.println("STUDENT GRADE RECORDING APPLICATION");
        out.println("-----------------------------------");
        out.println("Main Menu:");
        out.println("\t[A] Add Student Grade Record");
        out.println("\t[B] Update Student Grade Record");
        out.println("\t[C] Delete Student Grade Record");
        out.println("\t[D] View Student Grade Record");
        out.println("\t[E] View Student Grade Ranking");
        out.println("\t[F] View Top N Students");
        out.println("\t[X] Quit Application");
        out.println();
        out.print("\t>> Enter your choice: ");
    }
    
    //Save the Student Record data
    public static void saveFiles(String directory, String filename, String fileName2) throws IOException{
        FileManip.saveFile(directory, fileName2);
        FileManip.saveMainFile(directory, filename);
    }

}
