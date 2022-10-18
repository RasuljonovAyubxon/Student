package uz.pdp.student.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import uz.pdp.student.model.Student;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {

    private final JdbcTemplate jdbcTemplate;


    public void cerate(Student student) {
        String sql = "insert into student (name,age,surname) values(?,?,?);";
        jdbcTemplate.execute(sql);
    }

    public List<Student> read() {
        String sql = "select * from student;";
        return jdbcTemplate.query(sql, (rs, row) ->
                Student.builder()
                        .name(rs.getString(1))
                        .age(rs.getInt(2))
                        .surname(rs.getString(3))
                        .build()

        );
    }

    public void update(Student student) {
        String sql = "update student set name = ?, age = ?,surname=?  where id = ?;";
        int update = jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getSurname(), student.getId());
        System.out.println("update = " + update);
    }

    public int delete(int id) {
        String sql = "delete from student where id = ?;";
        try {
            jdbcTemplate.update(sql, id);
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }

}
