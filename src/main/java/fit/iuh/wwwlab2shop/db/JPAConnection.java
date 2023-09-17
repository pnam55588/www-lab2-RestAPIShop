package fit.iuh.wwwlab2shop.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConnection {
    private static JPAConnection instance;
    private EntityManager em;
    private EntityManagerFactory emf;

    public  JPAConnection(){
        try {
            emf = Persistence.createEntityManagerFactory("CRM");
            em = emf.createEntityManager();
        }catch (Exception e){
            throw  new RuntimeException(e);
        }

    }
    public static synchronized JPAConnection getInstance() {
        if(instance == null){
            instance = new JPAConnection();
        }
        return instance;
    }

    public EntityManager getEm() {
        return em;
    }

    public void close(){
        em.close();
    }
}
