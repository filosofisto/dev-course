@FunctionalInterface
public interface Validator<T> {

    boolean validate(T object);

    //void setValue(T object);

    /*default void x() {

    }

    default void y() {

    }*/
}
