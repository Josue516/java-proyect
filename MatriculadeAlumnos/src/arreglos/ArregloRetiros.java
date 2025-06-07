package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Retiro;

public class ArregloRetiros {
	private ArrayList<Retiro> retiro;
	
	public ArregloRetiros() {
		retiro = new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	public void adicionar(Retiro x) {
		retiro.add(x);
		grabarRetiros();
	}
	public void eliminar(Retiro x) {
		retiro.remove(x);
		grabarRetiros();
	}
	public int tamaño() {
		return retiro.size();
	}
	public Retiro obtener(int i) {
		return retiro.get(i);
	}
	public Retiro buscar(int codigo) {
		for (int i = 0; i < retiro.size(); i++) {
			if (retiro.get(i).getNumRetiro() == codigo)
				return retiro.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (retiro.size() == 0) return 200001;
		return retiro.get(retiro.size()-1).getNumRetiro() + 1;
	}
	public void ActualizarArchivo() {
		grabarRetiros();
	}
	
	private void grabarRetiros() {
		try {
			PrintWriter pw;
			String linea;
			Retiro x;
			pw = new PrintWriter(new FileWriter("retiros.txt"));
			for (int i = 0; i< retiro.size(); i++) {
				x = retiro.get(i);
				linea = x.getNumRetiro() + ";" +
					    x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarRetiros() {
		try {
			BufferedReader br;
			int numRetiro, numMatricula;
			String fecha, hora, linea;
			String[] s;
			br = new BufferedReader(new FileReader("retiros.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numRetiro = Integer.parseInt(s[0].trim());
				numMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				adicionar(new Retiro(numRetiro, numMatricula, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
