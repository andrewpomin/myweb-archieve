package myprojects.sql;

import myprojects.secure.SecureData;

import java.sql.*;

public class SQLDispatcher {

    static {
        registerDriver();
        try {
            long start = System.currentTimeMillis();
            Connection connection = DriverManager.getConnection(SecureData.getDataBaseURL());
            System.out.println("Get connection in " + (System.currentTimeMillis() - start) + " milliseconds.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed on connection");
        }
    }

    public static void createSession(int userId, String sessionId, long createTime) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql1 = "UPDATE users SET session_id = ?, create_time_session = ?, is_login = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, sessionId);
            preparedStatement.setLong(2, createTime);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setInt(4, userId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement, null);
        }
    }

    public static boolean isSessionLogin(String sessionId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql = "SELECT is_login FROM users WHERE session_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sessionId);
            rs = preparedStatement.executeQuery();
            boolean isLogin = false;
            if (rs.next()) {
                isLogin = rs.getBoolean("is_login");
            }

            return isLogin;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement, rs);
        }
        return false;
    }

    public static void registerUser(String emailUser, String passwordUser, String firstNameUser, String lastNameUser,
                                    String phoneUser, String sessionId, long createTime) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql1 = "INSERT INTO users(firstname, lastname, phone, email, password, session_id, " +
                    "create_time_session, is_login) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, firstNameUser);
            preparedStatement.setString(2, lastNameUser);
            preparedStatement.setString(3, phoneUser);
            preparedStatement.setString(4, emailUser);
            preparedStatement.setString(5, passwordUser);
            preparedStatement.setString(6, sessionId);
            preparedStatement.setLong(7, createTime);
            preparedStatement.setBoolean(8, true);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement, null);
        }
    }

    public static boolean isUserExists(String loginUser, String passwordUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql = "SELECT id FROM users WHERE email = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginUser);
            preparedStatement.setString(2, passwordUser);
            rs = preparedStatement.executeQuery();
            long id = 0;
            if (rs.next()) {
                id = rs.getLong("id");
            }

            return id != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement, rs);
        }
        return false;
    }

    public static boolean isUserExists(String loginUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql = "SELECT id FROM users WHERE email = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginUser);
            rs = preparedStatement.executeQuery();
            long id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
            }

            return id != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement, rs);
        }
        return false;
    }

    public static int getUserId(String loginUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql = "SELECT id FROM users WHERE email = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginUser);
            rs = preparedStatement.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
            }

            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement, rs);
        }
        return 0;
    }

    public static void logoutUser(String sessionId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(SecureData.getDataBaseURL());

            String sql = "UPDATE users SET is_login = ? WHERE session_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, sessionId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStreams(connection, preparedStatement,  null);
        }
    }

    public static void registerDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void closeStreams(Connection c, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
