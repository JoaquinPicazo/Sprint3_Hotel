package com.vaadinwork.tpademo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("PagarGUI")
public class Pagar extends VerticalLayout{ 
    
    public Pagar(){
        /////////// LAYOUTS /////////
        HorizontalLayout base = new HorizontalLayout();
        base.getElement().setAttribute("theme", "dark");
        base.setWidthFull();
        VerticalLayout pago = new VerticalLayout();
        VerticalLayout extras = new VerticalLayout();

        VerticalLayout aux = new VerticalLayout();

        /////////// TITULO /////////
        H2 titulo = new H2("ㅤREGISTRO HOTEL - COMPLEJO TURISTICO RELONCAVI"); // Tiene caracter invisible para hacer espacio a la izquierda del texto
        Image icon = new Image("https://cdn-icons-png.flaticon.com/512/7770/7770196.png", "ROUTE NOT FOUND");
        icon.setWidth("100px");
        icon.setHeight("100px");
        HorizontalLayout TituloLayout = new HorizontalLayout();
        TituloLayout.add(icon, titulo);

        //////////// CONFIRMACION DE PAGO CLIENTE /////////////
        TextField rut = new TextField("Ingrese su rut");
        rut.setRequiredIndicatorVisible(true);
        rut.setErrorMessage("This field is required");
        Button confirmar = new Button("PAGAR");        
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        
        pago.add(rut, confirmar);      

        //////////// EXTRAS (DERECHA) ///////////////
        Icon escudito = new Icon(VaadinIcon.SHIELD);

        Span instruccion1 = new Span("★ Ingrese unicamente numeros.");
        Span instruccion2 = new Span("★ Sin puntos, guion ni digito verificador.");
        Span seguro = new Span("AVISO: Sus datos estan cifrados totalmente, puede relizar esta transaccion de forma segura.");
        
        Span icono = new Span(escudito);
        icono.setHeight("60px");
        icono.setWidth("60px");

        extras.add(instruccion1, instruccion2, seguro, icono);

        ////////// FINAL ///////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Mantenidendo conexion con el servidor y actualizando seguridad. Puede continuar con su transaccion. Gracias.");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");
    
        //////////// ADDS //////////////
        base.add(pago, extras);
        aux.add(TituloLayout, base, barra, Final);
        add(aux);

        //////////// EVENTOS //////////

        confirmar.addClickListener(e ->{
            Cliente actual = TpademoApplication.getClts().get(0);
            Reserva reserva = TpademoApplication.getResers().get(0);
            File reservaBorrar = new File("reservas.csv");
            File reservasFile = new File("tempReservas.csv");
            Scanner lectorReservas = new Scanner("tempReservas.csv");
            try {
                if (reservasFile.createNewFile()) {
                        FileWriter reservasWriter = new FileWriter("tempReservas.csv", true);
                        reservasWriter.write(
                                "Nombre,Apellido,Rut,Pasajeros,Dia Inicio,Mes Inicio,Habitacion,Plan Menu,Excursion,Noches");
                        reservasWriter.close();
                    }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            for (int i = 0; TpademoApplication.getClts().size() > i; i++){
                if(!actual.getRut().equals(rut.getValue())){
                    actual = TpademoApplication.getClts().get(i);
                }
            }
            if (actual.getRut().equals(rut.getValue())){
                for(int i = 0; i < TpademoApplication.getResers().size(); i++){
                    if(!reserva.getCliente().getRut().equals(actual.getRut())){
                        while (lectorReservas.hasNextLine()) {
                            try {
                                FileWriter reservasWriter = new FileWriter(reservasFile, true);
                                reservasWriter.append("\n" + reserva.getCliente().getName() + ","
                                + reserva.getCliente().getApellido() + ","
                                + reserva.getCliente().getRut()
                                + "," + reserva.getPasajeros() + "," + reserva.getDiaInicio() + ","
                                + reserva.getMesInicio() + "," + reserva.getHabitacion().getTipo()
                                + ","
                                + reserva.getPlanMenu().getTipo() + ","
                                + reserva.getExcursion().getTipo()
                                + "," + reserva.getNoches());
                                reservasWriter.close();
                            } catch (IOException error) {
                                error.printStackTrace();
                            }
                            lectorReservas.nextLine();
                        }
                    }
                }
                if (reserva.getCliente().getRut().equals(rut.getValue())) {
                    for (int i = 0; i < TpademoApplication.getResers().size(); i++) {
                        if (actual.getRut().equals(reserva.getCliente().getRut())) {
                            TpademoApplication.getResers().remove(i);
                        }
                    }
                    Pulsera pulsera = new Pulsera(reserva.getPrecio(), actual);
                    System.out.println("\nPulsera de " + pulsera.getCliente().getName() + " "
                            + pulsera.getCliente().getApellido() + " a sido entregada");
                    confirmar.getUI().ifPresent(ui ->
                        ui.navigate("ExitoGUI"));
                } else {

                }
            }
            reservaBorrar.delete();
            reservasFile.renameTo(reservaBorrar);
            lectorReservas.close();
        });
    }  
}
