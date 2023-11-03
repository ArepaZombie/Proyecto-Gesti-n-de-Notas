package interfaces;
import java.util.List;

import model.Usuario;

public interface IeUsuario {
	public Usuario ValidarUsuario(Usuario u);
	public void RegistrarUsuario(Usuario u);
	public void EliminarUsuario(Usuario u);
	public void ActualizarUsuario(Usuario u);
	public Usuario BuscarUsuario(Usuario u);
	public List<Usuario> ListarUsuarios();
}
