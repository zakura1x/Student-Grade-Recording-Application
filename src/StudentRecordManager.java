import java.util.ArrayList;
import static java.lang.System.out;

public class StudentRecordManager{
    private static ArrayList <Student> students = new ArrayList<Student>();

    //Get the ArrayList of Students from the FileManip class
    public static void getStudentsFromFileManip(ArrayList <Student> list){
        students = list;
    }
    
    //Method to add a student to the ArrayList
    public static void addStudent(){
        out.println("Add Student Grade Record");
        out.println("------------------------");

        out.print("Enter Student Number (XX-XXXX): ");
        String studentNo = ConsoleInput.getStringInput();
        //Check if the input student number is already in the ArrayList and if it is, ask the user to input another student number
        //Check if the input student number is empty and if it is, ask the user to input another student number
        //Check if the input student number is in an incorrect format, ask the user to input proper format
        while (studentNo.isEmpty() || getStudent(studentNo) != null || studentNo.length() != 8 || studentNo.charAt(2) != '-'){
            if (studentNo.isEmpty()){
                out.print("Student Number is Empty. Please input proper format: ");
            }
            else if (getStudent(studentNo) != null){
                out.print("Student Number already exists. Please input another Student Number: ");
            }
            else if (studentNo.length() != 8){
                out.print("Student Number is not in the correct format. Please input Student Number in the format XX-XXXX: ");
            }
            else if (studentNo.charAt(2) != '-'){
                out.print("Student Number is not in the correct format. Please input Student Number in the format XX-XXXX: ");
            }

            studentNo = ConsoleInput.getStringInput();
        }

        out.print("Enter Student Last Name: ");
        String studentLastName = ConsoleInput.getStringInput();
        //Check if there are no input for student last name and if there is none, ask the user to input another student last name
        while (studentLastName.isEmpty()){
            out.print("Please input Student Last Name: ");
            studentLastName = ConsoleInput.getStringInput();
        }

        out.print("Enter Student First Name: ");
        String studentFirstName = ConsoleInput.getStringInput();
        //Check if there are no input for student first name and if there is none, ask the user to input another student first name
        while (studentFirstName.isEmpty()){
            out.print("Please input Student First Name");
            studentFirstName = ConsoleInput.getStringInput();
        }

        out.print("Enter: Student Middle Initial: ");    
        String studentMiddleInitial = ConsoleInput.getStringInput();
        //Check if there are no input for student middle initial and if there is none, ask the user to input another student middle initial
        while (studentMiddleInitial.isEmpty()){
            out.print("Please input Student Middle Initial");
            studentMiddleInitial = ConsoleInput.getStringInput();
        }

        out.print("Enter Gender [M/F]: ");
        char studentGender = ConsoleInput.getCharacterInput();
        studentGender = Character.toUpperCase(studentGender);
        //Check if there are no input for student gender and if there is none, ask the user to input another student
        while (studentGender != 'M' && studentGender != 'F'){
            out.print("Pleasse input student's gender [M/F]: ");
            studentGender = ConsoleInput.getCharacterInput();
            studentGender = Character.toUpperCase(studentGender);
        }

        out.print("Enter Mathematics Grade: ");
        int mathGrade = ConsoleInput.getIntInput();
        //Check if the input math grade is less than 0 or greater than 100 and if it is, ask the user to input another math grade
        while (mathGrade < 60 || mathGrade > 100){
            out.print("Please input Mathematics Grade [60-100]: ");
            mathGrade = ConsoleInput.getIntInput();
        }

        out.print("Enter Science & Technology Grade: ");
        int scienceGrade = ConsoleInput.getIntInput();
        //Check if the input science grade is less than 0 or greater than 100 and if it is, ask the user to input another science grade
        while (scienceGrade < 60 || scienceGrade > 100){
            out.print("Please input Science & Technology Grade [60-100]: ");
            scienceGrade = ConsoleInput.getIntInput();
        }

        out.print("Enter English Grade: ");
        int englishGrade = ConsoleInput.getIntInput();
        //Check if the input english grade is less than 0 or greater than 100 and if it is, ask the user to input another english grade
        while (englishGrade < 60 || englishGrade > 100){
            out.print("Please input English Grade [60-100]: ");
            englishGrade = ConsoleInput.getIntInput();
        }

        out.print("Enter Filipino Grade: ");
        int filipinoGrade = ConsoleInput.getIntInput();
        //Check if the input filipino grade is less than 0 or greater than 100 and if it is, ask the user to input another filipino grade
        while (filipinoGrade < 60 || filipinoGrade > 100){
            out.print("Please input Filipino Grade [60-100]: ");
            filipinoGrade = ConsoleInput.getIntInput();
        }

        out.print("Enter Makabayan Grade: ");
        int makabayanGrade = ConsoleInput.getIntInput();
        //Check if the input makabayan grade is less than 0 or greater than 100 and if it is, ask the user to input another makabayan grade
        while (makabayanGrade < 60 || makabayanGrade > 100){
            out.print("Please input Makabayan Grade [60-100]: ");
            makabayanGrade = ConsoleInput.getIntInput();
        }

        Student student = new Student(studentNo, studentLastName, studentFirstName, studentMiddleInitial, studentGender, mathGrade, scienceGrade, englishGrade, filipinoGrade, makabayanGrade);
        students.add(student);
    }

    //Method to display the students in the ArrayList
    public static void viewStudents(){
        out.println("\nView Student Grade Record");
        out.println("---------------------------");      
        //Sort the students by their name
        students.sort((Student s1, Student s2) -> s1.GetStudentName().compareTo(s2.GetStudentName()));
        
        displayStudents();
    }

    //Delete student record from the studentFile.txt
    public static void deleteStudent(){
        out.println("Delete Student Grade Record");
        out.println("---------------------------");

        out.print("Enter Student Number of the student to delete: ");
        String studentNo = ConsoleInput.getStringInput();

        Student student = getStudent(studentNo);
        if (student != null){
            students.remove(student);
            out.println("Student Grade Record Deleted!");
        }
        else{
            out.println("Student Grade Record not found!");
        }
    }

    //Get the student from the ArrayList
    //Return null if the student is not found
    private static Student getStudent(String studentNo) {
        for (Student student : students){
            if (student.GetStudentNo().equals(studentNo)){
                return student;
            }
        }
        return null;
    }

    //Update new student record to the arraylist
    public static void updateStudent(){
        out.println("Update Student Grade Record");
        out.println("---------------------------");

        out.print("Enter Student Number of the student to update: ");
        String studentNo = ConsoleInput.getStringInput();

        Student student = getStudent(studentNo);
        if (student != null){
            out.print("Enter New Student Last Name (current Last Name: " + student.GetStudentLN() + "): ");
            String studentLastName = ConsoleInput.getStringInput();
                if (!studentLastName.isEmpty()){
                    student.SetStudentLN(studentLastName);
                }
            out.print("Enter New Student First Name (current First Name: " + student.GetStudentFN() + "): ");
            String studentFirstName = ConsoleInput.getStringInput();
                if (!studentFirstName.isEmpty()){
                    student.SetStudentFN(studentFirstName);
                }
            out.print("Enter New Student Middle Initial (current Middle Initial: " + student.GetStudentMI() + "): ");
            String studentMiddleInitial = ConsoleInput.getStringInput();
                if (!studentMiddleInitial.isEmpty()){
                    student.SetStudentMI(studentMiddleInitial);
                }
            out.print("Enter new Gender [M/F] (current Gender: " + student.GetStudentGender() + "): ");
            char studentGender = ConsoleInput.getCharacterInput();
            studentGender = Character.toUpperCase(studentGender);
                if (studentGender == 'M' || studentGender == 'F'){
                    studentGender = Character.toUpperCase(studentGender);
                    student.SetStudentGender(studentGender);
                }
            out.print("Enter New Mathematics Grade (current Mathematics Grade: " + student.GetMathGrade() + "): ");
            int mathGrade = ConsoleInput.getIntInput();
                if (mathGrade > 60 || mathGrade < 100){
                    student.SetMathGrade(mathGrade);
                }
            out.print("Enter New Science & Technology Grade (current Science & Technology Grade: " + student.GetScienceGrade() + "): ");
            int scienceGrade = ConsoleInput.getIntInput();
                if (scienceGrade > 60 || scienceGrade < 100){
                    student.SetScienceGrade(scienceGrade);
                }
            out.print("Enter New English Grade (current English Grade: " + student.GetEnglishGrade() + "): ");
            int englishGrade = ConsoleInput.getIntInput();
                if (englishGrade > 60 || englishGrade < 100){
                    student.SetEnglishGrade(englishGrade);
                }
            out.print("Enter New Filipino Grade (current Filipino Grade: " + student.GetFilipinoGrade() + "): ");
            int filGrade = ConsoleInput.getIntInput();
                if (filGrade > 60 || filGrade < 100){
                    student.SetFilipinoGrade(filGrade);
                }
            out.print("Enter New Makabayan Grade (current Makabayan Grade: " + student.GetMakabayanGrade() + "): ");
            int makabayanGrade = ConsoleInput.getIntInput();
                if (makabayanGrade > 60 || makabayanGrade < 100){
                    student.SetMakabayanGrade(makabayanGrade);
                }
            
            out.println("\n-----------------------------");
            out.println("Student Grade Record Updated!");          
        }
        else{
            out.println("\nStudent Grade Record not found!");
        }
    }

    //Method to display the students base on their ranking
    public static void viewStudentRanking() {
        out.println("\nView Student Grade Ranking");
        out.println("----------------------------");
        
        //Sort the students by their GWA
        students.sort((s1, s2) -> Double.compare(s2.GetWeightedAverage(), s1.GetWeightedAverage()));
        
        displayStudents();
    }

    //Method to display the top N students
    public static void viewTopNStudents() {
        out.println("\nView Top N Students");
        out.println("---------------------");

        out.print("Enter number of students to view: ");
        int n = ConsoleInput.getIntInput();

        //Check if the number of students to view is greater than the number of students
        if (n > students.size()){
            out.println("\nNumber of students to view is greater than the number of students!");
        }else{
            //Print the table header
            out.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
            out.println("| NO | STUD NO. | NAME                          | SEX | S&T | MAT | ENG | FIL | MAK | GWA   |");
            
            //Sort the students by their GWA
            students.sort((s1, s2) -> Double.compare(s2.GetWeightedAverage(), s1.GetWeightedAverage()));
            
            for (int i = 0; i < n && i < students.size(); i++) {
                Student student = students.get(i);
                out.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
                //Get the student count
                int studentCount = students.indexOf(student) + 1;
                out.print("| ");
                out.format("%02d", studentCount);
                
                //Check the number of characters in the student name
                //Put proper spacing for the table
                int nameLength = student.GetStudentName().length();
                int spaceLength = 30 - nameLength;
                String spaces = "";
                for (int x = 0; x < spaceLength; x++){
                    spaces += " ";
                }
                out.print(" | " + student.GetStudentNo() + " | " + student.GetStudentName() + spaces + "| " + student.GetStudentGender() + "   | ");
                
                //If the student has a grade of < 75 print f for its field
                if (student.GetScienceGrade() < 74){
                    out.print("F   | ");
                }else{
                    out.print(student.GetScienceGrade() + "  | ");
                }
                if (student.GetMathGrade() < 74){
                    out.print("F   | ");
                }else{
                    out.print(student.GetMathGrade() + "  | ");
                }
                if (student.GetEnglishGrade() < 74){
                    out.print("F   | ");
                }else{
                    out.print(student.GetEnglishGrade() + "  | ");
                }
                if (student.GetFilipinoGrade() < 74){
                    out.print("F   | ");
                }else{
                    out.print(student.GetFilipinoGrade() + "  | ");
                }
                if (student.GetMakabayanGrade() < 74){
                    out.print("F   | ");
                }else{
                    out.print(student.GetMakabayanGrade() + "  | ");
                }
                
                //Print the GWA of the student
                out.print( String.format("%.2f",student.GetWeightedAverage()) + " |");

                out.println();
            }
            out.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
        }
    }

    //Method to display the students
    public static void displayStudents(){
        out.println("\n+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
        out.println("| NO | STUD NO. | NAME                          | SEX | S&T | MAT | ENG | FIL | MAK | GWA   |");
        
        for (Student student : students){
            out.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
            //Get the student count
            int studentCount = students.indexOf(student) + 1;
            out.print("| ");
            out.format("%02d", studentCount);
            
            //Check the number of characters in the student name
            //Put proper spacing for the table
            int nameLength = student.GetStudentName().length();
            int spaceLength = 30 - nameLength;
            String spaces = "";
            for (int i = 0; i < spaceLength; i++){
                spaces += " ";
            }
            out.print(" | " + student.GetStudentNo() + " | " + student.GetStudentName() + spaces + "| " + student.GetStudentGender() + "   | ");
            
            //If the student has a grade of < 75 print f for its field
            if (student.GetScienceGrade() < 74){
                out.print(" F  | ");
            }else{
                out.print(student.GetScienceGrade() + "  | ");
            }
            if (student.GetMathGrade() < 74){
                out.print(" F  | ");
            }else{
                out.print(student.GetMathGrade() + "  | ");
            }
            if (student.GetEnglishGrade() < 74){
                out.print(" F  | ");
            }else{
                out.print(student.GetEnglishGrade() + "  | ");
            }
            if (student.GetFilipinoGrade() < 74){
                out.print(" F  | ");
            }else{
                out.print(student.GetFilipinoGrade() + "  | ");
            }
            if (student.GetMakabayanGrade() < 74){
                out.print(" F  | ");
            }else{
                out.print(student.GetMakabayanGrade() + "  | ");
            }
            
            //Print the GWA of the student
            out.print( String.format("%.2f",student.GetWeightedAverage()) + " |");

            out.println();
        }
        out.println("+----+----------+-------------------------------+-----+-----+-----+-----+-----+-----+-------+");
    }
}