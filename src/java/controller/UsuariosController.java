package controller;

import model.Usuarios;
import model.RegistroTransacciones;
import java.util.Collection;
import facade.UsuariosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usuariosController")
@ViewScoped
public class UsuariosController extends AbstractController<Usuarios> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroTransaccionesCollectionEmpty;

    public UsuariosController() {
        // Inform the Abstract parent controller of the concrete Usuarios Entity
        super(Usuarios.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistroTransaccionesCollectionEmpty();
    }

    public boolean getIsRegistroTransaccionesCollectionEmpty() {
        return this.isRegistroTransaccionesCollectionEmpty;
    }

    private void setIsRegistroTransaccionesCollectionEmpty() {
        Usuarios selected = this.getSelected();
        if (selected != null) {
            UsuariosFacade ejbFacade = (UsuariosFacade) this.getFacade();
            this.isRegistroTransaccionesCollectionEmpty = ejbFacade.isRegistroTransaccionesCollectionEmpty(selected);
        } else {
            this.isRegistroTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistroTransacciones
     * entities that are retrieved from Usuarios and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistroTransacciones page
     */
    public String navigateRegistroTransaccionesCollection() {
        Usuarios selected = this.getSelected();
        if (selected != null) {
            UsuariosFacade ejbFacade = (UsuariosFacade) this.getFacade();
            Collection<RegistroTransacciones> selectedRegistroTransaccionesCollection = ejbFacade.findRegistroTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistroTransacciones_items", selectedRegistroTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registroTransacciones/index";
    }

}
