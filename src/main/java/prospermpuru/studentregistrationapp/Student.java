package prospermpuru.studentregistrationapp;

public class Student {
    private String name;
    private String surname;
    private int studentNumber;
    private String courseName;
    private String password;

    public Student(String name, String surname, int studentNumber, String courseName, String password) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.courseName = courseName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
