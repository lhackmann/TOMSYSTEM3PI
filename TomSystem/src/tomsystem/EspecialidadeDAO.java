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


public class EspecialidadeDAO {
	private String men, sql;
	private BD bd;
	
	public EspecialidadeDAO() {
		bd = new BD();
	}
	/**
	 * Retorna a lista de produtos existentes na tabela produtos
	 * @return
	 */
	public List<Especialidade> getEspecialidade(String sql){
		List<Especialidade> lista = new ArrayList<Especialidade>();
		bd.getConnection();
		//String sql = "select * from produtos";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				Especialidade es = new //criando um produto a partir dos dados do banco
			Especialidade(bd.rs.getInt(1), bd.rs.getString(2));
				lista.add(es);
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
	
	public String salvar(Especialidade es) {
		sql = "insert into especialidade values(?,?,?)";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, es.getCodEspecialidade());
			bd.st.setString(2, es.getNomeEspecialidade());
			bd.st.executeUpdate();
			men = "Especialidade inserida com sucesso!";
		}
		catch(SQLException e) {
			//tentar realizar um update
			sql = "update especialidade set nome_especialidade = ? where cod_especialidade = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(2, es.getCodEspecialidade());
				bd.st.setString(1, es.getNomeEspecialidade());
				bd.st.executeUpdate();
				men = "Especialidade alterada com sucesso!";
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
	
	public String excluir(int codEspecialidade) {
		sql = "delete from especialidade where cod_especialidade = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codEspecialidade);
			int n = bd.st.executeUpdate();
			if(n==1) {
				men = "Especialidade excluída com sucesso!";
			}
			else {
				men = "Especialidade não encontrada!";
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
			OutputStream os = new FileOutputStream("especialidade.csv");
			PrintWriter pw = new PrintWriter
					 (new OutputStreamWriter(os, "ISO-8859-1"));
			pw.append("codEspecialidade;nomeEspecialidade\n");
			sql = "select * from especialidade";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) {
				//gravar no CSV
				String linha = bd.rs.getString("codEspecialidade")+";"+
						bd.rs.getString("nomeEspecialidade")+";"+"\n";
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
