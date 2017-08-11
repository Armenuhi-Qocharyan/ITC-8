package customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class represents meta data about 'test' custom annotation
 * @author student
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface TestMeta {
    public enum Priority {
        LOW, MEDIUM, HIGH
    }
    
    String name() default "";
    Priority priority() default Priority.MEDIUM;
}