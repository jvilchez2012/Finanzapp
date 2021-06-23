/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.GestionIngresos;
import model.GestionIngresos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.TiposIngresos;

/**
 *
 * @author klkne
 */
@Stateless
public class GestionIngresosFacade extends AbstractFacade<GestionIngresos> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionIngresosFacade() {
        super(GestionIngresos.class);
    }

    public boolean isIdTipoIngresoEmpty(GestionIngresos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GestionIngresos> gestionIngresos = cq.from(GestionIngresos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gestionIngresos, entity), cb.isNotNull(gestionIngresos.get(GestionIngresos_.idTipoIngreso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposIngresos findIdTipoIngreso(GestionIngresos entity) {
        return this.getMergedEntity(entity).getIdTipoIngreso();
    }
    
}
