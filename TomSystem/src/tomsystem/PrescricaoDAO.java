package tomsystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescricaoDAO {
	
	private String men, sql;
	private BD bd;
	
	public PrescricaoDAO() {
		bd = new BD();
	}
	
	public List<Prescricao> getPrescricao(String sql) {
		List<Prescricao> lista = new ArrayList<Prescricao>();
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next() ) {
				Prescricao c = new 
						Prescricao(bd.rs.getInt(1), bd.rs.getString(2),bd.rs.getString(3), bd.rs.getString(4));
				lista.add(c);
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
	public String salvar(Prescricao c) {
		sql = "insert into prescricao values (?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, c.getCod_Prescricao());
			bd.st.setString(2, c.getNomeMedicacao());
			bd.st.setString(3, c.getIntensidade());
			bd.st.setString(4, c.getPosologia());
			bd.st.executeUpdate();
			men = "Prescricao cadastrado com sucesso!";
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
	public String excluir(int cod_Prescricao) {
		sql = "delete from prescricao where Cod_Prescricao = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, cod_Prescricao);
			int n = bd.st.executeUpdate();
			if(n==1) {
				men = "Prescrição excluída com sucesso!";
			}
			else {
				men = "Prescrição não encontrado!";
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
			OutputStream os = new FileOutputStream("prescricao.csv");
			PrintWriter pw = new PrintWriter
					 (new OutputStreamWriter(os, "ISO-8859-1"));
			pw.append("cod_Prescricao;nomeMedicacao;intensidade;posologia\n");
			sql = "select * from prescricao";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//gravar no CSV
				String linha = bd.rs.getString("cod_Prescricao")+";"+
						bd.rs.getString("nomeMedicacao")+";"+
						bd.rs.getString("intensidade")+
						bd.rs.getString("posologia")+"\n";
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








