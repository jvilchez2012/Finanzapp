package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TiposPagos;
import model.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(RegistroTransacciones.class)
public class RegistroTransacciones_ { 

    public static volatile SingularAttribute<RegistroTransacciones, Boolean> estado;
    public static volatile SingularAttribute<RegistroTransacciones, Date> fechaTransaccion;
    public static volatile SingularAttribute<RegistroTransacciones, Integer> noTDC;
    public static volatile SingularAttribute<RegistroTransacciones, TiposPagos> idTipoPago;
    public static volatile SingularAttribute<RegistroTransacciones, Date> fechaRegistro;
    public static volatile SingularAttribute<RegistroTransacciones, Usuarios> idUsuario;
    public static volatile SingularAttribute<RegistroTransacciones, Integer> id;
    public static volatile SingularAttribute<RegistroTransacciones, String> tipoTransaccion;
    public static volatile SingularAttribute<RegistroTransacciones, BigDecimal> montoTransaccion;
    public static volatile SingularAttribute<RegistroTransacciones, String> comentario;

}