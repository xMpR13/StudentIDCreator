package prospermpuru.studentregistrationapp;

import java.io.*;
import java.util.ArrayList;

public class Logic {
    private final ArrayList<Student> list = new ArrayList<>();
    private int index;

    public Logic() throws IOException {
        //must load list from a file and add to the list arraylist
        File file = new File("students.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str = "";

        while((str = bufferedReader.readLine()) != null){
            String[] details = str.split("#");
            String name = details[0];
            String surname = details[1];
            int student_number = Integer.parseInt(details[2]);
            String course = details[3];
            String password = details[4];
            String res = details[1];
            Student s = new Student(
                    name,
                    surname,
                    student_number,
                    course,
                    password,
                    res
            );
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
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
        for(int i = 0; i < list.size(); i++) {
            if (stud.getStudentNumber() == list.get(i).getStudentNumber()){
                return true;
            }
        }
        list.add(stud);
        return false;
    }

    //for debugging purposes, gets all the students in the list
    public void getList(){
        for (int i = 0; i < list.size(); i++){
            System.out.println("Name: " + list.get(i).getName() + ", surname: " + list.get(i).getSurname());
        }
    }
}
