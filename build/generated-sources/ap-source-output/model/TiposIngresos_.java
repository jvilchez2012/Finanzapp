package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.GestionIngresos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(TiposIngresos.class)
public class TiposIngresos_ { 

    public static volatile SingularAttribute<TiposIngresos, String> descripcion;
    public static volatile SingularAttribute<TiposIngresos, Boolean> estado;
    public static volatile CollectionAttribute<TiposIngresos, GestionIngresos> gestionIngresosCollection;
    public static volatile SingularAttribute<TiposIngresos, Integer> id;

}