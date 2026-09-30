package mthree.com.fullstackschool.dao;

import mthree.com.fullstackschool.dao.mappers.TeacherMapper;
import mthree.com.fullstackschool.model.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private final JdbcTemplate jdbcTemplate;

    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Teacher createNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE

        jdbcTemplate.update("INSERT INTO teacher(tid, tFName, tLName, dept) VALUES(?, ?, ?, ?);", teacher.getTeacherId(), teacher.getTeacherFName(), teacher.getTeacherLName(), teacher.getDept());
        return teacher;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE

        return jdbcTemplate.query("SELECT * FROM teacher", new TeacherMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Teacher findTeacherById(int id) {
        //YOUR CODE STARTS HERE

        return jdbcTemplate.query("SELECT * FROM teacher WHERE tid = " + id + ";", new TeacherMapper()).get(0);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateTeacher(Teacher t) {
        //YOUR CODE STARTS HERE

        jdbcTemplate.update("UPDATE teacher SET tFName = '" + t.getTeacherFName() + "', " +
                "tLName = '" + t.getTeacherLName() + "', " +
                "dept = '" + t.getDept() + "' " +
                "WHERE tid = " + t.getTeacherId() + ";");

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteTeacher(int id) {
        //YOUR CODE STARTS HERE

        jdbcTemplate.update("DELETE teacher WHERE tid = " + id + ";");

        //YOUR CODE ENDS HERE
    }
}
