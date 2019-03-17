package unifacear.edu.br.rastreador;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import unifacear.edu.br.rastreador.dao.Connect;
import unifacear.edu.br.rastreador.dao.VeiculoDAO;
import unifacear.edu.br.rastreador.entity.Veiculo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new Connect(getApplicationContext(),"veiculo.db", null, 1);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void telaCadastro() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void telaRastreio() {
        setContentView(R.layout.activity_rastreio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cadastrar) {
            telaCadastro();
        } else if (id == R.id.rastrear){
            telaRastreio();
        }

        return super.onOptionsItemSelected(item);
    }

    public void salvar(View v) {
        Button salvar = findViewById(R.id.salvar);

        Veiculo veiculo = new Veiculo();

        EditText edPlaca = findViewById(R.id.placa);
        EditText edModelo = findViewById(R.id.modelo);
        Spinner sMarca = findViewById(R.id.marca);

        veiculo.setPlaca(edPlaca.getText().toString());
        veiculo.setModelo(edModelo.getText().toString());
        veiculo.setMarca(sMarca.getSelectedItem().toString());

        new VeiculoDAO().inserir(veiculo);
    }
}
