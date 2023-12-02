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


public class ProntuarioDAO {
	private String men, sql;
	private BD bd;
	
	public ProntuarioDAO() {
		bd = new BD();
	}
	/**
	 * Retorna a lista de produtos existentes na tabela produtos
	 * @return
	 */
	public List<Prontuario> getProntuario(String sql){
		List<Prontuario> lista = new ArrayList<Prontuario>();
		bd.getConnection();
		//String sql = "select * from produtos";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				Prontuario pt = new //criando um produto a partir dos dados do banco
				  Prontuario(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3), bd.rs.getString(4));
				lista.add(pt);
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
	
	public String salvar(Prontuario pt) {
		sql = "insert into prontuario_consulta values(?,?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, pt.getCodProntuario());
			bd.st.setString(2, pt.getDataAtendimento());
			bd.st.setString(3, pt.getRegistroConsulta());
			bd.st.setString(4, pt.getExamesConsulta());
			bd.st.executeUpdate();
			men = "Prontuario inserido com sucesso!";
		}
		catch(SQLException e) {
			//tentar realizar um update
			sql = "update prontuario_consulta set data_atendimento = ?, registro_consulta = ?, exames_consulta = ? where cod_prontuario = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(4, pt.getCodProntuario());
				bd.st.setString(1, pt.getDataAtendimento());
				bd.st.setString(2, pt.getRegistroConsulta());
				bd.st.setString(4, pt.getExamesConsulta());
				bd.st.executeUpdate();
				men = "Prontuario alterado com sucesso!";
			}
			catch(Exception erro) {
				System.out.println(erro);
				men = "Falha! " + erro;
			}
		}
		finally {
			bd.close();
		}
		return men;
	}
	
	public String excluir(int codProntuario) {
		sql = "delete from prontuario_consulta where cod_prontuario = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codProntuario);
			int n = bd.st.executeUpdate();
			if(n==1) {
				men = "Prontuario excluído com sucesso!";
			}
			else {
				men = "Prontuario não encontrado!";
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
			OutputStream os = new FileOutputStream("prontuario.csv");
			PrintWriter pw = new PrintWriter
					 (new OutputStreamWriter(os, "ISO-8859-1"));
			pw.append("codProntuario;dataAtendimento;registroConsulta;examesConsulta\n");
			sql = "select * from prontuario_consulta";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//gravar no CSV
				String linha = bd.rs.getString("codProntuario")+";"+
						bd.rs.getString("dataAtendimento")+";"+
						bd.rs.getString("registroConsulta")+";"+
						bd.rs.getString("examesConsulta")+"\n";
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
