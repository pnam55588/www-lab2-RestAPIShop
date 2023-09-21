package fit.iuh.wwwlab2shop.repositories;
import fit.iuh.wwwlab2shop.db.JPAConnection;
import fit.iuh.wwwlab2shop.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;


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
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<T> getAll(Class<T> clazz){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            List<T> list = em.createNativeQuery("select * from " + clazz.getSimpleName() + " e", clazz).getResultList();
            tr.commit();
            return list;
        }catch (Exception e){
                tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public T findById(Class<T> clazz, int id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            T obj = em.find(clazz, id);
            tr.commit();
            return obj;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean update(T t){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(t);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
