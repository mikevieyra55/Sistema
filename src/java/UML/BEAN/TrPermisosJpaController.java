/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TrPermisos;
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
public class TrPermisosJpaController implements Serializable {

    public TrPermisosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrPermisos trPermisos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trPermisos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrPermisos trPermisos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trPermisos = em.merge(trPermisos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trPermisos.getIdPermiso();
                if (findTrPermisos(id) == null) {
                    throw new NonexistentEntityException("The trPermisos with id " + id + " no longer exists.");
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
            TrPermisos trPermisos;
            try {
                trPermisos = em.getReference(TrPermisos.class, id);
                trPermisos.getIdPermiso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trPermisos with id " + id + " no longer exists.", enfe);
            }
            em.remove(trPermisos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrPermisos> findTrPermisosEntities() {
        return findTrPermisosEntities(true, -1, -1);
    }

    public List<TrPermisos> findTrPermisosEntities(int maxResults, int firstResult) {
        return findTrPermisosEntities(false, maxResults, firstResult);
    }

    private List<TrPermisos> findTrPermisosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrPermisos.class));
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

    public TrPermisos findTrPermisos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrPermisos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrPermisosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrPermisos> rt = cq.from(TrPermisos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
