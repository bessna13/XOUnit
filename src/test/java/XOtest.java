import org.example.Main;
import org.junit.jupiter.api.Assertions;

public class XOtest {
    @org.junit.jupiter.api.Test
    public void Xwin() {
        char [][] field = new char[Main.SIZE][Main.SIZE];
        for (int i = 0; i < Main.SIZE; i++) {
            field[i][i] = Main.CROSS;
        }

        boolean xWin =  Main.isWin(field, Main.CROSS );

      Assertions.assertEquals(true, xWin);

    }

     @org.junit.jupiter.api.Test
    public void Ywin(){
        char [][] field = new char[Main.SIZE][Main.SIZE];
        for (int i = 0; i < Main.SIZE; i++) {
           field[2][i]=Main.ZERO;
            }
        boolean yWin = Main.isWin(field, Main.ZERO);

        Assertions.assertEquals(true, yWin);
        }

    @org.junit.jupiter.api.Test
    public void emptyField(){
        char [][] field = new char[Main.SIZE][Main.SIZE];
        for (int i = 0; i < Main.SIZE; i++) {
            for (int j = 0; j < Main.SIZE; j++) {
              field[i][j] = ' ';
            }
            boolean empty = Main.isWin(field,Main.CROSS);
            Assertions.assertEquals(false, empty);
        }
    }


    }
