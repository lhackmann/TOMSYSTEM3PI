package tomsystem;

public class Paciente {

	// variaveis 
	
	private int cpfPaciente;
	private String nomePaciente;
	private String dataNascimentoPaciente;
	private String contatoPaciente;
	private String generoPaciente;
	private String enderecoPaciente;
	
	
	public Paciente() {
		}
	
	// cadastro variaveis
	
	public Paciente(int cpfPaciente, String nomePaciente, String dataNascimentoPaciente, String contatoPaciente,
			String generoPaciente, String enderecoPaciente) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.nomePaciente = nomePaciente;
		this.dataNascimentoPaciente = dataNascimentoPaciente;
		this.contatoPaciente = contatoPaciente;
		this.generoPaciente = generoPaciente;
		this.enderecoPaciente = enderecoPaciente;
	}
	
	
	// Métodos variaveis
	
	public int getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(int cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getDataNascimentoPaciente() {
		return dataNascimentoPaciente;
	}

	public void setDataNascimentoPaciente(String dataNascimentoPaciente) {
		this.dataNascimentoPaciente = dataNascimentoPaciente;
	}

	public String getContatoPaciente() {
		return contatoPaciente;
	}

	public void setContatoPaciente(String contatoPaciente) {
		this.contatoPaciente = contatoPaciente;
	}

	public String getGeneroPaciente() {
		return generoPaciente;
	}

	public void setGeneroPaciente(String generoPaciente) {
		this.generoPaciente = generoPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	@Override
	public String toString() {
		return "Paciente [cpfPaciente=" + cpfPaciente + ", nomePaciente=" + nomePaciente + ", dataNascimentoPaciente="
				+ dataNascimentoPaciente + ", contatoPaciente=" + contatoPaciente + ", generoPaciente=" + generoPaciente
				+ ", enderecoPaciente=" + enderecoPaciente + "]";
	}
	
	

	

}
