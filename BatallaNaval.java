import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatallaNaval{
    
    private char[][] tablero;
    private boolean turno;
    private boolean finDeJuego;
    private Map<String, Integer> posLetra;
    private Map<Character, Boolean> barcos;
    private String[] letras = {"A","B","C","D","E","F","G","H","I","J"};
    private String estatus = "Inicio del juego";
    private int vidasPlayers = 18;
    public BatallaNaval(){
        this.tablero = new char[10][10];
        this.posLetra = new HashMap<String, Integer>();
        this.barcos = new HashMap<Character, Boolean>();
        llenarPosLetra();
        limpiarJuego();
        colocarBarcos();
        mostarTabla();
    }
    
    public void llenarPosLetra(){
        
        for(int i = 0; i < 10; i++){
            this.posLetra.put(letras[i],i);
        }
        this.barcos.put('P',true);
        this.barcos.put('A',true);
        this.barcos.put('C',true);
        this.barcos.put('S',true);
        this.barcos.put('D',true);
        
        this.barcos.put('p',false);
        this.barcos.put('q',false);
        this.barcos.put('c',false);
        this.barcos.put('s',false);
        this.barcos.put('d',false);
    }
    
    public void limpiarJuego(){
        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }

        }
    }
    
    public void mostarTabla() {
        System.out.println("==== tablero Batalla Naval v0.0.0.1 ====");
        for(int i = 0; i < tablero.length; i++){
           System.out.print(" |" + (i + 1)); 
        }
        System.out.println("");
        for(int i = 0; i < tablero.length; i++){
           if(i==0){
              System.out.print(" +--");  
           }else{
              System.out.print("+--"); 
           }
           
        }
        System.out.println("");
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(letras[i]);
            for (int j = 0; j < tablero[i].length; j++) {
                if(j==0){
                    System.out.print("|" + tablero[i][j]);
                }else{
                    System.out.print(" |" + tablero[i][j]);
                }
                
            }
            System.out.println("");
        }

        if (!turno) {
            System.out.println("Turno: player 1");
        } else {
            System.out.println("Turno: player 2");
        }
        System.out.println("Estatus: " + this.estatus);
        System.out.println("=========================");
    }
    
    public void colocarBarcos(){
        tablero[0][0] = 'P';
        tablero[1][0] = 'P';
        tablero[2][0] = 'P';
        tablero[3][0] = 'P';
        tablero[4][0] = 'P';
        
        tablero[9][0] = 'A';
        tablero[9][1] = 'A';
        tablero[9][2] = 'A';
        tablero[9][3] = 'A';
        
        tablero[7][0] = 'C';
        tablero[7][1] = 'C';
        tablero[7][2] = 'C';
        tablero[7][3] = 'C';
        
        tablero[3][2] = 'S';
        tablero[4][2] = 'S';
        tablero[5][2] = 'S';
        
        tablero[0][3] = 'D';
        tablero[0][4] = 'D';
        
        tablero[9][9] = 'p';
        tablero[8][9] = 'p';
        tablero[7][9] = 'p';
        tablero[6][9] = 'p';
        tablero[5][9] = 'p';
        
        tablero[0][9] = 'a';
        tablero[0][8] = 'a';
        tablero[0][7] = 'a';
        tablero[0][6] = 'a';
        
        tablero[2][9] = 'c';
        tablero[2][8] = 'c';
        tablero[2][7] = 'c';
        tablero[2][6] = 'c';
        
        tablero[4][6] = 's';
        tablero[5][6] = 's';
        tablero[6][6] = 's';
        
        tablero[9][4] = 'd';
        tablero[9][5] = 'd';
        
    }
    
    public boolean ataque(String l, int n){
        if(finDeJuego == true){
            mostarTabla();
            return false;
        }
        
        if(posLetra.get(l) == null || !(n > 0 && n <= 10)){
            this.estatus = "Ataque Fallido Fuera de rango :P " + l + n;
            mostarTabla();
            return false;
        }
        
        if(tablero[posLetra.get(l)][n-1] == ' '){
            this.estatus = "Ataque Fallido apuntele bien XD" + l + n;
            mostarTabla();
            return false;
        }
        
        this.estatus = "Ataque exitoso " + l + n;
        tablero[posLetra.get(l)][n-1] = 'R';
        validaTablero();        
        turno = !turno;
        mostarTabla();
        return true;
    }
    
    public boolean validaTablero(){
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(this.barcos.get(tablero[i][j]) != null){
                    if(this.barcos.get(tablero[i][j])){
                       p1 ++; 
                    }else{
                       p2 ++; 
                    }
 
                }
            }
        }
        if(p1 == 0 || p2 == 0){
          if (!turno) {
            this.estatus =  "Gandor: player 1 !!!!!";
        } else {
            this.estatus =  "Gandor: player 2 !!!!!";
        }
          finDeJuego = true;
          return true;  
        }
        return false;
    }
    
    public boolean getFinDeJuego(){
        return this.finDeJuego;
    }
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
    
}
