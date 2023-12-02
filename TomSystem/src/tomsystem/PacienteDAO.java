package tomsystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
	
	private String men, sql;
	private BD bd;
	
	public PacienteDAO() {
		bd = new BD();
	}
	
	public List<Paciente> getPaciente(String sql) {
		List<Paciente> lista = new ArrayList<Paciente>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next() ) {
				Paciente p = new 
						Paciente(bd.rs.getInt(1), bd.rs.getString(2),bd.rs.getString(3), bd.rs.getString(4), bd.rs.getString(5),bd.rs.getString(6));
				lista.add(p);
			}
		}
		catch(SQLException e) {
			System.out.println(e);			
	}
		finally {
			bd.close();
		}
		return lista;
}
	public String salvar(Paciente p) {
		sql = "insert into paciente values (?,?,?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, p.getCpfPaciente());
			bd.st.setString(2, p.getNomePaciente());
			bd.st.setString(3, p.getDataNascimentoPaciente());
			bd.st.setString(4, p.getContatoPaciente());
			bd.st.setString(5, p.getGeneroPaciente());
			bd.st.setString(6, p.getEnderecoPaciente());
			bd.st.executeUpdate();
			men = "Paciente cadastrado com sucesso!";
		}
		catch(Exception erro) {
			System.out.println(erro);
			men = "Falha! " + erro;
		}
		finally {
			bd.close();
		}
		return men;
	}
	public String excluir(int cpfPaciente) {
		sql = "delete from paciente where CPF_Paciente = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, cpfPaciente);
			int n = bd.st.executeUpdate();
			if(n==1) {
				men = "Paciente excluído com sucesso!";
			}
			else {
				men = "Paciente não encontrado!";
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			bd.close();
		}
		return men;
	}
	public String toCSV() {
		try {
			OutputStream os = new FileOutputStream("paciente.csv");
			PrintWriter pw = new PrintWriter
					 (new OutputStreamWriter(os, "ISO-8859-1"));
			pw.append("cpfPaciente;nomePaciente;dataNascimentoPaciente;contatoPaciente;generoPaciente;enderecoPaciente\n");
			sql = "select * from paciente";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//gravar no CSV
				String linha = bd.rs.getString("cpfPaciente")+";"+
						bd.rs.getString("nomePaciente")+";"+
						bd.rs.getString("dataNascimentoPaciente")+
						bd.rs.getString("contatoPaciente")+";"+
						bd.rs.getString("generoPaciente")+";"+
						bd.rs.getString("enderecoPaciente")+";"+"\n";
				pw.append(linha);
			}
			pw.close();
			return "Arquivo gerado com sucesso!";
		} 
		catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			bd.close();
		}
		return "Falha ao gerar o arquivo!";
	}
	}





