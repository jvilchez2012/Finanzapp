/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ProcesoCorte;

/**
 *
 * @author klkne
 */
@Stateless
public class ProcesoCorteFacade extends AbstractFacade<ProcesoCorte> {

    @PersistenceContext(unitName = "FinanzAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesoCorteFacade() {
        super(ProcesoCorte.class);
    }
    
}
