package controller;

import model.ProcesoCorte;
import facade.ProcesoCorteFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "procesoCorteController")
@ViewScoped
public class ProcesoCorteController extends AbstractController<ProcesoCorte> {

    @Inject
    private MobilePageController mobilePageController;

    public ProcesoCorteController() {
        // Inform the Abstract parent controller of the concrete ProcesoCorte Entity
        super(ProcesoCorte.class);
    }

}
