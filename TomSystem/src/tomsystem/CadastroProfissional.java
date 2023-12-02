package tomsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class CadastroProfissional extends JFrame {
	private JButton btCadastrar, btVoltar, btEditar, btExcluir;

	private JLabel lbCpfPf, lbNomePf, lbDataNascPf, lbConselhoPf, lbEnderecoPf, lbTelefonePf;
	private JTextField tfCpfPf, tfNomePf, tfDataNascPf, tfConselhoPf, tfEnderecoPf, tfTelefonePf;


public CadastroProfissional() {
	
	setTitle("Cadastro de Profissionais");
	setBounds(450,450,500,500);
	setLayout (null);
	setResizable(false);
	lbCpfPf = new JLabel ("CPF: ");
	lbNomePf = new JLabel("Nome Profissional: ");
	lbDataNascPf = new JLabel("Data Nascimento: ");
	lbConselhoPf = new JLabel("Conselho: ");
	lbEnderecoPf = new JLabel("Endereço: ");
	lbTelefonePf = new JLabel("Telefone: ");
	tfCpfPf = new JTextField();
	tfNomePf = new JTextField();
	tfDataNascPf = new JTextField();
	tfConselhoPf = new JTextField();
	tfEnderecoPf = new JTextField();
	tfTelefonePf = new JTextField();
	btCadastrar = new JButton("Cadastrar");
	btVoltar = new JButton("Voltar");
	btExcluir = new JButton("Excluir");
	btEditar = new JButton("Editar");
	
	lbCpfPf.setBounds (50,50,150,25);
	lbNomePf.setBounds (50,100,150,25);
	lbDataNascPf.setBounds (50,150,150,25);
	lbConselhoPf.setBounds (50,200,150,25);
	lbEnderecoPf.setBounds (50,250,150,25);
	lbTelefonePf.setBounds (50,300,150,25);
	add(lbCpfPf);
	add(lbNomePf);
	add(lbDataNascPf);
	add(lbConselhoPf);
	add(lbEnderecoPf);
	add(lbTelefonePf);
	
	tfCpfPf.setBounds (170,50,150,25);
	tfNomePf.setBounds (170,100,150,25);
	tfDataNascPf.setBounds (170,150,150,25);
	tfConselhoPf.setBounds (170,200,150,25);
	tfEnderecoPf.setBounds (170,250,150,25);
	tfTelefonePf.setBounds (170,300,150,25);
	add(tfCpfPf);
	add(tfNomePf);
	add(tfDataNascPf);
	add(tfConselhoPf);
	add(tfEnderecoPf);
	add(tfTelefonePf);
	
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
	        Profissional pr = new Profissional();
	        ProfissionalDAO prDAO = new ProfissionalDAO();
	        pr.setCpfProfissional(Integer.parseInt(tfCpfPf.getText()));
	        pr.setNomeProfissional(tfNomePf.getText());
	        pr.setDataNascProfissional(tfDataNascPf.getText());
	        pr.setConselhoDeClasse(tfConselhoPf.getText());
	        pr.setEnderecoProfissional(tfEnderecoPf.getText());
	        pr.setTelefoneProfissional(tfTelefonePf.getText());
	        
	        
	        prDAO.salvar(pr); 
	    }
	});
	btEditar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        ProfissionalDAO pr = new ProfissionalDAO();
	        
	        pr.salvar(null); 
	    }
	});
	btExcluir.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        ProfissionalDAO pr = new ProfissionalDAO();
	        pr.excluir(cpfProfissional); 
	    }
	});
}
	public static void main (String[]args) {
		CadastroProfissional cpf = new CadastroProfissional();
		cpf.setVisible(true);
		cpf.setLocation(500,200);
		cpf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
