import java.io.*;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileManip {
    
    private static ArrayList <Student> list;

    //Getter for ArrayList
    public static ArrayList <Student> getStudents() {
        return list;
    }

    //Constructor
    public FileManip() {
        list = new ArrayList <Student>();
    }

    //Method to load file from StudentList.txt
    //Store data in ArrayList
    public static void loadFile(String directory, String fileName2) throws IOException{

        File file = new File(directory, fileName2);
        Scanner readFile = new Scanner (file);
        StringTokenizer token = null;

        while(readFile.hasNextLine()){
            String data = readFile.nextLine();
            token = new StringTokenizer(data, "|");
            String studentNo = token.nextToken();
            String studentLN = token.nextToken();
            String studentFN = token.nextToken();
            String studentMI = token.nextToken();
            char studentGender = token.nextToken().charAt(0);
            int mathGrade = Integer.parseInt(token.nextToken());
            int scienceGrade = Integer.parseInt(token.nextToken());
            int englishGrade = Integer.parseInt(token.nextToken());
            int filipinoGrade = Integer.parseInt(token.nextToken());
            int makabayanGrade = Integer.parseInt(token.nextToken());

            Student student = new Student(studentNo, studentLN, studentFN, studentMI, studentGender, mathGrade, scienceGrade, englishGrade, filipinoGrade, makabayanGrade);
            list.add(student);
        }
        readFile.close();
    }

    //Method to save data in ArrayList to StudentList.txt
    public static void saveFile(String directory, String fileName) throws FileNotFoundException{
        File file = new File(directory, fileName);
        PrintWriter writeFile = new PrintWriter(file);

        for (Student student : list){
            writeFile.println(student.GetStudentNo() + "|" + student.GetStudentLN() + "|" + student.GetStudentFN() + "|" + student.GetStudentMI() + "|" + student.GetStudentGender() + "|" + student.GetMathGrade() + "|" + student.GetScienceGrade() + "|" + student.GetEnglishGrade() + "|" + student.GetFilipinoGrade() + "|" + student.GetMakabayanGrade());
        }
        writeFile.close();
    }

    //Method to create a new file and directory
    public void createNewFile(String directory, String fileName, String fileName2){
        File file = new File(directory);

        if(!file.exists()){
            file.mkdir();
        }

        File textfile = new File(directory, fileName);

        try {
            textfile.createNewFile();
        } catch (IOException e) {
            out.println("File already exists.");
        }

        File textfile2 = new File(directory, fileName2);

        try {
            textfile2.createNewFile();
        } catch (IOException e) {
            out.println("An error occurred.");
        }
    }

    //Method to save the data in ArrayList to StudentFile.txt
    public static void saveMainFile(String directory, String fileName) throws FileNotFoundException{
        File file = new File(directory, fileName);
        PrintWriter writeFile = new PrintWriter(file);

        writeFile.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
        writeFile.println("| NO | STUD NO. | NAME                          | SEX | S&T | MAT | ENG | FIL | MAK | GWA   |");
        
        for (Student student : list){
            writeFile.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
            //Get the student count
            int studentCount = list.indexOf(student) + 1;
            writeFile.print("| ");
            writeFile.format("%02d", studentCount);
            
            //Check the number of characters in the student name
            //Put proper spacing for the table
            int nameLength = student.GetStudentName().length();
            int spaceLength = 30 - nameLength;
            String spaces = "";
            for (int i = 0; i < spaceLength; i++){
                spaces += " ";
            }
            writeFile.print(" | " + student.GetStudentNo() + " | " + student.GetStudentName() + spaces + "| " + student.GetStudentGender() + "   | ");
            
            //If the student has a grade of < 75 print f for its field
            if (student.GetScienceGrade() < 74){
                writeFile.print(" F  | ");
            }else{
                writeFile.print(student.GetScienceGrade() + "  | ");
            }
            if (student.GetMathGrade() < 74){
                writeFile.print(" F  | ");
            }else{
                writeFile.print(student.GetMathGrade() + "  | ");
            }
            if (student.GetEnglishGrade() < 74){
                writeFile.print(" F  | ");
            }else{
                writeFile.print(student.GetEnglishGrade() + "  | ");
            }
            if (student.GetFilipinoGrade() < 74){
                writeFile.print(" F  | ");
            }else{
                writeFile.print(student.GetFilipinoGrade() + "  | ");
            }
            if (student.GetMakabayanGrade() < 74){
                writeFile.print(" F  | ");
            }else{
                writeFile.print(student.GetMakabayanGrade() + "  | ");
            }
            
            //Print the GWA of the student
            writeFile.print(String.format("%.2f",student.GetWeightedAverage()) + " |");

            writeFile.println();
        }
        writeFile.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");

        writeFile.close();
    }

    
}

