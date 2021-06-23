package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.GestionEgresos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(RenglonesEgresos.class)
public class RenglonesEgresos_ { 

    public static volatile SingularAttribute<RenglonesEgresos, String> descripcion;
    public static volatile SingularAttribute<RenglonesEgresos, Boolean> estado;
    public static volatile SingularAttribute<RenglonesEgresos, Integer> id;
    public static volatile CollectionAttribute<RenglonesEgresos, GestionEgresos> gestionEgresosCollection;

}