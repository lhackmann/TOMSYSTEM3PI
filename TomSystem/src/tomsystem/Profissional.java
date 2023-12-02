package tomsystem;

public class Profissional {
	
	private int cpfProfissional;
	private String nomeProfissional;
	private String dataNascProfissional;
	private String conselhoDeClasse;
	private String enderecoProfissional;
	private String telefoneProfissional;
	
	public Profissional() {
		
	}

	public Profissional(int cpfProfissional, String nomeProfissional, String dataNascProfissional,
			String conselhoDeClasse, String enderecoProfissional, String telefoneProfissional) {
		super();
		this.cpfProfissional = cpfProfissional;
		this.nomeProfissional = nomeProfissional;
		this.dataNascProfissional = dataNascProfissional;
		this.conselhoDeClasse = conselhoDeClasse;
		this.enderecoProfissional = enderecoProfissional;
		this.telefoneProfissional = telefoneProfissional;
	}

	public int getCpfProfissional() {
		return cpfProfissional;
	}

	public void setCpfProfissional(int cpfProfissional) {
		this.cpfProfissional = cpfProfissional;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getDataNascProfissional() {
		return dataNascProfissional;
	}

	public void setDataNascProfissional(String dataNascProfissional) {
		this.dataNascProfissional = dataNascProfissional;
	}

	public String getConselhoDeClasse() {
		return conselhoDeClasse;
	}

	public void setConselhoDeClasse(String conselhoDeClasse) {
		this.conselhoDeClasse = conselhoDeClasse;
	}

	public String getEnderecoProfissional() {
		return enderecoProfissional;
	}

	public void setEnderecoProfissional(String enderecoProfissional) {
		this.enderecoProfissional = enderecoProfissional;
	}

	public String getTelefoneProfissional() {
		return telefoneProfissional;
	}

	public void setTelefoneProfissional(String telefoneProfissional) {
		this.telefoneProfissional = telefoneProfissional;
	}

	@Override
	public String toString() {
		return "Profissional [cpfProfissional=" + cpfProfissional + ", nomeProfissional=" + nomeProfissional
				+ ", dataNascProfissional=" + dataNascProfissional + ", conselhoDeClasse=" + conselhoDeClasse
				+ ", enderecoProfissional=" + enderecoProfissional + ", telefoneProfissional=" + telefoneProfissional
				+ "]";
	}
	
	

}
