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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp = null;
        CharSequence[] numeros = {"1","2","3","4","5","6","7","8","9"};
        TableLayout tabla = findViewById(R.id.sudoku);

        for(int i=0;i < 9;i++){
            TableRow row = new TableRow(this);
            for(int j=0;j < 9;j++){
                sp = new Spinner(this);


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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int fila = (int) adapterView.getTag(R.id.fila);
        int col = (int) adapterView.getTag(R.id.col);

        Toast(String.valueOf(fila));
        Toast(String.valueOf(col));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void Toast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}