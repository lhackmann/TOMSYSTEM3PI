package tomsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TomSystem extends JFrame {
    private JButton btProfissional, btPaciente, btFechar;

    public TomSystem() {

        setTitle("Tom System");
        setBounds(500, 500, 500, 500);
        setLayout(null);
        setResizable(false);

        btProfissional = new JButton("Profissional");
        btPaciente = new JButton("Paciente");
        btFechar = new JButton("Fechar");

        btProfissional.setBounds(150, 150, 150, 25);
        btPaciente.setBounds(150, 200, 150, 25);
        btFechar.setBounds(150, 250, 150, 25);
        
        add(btProfissional);
        add(btPaciente);
        add(btFechar);

        
        btProfissional.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroProfissional();
                
            }
            
            protected void abrirCadastroProfissional() {		
            	new CadastroProfissional().setVisible(true);
            	
            	
        	}
        });

        btPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroPaciente();
            }

			private void abrirCadastroPaciente() {
				new CadastroPaciente().setVisible(true);
			}
        });

        btFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fecharTomSystem();
				}
			private void fecharTomSystem() {
				dispose();
			}
		});
      
    }
  
    public static void main(String[] args) {
        TomSystem ts = new TomSystem();
        ts.setVisible(true);
        ts.setLocation(500,200);;
        ts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

