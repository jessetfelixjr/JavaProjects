package enums;

public enum GeneroEnum {
	
	DRAMA(1, "Drama"), COMEDIA(2,"Com�dia"), ACAO(3, "A��o");
	
	private int codigo;
	private String genero;
	
	private GeneroEnum(int codigo, String genero) {
		this.codigo = codigo;
		this.genero = genero;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

}
