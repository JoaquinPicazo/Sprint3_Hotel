package com.vaadinwork.tpademo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



@Route("RegistroGUI")
public class Registro extends VerticalLayout{  
    
    public Registro(){
        /////////// LAYOUTS ////////////
        VerticalLayout basetotal = new VerticalLayout();
        HorizontalLayout fondoprincipal = new HorizontalLayout();
        fondoprincipal.getElement().setAttribute("theme", "dark");
        fondoprincipal.setWidthFull();

        VerticalLayout registro = new VerticalLayout();
        VerticalLayout textos = new VerticalLayout();
        VerticalLayout aux = new VerticalLayout();
        aux.getElement().setAttribute("theme", "dark");
        aux.setWidthFull();

        /////////// TITULO /////////
        H2 titulo = new H2("ㅤREGISTRO HOTEL - COMPLEJO TURISTICO RELONCAVI"); // Tiene caracter invisible para hacer espacio a la izquierda del texto
        Image icono = new Image("https://cdn-icons-png.flaticon.com/512/7770/7770196.png", "ROUTE NOT FOUND");
        icono.setWidth("100px");
        icono.setHeight("100px");
        HorizontalLayout TituloLayout = new HorizontalLayout();
        TituloLayout.add(icono, titulo);
        
        
        //////////// COLUMNA DE REGISTRO DE DATOS /////////////
        Span subtitulo = new Span("Registro:");
        
        TextField nombre = new TextField("Ingrese su nombre: ");
        nombre.setRequiredIndicatorVisible(true);
        nombre.setErrorMessage("Este campo es obligatorio");

        TextField apellido = new TextField("Ingrese su apellido");
        apellido.setRequiredIndicatorVisible(true);
        apellido.setErrorMessage("Este campo es obligatorio");

        TextField rut = new TextField("Ingrese su rut");
        rut.setRequiredIndicatorVisible(true);
        rut.setErrorMessage("This field is required");

        Button confirmar = new Button("Registrar mis datos");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        
        

        registro.add(subtitulo, nombre, apellido, rut, confirmar);

        ////////////// COLUMNA DE TEXTO //////////////////
        Span informacion = new Span("★ ATENCION: Primero debe realizar este paso antes de efectuar un registro de reserva en nuestro hotel. Agradecemos su comprension.");
        Span indicacion1 = new Span("★ Al momento de registrar su nombre no ingrese simbolos ni numeros. Gracias.");
        Span indicacion2 = new Span("★ Al momento de registrar su apellido no ingrese simbolos ni numeros. Gracias.");
        Span indicacion3 =  new Span("★ Al momento de ingresar su rut solo ingrese numeros, sin puntos, sin guion y sin digito verificador. Gracias.");

        textos.add(informacion, indicacion1, indicacion2, indicacion3);

        //////////// FINAL (BARRA PROGRESO) ////////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Manteniendo conexion con el servidor, continue su registro. Gracias.");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");

        ///////////// ADDS ///////////////
        fondoprincipal.add(registro, textos);
        basetotal.add(fondoprincipal);
        aux.add(TituloLayout, basetotal, barra, Final);
        add(aux);


        //////////// EVENTOS //////////

        confirmar.addClickListener(e ->{
        compPanel(nombre, apellido, rut, confirmar);


        /*confirmar.getUI().ifPresent(ui ->
            ui.navigate("ExitoGUI"));*/
        }); 
    }

    private static void compPanel(TextField nombre, TextField apellido, TextField rut, Button confirmar) {
        boolean nomValido;
        if (Cliente.nomComp(nombre.getValue())) {
            nomValido = true;
        } else {
            nomValido = false;
        }

        boolean apeValido;
        if (Cliente.apeComp(apellido.getValue())) {
            apeValido = true;
        } else {
            apeValido = false;
        }

        boolean rutValido;
        if (Cliente.rutComp(rut.getValue())) {
            rutValido = true;
        } else {
            rutValido = false;
        }

        File fCliente = new File("Datos Clientes.csv");
        Cliente c1 = new Cliente(rut.getValue(), nombre.getValue(), apellido.getValue());
        Cliente dupe = TpademoApplication.getClts().get(0);
        boolean cd = false;
        for (int i = 0; i < TpademoApplication.getClts().size(); i++) {
            dupe = TpademoApplication.getClts().get(i);
            if (dupe.getRut().equals(c1.getRut())) {
                cd = true;
            }
        }

        if (nomValido && rutValido && apeValido && !cd) {
            TpademoApplication.getClts().add(c1);
            if (!cd) {
                try {
                    Scanner lector = new Scanner(fCliente);
                    try {
                        FileWriter escritor = new FileWriter("Datos Clientes.csv", true);
                        escritor.append("\n" + c1.getName() + "," + c1.getApellido() + "," + c1.getRut());
                        escritor.close();
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                    lector.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            };

            nombre.setValue("");
            apellido.setValue("");
            rut.setValue("");

            confirmar.getUI().ifPresent(ui -> ui.navigate("ExitoGUI"));
        }
    }
}
