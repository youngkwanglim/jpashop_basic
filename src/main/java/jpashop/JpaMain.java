package jpashop;

import jpashop.domain.Book;
import jpashop.domain.Order;
import jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Book book = new Book();
            book.setName("리버풀");
            book.setAuthor("클롭");

            Book book2 = new Book();
            book2.setName("맨시티");
            book2.setAuthor("펩");

            em.persist(book);
            //em.persist(book2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
