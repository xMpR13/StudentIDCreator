package prospermpuru.studentregistrationapp;

import java.util.ArrayList;

public class Logic {
    private ArrayList<Student> list = new ArrayList<>();

    public Logic() {
        //must load list from a file and add to the list arraylist
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
