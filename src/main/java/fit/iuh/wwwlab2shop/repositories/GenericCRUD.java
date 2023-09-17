package fit.iuh.wwwlab2shop.repositories;
import fit.iuh.wwwlab2shop.db.JPAConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;



public abstract class GenericCRUD <T> {
    protected EntityManager em;
    public GenericCRUD(){
        em = JPAConnection.getInstance().getEm().getEntityManagerFactory().createEntityManager();
    }
    public boolean create(T t){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(t);
            tr.commit();
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
