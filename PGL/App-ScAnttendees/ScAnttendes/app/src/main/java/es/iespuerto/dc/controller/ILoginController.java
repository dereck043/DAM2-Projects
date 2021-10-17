package es.iespuerto.dc.controller;

public interface ILoginController {
    void OnLogin(String email,String clave);
    int isValid(String email, String clave);
}
