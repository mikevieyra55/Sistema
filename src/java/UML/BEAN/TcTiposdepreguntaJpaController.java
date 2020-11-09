/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TcTiposdepregunta;
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
public class TcTiposdepreguntaJpaController implements Serializable {

    public TcTiposdepreguntaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcTiposdepregunta tcTiposdepregunta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcTiposdepregunta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcTiposdepregunta tcTiposdepregunta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcTiposdepregunta = em.merge(tcTiposdepregunta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcTiposdepregunta.getIdTipoDePregunta();
                if (findTcTiposdepregunta(id) == null) {
                    throw new NonexistentEntityException("The tcTiposdepregunta with id " + id + " no longer exists.");
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
            TcTiposdepregunta tcTiposdepregunta;
            try {
                tcTiposdepregunta = em.getReference(TcTiposdepregunta.class, id);
                tcTiposdepregunta.getIdTipoDePregunta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcTiposdepregunta with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcTiposdepregunta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcTiposdepregunta> findTcTiposdepreguntaEntities() {
        return findTcTiposdepreguntaEntities(true, -1, -1);
    }

    public List<TcTiposdepregunta> findTcTiposdepreguntaEntities(int maxResults, int firstResult) {
        return findTcTiposdepreguntaEntities(false, maxResults, firstResult);
    }

    private List<TcTiposdepregunta> findTcTiposdepreguntaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcTiposdepregunta.class));
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

    public TcTiposdepregunta findTcTiposdepregunta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcTiposdepregunta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcTiposdepreguntaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcTiposdepregunta> rt = cq.from(TcTiposdepregunta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
