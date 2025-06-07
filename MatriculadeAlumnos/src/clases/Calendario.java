package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendario {
	public static String fechaActual() {
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(calendario.getTime());
	}
	public static String horaActual() {
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		return formato.format(calendario.getTime());
	}
}
