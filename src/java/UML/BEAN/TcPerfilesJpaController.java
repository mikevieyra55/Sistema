/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TcPerfiles;
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
public class TcPerfilesJpaController implements Serializable {

    public TcPerfilesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcPerfiles tcPerfiles) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcPerfiles);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcPerfiles tcPerfiles) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcPerfiles = em.merge(tcPerfiles);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcPerfiles.getIdPerfil();
                if (findTcPerfiles(id) == null) {
                    throw new NonexistentEntityException("The tcPerfiles with id " + id + " no longer exists.");
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
            TcPerfiles tcPerfiles;
            try {
                tcPerfiles = em.getReference(TcPerfiles.class, id);
                tcPerfiles.getIdPerfil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcPerfiles with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcPerfiles);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcPerfiles> findTcPerfilesEntities() {
        return findTcPerfilesEntities(true, -1, -1);
    }

    public List<TcPerfiles> findTcPerfilesEntities(int maxResults, int firstResult) {
        return findTcPerfilesEntities(false, maxResults, firstResult);
    }

    private List<TcPerfiles> findTcPerfilesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcPerfiles.class));
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

    public TcPerfiles findTcPerfiles(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcPerfiles.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcPerfilesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcPerfiles> rt = cq.from(TcPerfiles.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
