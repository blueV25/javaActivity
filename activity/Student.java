package activity;
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private float gpa;

    public Student(int studentId, String firstName, String lastName, int gradeLevel, float gpa){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return ("******************************************\n"  +
        "Student ID: " + studentId + "\n" +
        " \n" +
        "Student First Name: " + firstName + "\n" +
        "\n"  +
        "Student Last Name:  " + lastName + "\n" +
        "\n" +
        "Student GradeLevel: " + gradeLevel + "\n" +
        "\n" +
        "Student GPA: " + gpa + "\n" +
        "\n"
        );
    }
}

