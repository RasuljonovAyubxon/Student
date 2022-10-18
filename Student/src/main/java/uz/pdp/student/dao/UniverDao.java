package uz.pdp.student.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import uz.pdp.student.model.Univer;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UniverDao {
    private final JdbcTemplate jdbcTemplate;


    public void cerate(Univer Univer) {
        String sql = "insert into univer (name,street,student_id) values(?,?,?);";
        jdbcTemplate.execute(sql);
    }

    public List<Univer> read() {
        String sql = "select * from univer;";
        return jdbcTemplate.query(sql, (rs, row) ->
                Univer.builder()
                        .name(rs.getString(1))
                        .street(rs.getString(2))
                        .build()

        );
    }

    public void update(Univer univer) {
        String sql = "update univer set name = ?, street = ? where id = ?;";
        int update = jdbcTemplate.update(sql, univer.getName(), univer.getStreet(), univer.getId());
        System.out.println("update = " + update);
    }

    public int delete(int id) {
        String sql = "delete from univer where id = ?;";
        try {
            jdbcTemplate.update(sql, id);
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }

}
