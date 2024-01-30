package com.example.simplenotesr;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText noteHeadingEditText;
    private EditText noteContentEditText;
    private Button addButton;
    private ListView notesListView;

    private ArrayAdapter<String> notesAdapter;
    private ArrayList<String> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteHeadingEditText = findViewById(R.id.editTextTextPersonName);
        noteContentEditText = findViewById(R.id.contentfield);
        addButton = findViewById(R.id.savebutton);
        notesListView = findViewById(R.id.listView);

        notesList = new ArrayList<>();
        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(notesAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
            }
        });
    }
    private void addNote() {
        String heading = noteHeadingEditText.getText().toString().trim();
        String content = noteContentEditText.getText().toString().trim();

        if (!heading.isEmpty() && !content.isEmpty()) {
            String note = heading + "\n:" + content;
            notesList.add(note);
            notesAdapter.notifyDataSetChanged();

            // Clear input fields
            noteHeadingEditText.getText().clear();
            noteContentEditText.getText().clear();
        }

    }
 }