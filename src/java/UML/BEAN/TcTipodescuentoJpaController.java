/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.BEAN.exceptions.PreexistingEntityException;
import UML.TcTipodescuento;
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
public class TcTipodescuentoJpaController implements Serializable {

    public TcTipodescuentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcTipodescuento tcTipodescuento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcTipodescuento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTcTipodescuento(tcTipodescuento.getIdTipoDescuento()) != null) {
                throw new PreexistingEntityException("TcTipodescuento " + tcTipodescuento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcTipodescuento tcTipodescuento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcTipodescuento = em.merge(tcTipodescuento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcTipodescuento.getIdTipoDescuento();
                if (findTcTipodescuento(id) == null) {
                    throw new NonexistentEntityException("The tcTipodescuento with id " + id + " no longer exists.");
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
            TcTipodescuento tcTipodescuento;
            try {
                tcTipodescuento = em.getReference(TcTipodescuento.class, id);
                tcTipodescuento.getIdTipoDescuento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcTipodescuento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcTipodescuento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcTipodescuento> findTcTipodescuentoEntities() {
        return findTcTipodescuentoEntities(true, -1, -1);
    }

    public List<TcTipodescuento> findTcTipodescuentoEntities(int maxResults, int firstResult) {
        return findTcTipodescuentoEntities(false, maxResults, firstResult);
    }

    private List<TcTipodescuento> findTcTipodescuentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcTipodescuento.class));
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

    public TcTipodescuento findTcTipodescuento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcTipodescuento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcTipodescuentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcTipodescuento> rt = cq.from(TcTipodescuento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
