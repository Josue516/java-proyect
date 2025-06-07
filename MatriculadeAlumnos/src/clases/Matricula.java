package clases;

public class Matricula {

		private int numMatricula, codAlumno, codCurso;
		private String fecha, hora;
		
		public Matricula (int numMatricula, int codAlumno, int codCurso, String fecha, String hora){
			this.numMatricula = numMatricula;
			this.codAlumno = codAlumno;
			this.codCurso = codCurso;
			this.fecha = fecha;
			this.hora = hora;
		}
	
		public void setNumeroMatricula(int numMatricula) {
			this.numMatricula = numMatricula;
		}

		public void setCodigoAlumno(int codAlumno) {
			this.codAlumno = codAlumno;
		}

		public void setCodigoCurso(int codCurso) {
			this.codCurso = codCurso;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public void setHora(String hora) {
			this.hora = hora;
		}
		
		public int getNumeroMatricula() {
			return numMatricula;
		}

		public int getCodigoAlumno() {
			return codAlumno;
		}

		public int getCodigoCurso() {
			return codCurso;
		}

		public String getFecha() {
			return fecha;
		}

		public String getHora() {
			return hora;
		}
		
}
