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
import model.TiposPagos;
import model.TiposPagos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.RegistroTransacciones;
import model.GestionEgresos;

/**
 *
 * @author klkne
 */
@Stateless
public class TiposPagosFacade extends AbstractFacade<TiposPagos> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposPagosFacade() {
        super(TiposPagos.class);
    }

    public boolean isRegistroTransaccionesCollectionEmpty(TiposPagos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposPagos> tiposPagos = cq.from(TiposPagos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposPagos, entity), cb.isNotEmpty(tiposPagos.get(TiposPagos_.registroTransaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistroTransacciones> findRegistroTransaccionesCollection(TiposPagos entity) {
        TiposPagos mergedEntity = this.getMergedEntity(entity);
        Collection<RegistroTransacciones> registroTransaccionesCollection = mergedEntity.getRegistroTransaccionesCollection();
        registroTransaccionesCollection.size();
        return registroTransaccionesCollection;
    }

    public boolean isGestionEgresosCollectionEmpty(TiposPagos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposPagos> tiposPagos = cq.from(TiposPagos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposPagos, entity), cb.isNotEmpty(tiposPagos.get(TiposPagos_.gestionEgresosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<GestionEgresos> findGestionEgresosCollection(TiposPagos entity) {
        TiposPagos mergedEntity = this.getMergedEntity(entity);
        Collection<GestionEgresos> gestionEgresosCollection = mergedEntity.getGestionEgresosCollection();
        gestionEgresosCollection.size();
        return gestionEgresosCollection;
    }
    
}
