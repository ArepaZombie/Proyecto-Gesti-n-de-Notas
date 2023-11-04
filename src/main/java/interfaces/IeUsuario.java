package interfaces;
import java.util.List;

import model.Usuario;

public interface IeUsuario {
	public Usuario ValidarUsuario(Usuario u);
	public void RegistrarUsuario(Usuario u);
	public void EliminarUsuario(int id);
	public void ActualizarUsuario(Usuario u);
	public Usuario BuscarUsuario(int id);
	public List<Usuario> ListarUsuarios(Boolean activos);
}
