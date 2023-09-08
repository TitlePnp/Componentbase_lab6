/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentjpa_ex6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;
import model.StudentTable;

/**
 *
 * @author tleku
 */
public class StudentJPA_ex6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student std1 = new Student(1, "John", 4.00);
       Student std2 = new Student(2, "Marry", 4.00);
       StudentTable.insertStudent(std1);
       StudentTable.insertStudent(std2);
       //Student emp;
       //emp = StudentTable.findStudentById(1);
       //if (emp != null) {
       //    emp.setName("Jack");
           //StudentTable.removeStudent(emp);
       //    StudentTable.updateStudent(emp);
       //}
       //List<Student> empList = StudentTable.findStudentByName("Marry"); 
       //List<Student> stdList = StudentTable.findAllStudent();
       //printAllStudent(stdList);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPA_ex6PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }
    
}
