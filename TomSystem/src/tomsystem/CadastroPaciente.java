package tomsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class CadastroPaciente extends JFrame {
	private JButton btCadastrar, btVoltar, btEditar, btExcluir;

	private JLabel lbCpfP, lbNomeP, lbDataNasc, lbContatoP, lbGeneroP, lbEnderecoP;
	private JTextField tfCpfP, tfNomeP, tfDataNasc, tfContatoP, tfGeneroP, tfEnderecoP;


public CadastroPaciente() {
	
	setTitle("Cadastro de Pacientes");
	setBounds(450,450,500,500);
	setLayout (null);
	setResizable(false);
	lbCpfP = new JLabel ("CPF: ");
	lbNomeP = new JLabel("Nome Paciente: ");
	lbDataNasc = new JLabel("Data Nascimento: ");
	lbContatoP = new JLabel("Contato: ");
	lbGeneroP = new JLabel("Genero: ");
	lbEnderecoP = new JLabel("Endereço: ");
	tfCpfP = new JTextField();
	tfNomeP = new JTextField();
	tfDataNasc = new JTextField();
	tfContatoP = new JTextField();
	tfGeneroP = new JTextField();
	tfEnderecoP = new JTextField();
	btCadastrar = new JButton("Cadastrar");
	btVoltar = new JButton("Voltar");
	btExcluir = new JButton("Excluir");
	btEditar = new JButton("Editar");
	
	lbCpfP.setBounds (50,50,150,25);
	lbNomeP.setBounds (50,100,150,25);
	lbDataNasc.setBounds (50,150,150,25);
	lbContatoP.setBounds (50,200,150,25);
	lbGeneroP.setBounds (50,250,150,25);
	lbEnderecoP.setBounds (50,300,150,25);
	add(lbCpfP);
	add(lbNomeP);
	add(lbDataNasc);
	add(lbContatoP);
	add(lbGeneroP);
	add(lbEnderecoP);
	
	tfCpfP.setBounds (150,50,150,25);
	tfNomeP.setBounds (150,100,150,25);
	tfDataNasc.setBounds (150,150,150,25);
	tfContatoP.setBounds (150,200,150,25);
	tfGeneroP.setBounds (150,250,150,25);
	tfEnderecoP.setBounds (150,300,150,25);
	add(tfCpfP);
	add(tfNomeP);
	add(tfDataNasc);
	add(tfContatoP);
	add(tfGeneroP);
	add(tfEnderecoP);
	
	btCadastrar.setBounds(150,350,100,25);
	btVoltar.setBounds(300,350,100,25);
	btEditar.setBounds(150,400,100,25);
	btExcluir.setBounds(300,400,100,25);
	add(btCadastrar);
	add(btVoltar);
	add(btEditar);
	add(btExcluir);
	
	btVoltar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            voltarTomSystem();
        }
        
        private void voltarTomSystem() {
			 dispose();
		}
    });
	btCadastrar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	Paciente p = new Paciente();
	    	PacienteDAO pDAO = new PacienteDAO();
	    	p.setCpfPaciente(Integer.parseInt(tfCpfP.getText()));
	    	p.setNomePaciente(tfNomeP.getText());
	    	p.setDataNascimentoPaciente(tfContatoP.getText());
	    	p.setGeneroPaciente(tfGeneroP.getText());
	    	p.setEnderecoPaciente(tfEnderecoP.getText());
	        pDAO.salvar(null); 
	    }
	});
	btEditar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	PacienteDAO p = new PacienteDAO();
	        p.salvar(null); 
	    }
	});
	btExcluir.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	PacienteDAO p = new PacienteDAO();
	        p.excluir(cpfPaciente); 
	    }
	});
	
	
}




	public static void main (String[]args) {
		CadastroPaciente cp = new CadastroPaciente();
		cp.setVisible(true);
		cp.setLocation(500,200);
		cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
