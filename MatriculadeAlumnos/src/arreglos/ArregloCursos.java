package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Curso;

public class ArregloCursos {
	private ArrayList<Curso> curso;
	
	public ArregloCursos() {
		curso = new ArrayList<Curso>();
		cargarCursos();
	}
	
	public void adicionar(Curso x) {
		curso.add(x);
		grabarCursos();
	}
	public void eliminar(Curso x) {
		curso.remove(x);
		grabarCursos();
	}
	public int tamaño() {
		return curso.size();
	}
	public Curso obtener(int i) {
		return curso.get(i);
	}
	public Curso buscar(int codigo) {
		for (int i = 0; i < curso.size(); i++) {
			if (curso.get(i).getCodCurso() == codigo)
				return curso.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (curso.size() == 0)
			return 101;
		return curso.get(curso.size()-1).getCodCurso() + 1;
	}
	public void ActualizarArchivo() {
		grabarCursos();
	}
	
	private void grabarCursos() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("cursos.txt"));
			for (int i = 0; i< curso.size(); i++) {
				x = curso.get(i);
				linea = x.getCodCurso() + ";" +
					    x.getAsignatura() + ";" +
						x.getCiclo() + ";" +
						x.getCreditos() + ";" +
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarCursos() {
		try {
			BufferedReader br;
			int codCurso, ciclo, creditos, horas;
			String asignatura, linea;
			String[] s;
			br = new BufferedReader(new FileReader("cursos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				curso.add(new Curso(codCurso, asignatura, ciclo, creditos, horas));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}
}
