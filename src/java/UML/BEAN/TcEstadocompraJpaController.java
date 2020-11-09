/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.BEAN.exceptions.PreexistingEntityException;
import UML.TcEstadocompra;
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
public class TcEstadocompraJpaController implements Serializable {

    public TcEstadocompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcEstadocompra tcEstadocompra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcEstadocompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTcEstadocompra(tcEstadocompra.getIdEstadoCompra()) != null) {
                throw new PreexistingEntityException("TcEstadocompra " + tcEstadocompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcEstadocompra tcEstadocompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcEstadocompra = em.merge(tcEstadocompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcEstadocompra.getIdEstadoCompra();
                if (findTcEstadocompra(id) == null) {
                    throw new NonexistentEntityException("The tcEstadocompra with id " + id + " no longer exists.");
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
            TcEstadocompra tcEstadocompra;
            try {
                tcEstadocompra = em.getReference(TcEstadocompra.class, id);
                tcEstadocompra.getIdEstadoCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcEstadocompra with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcEstadocompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcEstadocompra> findTcEstadocompraEntities() {
        return findTcEstadocompraEntities(true, -1, -1);
    }

    public List<TcEstadocompra> findTcEstadocompraEntities(int maxResults, int firstResult) {
        return findTcEstadocompraEntities(false, maxResults, firstResult);
    }

    private List<TcEstadocompra> findTcEstadocompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcEstadocompra.class));
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

    public TcEstadocompra findTcEstadocompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcEstadocompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcEstadocompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcEstadocompra> rt = cq.from(TcEstadocompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
