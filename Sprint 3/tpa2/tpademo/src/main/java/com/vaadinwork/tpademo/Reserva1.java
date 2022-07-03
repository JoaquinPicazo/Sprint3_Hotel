package com.vaadinwork.tpademo;

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



@Route("Reserva1GUI")
public class Reserva1 extends VerticalLayout{  
    
    public Reserva1(){
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
        TextField rut = new TextField("Ingrese su rut");
        rut.setRequiredIndicatorVisible(true);
        rut.setErrorMessage("This field is required");

        Button confirmar = new Button("Confirmar RUT");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        Registro.add(rut, confirmar);

        ////////////// TEXTOS /////////////
        Span instruccion1 = new Span("★ Ingrese unicamente numeros.");
        Span instruccion2 = new Span("★ Sin puntos, guion ni digito verificador.");
        Texto.add(instruccion1, instruccion2);

        //////////// FINAL ////////////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(0.0);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Progreso de reserva (0%)");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");


        /////////// ADDDS ///////////////
        base.add(Registro, Texto);
        aux.add(TituloLayout, base, barra, Final);
        add(aux);

        //////////// EVENTOS //////////
        confirmar.addClickListener(e -> {
            boolean rutValido;
            if (Cliente.rutComp(rut.getValue())) {
                rutValido = true;
            } else {
                rutValido = false;
            }
            if(rutValido){
                Cliente actual = TpademoApplication.getClts().get(0);
                for (int i = 0; TpademoApplication.getClts().size() > i; i++) {
                    if (!actual.getRut().equals(rut.getValue())) {
                        actual = TpademoApplication.getClts().get(i);
                    }
                }
                if (actual.getRut().equals(rut.getValue())) {
                    setReservante(actual);
                    confirmar.getUI().ifPresent(ui ->
                    ui.navigate("Reserva2GUI"));

                    // anterior // 
                    //datosBasicos(panelDB,actual,temFinalReserva,panelHabitaciones,temHabitaciones, panelMenu,temMenu,temExcursiones,panelExcursiones,panelFinalReserva,temInicio,panelInicio);
                    // selecHab(diaInicio, mesInicio, actual, nPasajeros);
                } else {
                    //
                    //Agregar representacion de errores
                    //
                }
            }
        });
        confirmar.addClickShortcut(Key.ENTER);        
    }
    
    public static Cliente reservante;

    public Cliente getReservante() {
        return reservante;
    }
    public void setReservante(Cliente reservante) {
        Reserva1.reservante = reservante;
    }
    
}
