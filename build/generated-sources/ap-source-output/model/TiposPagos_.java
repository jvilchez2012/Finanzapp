package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.GestionEgresos;
import model.RegistroTransacciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(TiposPagos.class)
public class TiposPagos_ { 

    public static volatile SingularAttribute<TiposPagos, String> descripcion;
    public static volatile CollectionAttribute<TiposPagos, RegistroTransacciones> registroTransaccionesCollection;
    public static volatile SingularAttribute<TiposPagos, Boolean> estado;
    public static volatile SingularAttribute<TiposPagos, Integer> id;
    public static volatile CollectionAttribute<TiposPagos, GestionEgresos> gestionEgresosCollection;

}