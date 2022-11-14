package UF1.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SudokuModel model = new SudokuModel();
    private Spinner[][] matriu = new Spinner[9][9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence[] numeros = {"0","1","2","3","4","5","6","7","8","9"};
        TableLayout tabla = findViewById(R.id.sudoku);

        for(int i=0;i < 9;i++){
            TableRow row = new TableRow(this);

            for(int j=0;j < 9;j++){
                Spinner sp = new Spinner(this);
                sp.setBackground(null);
                sp.setPadding(5,5,5,5);
                sp.setSelection(1);
                sp.setTag("bug init");
                sp.setTag(R.id.fila,i);
                sp.setTag(R.id.col,j);

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long l) {

                        int fila = (int) adapterView.getTag(R.id.fila);
                        int col = (int) adapterView.getTag(R.id.col);

                        if (sp.getTag().equals("bug init")){
                            return;
                        }

                        // String txtFila = adapterView.getSelectedItem().toString();
                        // Toast("Fila: " + fila + " | Columna: " + col + "\nValor: " + txtFila);

                        if(model.setVal(i2,fila,col)>-1){
                            refrescaGUI();
                        }
                        else{
                            matriu[fila][col].setSelection(0);
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });



                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, numeros);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(adapter);
                this.matriu[i][j] = sp;
                row.addView(this.matriu[i][j]);
            }

            tabla.addView(row);
        }
        refrescaGUI();
    }

    private void refrescaGUI(){
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                matriu[i][j].setSelection(model.getVal(i,j));
            }
        }
    }

    public void Toast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}