/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TrRespuestas;
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
public class TrRespuestasJpaController implements Serializable {

    public TrRespuestasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrRespuestas trRespuestas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trRespuestas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrRespuestas trRespuestas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trRespuestas = em.merge(trRespuestas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trRespuestas.getIdRespuesta();
                if (findTrRespuestas(id) == null) {
                    throw new NonexistentEntityException("The trRespuestas with id " + id + " no longer exists.");
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
            TrRespuestas trRespuestas;
            try {
                trRespuestas = em.getReference(TrRespuestas.class, id);
                trRespuestas.getIdRespuesta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trRespuestas with id " + id + " no longer exists.", enfe);
            }
            em.remove(trRespuestas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrRespuestas> findTrRespuestasEntities() {
        return findTrRespuestasEntities(true, -1, -1);
    }

    public List<TrRespuestas> findTrRespuestasEntities(int maxResults, int firstResult) {
        return findTrRespuestasEntities(false, maxResults, firstResult);
    }

    private List<TrRespuestas> findTrRespuestasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrRespuestas.class));
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

    public TrRespuestas findTrRespuestas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrRespuestas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrRespuestasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrRespuestas> rt = cq.from(TrRespuestas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
