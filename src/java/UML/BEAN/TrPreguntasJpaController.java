/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TrPreguntas;
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
public class TrPreguntasJpaController implements Serializable {

    public TrPreguntasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrPreguntas trPreguntas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trPreguntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrPreguntas trPreguntas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trPreguntas = em.merge(trPreguntas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trPreguntas.getIdPregunta();
                if (findTrPreguntas(id) == null) {
                    throw new NonexistentEntityException("The trPreguntas with id " + id + " no longer exists.");
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
            TrPreguntas trPreguntas;
            try {
                trPreguntas = em.getReference(TrPreguntas.class, id);
                trPreguntas.getIdPregunta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trPreguntas with id " + id + " no longer exists.", enfe);
            }
            em.remove(trPreguntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrPreguntas> findTrPreguntasEntities() {
        return findTrPreguntasEntities(true, -1, -1);
    }

    public List<TrPreguntas> findTrPreguntasEntities(int maxResults, int firstResult) {
        return findTrPreguntasEntities(false, maxResults, firstResult);
    }

    private List<TrPreguntas> findTrPreguntasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrPreguntas.class));
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

    public TrPreguntas findTrPreguntas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrPreguntas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrPreguntasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrPreguntas> rt = cq.from(TrPreguntas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
