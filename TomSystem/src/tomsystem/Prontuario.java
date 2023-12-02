package tomsystem;

public class Prontuario {
	
	private int codProntuario;
	private String dataAtendimento;
	private String registroConsulta;
	private String examesConsulta;
	
	public Prontuario() {
		
	}

	public Prontuario(int codProntuario, String dataAtendimento, String registroConsulta, String examesConsulta) {
		super();
		this.codProntuario = codProntuario;
		this.dataAtendimento = dataAtendimento;
		this.registroConsulta = registroConsulta;
		this.examesConsulta = examesConsulta;
	}

	public int getCodProntuario() {
		return codProntuario;
	}

	public void setCodProntuario(int codProntuario) {
		this.codProntuario = codProntuario;
	}

	public String getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(String dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getRegistroConsulta() {
		return registroConsulta;
	}

	public void setRegistroConsulta(String registroConsulta) {
		this.registroConsulta = registroConsulta;
	}

	public String getExamesConsulta() {
		return examesConsulta;
	}

	public void setExamesConsulta(String examesConsulta) {
		this.examesConsulta = examesConsulta;
	}

	@Override
	public String toString() {
		return "Prontuario [codProntuario=" + codProntuario + ", dataAtendimento=" + dataAtendimento
				+ ", registroConsulta=" + registroConsulta + ", examesConsulta=" + examesConsulta + "]";
	}
	
	
	

}
