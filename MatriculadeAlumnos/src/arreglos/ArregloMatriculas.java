package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Matricula;

public class ArregloMatriculas {
	private ArrayList<Matricula> matricula;
	
	public ArregloMatriculas() {
		matricula = new ArrayList<Matricula>();
		cargarMatriculas();
	}
	
	public void adicionar(Matricula x) {
		matricula.add(x);
		grabarMatriculas();
	}
	public void eliminar(Matricula x) {
		matricula.remove(x);
		grabarMatriculas();
	}
	public int tamaño() {
		return matricula.size();
	}
	public Matricula obtener(int i) {
		return matricula.get(i);
	}
	public Matricula buscar(int codigo) {
		for (int i = 0; i < matricula.size(); i++) {
			if (matricula.get(i).getNumeroMatricula() == codigo)
				return matricula.get(i);
		}
		return null;
	}
	public Matricula buscarCod(int codigo) {
		for (int i = 0; i < matricula.size(); i++) {
			if (matricula.get(i).getCodigoAlumno() == codigo)
				return matricula.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (matricula.size() == 0) return 100001;
		return matricula.get(matricula.size()-1).getNumeroMatricula() + 1;
	}
	public void ActualizarArchivo() {
		grabarMatriculas();
	}
	
	private void grabarMatriculas() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("matriculas.txt"));
			for (int i = 0; i< matricula.size(); i++) {
				x = matricula.get(i);
				linea = x.getNumeroMatricula() + ";" +
					    x.getCodigoAlumno() + ";" +
						x.getCodigoCurso() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarMatriculas() {
		try {
			BufferedReader br;
			int numMatricula, codAlumno, codCurso;
			String fecha, hora, linea;
			String[] s;
			br = new BufferedReader(new FileReader("matriculas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();
				adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
