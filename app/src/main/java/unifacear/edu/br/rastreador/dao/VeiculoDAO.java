package unifacear.edu.br.rastreador.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import unifacear.edu.br.rastreador.entity.Veiculo;

public class VeiculoDAO {

    SQLiteDatabase conn = Connect.getInstatnce();

    public void inserir(Veiculo v) {
        ContentValues values = new ContentValues();
        values.put("placa", v.getPlaca());
        values.put("modelo", v.getModelo());
        values.put("marca", v.getMarca());

        conn.insert("veiculo",
                null,
                values);
    }

    public void alterar(Veiculo v) {

    }

    public List<Veiculo> listar() {
        Cursor c = conn.query("veiculo",
                new String[]{"id", "placa", "modelo", "marca"},
                null,
                null,
                null,
                null,
                "id asc");
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        if(c.moveToFirst()) {
            do {
                Veiculo v = new Veiculo();
                v.setId(c.getInt(c.getColumnIndex("id")));
                v.setPlaca(c.getString(c.getColumnIndex("placa")));
                v.setModelo(c.getString(c.getColumnIndex("modelo")));
                v.setMarca(c.getString(c.getColumnIndex("marca")));
                veiculos.add(v);
            }while (c.moveToNext());
        }
        return veiculos;
    }

    public void excluir(Veiculo v) {

    }
}
