package controller;

import model.TiposEgresos;
import model.GestionEgresos;
import java.util.Collection;
import facade.TiposEgresosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposEgresosController")
@ViewScoped
public class TiposEgresosController extends AbstractController<TiposEgresos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isGestionEgresosCollectionEmpty;

    public TiposEgresosController() {
        // Inform the Abstract parent controller of the concrete TiposEgresos Entity
        super(TiposEgresos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsGestionEgresosCollectionEmpty();
    }

    public boolean getIsGestionEgresosCollectionEmpty() {
        return this.isGestionEgresosCollectionEmpty;
    }

    private void setIsGestionEgresosCollectionEmpty() {
        TiposEgresos selected = this.getSelected();
        if (selected != null) {
            TiposEgresosFacade ejbFacade = (TiposEgresosFacade) this.getFacade();
            this.isGestionEgresosCollectionEmpty = ejbFacade.isGestionEgresosCollectionEmpty(selected);
        } else {
            this.isGestionEgresosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of GestionEgresos entities
     * that are retrieved from TiposEgresos and returns the navigation outcome.
     *
     * @return navigation outcome for GestionEgresos page
     */
    public String navigateGestionEgresosCollection() {
        TiposEgresos selected = this.getSelected();
        if (selected != null) {
            TiposEgresosFacade ejbFacade = (TiposEgresosFacade) this.getFacade();
            Collection<GestionEgresos> selectedGestionEgresosCollection = ejbFacade.findGestionEgresosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GestionEgresos_items", selectedGestionEgresosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/gestionEgresos/index";
    }

}
