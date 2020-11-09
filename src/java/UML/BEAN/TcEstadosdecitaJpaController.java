/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.BEAN.exceptions.PreexistingEntityException;
import UML.TcEstadosdecita;
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
public class TcEstadosdecitaJpaController implements Serializable {

    public TcEstadosdecitaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcEstadosdecita tcEstadosdecita) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcEstadosdecita);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTcEstadosdecita(tcEstadosdecita.getIdEstadoDeCita()) != null) {
                throw new PreexistingEntityException("TcEstadosdecita " + tcEstadosdecita + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcEstadosdecita tcEstadosdecita) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcEstadosdecita = em.merge(tcEstadosdecita);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcEstadosdecita.getIdEstadoDeCita();
                if (findTcEstadosdecita(id) == null) {
                    throw new NonexistentEntityException("The tcEstadosdecita with id " + id + " no longer exists.");
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
            TcEstadosdecita tcEstadosdecita;
            try {
                tcEstadosdecita = em.getReference(TcEstadosdecita.class, id);
                tcEstadosdecita.getIdEstadoDeCita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcEstadosdecita with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcEstadosdecita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcEstadosdecita> findTcEstadosdecitaEntities() {
        return findTcEstadosdecitaEntities(true, -1, -1);
    }

    public List<TcEstadosdecita> findTcEstadosdecitaEntities(int maxResults, int firstResult) {
        return findTcEstadosdecitaEntities(false, maxResults, firstResult);
    }

    private List<TcEstadosdecita> findTcEstadosdecitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcEstadosdecita.class));
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

    public TcEstadosdecita findTcEstadosdecita(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcEstadosdecita.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcEstadosdecitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcEstadosdecita> rt = cq.from(TcEstadosdecita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
