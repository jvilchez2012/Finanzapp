package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.GestionEgresos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(TiposEgresos.class)
public class TiposEgresos_ { 

    public static volatile SingularAttribute<TiposEgresos, String> descripcion;
    public static volatile SingularAttribute<TiposEgresos, Boolean> estado;
    public static volatile SingularAttribute<TiposEgresos, Integer> id;
    public static volatile CollectionAttribute<TiposEgresos, GestionEgresos> gestionEgresosCollection;

}