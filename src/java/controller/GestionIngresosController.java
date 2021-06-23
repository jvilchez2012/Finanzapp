package controller;

import model.GestionIngresos;
import facade.GestionIngresosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "gestionIngresosController")
@ViewScoped
public class GestionIngresosController extends AbstractController<GestionIngresos> {

    @Inject
    private TiposIngresosController idTipoIngresoController;
    @Inject
    private MobilePageController mobilePageController;

    public GestionIngresosController() {
        // Inform the Abstract parent controller of the concrete GestionIngresos Entity
        super(GestionIngresos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoIngresoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TiposIngresos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoIngreso(ActionEvent event) {
        GestionIngresos selected = this.getSelected();
        if (selected != null && idTipoIngresoController.getSelected() == null) {
            idTipoIngresoController.setSelected(selected.getIdTipoIngreso());
        }
    }

}
