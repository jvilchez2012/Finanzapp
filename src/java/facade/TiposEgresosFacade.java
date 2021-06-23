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
import model.TiposEgresos;
import model.TiposEgresos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.GestionEgresos;

/**
 *
 * @author klkne
 */
@Stateless
public class TiposEgresosFacade extends AbstractFacade<TiposEgresos> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposEgresosFacade() {
        super(TiposEgresos.class);
    }

    public boolean isGestionEgresosCollectionEmpty(TiposEgresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposEgresos> tiposEgresos = cq.from(TiposEgresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposEgresos, entity), cb.isNotEmpty(tiposEgresos.get(TiposEgresos_.gestionEgresosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<GestionEgresos> findGestionEgresosCollection(TiposEgresos entity) {
        TiposEgresos mergedEntity = this.getMergedEntity(entity);
        Collection<GestionEgresos> gestionEgresosCollection = mergedEntity.getGestionEgresosCollection();
        gestionEgresosCollection.size();
        return gestionEgresosCollection;
    }
    
}
