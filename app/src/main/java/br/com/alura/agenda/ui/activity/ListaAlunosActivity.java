package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDao;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Toast.makeText(this, "Olá Mundo!", Toast.LENGTH_LONG).show(); >> Cria uma mensagem que aparece e some na tela
        //  TextView aluno = new TextView(this); aluno.setText("Jeniffer"); >> Inserindo a View através do Java

        setContentView(R.layout.activity_lista_alunos);

        setTitle(TITULO_APPBAR);

        //Fazendo a inclusão pelo java
//        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "José", "Jeni", "Romeu"));
//        TextView primeiroAluno = findViewById(R.id.textView);
//        TextView segundoAluno = findViewById(R.id.textView2);
//        TextView terceiroAluno = findViewById(R.id.textView3);
//        primeiroAluno.setText(alunos.get(0));
//        segundoAluno.setText(alunos.get(1));
//        terceiroAluno.setText(alunos.get(2));

        configuraFabNovoAluno();

    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.lista_de_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos())); //qual activity vai usar | layout padrão do android com textview | qual lista será usada
    }

}
