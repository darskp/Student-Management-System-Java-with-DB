package dao;

import model.Student;

public interface StudentDaoInterface {
    public boolean insertStudent(Student s);
    public boolean delete (int roll);
    public boolean update(int roll,String update,int ch,Student S);
    public void showAllStudent();
    public boolean showStudentByID(int roll);
    public boolean checkStudentRollno(int roll);
}
