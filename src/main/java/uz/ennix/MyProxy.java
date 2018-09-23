package uz.ennix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class MyProxy{
    public static void main(String[] args) {
        InvocationHandler handler = new MyPro("L");
        Class[] classes = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, handler);

        proxy.toString();
        System.out.println(((Comparable)proxy).compareTo(handler));
    }
    static class MyPro implements InvocationHandler{
        Object target;

        public MyPro(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args);
            return method.invoke(target, args);
        }
    }
}
