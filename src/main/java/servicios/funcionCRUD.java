/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author AllanRamiro
 */
public abstract class funcionCRUD<T> {

    private Class<T> entityClass;

    public funcionCRUD(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    
    //Crear nuevos registros
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    //Editar registros
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    //Eliminar registros
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    //buscar registros
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    //Listar registros
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    //Listar un rango de registros
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    
    //Contar registros
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
