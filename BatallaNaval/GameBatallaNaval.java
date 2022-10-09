import java.util.Scanner;

/**
 * Write a description of class GameBatallaNaval here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBatallaNaval
{
    public static void main(String args[]){
        Scanner leer = new Scanner(System.in);
        BatallaNaval game = new BatallaNaval();
        do{ 
            try{
                String Cordenadas = leer.next();
                String letra = Cordenadas.charAt(0) + "";
                int numero = Integer.parseInt(Cordenadas.substring(1));
                game.ataque(letra.toUpperCase(), numero); 
            }catch(Exception e){  
                game.setEstatus("Error en las coordenadas");
                game.mostarTabla();
            }
            
        }while(!game.getFinDeJuego());
    }
}
