import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//this @Rerenetion is telling keep this annotation "Log" until runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

}
