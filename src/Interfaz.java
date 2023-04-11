import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Interfaz   extends JFrame{

   private JTextField textField1;
    private JButton insertarButton;
    private JButton atrasButton;
    private JButton adelanteButton;
    private JTextArea textArea1;
    private JPanel pNavegadir;
    private JPanel panelBrowser;


   /* private JTextArea textArea1;
    private JButton adelanteButton;
    private JButton atrasButton;
    private JButton insertarButton;
    private JTextField textField1;*/




    Stack<String> viewSearches = new Stack<String>();

    Stack<String> deleteSearches = new Stack<String>();

    String texto;


    public Interfaz() {


        adelanteButton.setEnabled(false);


        atrasButton.setEnabled(false);


        setContentPane(pNavegadir);


        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                func_enter();

                func_mostrarTexto();
            }
        });


        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                func_back();

                func_mostrarTexto();
            }
        });


        adelanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                func_fordward();

                func_mostrarTexto();
            }
        });
    }

    private void func_backEnabled(){
        if(!atrasButton.isEnabled()){

            atrasButton.setEnabled(true);
        }
    }

    private void func_enter(){


        if(!textField1.getText().equals("") && !textField1.getText().startsWith(" ")){

            viewSearches.push(textField1.getText());

            deleteSearches.clear();

            adelanteButton.setEnabled(false);

            func_backEnabled();

            func_textoBusqueda();
        }

    }

    private void func_back(){

        if(!viewSearches.isEmpty()){

            if(!adelanteButton.isEnabled()){

                adelanteButton.setEnabled(true);
            }


            deleteSearches.push(viewSearches.pop());
            func_textoBusqueda();

            if(viewSearches.isEmpty()){
                func_textoSinBusqueda();
            }
        }
    }

    private void func_fordward(){

        if(!deleteSearches.isEmpty()){
            func_backEnabled();

            viewSearches.push(deleteSearches.pop());
            func_textoBusqueda();

            if(deleteSearches.isEmpty()){

                adelanteButton.setEnabled(false);
            }
        }
    }

    private void func_mostrarTexto(){

        textArea1.setText(texto);
    }

    private void func_textoBusqueda(){
        texto = "";

        for (int i = 0; i < viewSearches.size(); i++){

            texto += viewSearches.get(i) + "  ";
        }
    }

    private void func_textoSinBusqueda(){

        atrasButton.setEnabled(false);
    }

}



