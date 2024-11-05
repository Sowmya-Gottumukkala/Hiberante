package Day10.MavenHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Day10.MavenHibernateProject.model.example;

public class App {
    public static void main(String[] args) {
        // Create session factory and open session
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Begin the transaction
        Transaction t = session.beginTransaction();

        // Create example objects
        example actor1 = new example("Sowmya", "20"); // Set name and sub
        example actor2 = new example("Gayathri", "23");

        // Print actor1 details
        System.out.println("Actor 1 - Age: " + actor1.getSub() + ", Name: " + actor1.getName());

        // Print actor2 details
        System.out.println("Actor 2 - Age: " + actor2.getSub() + ", Name: " + actor2.getName());

        // Save actors to database
        session.save(actor1);
        session.save(actor2);

        // Commit transaction
        t.commit();

        // Close session and factory
        session.close();
        factory.close();

        System.out.println("Actors inserted successfully!");
    }
}

