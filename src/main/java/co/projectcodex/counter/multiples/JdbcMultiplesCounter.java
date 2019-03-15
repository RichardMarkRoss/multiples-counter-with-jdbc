package co.projectcodex.counter.multiples;

import co.projectcodex.counter.MultiplesCounter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMultiplesCounter implements MultiplesCounter {

    final String COUNT_UPDATE_SQL = "update multiple set counter = ? where multiple = ?";
    final String COUNT_FIND_SQL = "select counter from multiple where multiple = ?";
    final String COUNT_INSERT_SQL = "insert into multiple (multiple, counter) values (? ,?)";

    final PreparedStatement updateCountPreparedStatement;
    final PreparedStatement findCountPreparedStatement;
    final PreparedStatement insertCountPreparedStatement;

    private int multiple;
    private int value;

    public JdbcMultiplesCounter(int multiple, Connection connection) throws SQLException {
        this.multiple = multiple;

        updateCountPreparedStatement = connection.prepareStatement(COUNT_UPDATE_SQL);
        findCountPreparedStatement = connection.prepareStatement(COUNT_FIND_SQL);
        insertCountPreparedStatement = connection.prepareStatement(COUNT_INSERT_SQL);

        value = getCurrentCounterValue();
    }

    private int getCurrentCounterValue() throws SQLException {
        findCountPreparedStatement.setInt(1, multiple);
        ResultSet rs = findCountPreparedStatement.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    private boolean updateCounterValue(int value) throws SQLException {
        updateCountPreparedStatement.setInt(1, value);
        updateCountPreparedStatement.setInt(2, multiple);
        return updateCountPreparedStatement.execute();
    }

    private void insertCounterValue(int multiple, int value) throws SQLException {
        insertCountPreparedStatement.setInt(1, value);
        insertCountPreparedStatement.setInt(2, multiple);
        insertCountPreparedStatement.execute();
    }

    public void count() {
        this.value += this.multiple;
        try {
            if (!updateCounterValue(this.value)) {
                insertCounterValue(this.multiple, this.value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int value() {
        return this.value;
    }

}
