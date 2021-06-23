/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.TiposIngresos;
import model.TiposIngresos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.GestionIngresos;

/**
 *
 * @author klkne
 */
@Stateless
public class TiposIngresosFacade extends AbstractFacade<TiposIngresos> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposIngresosFacade() {
        super(TiposIngresos.class);
    }

    public boolean isGestionIngresosCollectionEmpty(TiposIngresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposIngresos> tiposIngresos = cq.from(TiposIngresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposIngresos, entity), cb.isNotEmpty(tiposIngresos.get(TiposIngresos_.gestionIngresosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<GestionIngresos> findGestionIngresosCollection(TiposIngresos entity) {
        TiposIngresos mergedEntity = this.getMergedEntity(entity);
        Collection<GestionIngresos> gestionIngresosCollection = mergedEntity.getGestionIngresosCollection();
        gestionIngresosCollection.size();
        return gestionIngresosCollection;
    }
    
}
