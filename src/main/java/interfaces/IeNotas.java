package interfaces;

import java.util.List;

import model.Nota;

public interface IeNotas {
	public String RegistrarNota(Nota c);
	//public void EliminarNota(int id);
	public void ActualizarNota(Nota c);
	public Nota BuscarNota(int idsalon,int idalumno);
	public List<Nota> ListarNotas();
	public List<Nota> ListarNotasxAlumno(int idalumno);
}
