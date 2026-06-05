
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls=Sagar.class;
        Method[] methodsInSagar=cls.getDeclaredMethods();
        for(Method method:methodsInSagar){

            if(method.isAnnotationPresent(Log.class)){
            method.invoke(null);
            }
            if(method.isAnnotationPresent(Personal.class)){
                System.out.println("this is personal method cannot invoke :"+method.getName());
            }
        }
    }
}
