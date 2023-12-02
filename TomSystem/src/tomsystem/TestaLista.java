package tomsystem;

import java.util.List;

public class TestaLista {

	public static void main(String[] args) {
		EspecialidadeDAO esdao = new EspecialidadeDAO();
		
		String sql = "select * from produtos order by cod_Especialidade";
		List<Especialidade> lista = esdao.getEspecialidade(sql);
		for(Especialidade es:lista) {
			System.out.println(es);
		}
		
		PacienteDAO pdao = new PacienteDAO();
		
		String sql = "select * from produtos order by cod_Especialidade";
		List<Paciente> lista = pdao.getPaciente(sql);
		for(Paciente p:lista) {
			System.out.println(p);
		}

	}

}
