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
    private JPanel panelBrowser;


   /* private JTextArea textArea1;
    private JButton adelanteButton;
    private JButton atrasButton;
    private JButton insertarButton;
    private JTextField textField1;*/



    //Stack para las busquedas (activas);
    Stack<String> viewSearches = new Stack<String>();
    //Stack para las busquedas eliminadas;
    Stack<String> deleteSearches = new Stack<String>();
    //Se usara para mostrar en el text area
    String texto;


    public Interfaz() {

        //Se deshabilita el boton fordward
        adelanteButton.setEnabled(false);

        //Boton back deshabilitado
        atrasButton.setEnabled(false);

        //Establece el panel que se mostrará en una ventana JFrame
        setContentPane(panelBrowser);

        //Se crea un evento para el boton enter
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                func_enter();

                func_mostrarTexto();
            }
        });

        //Se crea un evento para el boton back
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                func_back();

                func_mostrarTexto();
            }
        });

        //Se crea un evento para el boton fordward
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
            //Se activa el boton back en caso de que este deshabilitado
            atrasButton.setEnabled(true);
        }
    }

    private void func_enter(){

        //Condicion que verificara que el jtextfield (search) no contenga espacios y tampoco este vacio;
        if(!textField1.getText().equals("") && !textField1.getText().startsWith(" ")){
            //Se agrega la busqueda al stack de las busquedas activas
            viewSearches.push(textField1.getText());
            //Se vacia el stack de las busquedas eliminadas
            deleteSearches.clear();
            //Se desactiva el boton fordward
            adelanteButton.setEnabled(false);
            //Se activa el btn back en caso de que este deshabilitado
            func_backEnabled();
            //Se junta las busquedas activas en el string texto
            func_textoBusqueda();
        }

    }

    private void func_back(){
        //Condicion que verifica si el stack de busquedas activas no este vacio
        if(!viewSearches.isEmpty()){

            if(!adelanteButton.isEnabled()){
                //Se habilita el boton fordward en caso de que este deshabilitado
                adelanteButton.setEnabled(true);
            }

            //Se agrega al stack de busquedas eliminadas el ultimo elemento del stack de busquedas activas
            deleteSearches.push(viewSearches.pop());
            func_textoBusqueda();

            if(viewSearches.isEmpty()){
                func_textoSinBusqueda();
            }
        }
    }

    private void func_fordward(){
        //Se verifica que el stack de busquedas eliminadas no este vacio
        if(!deleteSearches.isEmpty()){
            func_backEnabled();
            //Se agrega al stack de busquedas activas el ultimo elemento del stack de busquedas eliminadas y ademas ese elemento se elimina de dicho stack
            viewSearches.push(deleteSearches.pop());
            func_textoBusqueda();
            //Condicion que verifica que el stack de busquedas eliminadas este vacio
            if(deleteSearches.isEmpty()){
                //Se desactiva el boton fordward
                adelanteButton.setEnabled(false);
            }
        }
    }

    private void func_mostrarTexto(){
        //se muestra el texto correspondiente en el text area
        textArea1.setText(texto);
    }

    private void func_textoBusqueda(){
        texto = "";
        //Se recorre el for en base al stack de busquedas activas
        for (int i = 0; i < viewSearches.size(); i++){
            //Se concatena el texto con los elementos del stack de busquedas activas
            texto += viewSearches.get(i) + "  ";
        }
    }

    private void func_textoSinBusqueda(){
        //Boton back deshabilitado
        atrasButton.setEnabled(false);
    }

}



