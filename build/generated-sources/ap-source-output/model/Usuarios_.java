package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.RegistroTransacciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile CollectionAttribute<Usuarios, RegistroTransacciones> registroTransaccionesCollection;
    public static volatile SingularAttribute<Usuarios, Boolean> estado;
    public static volatile SingularAttribute<Usuarios, String> tipoPersona;
    public static volatile SingularAttribute<Usuarios, Date> fechaCorte;
    public static volatile SingularAttribute<Usuarios, String> identificacion;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, BigDecimal> limiteEgresos;
    public static volatile SingularAttribute<Usuarios, String> nombre;

}