package com.example.tdd1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText wordLength;
    private TextView resultTextView;
    private Button generateButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app5);
        wordLength = findViewById(R.id.wordLength);
        resultTextView = findViewById(R.id.resultTextView);
        generateButton = findViewById(R.id.generateButton);

        generateButton.setOnClickListener(view -> generateWord());
    }

    private void generateWord() {
        String lengthInput = wordLength.getText().toString();

        if (lengthInput.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer une taille", Toast.LENGTH_SHORT).show();
            return;
        }

        int length = Integer.parseInt(lengthInput);
        String generatedWord = createRandomWord(length);
        resultTextView.setText(generatedWord);
    }

    private String createRandomWord(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * alphabet.length());
            word.append(alphabet.charAt(index));
        }
        return word.toString();
    }
}
