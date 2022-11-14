package UF1.sudoku;

import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Random;

public class SudokuModel {
    private static int[][] matriu = new int[9][9];

    public SudokuModel(int[][] matriu) {
        this.matriu = matriu;
    }

    SudokuModel() {
        crearPartida();
    }

    public int getVal(int fila, int col){
        return matriu[fila][col];
    }

    public int setVal(int fila, int col, int valor){
        int val = matriu[fila][col];
        matriu[fila][col] = valor;

        if (!comprovarFila(fila)){matriu[fila][col] = val; return -1;};
        if (!comprovarCol(col)){matriu[fila][col] = val; return -1;};
        return 0;
    }

    public boolean comprovarFila(int fila){
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (i != j && matriu[fila][i] != 0){
                    if (matriu[fila][i] == matriu[fila][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean comprovarCol(int col){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (i != j && matriu[j][col] != 0){
                    if (matriu[i][col] == matriu[j][col]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean comprovarQuad(int col, int fila, int valor){
        fila = (fila / 3) * 3;
        col = (col / 3) * 3;
        for(int i = fila; i < fila + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(this.matriu[i][j] == valor){
                    return false;
                }
            }
        }
        return true;
    }

    public void crearPartida(){
        Random rand = new Random();
        int nums = rand.nextInt(99);

        int fila = 0;
        int col = 0;
        int valor = 0;

        for (int a = 0; a < nums; a++){
            fila = rand.nextInt(9);
            col = rand.nextInt(9);
            valor = rand.nextInt(9);
            setVal(fila,col,valor);

            while (setVal(fila,col,valor) == -1){
                fila = rand.nextInt(9);
                col = rand.nextInt(9);
            }
        }

    }

}
