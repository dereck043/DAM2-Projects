package es.iespuerto.dc.model;

public interface IUser {
    String getEmail();
    String getPassword();
    int isValid();
}
