@FunctionalInterface
public interface Validator<T> {

    boolean accept(T object);

    // void x();
}
