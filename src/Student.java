public class Student {

    //Students Information
    private String StudentNo, StudentFN, StudentLN, StudentMI;
    private char StudentGender;
    private int MathGrade, ScienceGrade, EnglishGrade, FilipinoGrade, MakabayanGrade;

    //Constructor
    Student (String StudentNo, String StudentLN, String StudentFN, String StudentMI, char StudentGender, int MathGrade, int ScienceGrade, int EnglishGrade, int FilipinoGrade, int MakabayanGrade){
        this.StudentNo = StudentNo;
        this.StudentLN = StudentLN;
        this.StudentFN = StudentFN;
        this.StudentMI = StudentMI;
        this.StudentGender = StudentGender;
        this.MathGrade = MathGrade;
        this.ScienceGrade = ScienceGrade;
        this.EnglishGrade = EnglishGrade;
        this.FilipinoGrade = FilipinoGrade;
        this.MakabayanGrade = MakabayanGrade;
    }
    
    //Setter
    public void SetStudentNo(String StudentNo){
        this.StudentNo = StudentNo;
    }
    public void SetStudentLN(String StudentLN){
        this.StudentLN = StudentLN;
    }
    public void SetStudentFN(String StudentFN){
        this.StudentFN = StudentFN;
    }
    public void SetStudentMI(String StudentMI){
        this.StudentMI = StudentMI;
    }
    public void SetStudentGender(char StudentGender){
        this.StudentGender = StudentGender;
    }
    
    //Setter
    public void SetMathGrade(int MathGrade){
        this.MathGrade = MathGrade;
    }
    public void SetScienceGrade(int ScienceGrade){
        this.ScienceGrade = ScienceGrade;
    }
    public void SetEnglishGrade(int EnglishGrade){
        this.EnglishGrade = EnglishGrade;
    }
    public void SetFilipinoGrade(int FilipinoGrade){
        this.FilipinoGrade = FilipinoGrade;
    }
    public void SetMakabayanGrade(int MakabayanGrade){
        this.MakabayanGrade = MakabayanGrade;
    }

    //Getter
    public String GetStudentNo(){
        return StudentNo;
    }
    public String GetStudentLN(){
        return StudentLN;
    }
    public String GetStudentFN(){
        return StudentFN;
    }
    public String GetStudentMI(){
        return StudentMI;
    }
    public char GetStudentGender(){
        return StudentGender;
    }

    //Getter
    public int GetMathGrade(){
        return MathGrade;
    }
    public int GetScienceGrade(){
        return ScienceGrade;
    }
    public int GetEnglishGrade(){
        return EnglishGrade;
    }
    public int GetFilipinoGrade(){
        return FilipinoGrade;
    }
    public int GetMakabayanGrade(){
        return MakabayanGrade;
    }

    //Calculate the Average
    public double GetWeightedAverage(){
        double totalUnits = 2.0 + 2.0 + 1.5 + 1.5 + 4.0;
        double totalGrade = (MathGrade * 2.0) + (ScienceGrade * 2.0) + (EnglishGrade * 1.5) + (FilipinoGrade * 1.5) + (MakabayanGrade * 4.0);
        
        //round to 2 decimal places
        return Math.round(totalGrade / totalUnits * 100.0) / 100.0;
    }

    //Get the Student Full Name
    public String GetStudentName(){
        return StudentLN + ", " + StudentFN + " " + StudentMI;
    }
    
}
