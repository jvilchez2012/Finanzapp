/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.RegistroTransacciones;
import model.RegistroTransacciones_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.TiposPagos;
import model.Usuarios;

/**
 *
 * @author klkne
 */
@Stateless
public class RegistroTransaccionesFacade extends AbstractFacade<RegistroTransacciones> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroTransaccionesFacade() {
        super(RegistroTransacciones.class);
    }

    public boolean isIdTipoPagoEmpty(RegistroTransacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistroTransacciones> registroTransacciones = cq.from(RegistroTransacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registroTransacciones, entity), cb.isNotNull(registroTransacciones.get(RegistroTransacciones_.idTipoPago)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposPagos findIdTipoPago(RegistroTransacciones entity) {
        return this.getMergedEntity(entity).getIdTipoPago();
    }

    public boolean isIdUsuarioEmpty(RegistroTransacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistroTransacciones> registroTransacciones = cq.from(RegistroTransacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registroTransacciones, entity), cb.isNotNull(registroTransacciones.get(RegistroTransacciones_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuarios findIdUsuario(RegistroTransacciones entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }
    
}
