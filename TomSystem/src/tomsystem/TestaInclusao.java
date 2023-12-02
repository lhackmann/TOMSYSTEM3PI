package tomsystem;

import javax.swing.JOptionPane;

public class TestaInclusao  {
	
	public static void main(String[] args) { 
		//Paciente
		/**
    	 * Pede ao usuário para cadastrar o paciente e salva no BD
    	 */
    	int cpfPaciente = Integer.parseInt(JOptionPane.showInputDialog("Defina o código do paciente:"));
        String nomePaciente = JOptionPane.showInputDialog("Nome do paciente: ");
        String dataNascimentoPaciente = JOptionPane.showInputDialog("Data de Nascimento(dd/mm/yyyy): ");
        String contatoPaciente = JOptionPane.showInputDialog("Telefone: ");
        String generoPaciente = JOptionPane.showInputDialog("Genero: ");
        String enderecoPaciente = JOptionPane.showInputDialog("Endereço: ");
        
        Paciente p = new Paciente(cpfPaciente, nomePaciente, dataNascimentoPaciente, contatoPaciente, generoPaciente, enderecoPaciente);
         
        PacienteDAO pdao = new PacienteDAO();
        System.out.println(pdao.salvar(p));        
        
        
        /**
    	 * Pede ao usuário para cadastrar a especialidade e salva no BD
    	 */
    	int codEspecialidade = Integer.parseInt(JOptionPane.showInputDialog("Defina o código da especialidade:"));
        String nomeEspecialidade = JOptionPane.showInputDialog("Especialidade: ");
        
        Especialidade es = new Especialidade(codEspecialidade, nomeEspecialidade);
         
        EspecialidadeDAO esdao = new EspecialidadeDAO();
        System.out.println(esdao.salvar(es));
        
        /**
    	 * Pede ao usuário para cadastrar o paciente e salva no BD
    	 */
    	int cod_Prescricao = Integer.parseInt(JOptionPane.showInputDialog("Defina o código da prescrição:"));
        String nomeMedicacao = JOptionPane.showInputDialog("Medicação: ");
        String intensidade = JOptionPane.showInputDialog("Intensidade: ");
        String posologia = JOptionPane.showInputDialog("Posologia: ");
                
        Prescricao c = new Prescricao(cod_Prescricao, nomeMedicacao, intensidade, posologia);
         
        PrescricaoDAO cdao = new PrescricaoDAO();
        System.out.println(cdao.salvar(c));
        
        /**
    	 * Pede ao usuário para cadastrar o paciente e salva no BD
    	 */
    	int cpfProfissional = Integer.parseInt(JOptionPane.showInputDialog("Defina o código do profissional:"));
        String nomeProfissional = JOptionPane.showInputDialog("Nome do profissional: ");
        String dataNascProfissional = JOptionPane.showInputDialog("Data de Nascimento(dd/mm/yyyy): ");
        String conselhoDeClasse = JOptionPane.showInputDialog("Conselho de Classe: ");
        String enderecoProfissional = JOptionPane.showInputDialog("Endereço: ");
        String telefoneProfissional = JOptionPane.showInputDialog("Telefone: ");
        
        Profissional pr = new Profissional(cpfProfissional, nomeProfissional, dataNascProfissional, conselhoDeClasse, enderecoProfissional, telefoneProfissional);
         
        ProfissionalDAO prdao = new ProfissionalDAO();
        System.out.println(prdao.salvar(pr));
        
        /**
    	 * Pede ao usuário para cadastrar o prontuario e salva no BD
    	 */
    	int codProntuario = Integer.parseInt(JOptionPane.showInputDialog("Defina o código do prontuario:"));
        String dataAtendimento = JOptionPane.showInputDialog("Qual a data de atendimento (dd/mm/yyyy): ");
        String registroConsulta = JOptionPane.showInputDialog("Registro da consulta: ");
        String examesConsulta = JOptionPane.showInputDialog("Exames solicitados: ");
                
        Prontuario pt = new Prontuario(codProntuario, dataAtendimento, registroConsulta, examesConsulta);
         
        ProntuarioDAO ptdao = new ProntuarioDAO();
        System.out.println(ptdao.salvar(pt));

        
    }
	
	
	
	

}
