package clases;

public class Alumno{
	//atributos
	private int codAlumno, edad, celular, estado;
	private String nombres, apellidos, dni;
	
	// Constructor
	
	public Alumno(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		this.codAlumno=codAlumno;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.dni=dni;
		this.edad=edad;
		this.celular=celular;
		this.estado = estado;
	}
	//metodos get an set
	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}