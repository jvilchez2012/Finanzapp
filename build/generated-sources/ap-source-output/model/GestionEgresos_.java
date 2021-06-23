package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.RenglonesEgresos;
import model.TiposEgresos;
import model.TiposPagos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(GestionEgresos.class)
public class GestionEgresos_ { 

    public static volatile SingularAttribute<GestionEgresos, String> descripcion;
    public static volatile SingularAttribute<GestionEgresos, RenglonesEgresos> idReglonEgreso;
    public static volatile SingularAttribute<GestionEgresos, Boolean> estado;
    public static volatile SingularAttribute<GestionEgresos, TiposEgresos> idTipoEgreso;
    public static volatile SingularAttribute<GestionEgresos, TiposPagos> idTipoPago;
    public static volatile SingularAttribute<GestionEgresos, Integer> id;

}