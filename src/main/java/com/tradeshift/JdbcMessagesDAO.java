package com.tradeshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class JdbcMessagesDAO implements MessagesDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS messages (id uuid, username text, message text, postedAt text)");
    }

    public List<Message> getMessages(int limit) {
        try {
            System.out.println(this.jdbcTemplate.getDataSource().getConnection());
            List<Message> messages = new ArrayList<Message>();
            String sql = "SELECT * FROM messages limit " + limit;
            List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
            for (Map row : rows) {
                Message message = new Message();
                message.setId((UUID) row.get("id"));
                message.setUser((String) row.get("username"));
                message.setMessage((String) row.get("message"));
                message.setPostedAt((String) row.get("postedAt"));
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveMessage(final Message msg){
        int ret = this.jdbcTemplate.update("insert into messages(id, username, message, postedAt) "
                + "values (?, ?, ?, ?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1, msg.getId());
                ps.setString(2, msg.getUser());
                ps.setString(3, msg.getMessage());
                ps.setString(4, msg.getPostedAt());
            }
        });

        System.out.println(">>>>>save(): ret: " + ret);
    }
}
