package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.StudentDao;
import mthree.com.fullstackschool.model.Course;
import mthree.com.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    //YOUR CODE STARTS HERE

    StudentDao dao;
    StudentServiceImpl(StudentDao dao){
        this.dao = dao;
    }

    //YOUR CODE ENDS HERE

    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        return dao.getAllStudents();

        //YOUR CODE ENDS HERE
    }

    public Student getStudentById(int id) {
        //YOUR CODE STARTS HERE


        Student s = dao.findStudentById(id);

        if (s == null){
            s = new Student();
            s.setStudentFirstName("Student Not Found");
            s.setStudentLastName("Student Not Found");
        }
        return s;

        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE

        return dao.createNewStudent(student);

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE

        if (id == student.getStudentId()) {
            dao.updateStudent(student);

            return student;
        }
        student.setStudentFirstName("IDs do not match, student not updated");
        student.setStudentLastName("IDs do not match, student not updated");
        return student;
        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE


        //YOUR CODE ENDS HERE
    }
}
