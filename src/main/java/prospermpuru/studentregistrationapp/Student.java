package prospermpuru.studentregistrationapp;

public class Student {
    private final String name;
    private final String surname;
    private final int studentNumber;
    private final String courseName;
    private final String password;
    private final String resName;

    public Student(String name, String surname, int studentNumber, String courseName, String password, String resName) {
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
        this.courseName = courseName;
        this.password = password;
        this.resName = resName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getPassword() {
        return password;
    }

    public String getResName() {
        return resName;
    }
}
