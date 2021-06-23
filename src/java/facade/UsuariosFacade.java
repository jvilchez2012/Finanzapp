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
import model.Usuarios;
import model.Usuarios_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.RegistroTransacciones;

/**
 *
 * @author klkne
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public boolean isRegistroTransaccionesCollectionEmpty(Usuarios entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuarios> usuarios = cq.from(Usuarios.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuarios, entity), cb.isNotEmpty(usuarios.get(Usuarios_.registroTransaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistroTransacciones> findRegistroTransaccionesCollection(Usuarios entity) {
        Usuarios mergedEntity = this.getMergedEntity(entity);
        Collection<RegistroTransacciones> registroTransaccionesCollection = mergedEntity.getRegistroTransaccionesCollection();
        registroTransaccionesCollection.size();
        return registroTransaccionesCollection;
    }
    
}
