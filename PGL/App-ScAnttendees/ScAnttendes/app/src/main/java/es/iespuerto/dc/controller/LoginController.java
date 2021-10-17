package es.iespuerto.dc.controller;

import android.text.TextUtils;
import android.util.Patterns;

import es.iespuerto.dc.model.Usuario;
import es.iespuerto.dc.view.ILoginView;

public class LoginController implements ILoginController {
    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    /**
     * Funcion que valida los parametros introducidos por el usuario
     * @param nombreUsuario del usuario
     * @param clave del usuario
     */
    @Override
    public void OnLogin(String nombreUsuario, String clave) {
        int loginCode = isValid(nombreUsuario,clave);
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

    /**
     * Funcion que verifica si los datos ingresados son validos para verificar  al usuario
     * @return (-1..2)
     *  0. nombreUsuario vacio
     *  1. clave vacio
     *  2. clave <= 6
     * -1. Ok
     */

    public int isValid(String nombreUsuario, String clave) {
        if(TextUtils.isEmpty(nombreUsuario))
            return  0;
        else if(TextUtils.isEmpty(clave))
            return 1;
        else if(clave.length()<=6)
            return 2;
        else
            return -1;
    }
}
