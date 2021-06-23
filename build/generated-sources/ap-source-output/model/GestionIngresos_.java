package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TiposIngresos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(GestionIngresos.class)
public class GestionIngresos_ { 

    public static volatile SingularAttribute<GestionIngresos, String> descripcion;
    public static volatile SingularAttribute<GestionIngresos, Boolean> estado;
    public static volatile SingularAttribute<GestionIngresos, String> fuente;
    public static volatile SingularAttribute<GestionIngresos, Integer> id;
    public static volatile SingularAttribute<GestionIngresos, TiposIngresos> idTipoIngreso;

}