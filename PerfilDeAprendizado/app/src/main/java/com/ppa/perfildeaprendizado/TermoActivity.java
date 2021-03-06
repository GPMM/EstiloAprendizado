package com.ppa.perfildeaprendizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewDebug;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ppa.perfildeaprendizado.data.model.Aluno;
import com.ppa.perfildeaprendizado.ui.login.LoginActivity;

public class TermoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoginActivity.loadingProgressBar.setVisibility(View.GONE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termo);
        final TextView textoTermo = findViewById(R.id.textoTermo);
        final RadioButton radioSim = findViewById(R.id.radioYes);
        final RadioButton radioNao = findViewById(R.id.radioNo);
        //final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarLogin();
            }
        });
        radioSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarPerguntasPessoais();
            }
        });
        textoTermo.setMovementMethod(new ScrollingMovementMethod());
    }

    public void iniciarPerguntasPessoais(){
        Aluno aluno = (Aluno) getIntent().getSerializableExtra(Aluno.class.getSimpleName());
        Intent intent = new Intent(this, QuestionarioActivity.class);
        intent.putExtra(Aluno.class.getSimpleName(), aluno);
        startActivity(intent);
    }

    public void voltarLogin(){
        finish();
    }
}
