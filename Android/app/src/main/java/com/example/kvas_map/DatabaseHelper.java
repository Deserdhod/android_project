package com.example.kvas_map;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH; // полный путь к базе данных
    private static String DB_NAME = "Kvas.db";
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "Users"; // название таблицы в бд
    // названия столбцов
    static final String COLUMN_ID = "_id";
    static final String COLUMN_TEXT = "text";;
    private Context myContext;

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) { }

    void create_db(){

        File file = new File(DB_PATH);
        if (!file.exists()) {
            //получаем локальную бд как поток
            try(InputStream myInput = myContext.getAssets().open(DB_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new FileOutputStream(DB_PATH)) {

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("DatabaseHelper", ex.getMessage());
            }
        }
    }
    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }

/*    private final Context context;

    public static class TableNote {
        public static final String TABLE_NAME = "profile";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_EMAIL = "email";

        public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXIST" + TABLE_NAME +
                " ( " +
                    COLUMN_ID + "INTEGER PRIMARY KEY NOT NULL, " +
                    COLUMN_LOGIN + "TEXT, " +
                    COLUMN_PASSWORD + "TEXT, " +
                    COLUMN_EMAIL + "TEXT, " +
                ");";

        public static final String SELECT_ONE_BY_ID_QUERY = COLUMN_ID + " = ?";
        public static final String SELECT_ALL_QUERY = "SELECT * FROM " + TABLE_NAME;
        public static final String DROP_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String DELETE_ALL_QUERY = "DELETE FROM " + TABLE_NAME;
    }

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Kvas.db", null, 30);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TableNote.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TableNote.DROP_QUERY);
        onCreate(sqLiteDatabase);
    }

    public int addProfile() {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();


    }*/
}
