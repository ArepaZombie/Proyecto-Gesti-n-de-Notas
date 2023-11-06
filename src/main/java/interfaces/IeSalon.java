package interfaces;

import java.util.List;

import model.Salon;

public interface IeSalon {
	public void RegistrarSalon(Salon s);
	public void EliminarSalon(int id);
	public void ActualizarSalon(Salon s);
	public Salon BuscarSalon(int id);
	public List<Salon> ListarSalon(Boolean activos);
	public List<Salon> ListarSalonesDisponibles(String turno, int ciclo, int idcarrera);
	public List<Salon> ListarSalonesProfesor(int idprofesor);
	public List<Salon> ListarSalonesCurso(int idcurso);
}