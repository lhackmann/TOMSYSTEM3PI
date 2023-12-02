package tomsystem;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestaExclusao {

	public static void main(String[] args) throws SQLException {
				/**
		    	 * Pede ao usuário para excluir o paciente no BD
		    	 */
		    	int cpfPaciente = Integer.parseInt(JOptionPane.showInputDialog("Qual o cpf do paciente deseja excluir:"));
		        
		        DB db = new DB();   
		        PacienteDAO pdao = new PacienteDAO();
		        System.out.println(pdao.excluir(cpfPaciente));        
		        
		        
		        /**
		    	 * Pede ao usuário qual a especialidade deseja escluir do BD
		    	 */
		    	int codEspecialidade = Integer.parseInt(JOptionPane.showInputDialog("Defina o código da especialidade que deseja excluir:"));
		                
		        	         
		        EspecialidadeDAO esdao = new EspecialidadeDAO();
		        System.out.println(esdao.excluir(codEspecialidade));
		        
		        /**
		    	 * Pede ao usuário para excluir a prescrição no BD
		    	 */
		    	int cod_Prescricao = Integer.parseInt(JOptionPane.showInputDialog("Defina o código da prescrição:"));
		        		                
		        
		         
		        PrescricaoDAO cdao = new PrescricaoDAO();
		        System.out.println(cdao.excluir(cod_Prescricao));
		        
		        /**
		    	 * Pede ao usuário para excluir o paciente no BD
		    	 */
		    	int cpfProfissional = Integer.parseInt(JOptionPane.showInputDialog("Defina o código do profissional que deseja excluir:"));
		        		        
		        
		         
		        ProfissionalDAO prdao = new ProfissionalDAO();
		        System.out.println(prdao.excluir(cpfProfissional));
		        
		        /**
		    	 * Pede ao usuário para excluir o prontuario no BD
		    	 */
		    	int codProntuario = Integer.parseInt(JOptionPane.showInputDialog("Defina o código do prontuario:"));
		        
		        
		         
		        ProntuarioDAO ptdao = new ProntuarioDAO();
		        System.out.println(ptdao.excluir(codProntuario));

		        
		    }
	}


