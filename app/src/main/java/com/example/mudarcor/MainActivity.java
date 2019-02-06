package com.example.mudarcor;

import android.content.SharedPreferences;
import android.support.annotation.ColorInt;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup opcoes;
    private RadioButton radioButtonVermelho,radioButtonAzul,radioButtonAmarelo;
    private ConstraintLayout telaPrincipal;
    public static final String CHAVE_SHAREDPREFERENCES="sharedPreferenceCorEscolhida";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opcoes=findViewById(R.id.RadioGroupCores);
        radioButtonAmarelo=findViewById(R.id.radioButtonAmarelo);
        radioButtonAzul=findViewById(R.id.radioButtonAzul);
        radioButtonVermelho=findViewById(R.id.radioButtonVermelho);
        telaPrincipal=findViewById(R.id.constraintTela);




        opcoes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                try {
                    String corEscolhida;
                    switch (i) {
                        case R.id.radioButtonAmarelo:
                            telaPrincipal.setBackgroundColor(R.color.colorPrimaryDark);
                            Toast.makeText(getApplicationContext(), "btn apertado amarelo", Toast.LENGTH_SHORT).show();
                            salvarCor("Amarelo");


                            break;
                        case R.id.radioButtonAzul:
                            telaPrincipal.setBackgroundColor(R.color.colorPersonalAzul);
                            Toast.makeText(getApplicationContext(), "btn apertado azul", Toast.LENGTH_SHORT).show();
                            salvarCor("Azul");
                            break;

                        case R.id.radioButtonVermelho:
                            telaPrincipal.setBackgroundColor(R.color.colorPersonalVermelho);
                            Toast.makeText(getApplicationContext(), "btn apertado varmelho", Toast.LENGTH_SHORT).show();
                            salvarCor("Vermelho");
                            break;


                    }
                }finally {
                    lerCor();
                }




            }
        });



    }
    public void salvarCor(String cor) {

        SharedPreferences sharedPreference = getSharedPreferences(CHAVE_SHAREDPREFERENCES, 0);

        SharedPreferences.Editor edit =sharedPreference.edit();

        edit.putString("corEscolhida",cor);
        edit.commit();



    }
    public void lerCor(){
        SharedPreferences sharedPreferences=getSharedPreferences(CHAVE_SHAREDPREFERENCES,0);
        String corRecuperada=sharedPreferences.getString("corEscolhida","");
        Toast.makeText(getApplicationContext(),corRecuperada,Toast.LENGTH_SHORT).show();






    }

}
