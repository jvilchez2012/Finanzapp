/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.GestionEgresos;
import model.GestionEgresos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.RenglonesEgresos;
import model.TiposEgresos;
import model.TiposPagos;

/**
 *
 * @author klkne
 */
@Stateless
public class GestionEgresosFacade extends AbstractFacade<GestionEgresos> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionEgresosFacade() {
        super(GestionEgresos.class);
    }

    public boolean isIdReglonEgresoEmpty(GestionEgresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GestionEgresos> gestionEgresos = cq.from(GestionEgresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gestionEgresos, entity), cb.isNotNull(gestionEgresos.get(GestionEgresos_.idReglonEgreso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public RenglonesEgresos findIdReglonEgreso(GestionEgresos entity) {
        return this.getMergedEntity(entity).getIdReglonEgreso();
    }

    public boolean isIdTipoEgresoEmpty(GestionEgresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GestionEgresos> gestionEgresos = cq.from(GestionEgresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gestionEgresos, entity), cb.isNotNull(gestionEgresos.get(GestionEgresos_.idTipoEgreso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposEgresos findIdTipoEgreso(GestionEgresos entity) {
        return this.getMergedEntity(entity).getIdTipoEgreso();
    }

    public boolean isIdTipoPagoEmpty(GestionEgresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GestionEgresos> gestionEgresos = cq.from(GestionEgresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gestionEgresos, entity), cb.isNotNull(gestionEgresos.get(GestionEgresos_.idTipoPago)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposPagos findIdTipoPago(GestionEgresos entity) {
        return this.getMergedEntity(entity).getIdTipoPago();
    }
    
}
