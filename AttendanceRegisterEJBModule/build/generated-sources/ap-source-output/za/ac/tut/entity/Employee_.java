package za.ac.tut.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.TimeIn;
import za.ac.tut.entity.TimeOut;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-11T18:27:25")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> surname;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile ListAttribute<Employee, TimeOut> timeOuts;
    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, String> department;
    public static volatile ListAttribute<Employee, TimeIn> timeIns;

}