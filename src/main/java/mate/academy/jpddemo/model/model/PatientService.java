package mate.academy.jpddemo.model.model;

import mate.academy.jpddemo.model.ConnectionUtil;
import mate.academy.jpddemo.model.test.Test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private static  Connection connection = ConnectionUtil.getConnection();

//    public List<Test> getAllTests() {
//        List<Test> tests = new ArrayList<>();
//        final String SELECT = "SELECT * FROM tests";
//
//        try {
//            PreparedStatement statement = connection.prepareStatement(SELECT);
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                Test test = getTest(rs);
//                tests.add(test);
//            }
//
//            return tests;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return tests;
//    }

    public List<String> getAllTests() {
        List<String> tests = new ArrayList<>();
        final String SELECT = "SELECT * FROM tests";

            String get = null;
            try{

                PreparedStatement stmt = connection.prepareStatement(SELECT);
                ResultSet rs = stmt.executeQuery();
                while (rs.next())
                {
                    tests.add(rs.getString("name"));
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return tests;
        }



    private Test getTest(ResultSet rs) throws SQLException {
        Test test = new Test();
        test.setId(rs.getInt("test_id"));
        test.setLocation(rs.getString("location"));
        test.setName(rs.getString("name"));
//        Test.Type.valueOf(rs.getString("type"));

        return test;
    }

    List<Test> getAllTestsInDateRange(LocalDateTime from, LocalDateTime to) {
        List<Test> tests = new ArrayList<>();

        return tests;
    }
}
