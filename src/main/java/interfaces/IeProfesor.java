package interfaces;

import java.util.List;

import model.Profesor;

public interface IeProfesor {
	public void RegistrarProfesor(Profesor p);
	public void EliminarProfesor(int id);
	public void ActualizarProfesor(Profesor p);
	public Profesor BuscarProfesor(int id);
	public List<Profesor> ListarProfesor(Boolean activos);
}
