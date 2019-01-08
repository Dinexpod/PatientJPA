package mate.academy.jpddemo.model.model;

import mate.academy.jpddemo.model.ConnectionUtil;
import mate.academy.jpddemo.model.test.Test;
import mate.academy.jpddemo.model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
import java.util.Queue;

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

    public List<Test> getAllTests() {
        List<String> tests = new ArrayList<>();
        final String SELECT = "SELECT * FROM tests";
        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<Test> query = session.createNamedQuery(SELECT, Test.class);


        return session.createCriteria(Test.class).list();
    }

    public List<Patient> getAllPatient() {

        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<Test> query = session.createNamedQuery(SELECT, Test.class);


        return session.createQuery("select t from  patient t", Patient.class).getResultList();
    }




    List<Test> getAllTestsInDateRange(LocalDateTime from, LocalDateTime to) {
        List<Test> tests = new ArrayList<>();

        return tests;
    }
}
