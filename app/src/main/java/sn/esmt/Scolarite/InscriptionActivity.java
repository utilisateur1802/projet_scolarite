package sn.esmt.Scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.Scolarite.http.Api;
import sn.esmt.Scolarite.http.EtudiantResponse;

public class InscriptionActivity extends AppCompatActivity {

    private Button retourbt;
    private EditText mattxt;
    private EditText nomtxt;
    private EditText prenomtxt;
    private EditText adrtxt;
    private EditText teltxt;
    private EditText fr_inscriptiontxt;
    private Button validerbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        mattxt = (EditText)  findViewById(R.id.mattxt);
        nomtxt = (EditText)  findViewById(R.id.nomtxt);
        prenomtxt = (EditText)  findViewById(R.id.prenomtxt);
        adrtxt = (EditText)  findViewById(R.id.adrtxt);
        teltxt = (EditText)  findViewById(R.id.teltxt);
        fr_inscriptiontxt = (EditText)  findViewById(R.id.fr_inscriptiontxt);

        //Recuperation de l'id du bouton login
        retourbt = (Button) findViewById(R.id.retourbt);
        validerbt = (Button) findViewById(R.id.validerbt);
        validerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8081/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);
                EtudiantResponse e = new EtudiantResponse();
                e.setMat(mattxt.getText().toString());
                e.setNom(nomtxt.getText().toString());
                e.setPrenom(prenomtxt.getText().toString());
                e.setAdr(adrtxt.getText().toString());
                e.setTel(Integer.parseInt(teltxt.getText().toString()));
                e.setFrais(Double.parseDouble(fr_inscriptiontxt.getText().toString()));

                Call<EtudiantResponse> callSave = api.saveEtudiant(e);
                callSave.enqueue(new Callback<EtudiantResponse>() {
                    @Override
                    public void onResponse(Call<EtudiantResponse> call, Response<EtudiantResponse> response) {
                        Toast.makeText(InscriptionActivity.this,"OK",Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void onFailure(Call<EtudiantResponse> call, Throwable t) {
                        Toast.makeText(InscriptionActivity.this,"KO",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}