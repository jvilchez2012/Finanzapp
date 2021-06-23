package controller;

import model.GestionEgresos;
import facade.GestionEgresosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "gestionEgresosController")
@ViewScoped
public class GestionEgresosController extends AbstractController<GestionEgresos> {

    @Inject
    private RenglonesEgresosController idReglonEgresoController;
    @Inject
    private TiposEgresosController idTipoEgresoController;
    @Inject
    private TiposPagosController idTipoPagoController;
    @Inject
    private MobilePageController mobilePageController;

    public GestionEgresosController() {
        // Inform the Abstract parent controller of the concrete GestionEgresos Entity
        super(GestionEgresos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idReglonEgresoController.setSelected(null);
        idTipoEgresoController.setSelected(null);
        idTipoPagoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the RenglonesEgresos controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdReglonEgreso(ActionEvent event) {
        GestionEgresos selected = this.getSelected();
        if (selected != null && idReglonEgresoController.getSelected() == null) {
            idReglonEgresoController.setSelected(selected.getIdReglonEgreso());
        }
    }

    /**
     * Sets the "selected" attribute of the TiposEgresos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoEgreso(ActionEvent event) {
        GestionEgresos selected = this.getSelected();
        if (selected != null && idTipoEgresoController.getSelected() == null) {
            idTipoEgresoController.setSelected(selected.getIdTipoEgreso());
        }
    }

    /**
     * Sets the "selected" attribute of the TiposPagos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoPago(ActionEvent event) {
        GestionEgresos selected = this.getSelected();
        if (selected != null && idTipoPagoController.getSelected() == null) {
            idTipoPagoController.setSelected(selected.getIdTipoPago());
        }
    }

}
