package es.iespuerto.dc.controller;

import es.iespuerto.dc.model.User;
import es.iespuerto.dc.view.ILoginView;

public class LoginController implements ILoginController {
    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    /**
     * Funcion que valida los parametros introducidos por el usuario
     * @param email del usuario
     * @param password del usuario
     */
    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValid();
        switch(loginCode) {
            case 0 :
                loginView.OnLoginError("Por favor introduce un Email");
                break;
            case 1 :
                loginView.OnLoginError("Por favor introduce un Email valido");
                break;
            case 2 :
                loginView.OnLoginError("Por favor introduce un Password");
                break;
            case 3 :
                loginView.OnLoginError("Por favor introduce un Password > 6");
                break;
            default :
                loginView.OnLoginSuccess("Login correcto");
        }
    }
}
