package pe.edu.ulima.comicsstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.comicsstore.model.UserManager;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, UserManager.LoginListener {

    private Button butLogin;
    private EditText eteUsuario, etePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eteUsuario = findViewById(R.id.eteUsuario);
        etePassword = findViewById(R.id.etePassword);
        butLogin = findViewById(R.id.butLogin);

        butLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i(getClass().getCanonicalName(), "Se hizo click");
        final UserManager manager = new UserManager();
        manager.login(
                eteUsuario.getText().toString(),
                etePassword.getText().toString(), this);

    }

    @Override
    public void onOk() {
        // Codigo si todo estuvo correcto
        final Intent i = new Intent();
        i.setClass(this, ShelfActivity.class);
        startActivity(i);
    }

    @Override
    public void onError(String error) {
        // Codigo si hubo error en login
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
