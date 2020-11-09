/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.BEAN;

import UML.BEAN.exceptions.NonexistentEntityException;
import UML.TcCuestionarios;
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
public class TcCuestionariosJpaController implements Serializable {

    public TcCuestionariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TcCuestionarios tcCuestionarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tcCuestionarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TcCuestionarios tcCuestionarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tcCuestionarios = em.merge(tcCuestionarios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tcCuestionarios.getIdCuestionario();
                if (findTcCuestionarios(id) == null) {
                    throw new NonexistentEntityException("The tcCuestionarios with id " + id + " no longer exists.");
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
            TcCuestionarios tcCuestionarios;
            try {
                tcCuestionarios = em.getReference(TcCuestionarios.class, id);
                tcCuestionarios.getIdCuestionario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tcCuestionarios with id " + id + " no longer exists.", enfe);
            }
            em.remove(tcCuestionarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TcCuestionarios> findTcCuestionariosEntities() {
        return findTcCuestionariosEntities(true, -1, -1);
    }

    public List<TcCuestionarios> findTcCuestionariosEntities(int maxResults, int firstResult) {
        return findTcCuestionariosEntities(false, maxResults, firstResult);
    }

    private List<TcCuestionarios> findTcCuestionariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TcCuestionarios.class));
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

    public TcCuestionarios findTcCuestionarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TcCuestionarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getTcCuestionariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TcCuestionarios> rt = cq.from(TcCuestionarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
