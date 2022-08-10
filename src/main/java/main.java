import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {
    public static void main(String[] args) {
        SuenioSimple s1 = new SuenioSimple("viajar por el mundo", 120,"viajar");

        guardar(s1);
        actualizarSuenioSimplePorId(1);

    }

    private static void guardar(SuenioSimple _s) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("suenio");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(_s);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static SuenioSimple encontrarSuenioPorId(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("suenio");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            SuenioSimple s1 = em.find(SuenioSimple.class, id);
            return s1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    private static void actualizarSuenioSimplePorId(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("suenio");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
           SuenioSimple s1 = em.find(SuenioSimple.class, id);
            em.detach(s1);
            s1.setFelicidonios(150);
            em.merge(s1);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void eliminarSuenioSimplePorId(Long id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("suenio");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            SuenioSimple s1 = em.find(SuenioSimple.class, id);
            em.remove(s1);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}