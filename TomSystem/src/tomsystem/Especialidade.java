package tomsystem;

public class Especialidade {
	
	private int codEspecialidade;
	private String nomeEspecialidade;
		
	public Especialidade() { 
		}
	
	public Especialidade(int codEspecialidade, String nomeEspecialidade) {
		this.codEspecialidade = codEspecialidade;
		this.nomeEspecialidade = nomeEspecialidade;
		}

	public int getCodEspecialidade() {
		return codEspecialidade;
	}

	public void CodEspecialidade(int codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	@Override
	public String toString() {
		return "Especialidade [Código=" + codEspecialidade + ", Especialidade=" + nomeEspecialidade + "]";
	}
	
	

}
