/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TrCompras;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ULISES.VIEYRA
 */
public class TrComprasJpaController implements Serializable {

    public TrComprasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrCompras trCompras) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trCompras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrCompras trCompras) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trCompras = em.merge(trCompras);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trCompras.getIdCompra();
                if (findTrCompras(id) == null) {
                    throw new NonexistentEntityException("The trCompras with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TrCompras trCompras;
            try {
                trCompras = em.getReference(TrCompras.class, id);
                trCompras.getIdCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trCompras with id " + id + " no longer exists.", enfe);
            }
            em.remove(trCompras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrCompras> findTrComprasEntities() {
        return findTrComprasEntities(true, -1, -1);
    }

    public List<TrCompras> findTrComprasEntities(int maxResults, int firstResult) {
        return findTrComprasEntities(false, maxResults, firstResult);
    }

    private List<TrCompras> findTrComprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrCompras.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TrCompras findTrCompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrCompras.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrComprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrCompras> rt = cq.from(TrCompras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
