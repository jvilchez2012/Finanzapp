package controller;

import model.RenglonesEgresos;
import model.GestionEgresos;
import java.util.Collection;
import facade.RenglonesEgresosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "renglonesEgresosController")
@ViewScoped
public class RenglonesEgresosController extends AbstractController<RenglonesEgresos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isGestionEgresosCollectionEmpty;

    public RenglonesEgresosController() {
        // Inform the Abstract parent controller of the concrete RenglonesEgresos Entity
        super(RenglonesEgresos.class);
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
        RenglonesEgresos selected = this.getSelected();
        if (selected != null) {
            RenglonesEgresosFacade ejbFacade = (RenglonesEgresosFacade) this.getFacade();
            this.isGestionEgresosCollectionEmpty = ejbFacade.isGestionEgresosCollectionEmpty(selected);
        } else {
            this.isGestionEgresosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of GestionEgresos entities
     * that are retrieved from RenglonesEgresos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GestionEgresos page
     */
    public String navigateGestionEgresosCollection() {
        RenglonesEgresos selected = this.getSelected();
        if (selected != null) {
            RenglonesEgresosFacade ejbFacade = (RenglonesEgresosFacade) this.getFacade();
            Collection<GestionEgresos> selectedGestionEgresosCollection = ejbFacade.findGestionEgresosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GestionEgresos_items", selectedGestionEgresosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/gestionEgresos/index";
    }

}
