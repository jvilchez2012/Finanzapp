package controller;

import model.RegistroTransacciones;
import facade.RegistroTransaccionesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroTransaccionesController")
@ViewScoped
public class RegistroTransaccionesController extends AbstractController<RegistroTransacciones> {

    @Inject
    private TiposPagosController idTipoPagoController;
    @Inject
    private UsuariosController idUsuarioController;
    @Inject
    private MobilePageController mobilePageController;

    public RegistroTransaccionesController() {
        // Inform the Abstract parent controller of the concrete RegistroTransacciones Entity
        super(RegistroTransacciones.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoPagoController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TiposPagos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoPago(ActionEvent event) {
        RegistroTransacciones selected = this.getSelected();
        if (selected != null && idTipoPagoController.getSelected() == null) {
            idTipoPagoController.setSelected(selected.getIdTipoPago());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuarios controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        RegistroTransacciones selected = this.getSelected();
        if (selected != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(selected.getIdUsuario());
        }
    }

}
