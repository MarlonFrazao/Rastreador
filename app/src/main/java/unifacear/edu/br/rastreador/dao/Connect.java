package unifacear.edu.br.rastreador.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Connect extends SQLiteOpenHelper {

    private static SQLiteDatabase instance;


    public Connect(Context context,
                   String name,
                   SQLiteDatabase.CursorFactory factory,
                   int version) {
        super(context, name, factory, version);
        instance = getWritableDatabase();
    }

    public static SQLiteDatabase getInstatnce() {
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table veiculo(" +
                "id integer not null primary key autoincrement, " +
                "placa string not null, " +
                "modelo string not null, " +
                "marca string not null);" +
                "");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
