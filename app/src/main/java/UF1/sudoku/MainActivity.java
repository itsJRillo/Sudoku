package UF1.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence[] numeros = {"1","2","3","4","5","6","7","8","9"};
        TableLayout tabla = findViewById(R.id.sudoku);

        for(int i=0;i < 9;i++){
            TableRow row = new TableRow(this);
            for(int j=0;j < 9;j++){
                Spinner sp = new Spinner(this);
                sp.setTag(R.id.fila,i);
                sp.setTag(R.id.col,j);

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int fila = (int) adapterView.getTag(R.id.fila);
                        int col = (int) adapterView.getTag(R.id.col);

                        String txtFila = adapterView.getSelectedItem().toString();
                        String txtCol = adapterView.getSelectedItem().toString();

                        Toast("Fila: " + fila + " | Columna: " + col + "\nValor: " + txtFila);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });

                sp.setBackground(null);
                sp.setPadding(5,5,5,5);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, numeros);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(adapter);

                row.addView(sp);
            }
            tabla.addView(row);
        }
    }


    public void Toast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}