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
import model.RenglonesEgresos;
import model.RenglonesEgresos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.GestionEgresos;

/**
 *
 * @author klkne
 */
@Stateless
public class RenglonesEgresosFacade extends AbstractFacade<RenglonesEgresos> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RenglonesEgresosFacade() {
        super(RenglonesEgresos.class);
    }

    public boolean isGestionEgresosCollectionEmpty(RenglonesEgresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RenglonesEgresos> renglonesEgresos = cq.from(RenglonesEgresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(renglonesEgresos, entity), cb.isNotEmpty(renglonesEgresos.get(RenglonesEgresos_.gestionEgresosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<GestionEgresos> findGestionEgresosCollection(RenglonesEgresos entity) {
        RenglonesEgresos mergedEntity = this.getMergedEntity(entity);
        Collection<GestionEgresos> gestionEgresosCollection = mergedEntity.getGestionEgresosCollection();
        gestionEgresosCollection.size();
        return gestionEgresosCollection;
    }
    
}
