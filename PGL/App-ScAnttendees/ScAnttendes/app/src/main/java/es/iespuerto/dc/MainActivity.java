package es.iespuerto.dc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.iespuerto.dc.controller.ILoginController;
import es.iespuerto.dc.controller.LoginController;
import es.iespuerto.dc.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText nombreUsuario,clave;
    Button loginb;
    ILoginController loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreUsuario = (EditText) findViewById(R.id.email);
        clave = (EditText)findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.loginb);
        loginPresenter = new LoginController(this);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(nombreUsuario.getText().toString().trim(),clave.getText().toString().trim());
            }
        });
    }
    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}