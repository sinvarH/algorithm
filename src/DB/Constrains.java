package DB;

/**
 * Created by Administrator on 2017/4/18.
 */
public @interface Constrains {
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
