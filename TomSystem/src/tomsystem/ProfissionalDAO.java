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

public class ProfissionalDAO {
	
		private String men, sql;
		private BD bd;
		
		public ProfissionalDAO() {
			bd = new BD();
		}
		
		public List<Profissional> getProfissional(String sql) {
			List<Profissional> lista = new ArrayList<Profissional>();
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery();
				while (bd.rs.next() ) {
					Profissional pr = new 
							Profissional(bd.rs.getInt(1), bd.rs.getString(2),bd.rs.getString(3), bd.rs.getString(4), bd.rs.getString(5),bd.rs.getString(6));
					lista.add(pr);
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
		public String salvar(Profissional pr) {
			sql = "insert into profissional values (?,?,?,?,?,?)";
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, pr.getCpfProfissional());
				bd.st.setString(2, pr.getNomeProfissional());
				bd.st.setString(3, pr.getDataNascProfissional());
				bd.st.setString(4, pr.getConselhoDeClasse());
				bd.st.setString(5, pr.getEnderecoProfissional());
				bd.st.setString(6, pr.getTelefoneProfissional());
				bd.st.executeUpdate();
				men = "Profissional cadastrado com sucesso!";
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
		public String excluir(int cpfProfissional) {
			sql = "delete from profissional where CPF_Profissional = ?";
			bd.getConnection();
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, cpfProfissional);
				int n = bd.st.executeUpdate();
				if(n==1) {
					men = "Profissional excluído com sucesso!";
				}
				else {
					men = "Profissional não encontrado!";
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
				OutputStream os = new FileOutputStream("profissional.csv");
				PrintWriter pw = new PrintWriter
						 (new OutputStreamWriter(os, "ISO-8859-1"));
				pw.append("cpfProfissional;nomeProfissional;dataNascProfissional;conselhoDeClasse;enderecoProfissional;telefoneProfissional\n");
				sql = "select * from profissional";
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery();
				while(bd.rs.next()) {
					//gravar no CSV
					String linha = bd.rs.getString("cpfProfissional")+";"+
							bd.rs.getString("nomeProfissional")+";"+
							bd.rs.getString("dataNascProfissional")+
							bd.rs.getString("conselhoDeClasse")+";"+
							bd.rs.getString("enderecoProfissional")+";"+
							bd.rs.getString("telefoneProfissional")+";"+"\n";
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


