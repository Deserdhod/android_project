package com.example.kvas_map;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class AcivmentsActivity extends AppCompatActivity {

    ListView listView;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivments);

        listView = findViewById(R.id.list);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });

        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.create_db();

        Button homeButton2 = (Button) findViewById(R.id.home_button2);
        View.OnClickListener onClickListenerHomeButton2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome2 = new Intent(AcivmentsActivity.this, MainActivity.class);
                startActivity(intentHome2);
            }
        };
        homeButton2.setOnClickListener(onClickListenerHomeButton2);
    }

    @Override
    public void onResume() {
        super.onResume();
// открываем подключение
        db = databaseHelper.open();
//получаем данные из бд в виде курсора
        cursor = db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
// определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[]{DatabaseHelper.COLUMN_TEXT};
// создаем адаптер, передаем в него курсор
        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                cursor, headers, new int[]{android.R.id.text1}, 0);
        listView.setAdapter(cursorAdapter);
    }

    // по нажатию на кнопку запускаем UserActivity для добавления данных
    public void add(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
// Закрываем подключение и курсор
        db.close();
        cursor.close();
    }
}