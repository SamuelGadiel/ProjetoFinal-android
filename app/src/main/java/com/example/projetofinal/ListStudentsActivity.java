package com.example.projetofinal;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListStudentsActivity extends Activity {
    DatabaseHelper db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        listView = findViewById(R.id.list_students);
        db = new DatabaseHelper(this);

        loadStudentList();
    }

    private void loadStudentList() {
        ArrayList<String> studentList = new ArrayList<>();
        Cursor cursor = db.getAllStudents();

        if (cursor.moveToFirst()) {
            do {
                // Modificar conforme sua implementação
                studentList.add(cursor.getString(1)); // A coluna 1 é o nome do estudante
            } while (cursor.moveToNext());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);
    }
}
