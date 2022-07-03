package com.vaadinwork.tpademo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.vaadin.flow.component.Key;
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



@Route("Reserva6GUI")
public class Reserva6 extends VerticalLayout{  
    
    public Reserva6(){
        ///////////// LAYOUTS //////////////
        HorizontalLayout base = new HorizontalLayout();
        base.getElement().setAttribute("theme", "dark");
        base.setWidthFull();

        VerticalLayout Registro = new VerticalLayout();
        VerticalLayout Texto = new VerticalLayout();

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

        /////////// REGISTRO /////////
        TextField CantidadNoches = new TextField("Cantidad de noches");
        CantidadNoches.setRequiredIndicatorVisible(true);
        CantidadNoches.setErrorMessage("Este campo es requerido");

        Button confirmar = new Button("Confirmar mi cantidad de noches");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        Registro.add(CantidadNoches, confirmar);

        ////////////// TEXTOS /////////////
        Span instruccion1 = new Span("★ Use unicamente numeros enteros.");
        Span instruccion2 = new Span("★ Tenga en cuenta los siguientes precios para elegir su cantidad de noches:");
        Span hab1 = new Span("Ejecutiva individual - Precio por noche: $50.000 - Capacidad: 2 personas");
        Span hab2 = new Span("Ejecutiva doble - Precio por noche: $80.000 - Capacidad: 4 personas");
        Span hab3 = new Span("Familiar - Precio por noche: $150.000 - Capacidad: 8 personas");
        Span hab4 = new Span("PentHouse - Precio por noche: $1.080.000 - Capacidad: 2 + invitados temporales");
        Texto.add(instruccion1, instruccion2, hab1, hab2, hab3, hab4);

        ///////////// FINAL ///////////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(0.833333);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Progreso de reserva (83.3%)");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");

        /////////// ADDDS ///////////////
        base.add(Registro, Texto);
        aux.add(TituloLayout, base, barra, Final);
        add(aux);
        //////////// EVENTOS //////////
        confirmar.addClickListener(e -> {
            Reserva reserva = new Reserva(
                    ((Reserva3.habElegida.getPrecio() + Reserva4.planElegido.getPrecio() + Reserva5.excElegida.getPrecio())
                            * Integer.parseInt(CantidadNoches.getValue())),
                    Integer.parseInt(CantidadNoches.getValue()), Reserva2.diaElegido, Reserva2.mesElegido, Reserva1.reservante, Reserva2.cantidadPasajeros,
                    Reserva3.habElegida,
                    Reserva4.planElegido, Reserva5.excElegida);
            TpademoApplication.getResers().add(reserva);

            try {
                File bd = new File("reservas.csv");
                Scanner lector = new Scanner(bd);
                if (lector.hasNextLine()) {
                    try {
                        FileWriter escritor = new FileWriter("reservas.csv", true);
                        escritor.append("\n" + reserva.getCliente().getName() + ","
                                + reserva.getCliente().getApellido() + "," + reserva.getCliente().getRut()
                                + "," + reserva.getPasajeros() + "," + reserva.getDiaInicio() + ","
                                + reserva.getMesInicio() + "," + reserva.getHabitacion().getTipo() + ","
                                + reserva.getPlanMenu().getTipo() + "," + reserva.getExcursion().getTipo()
                                + "," + reserva.getNoches());
                        escritor.close();
                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                    } catch (IOException error) {
                        System.out.println("Ocurrió un error en la escritura del archivo");
                        error.printStackTrace();
                    }
                }
                lector.close();
            } catch (FileNotFoundException error) {
                System.out.println("ERROR: Archivo no encontrado!!!");
                error.printStackTrace();
            }
            confirmar.getUI().ifPresent(ui ->
                ui.navigate("ExitoGUI"));
            confirmar.addClickShortcut(Key.ENTER);
        }); 
    }  
}
