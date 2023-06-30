package transaction.model.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import transaction.connection.Conn;

/**
 *
 * @author Khanza
 */
public class BuyJdbcImplement implements BuyJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public BuyJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<ResponseListTableBuy> selectBuys(String search) {
        List<ResponseListTableBuy> buys = new ArrayList<>();
        try {
            sql = "SELECT a.id, c.name, e.name, a.buy_price, a.date "
                    + "FROM buy a "
                    + "LEFT JOIN supplier c ON a.id_supplier = c.id "
                    + "LEFT JOIN item e ON a.id_item = e.id "
                    + "WHERE a.id LIKE ? "
                    + "OR c.name LIKE ? "
                    + "OR e.name LIKE ? "
                    + "OR a.buy_price LIKE ? "
                    + "OR a.date LIKE ? "
                    + "ORDER BY a.id DESC";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, search);
            preparedStatement.setString(2, search);
            preparedStatement.setString(3, search);
            preparedStatement.setString(4, search);
            preparedStatement.setString(5, search);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ResponseListTableBuy buy = new ResponseListTableBuy();
                buy.setId(resultSet.getLong(1));
                buy.getSupplier().setName(resultSet.getString(2));
                buy.getItem().setName(resultSet.getString(3));
                buy.setBuyPrice(resultSet.getBigDecimal(4));
                buy.setDate(resultSet.getTimestamp(5).toLocalDateTime());
                buys.add(buy);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return buys;
    }

    @Override
    public void insertBuy(Buy buy) {
        try {
            sql = "INSERT INTO buy VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, buy.getId());
            preparedStatement.setLong(2, buy.getSupplier().getId());
            preparedStatement.setLong(3, buy.getItem().getId());
            preparedStatement.setBigDecimal(4, buy.getBuyPrice());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(buy.getDate()));
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateBuy(Buy buy) {
        try {
            sql = "UPDATE buy SET "
                    + "id_supplier = ?, "
                    + "id_item = ?, "
                    + "buy_price = ?, "
                    + "WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, buy.getSupplier().getId());
            preparedStatement.setLong(2, buy.getItem().getId());
            preparedStatement.setBigDecimal(3, buy.getBuyPrice());
            preparedStatement.setLong(4, buy.getId());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteBuy(Long id) {
        try {
            sql = "DELETE FROM buy WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
