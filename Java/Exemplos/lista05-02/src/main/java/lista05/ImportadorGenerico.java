package lista05;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ImportadorGenerico<T> implements Importador<T> {

    public List<T> importar(File file) throws IOException {
        Class<T> clazz = getParentItemClass();
        List<ReflectData> reflectDataList = null;

        try {
            reflectDataList = criarReflectDataList(clazz);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        List<T> list = new ArrayList<T>();
        String linha;
        T object;
        Scanner scanner = new Scanner(file).useDelimiter("\n");
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();

            try {
                object = processaLinha(clazz, reflectDataList, linha);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            customizarItem(object);
            list.add(object);
        }

        return list;
    }

    private List<ReflectData> criarReflectDataList(Class<T> clazz)
            throws NoSuchMethodException {
        List<ReflectData> list = new ArrayList<ReflectData>();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            Substring substring = (Substring) field.getAnnotation(Substring.class);
            if (substring != null) {
                Method setter = obterSetter(clazz, field);
                ReflectData reflectData = new ReflectData(substring, setter, field);
                list.add(reflectData);
            }
        }

        return list;
    }

    private Method obterSetter(Class<T> clazz, Field field)
            throws NoSuchMethodException {
        return clazz.getMethod(nomeSetter(field), field.getType());
    }

    // idade =          setIdade:          set + I + dade
    // dataNascimento = setDataNascimento: set + D + ataNascimento
    private String nomeSetter(Field field) {
        return "set" + field.getName().substring(0,1).toUpperCase()
                + field.getName().substring(1);
    }

    private T processaLinha(Class<T> clazz, List<ReflectData> reflectDataList, String linha)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T object = clazz.newInstance();

        for (ReflectData reflectData: reflectDataList) {
            String substring = linha.substring(
                    reflectData.getSubstring().inicio(),
                    reflectData.getSubstring().fim()
            );
            Object valor = converterValor(reflectData.getField(), substring);
            reflectData.getMethod().invoke((T)object, valor);
        }

        return object;
    }

    private Object converterValor(Field field, String substring) {
        if (field.getType() == String.class) {
            return substring;
        } else if (field.getType() == Double.class) {
            return Double.parseDouble(substring);
        } else if (field.getType() == Float.class) {
            return Float.parseFloat(substring);
        } else if (field.getType() == Integer.class) {
            return Integer.parseInt(substring);
        }
        // completar com outros tipos
        return null;
    }

    @SuppressWarnings("unchecked")
    public Class<T> getParentItemClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) type;
            return (Class<T>) paramType.getActualTypeArguments()[0];
        } else {
            throw new IllegalArgumentException("Nao eh possivel obter a classe do item por reflexao");
        }
    }

    public void customizarItem(T item) {

    }
}

class ReflectData {
    private Substring substring;
    private Method method;
    private Field field;

    public ReflectData(Substring substring, Method method, Field field) {
        this.substring = substring;
        this.method = method;
        this.field = field;
    }

    public Substring getSubstring() {
        return substring;
    }

    public void setSubstring(Substring substring) {
        this.substring = substring;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}