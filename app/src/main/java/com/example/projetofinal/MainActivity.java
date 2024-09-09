package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        studentName = findViewById(R.id.edit_student_name);

        Button addStudent = findViewById(R.id.button_add_student);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = studentName.getText().toString();
                db.addStudent(name, 0); // Nota 0 por padrão
                studentName.setText(""); // Limpa o campo após adicionar
            }
        });

        Button listStudents = findViewById(R.id.button_list_students);
        listStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListStudentsActivity.class);
                startActivity(intent);
            }
        });
    }
}