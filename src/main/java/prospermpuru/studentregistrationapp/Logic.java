package prospermpuru.studentregistrationapp;

import java.util.ArrayList;

public class Logic {
    private ArrayList<Student> list = new ArrayList<>();

    public Logic() {
        //must load list from a file and add to the list arraylist
<<<<<<< HEAD
<<<<<<< HEAD
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
            String res = details[5];
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
=======
>>>>>>> parent of f894385 (Added Registration Logic)
=======
>>>>>>> parent of f894385 (Added Registration Logic)
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
}
