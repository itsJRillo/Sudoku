package UF1.sudoku;

public class SudokuModel {
    private int[][] core = new int[9][9];

    public SudokuModel(int[][] core) {
        this.core = core;
    }

    public int getVal(int fila, int col){
        return core[fila][col];
    }

    public void setVal(int fila, int col, int valor){
        core[fila][col] = valor;
    }

    public int comprovarFila(int fila, int valor){
        for(int i=0;i < 9;i++){
            if(core[fila][i] == valor){
                return 0;
            }
        }
        return -1;
    }

    public int comprovarCol(int col, int valor){
        for(int i=0;i < 9;i++){
            if(core[i][col] == valor){
                return 0;
            }
        }
        return -1;
    }

    public void comprovarQuad(){

    }

    public void crearPartida(){

    }

}
