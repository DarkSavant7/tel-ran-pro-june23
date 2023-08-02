package de.telran.practice.lectures.oop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseExample {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static String insertStatement = "insert into students (name, score) values (?, ?);";
    private static String exampleCall = "{call do_something_prc(?,?,?)}";


    public static void main(String[] args) {
        try {
            connect();
            createDB();
//            dropTable();
            simpleInsert();
            simpleDelete();
            simpleUpdate();
            simpleRead();
            notReallyCorrectInsert("Petya Petrov", 75);
//            notReallyCorrectInsert("Sidor Sidorov", 75);
//            notReallyCorrectInsert("Sidor Sidorov', 75); delete from students;", 75);
//            preparedInsert("Sidor Sidorov", 75);
            preparedInsert("Sidor Sidorov', 75); delete from students;", 75);
//            massInsertExample();
            batchInsertExample();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void batchInsertExample() throws SQLException {
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "Student# " + i);
            preparedStatement.setInt(2, i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void massInsertExample() throws SQLException {
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedInsert("Student# " + i, i);
//            if (i == 10) connection.commit();
//            if (i == 15) throw new RuntimeException();
        }
//            connection.commit();
//        connection.rollback();
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void preparedInsert(String name, int score) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, score);
        preparedStatement.executeUpdate();
    }

    private static void notReallyCorrectInsert(String name, int score) throws SQLException {
        statement.executeUpdate("insert into students (name, score) values (\'" + name + "\', " + score + ");");
    }

    private static void simpleRead() throws SQLException {
        try (ResultSet resultSet = statement.executeQuery("select name as student_name, score from students;")) {
            while (resultSet.next()) {
                System.out.printf("Student: %s score %s\n",
                        resultSet.getString(1),
                        resultSet.getInt("score"));
            }
        }
    }

    private static void simpleUpdate() throws SQLException {
        statement.executeUpdate("update students set name = 'Ivan Ivanov' where score > 90");
    }

    private static void simpleDelete() throws SQLException {
        statement.executeUpdate("delete from students where id = 1 or name like '%Morz%' or score > 99;");
    }

    private static void simpleInsert() throws SQLException {
        int insertedRows = statement
                .executeUpdate("insert into students (name, score) values ('Vasya Pupkin', 80), ('Kolya Morzhov', 90), ('Vitaly Petrov', 100);");
        System.out.println(insertedRows);
    }

    private static void dropTable() throws SQLException {
        statement.execute("drop table if exists students;");
    }

    private static void createDB() throws SQLException {
        statement = connection.createStatement();
//        statement = connection.prepareStatement();
//        statement = connection.prepareCall();
        statement.execute("create table if not exists students (id integer primary key autoincrement, name text, score integer);");
        preparedStatement = connection.prepareStatement(insertStatement);
//        CallableStatement cs = connection.prepareCall(exampleCall);
    }

    private static void connect() throws SQLException {
        //Раньше требовалось проинициализировать драйвер
//        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:db/example.db");
    }

    private static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
