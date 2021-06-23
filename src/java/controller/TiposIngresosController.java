package controller;

import model.TiposIngresos;
import model.GestionIngresos;
import java.util.Collection;
import facade.TiposIngresosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposIngresosController")
@ViewScoped
public class TiposIngresosController extends AbstractController<TiposIngresos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isGestionIngresosCollectionEmpty;

    public TiposIngresosController() {
        // Inform the Abstract parent controller of the concrete TiposIngresos Entity
        super(TiposIngresos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsGestionIngresosCollectionEmpty();
    }

    public boolean getIsGestionIngresosCollectionEmpty() {
        return this.isGestionIngresosCollectionEmpty;
    }

    private void setIsGestionIngresosCollectionEmpty() {
        TiposIngresos selected = this.getSelected();
        if (selected != null) {
            TiposIngresosFacade ejbFacade = (TiposIngresosFacade) this.getFacade();
            this.isGestionIngresosCollectionEmpty = ejbFacade.isGestionIngresosCollectionEmpty(selected);
        } else {
            this.isGestionIngresosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of GestionIngresos entities
     * that are retrieved from TiposIngresos and returns the navigation outcome.
     *
     * @return navigation outcome for GestionIngresos page
     */
    public String navigateGestionIngresosCollection() {
        TiposIngresos selected = this.getSelected();
        if (selected != null) {
            TiposIngresosFacade ejbFacade = (TiposIngresosFacade) this.getFacade();
            Collection<GestionIngresos> selectedGestionIngresosCollection = ejbFacade.findGestionIngresosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GestionIngresos_items", selectedGestionIngresosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/gestionIngresos/index";
    }

}
