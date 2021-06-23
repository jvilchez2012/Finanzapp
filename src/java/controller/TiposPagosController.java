package controller;

import model.TiposPagos;
import model.RegistroTransacciones;
import model.GestionEgresos;
import java.util.Collection;
import facade.TiposPagosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposPagosController")
@ViewScoped
public class TiposPagosController extends AbstractController<TiposPagos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroTransaccionesCollectionEmpty;
    private boolean isGestionEgresosCollectionEmpty;

    public TiposPagosController() {
        // Inform the Abstract parent controller of the concrete TiposPagos Entity
        super(TiposPagos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistroTransaccionesCollectionEmpty();
        this.setIsGestionEgresosCollectionEmpty();
    }

    public boolean getIsRegistroTransaccionesCollectionEmpty() {
        return this.isRegistroTransaccionesCollectionEmpty;
    }

    private void setIsRegistroTransaccionesCollectionEmpty() {
        TiposPagos selected = this.getSelected();
        if (selected != null) {
            TiposPagosFacade ejbFacade = (TiposPagosFacade) this.getFacade();
            this.isRegistroTransaccionesCollectionEmpty = ejbFacade.isRegistroTransaccionesCollectionEmpty(selected);
        } else {
            this.isRegistroTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistroTransacciones
     * entities that are retrieved from TiposPagos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistroTransacciones page
     */
    public String navigateRegistroTransaccionesCollection() {
        TiposPagos selected = this.getSelected();
        if (selected != null) {
            TiposPagosFacade ejbFacade = (TiposPagosFacade) this.getFacade();
            Collection<RegistroTransacciones> selectedRegistroTransaccionesCollection = ejbFacade.findRegistroTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistroTransacciones_items", selectedRegistroTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registroTransacciones/index";
    }

    public boolean getIsGestionEgresosCollectionEmpty() {
        return this.isGestionEgresosCollectionEmpty;
    }

    private void setIsGestionEgresosCollectionEmpty() {
        TiposPagos selected = this.getSelected();
        if (selected != null) {
            TiposPagosFacade ejbFacade = (TiposPagosFacade) this.getFacade();
            this.isGestionEgresosCollectionEmpty = ejbFacade.isGestionEgresosCollectionEmpty(selected);
        } else {
            this.isGestionEgresosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of GestionEgresos entities
     * that are retrieved from TiposPagos and returns the navigation outcome.
     *
     * @return navigation outcome for GestionEgresos page
     */
    public String navigateGestionEgresosCollection() {
        TiposPagos selected = this.getSelected();
        if (selected != null) {
            TiposPagosFacade ejbFacade = (TiposPagosFacade) this.getFacade();
            Collection<GestionEgresos> selectedGestionEgresosCollection = ejbFacade.findGestionEgresosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GestionEgresos_items", selectedGestionEgresosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/gestionEgresos/index";
    }

}
