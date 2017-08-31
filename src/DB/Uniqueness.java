package DB;

/**
 * Created by Administrator on 2017/4/18.
 */
public @interface Uniqueness {
    Constrains constraints() default @Constrains(unique = true);
}
