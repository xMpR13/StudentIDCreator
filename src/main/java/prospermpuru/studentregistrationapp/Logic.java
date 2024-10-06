package prospermpuru.studentregistrationapp;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Logic {
    private final ArrayList<Student> list = new ArrayList<>();
    private int index;
    private final Alert alert = new Alert(Alert.AlertType.NONE);

    public Logic() throws IOException {
        //must load list from a file and add to the list arraylist
        File file = new File("students.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str;

        while((str = bufferedReader.readLine()) != null){
            Student s = getStudent(str);
            list.add(s);
        }
    }

    private static Student getStudent(String str) {
        String[] details = str.split("#");
        String name = details[0];
        String surname = details[1];
        int student_number = Integer.parseInt(details[2]);
        String course = details[3];
        String password = details[4];
        String res = details[5];
        return new Student(
                name,
                surname,
                student_number,
                course,
                password,
                res
        );
    }

    public boolean login(String password, int student_number) {
        for (int i = 0; i < list.size(); i++) {
            if (password.equals(list.get(i).getPassword()) && student_number == list.get(i).getStudentNumber()) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public Student getStudent(){
        return new Student(
                list.get(index).getName(),
                list.get(index).getSurname(),
                list.get(index).getStudentNumber(),
                list.get(index).getCourseName(),
                list.get(index).getPassword(),
                list.get(index).getResName()
        );
    }

    //checks if the student is registered or not
    public boolean checkRegistered(Student stud){
        for (Student student : list) {
            if (stud.getStudentNumber() == student.getStudentNumber()) {
                return true;
            }
        }
        list.add(stud);
        return false;
    }

    public void error_pop_up(String title, String header, String content_text){
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content_text);
        alert.showAndWait();
    }
}
