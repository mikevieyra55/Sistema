/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.BEAN.exceptions.PreexistingEntityException;
import UML.TrAbonos;
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
public class TrAbonosJpaController implements Serializable {

    public TrAbonosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrAbonos trAbonos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trAbonos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTrAbonos(trAbonos.getIdAbono()) != null) {
                throw new PreexistingEntityException("TrAbonos " + trAbonos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrAbonos trAbonos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trAbonos = em.merge(trAbonos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trAbonos.getIdAbono();
                if (findTrAbonos(id) == null) {
                    throw new NonexistentEntityException("The trAbonos with id " + id + " no longer exists.");
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
            TrAbonos trAbonos;
            try {
                trAbonos = em.getReference(TrAbonos.class, id);
                trAbonos.getIdAbono();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trAbonos with id " + id + " no longer exists.", enfe);
            }
            em.remove(trAbonos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrAbonos> findTrAbonosEntities() {
        return findTrAbonosEntities(true, -1, -1);
    }

    public List<TrAbonos> findTrAbonosEntities(int maxResults, int firstResult) {
        return findTrAbonosEntities(false, maxResults, firstResult);
    }

    private List<TrAbonos> findTrAbonosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrAbonos.class));
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

    public TrAbonos findTrAbonos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrAbonos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrAbonosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrAbonos> rt = cq.from(TrAbonos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
