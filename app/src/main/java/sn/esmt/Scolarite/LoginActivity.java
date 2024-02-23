package sn.esmt.Scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailtxt;
    private EditText mdptxt;
    private Button loginbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Recuperation des valeurs saisies
        emailtxt = (EditText)  findViewById(R.id.emailtxt);
        mdptxt = (EditText) findViewById(R.id.mdptxt);

        //Recuperation de l'id du bouton login
        loginbt = (Button) findViewById(R.id.loginbt);
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailtxt.getText().toString();
                String mdp = mdptxt.getText().toString();
                if(email.isEmpty() || mdp.isEmpty()){
                    Toast.makeText(LoginActivity.this,
                            "Veuillez renseiger les champs",Toast.LENGTH_LONG).show();
                }
                else{
                    if(email.equals("esmt@esmt.sn") && mdp.equals("123")){
                        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,
                                "E-mail ou mot de passe incorrect",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}