/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.BEAN.exceptions.PreexistingEntityException;
import UML.TrOrdendetrabajo;
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
public class TrOrdendetrabajoJpaController implements Serializable {

    public TrOrdendetrabajoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrOrdendetrabajo trOrdendetrabajo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trOrdendetrabajo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTrOrdendetrabajo(trOrdendetrabajo.getIdOrdenDeTrabajo()) != null) {
                throw new PreexistingEntityException("TrOrdendetrabajo " + trOrdendetrabajo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrOrdendetrabajo trOrdendetrabajo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trOrdendetrabajo = em.merge(trOrdendetrabajo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trOrdendetrabajo.getIdOrdenDeTrabajo();
                if (findTrOrdendetrabajo(id) == null) {
                    throw new NonexistentEntityException("The trOrdendetrabajo with id " + id + " no longer exists.");
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
            TrOrdendetrabajo trOrdendetrabajo;
            try {
                trOrdendetrabajo = em.getReference(TrOrdendetrabajo.class, id);
                trOrdendetrabajo.getIdOrdenDeTrabajo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trOrdendetrabajo with id " + id + " no longer exists.", enfe);
            }
            em.remove(trOrdendetrabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrOrdendetrabajo> findTrOrdendetrabajoEntities() {
        return findTrOrdendetrabajoEntities(true, -1, -1);
    }

    public List<TrOrdendetrabajo> findTrOrdendetrabajoEntities(int maxResults, int firstResult) {
        return findTrOrdendetrabajoEntities(false, maxResults, firstResult);
    }

    private List<TrOrdendetrabajo> findTrOrdendetrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrOrdendetrabajo.class));
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

    public TrOrdendetrabajo findTrOrdendetrabajo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrOrdendetrabajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrOrdendetrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrOrdendetrabajo> rt = cq.from(TrOrdendetrabajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
