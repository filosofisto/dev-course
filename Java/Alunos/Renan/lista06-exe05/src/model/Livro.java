package model;

public class Livro{

	protected String autor;
	protected String titulo;
	protected String ISBN;

	public Livro() {
	}

	public Livro(String autor, String titulo, String ISBN) {
		this.autor = autor;
		this.titulo = titulo;
		this.ISBN = ISBN;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [ Autor = " + autor + ", Titulo = " + titulo + ", ISBN = " + ISBN + " ]";
	}

}
