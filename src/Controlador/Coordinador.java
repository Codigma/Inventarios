package Controlador;

import Modelo.SystemDao;
import Modelo.SystemVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Inicio;
import Vista.Login;

public class Coordinador {

    private Login login;
    private Inicio inicio;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Inicio getInicio() {
        return inicio;
    }

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public void mostrarPrincipal() {
        getInicio().setVisible(true);
        getLogin().dispose();
    }

    public UsuarioVo buscarUsuario(Integer id_user) {
        UsuarioDao usuario = new UsuarioDao();
        return usuario.getUsuario(id_user);
    }

    public SystemVo buscarUser(String user, String password) {
        SystemDao system = new SystemDao();
        return system.getUser(user, password);

    }

}
