package interfaces;

import java.util.List;

import model.Curso;

public interface IeCurso {
	public void RegistrarCurso(Curso c);
	public void EliminarCurso(int id);
	public void ActualizarCurso(Curso c);
	public Curso BuscarCurso(int id);
	public List<Curso> ListarCurso(Boolean activos);
}