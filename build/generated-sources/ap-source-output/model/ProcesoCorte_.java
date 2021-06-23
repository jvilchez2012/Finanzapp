package model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-23T16:09:24")
@StaticMetamodel(ProcesoCorte.class)
public class ProcesoCorte_ { 

    public static volatile SingularAttribute<ProcesoCorte, BigDecimal> balanceCorte;
    public static volatile SingularAttribute<ProcesoCorte, Date> fechaCorte;
    public static volatile SingularAttribute<ProcesoCorte, BigDecimal> totalIngresos;
    public static volatile SingularAttribute<ProcesoCorte, Integer> year;
    public static volatile SingularAttribute<ProcesoCorte, Integer> mes;
    public static volatile SingularAttribute<ProcesoCorte, Integer> id;
    public static volatile SingularAttribute<ProcesoCorte, BigDecimal> balanceInicial;
    public static volatile SingularAttribute<ProcesoCorte, BigDecimal> totalEgresos;

}