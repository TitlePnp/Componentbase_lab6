/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Phoom1645
 */
public class StudentTable {
    public static void insertStudent(Student emp) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentJPA_ex6PU");
        EntityManager em = stf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateStudent(Student std) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentJPA_ex6PU");
        EntityManager sd = stf.createEntityManager();
        Student fromDb = sd.find(Student.class, std.getId());
        fromDb.setName(std.getName());
        fromDb.setGpa(std.getGpa());
        sd.getTransaction().begin();
        try {
            sd.persist(fromDb);
            sd.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            sd.getTransaction().rollback();
        } finally {
            sd.close();
        }
    }
    public static Student findStudentById(Integer id) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentJPA_ex6PU");
        EntityManager sd = stf.createEntityManager();
        Student emp = sd.find(Student.class, id);
        sd.close();
        return emp;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentJPA_ex6PU");
        EntityManager sd = stf.createEntityManager();
        List<Student> stdList = (List<Student>) sd.createNamedQuery("Student.findAll").getResultList();
        sd.close();
        return stdList;
    }
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager sd = stf.createEntityManager();
        Query query = sd.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> stdList = (List<Student>) query.getResultList();
        sd.close();
        return stdList;
    }
    public static void removeStudent(Student std) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("StudentJPA_ex6PU");
        EntityManager sd = stf.createEntityManager();
        Student fromDb = sd.find(Student.class, std.getId());
        sd.getTransaction().begin();
        try {
            sd.remove(fromDb);
            sd.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            sd.getTransaction().rollback();
        } finally {
            sd.close();
        }
                
    }
}