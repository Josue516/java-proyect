package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Alumno;

public class ArregloAlumnos {
	private ArrayList<Alumno> alumno;
	
	public ArregloAlumnos() {
		alumno = new ArrayList<Alumno>();

		cargarAlumnos();
	}
	
	public void adicionar(Alumno x) {
		alumno.add(x);
		grabarAlumnos();
	}
	public void eliminar(Alumno x) {
		alumno.remove(x);
		grabarAlumnos();
	}
	public int tamaño() {
		return alumno.size();
	}
	public Alumno obtener(int i) {
		return alumno.get(i);
	}
	public Alumno buscar(int codigo) {
		for (int i = 0; i < alumno.size(); i++) {
			if (alumno.get(i).getCodAlumno() == codigo)
				return alumno.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (alumno.size() == 0) return 202010001;
		return alumno.get(alumno.size()-1).getCodAlumno() + 1;
	}
	public void ActualizarArchivo() {
		grabarAlumnos();
	}
	
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i = 0; i< alumno.size(); i++) {
				x = alumno.get(i);
				linea = x.getCodAlumno() + ";" +
					    x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getEdad() + ";" +
						x.getCelular() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni;
			String[] s;
			int codAlumno, edad, celular, estado;
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				edad = Integer.parseInt(s[4].trim());
				celular = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
