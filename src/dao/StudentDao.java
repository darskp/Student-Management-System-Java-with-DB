package dao;

import model.Student;

public class StudentDao implements StudentDaoInterface{

    @Override
    public boolean delete(int roll) {
        
        return false;
    }

    @Override
    public boolean insertStudent(Student s) {
        
        return false;
    }

    @Override
    public void showAllStudent() {
       
        
    }

    @Override
    public boolean showStudentByID(int roll) {
        return false;
    }

    @Override
    public boolean update(int roll, String update, int ch, Student S) {
        return false;
    }


    
}
