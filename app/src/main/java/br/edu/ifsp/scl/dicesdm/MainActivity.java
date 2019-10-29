package br.edu.ifsp.scl.dicesdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Random geradorRandomico;

    private TextView resultadoTextView;
    private Button jogarDadoButton;

    private ImageView resultadoImageView;

    private Spinner numDadosSpinner;
    private ImageView resultado2ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numDadosSpinner = findViewById(R.id.numDadosSpinner);
        resultado2ImageView = findViewById(R.id.resultado2ImageView);

        geradorRandomico = new Random(System.currentTimeMillis());

        resultadoTextView = findViewById(R.id.resultadoTextView);

        resultadoImageView = findViewById(R.id.resultadoImageView);

        jogarDadoButton = findViewById(R.id.jogarDadoButton);
        jogarDadoButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.jogarDadoButton) {
           int numDados = Integer.parseInt(numDadosSpinner.getSelectedItem().toString());

           String resultadoText = "Faces sorteadas: ";

           if (numDados == 2) {
               resultado2ImageView.setVisibility(View.VISIBLE);
           }else{
               resultado2ImageView.setVisibility(View.GONE);
               resultadoText = "Face sorteada: ";
           }

           for (int i = 1; i <= numDados; i++) {
               int resultado =  geradorRandomico.nextInt(6) + 1;
               resultadoText += resultado + ", ";
               ImageView iv = (i == 1) ? resultadoImageView : resultado2ImageView;
               setImageResource(iv, resultado);
           }

           resultadoTextView.setText(resultadoText.substring(0, resultadoText.lastIndexOf(",")));

        }
    }

    public void setImageResource(ImageView iv, int face) {
        switch (face) {
            case 1:
                iv.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                iv.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                iv.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                iv.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                iv.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                iv.setImageResource(R.drawable.dice_6);
                break;
        }

    }
}
