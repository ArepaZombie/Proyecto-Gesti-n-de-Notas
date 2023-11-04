package interfaces;

import java.util.List;

import model.Alumno;

public interface IeAlumno {
	public void RegistrarAlumno(Alumno a);
	public void EliminarAlumno(int id);
	public void ActualizarAlumno(Alumno a);
	public Alumno BuscarAlumno(int id);
	public List<Alumno> ListarAlumno(Boolean activos);
}
