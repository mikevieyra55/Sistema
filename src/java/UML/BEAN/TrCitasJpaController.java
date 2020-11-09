/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.BEAN.exceptions.PreexistingEntityException;
import UML.TrCitas;
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
public class TrCitasJpaController implements Serializable {

    public TrCitasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrCitas trCitas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trCitas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTrCitas(trCitas.getIdCita()) != null) {
                throw new PreexistingEntityException("TrCitas " + trCitas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrCitas trCitas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trCitas = em.merge(trCitas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trCitas.getIdCita();
                if (findTrCitas(id) == null) {
                    throw new NonexistentEntityException("The trCitas with id " + id + " no longer exists.");
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
            TrCitas trCitas;
            try {
                trCitas = em.getReference(TrCitas.class, id);
                trCitas.getIdCita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trCitas with id " + id + " no longer exists.", enfe);
            }
            em.remove(trCitas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrCitas> findTrCitasEntities() {
        return findTrCitasEntities(true, -1, -1);
    }

    public List<TrCitas> findTrCitasEntities(int maxResults, int firstResult) {
        return findTrCitasEntities(false, maxResults, firstResult);
    }

    private List<TrCitas> findTrCitasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrCitas.class));
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

    public TrCitas findTrCitas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrCitas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrCitasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrCitas> rt = cq.from(TrCitas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
