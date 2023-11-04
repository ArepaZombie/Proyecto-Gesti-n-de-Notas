package interfaces;

import java.util.List;

import model.Carrera;

public interface IeCarrera {
	public void RegistrarCarrera(Carrera a);
	public void EliminarCarrera(int id);
	public void ActualizarCarrera(Carrera a);
	public Carrera BuscarCarrera(int id);
	public List<Carrera> ListarCarrera(Boolean activos);
}
