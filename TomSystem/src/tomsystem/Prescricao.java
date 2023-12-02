package tomsystem;

public class Prescricao {
	
	private int cod_Prescricao;
	private String nomeMedicacao;
	private String intensidade;
	private String posologia;
	
	public Prescricao() {
		
	}
	

	public Prescricao(int cod_Prescricao, String nomeMedicacao, String intensidade, String posologia) {
		super();
		this.cod_Prescricao = cod_Prescricao;
		this.nomeMedicacao = nomeMedicacao;
		this.intensidade = intensidade;
		this.posologia = posologia;
	}


	public int getCod_Prescricao() {
		return cod_Prescricao;
	}


	public void setCod_Prescricao(int cod_Prescricao) {
		this.cod_Prescricao = cod_Prescricao;
	}


	public String getNomeMedicacao() {
		return nomeMedicacao;
	}


	public void setNomeMedicacao(String nomeMedicacao) {
		this.nomeMedicacao = nomeMedicacao;
	}


	public String getIntensidade() {
		return intensidade;
	}


	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}


	public String getPosologia() {
		return posologia;
	}


	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}


	@Override
	public String toString() {
		return "Prescricao [cod_Prescricao=" + cod_Prescricao + ", nomeMedicacao=" + nomeMedicacao + ", intensidade="
				+ intensidade + ", posologia=" + posologia + "]";
	}
	
	
	
	
	

}
