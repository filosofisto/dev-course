package lista05;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ExportadorXml1 extends Exportador {

	private StringBuilder buf;

	public ExportadorXml1() {
		buf = new StringBuilder();
	}

	public ExportadorXml1 cabecalho() {
		buf.append("<?xml version=\"1.0\"encoding=UTF8?>\n");
		return this;
	}

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {

	}

	@Override
	public String exportar(File destino, List<Conta> contas, String root) 
			throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, 
			IllegalArgumentException, 
			InvocationTargetException {

		buf.append("<" + root + ">\n");

		for (Object obj : contas) {
			buf.append(exportar(obj) + "\n");
		}

		buf.append("</" + root + ">\n");
		
		return buf.toString();

	}

	private String exportar(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Class cls = obj.getClass();

		StringBuilder buf = new StringBuilder();

		buf.append("<" + cls.getSimpleName().toLowerCase() + ">\n");

		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			buf.append("\t<" + field.getName() + ">");

			Method getter = getter(cls, field);
			Object value = getter.invoke(obj);

			if (value != null) {
				buf.append(value);
			}

			buf.append("</" + field.getName() + ">\n");

		}

		buf.append("</" + cls.getSimpleName().toLowerCase() + ">");

		return buf.toString();

	}

	private Method getter(Class cls, Field field) throws NoSuchMethodException, SecurityException {
		return cls.getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
	}

	public StringBuilder getBuf() {
		return buf;
	}

	public void setBuf(StringBuilder buf) {
		this.buf = buf;
	}

}
