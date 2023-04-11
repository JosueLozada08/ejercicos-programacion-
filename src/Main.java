import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Interfaz b = new Interfaz();
        //Titulo del JFrame
        b.setTitle("Navegador");
        //Tamanio del JFrame
        b.setSize(300, 400);
        //Hace visible el browser (JFrame)
        b.setVisible(true);
        //Indica que la aplicación debe finalizar completamente cuando se cierra la ventana JFrame
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

