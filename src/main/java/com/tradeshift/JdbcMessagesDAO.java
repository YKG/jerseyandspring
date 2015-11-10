package com.tradeshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class JdbcMessagesDAO implements MessagesDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getMessagesCount() {
        try {
            System.out.println(this.jdbcTemplate.getDataSource().getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
