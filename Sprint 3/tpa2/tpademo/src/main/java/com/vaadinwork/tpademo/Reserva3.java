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
import com.vaadin.flow.router.Route;



@Route("Reserva3GUI")
public class Reserva3 extends VerticalLayout{  
    public Reserva3(){
        ////////////////// LAYOUT ////////////////
        HorizontalLayout plantilla = new HorizontalLayout();
        plantilla.getElement().setAttribute("theme", "dark");
        plantilla.setWidthFull();

        VerticalLayout opciones = new VerticalLayout();
        VerticalLayout ofertas = new VerticalLayout();

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

        /////////////// OPCIONES DE HABITACIONES ///////////////
        Span op = new Span("Elija su habitacion preferida: ");
        Button EjecutivaIndividual = new Button("Ejecutiva Individual");
        Button EjecutivaDoble = new Button("Ejecutiva doble");
        Button Familiar = new Button("Familiar");
        Button Penthouse = new Button("Penthouse");

        Button confirmar = new Button("Confirmar mi habitacion");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        
        opciones.add(op, EjecutivaIndividual, EjecutivaDoble, Familiar, Penthouse, confirmar);

        ///////////////////// OFERTAS EN TEXTO /////////////////////
        Span hab1 = new Span("Ejecutiva individual - Precio por noche: $50.000 - Capacidad: 2 personas");
        Span hab2 = new Span("Ejecutiva doble - Precio por noche: $80.000 - Capacidad: 4 personas");
        Span hab3 = new Span("Familiar - Precio por noche: $150.000 - Capacidad: 8 personas");
        Span hab4 = new Span("PentHouse - Precio por noche: $1.080.000 - Capacidad: 2 + invitados temporales");
        ofertas.add(hab1, hab2, hab3, hab4);

        //////////////// FINAL ///////////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(0.333333);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Progreso de reserva (33.3%)");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");

        //////////////// ADDS ///////////////
        plantilla.add(opciones, ofertas);
        aux.add(TituloLayout, plantilla, barra, Final);
        add(aux);

        ///////////// EVENTOS ///////////

        EjecutivaIndividual.addClickListener(e -> {
            Habitacion habitacion = TpademoApplication.getRooms().get(0);
            setVeEi(true);
            if(veEd){
                setVeEd(false);
                EjecutivaDoble.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);;
            }else if(veFa){
                setVeFa(false);
                Familiar.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(vePe){
                setVePe(false);
                Penthouse.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            
            if(cantidadPasajeros>2){
                setVeEi(false);
                EjecutivaIndividual.addThemeVariants(ButtonVariant.LUMO_ERROR);
            }else if (habitacion.getDisponible() < 1) {
                setVeEi(false);
                EjecutivaIndividual.addThemeVariants(ButtonVariant.LUMO_ERROR);
            } else {
                EjecutivaIndividual.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        EjecutivaDoble.addClickListener(e -> {
            Habitacion habitacion = TpademoApplication.getRooms().get(1);
            setVeEd(true);
            if(veEi){
                setVeEi(false);
                EjecutivaIndividual.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veFa){
                setVeFa(false);
                Familiar.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(vePe){
                setVePe(false);
                Penthouse.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            
            if(cantidadPasajeros>4){
                setVeEd(false);
                EjecutivaDoble.addThemeVariants(ButtonVariant.LUMO_ERROR);
            }else if (habitacion.getDisponible() < 1) {
                setVeEd(false);
                Penthouse.addThemeVariants(ButtonVariant.LUMO_ERROR);
            } else {
                EjecutivaDoble.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        Familiar.addClickListener(e -> {
            Habitacion habitacion = TpademoApplication.getRooms().get(2);
            setVeFa(true);
            if(veEi){
                setVeEi(false);
                EjecutivaIndividual.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veEd){
                setVeEd(false);
                EjecutivaDoble.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(vePe){
                setVePe(false);
                Penthouse.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            
            if(cantidadPasajeros>8){
                setVeFa(false);
                Familiar.addThemeVariants(ButtonVariant.LUMO_ERROR);
            }else if (habitacion.getDisponible() < 1) {
                setVeFa(false);
                Familiar.addThemeVariants(ButtonVariant.LUMO_ERROR);
            } else {
                Familiar.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        Penthouse.addClickListener(e -> {
            Habitacion habitacion = TpademoApplication.getRooms().get(3);
            setVePe(true);
            if(veEi){
                setVeEi(false);
                EjecutivaIndividual.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veEd){
                setVeEd(false);
                EjecutivaDoble.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veFa){
                setVeFa(false);
                Familiar.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            
            if(cantidadPasajeros>2){
                setVePe(false);
                Penthouse.addThemeVariants(ButtonVariant.LUMO_ERROR);
            }else if (habitacion.getDisponible() < 1) {
                setVePe(false);
                Penthouse.addThemeVariants(ButtonVariant.LUMO_ERROR);
            } else {
                Penthouse.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        confirmar.addClickListener(e -> {

            if(veEd || veEi || veFa || vePe){
                if(veEi){
                    Habitacion habitacion = TpademoApplication.getRooms().get(0);
                    setHabElegida(habitacion);

                    // anterior
                    //seleccionMenu(panelMenu, temExcursiones,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion, panelExcursiones,temFinalReserva,panelFinalReserva,temInicio,panelInicio);
                }else if(veEd){
                    Habitacion habitacion = TpademoApplication.getRooms().get(1);
                    setHabElegida(habitacion);

                    // anterior
                    //seleccionMenu(panelMenu, temExcursiones,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion, panelExcursiones,temFinalReserva,panelFinalReserva,temInicio,panelInicio);
                }else if(veFa){
                    Habitacion habitacion = TpademoApplication.getRooms().get(2);
                    setHabElegida(habitacion);

                    // anterior
                    //seleccionMenu(panelMenu, temExcursiones,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,panelExcursiones,temFinalReserva,panelFinalReserva,temInicio,panelInicio);
                }else if(vePe){
                    Habitacion habitacion = TpademoApplication.getRooms().get(3);
                    setHabElegida(habitacion);

                    // anterior
                    //seleccionMenu(panelMenu, temExcursiones,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,panelExcursiones,temFinalReserva,panelFinalReserva,temInicio,panelInicio);
                }
                confirmar.getUI().ifPresent(ui ->
                    ui.navigate("Reserva4GUI"));

            };
        });
        confirmar.addClickShortcut(Key.ENTER);
    }

    int cantidadPasajeros = Reserva2.getCantidadPasajeros();

    public static Habitacion habElegida;

    boolean veEi=false;
    boolean veEd=false;
    boolean veFa=false;
    boolean vePe=false;

    public Habitacion getHabElegida() {
        return habElegida;
    }


    public void setHabElegida(Habitacion habElegida) {
        Reserva3.habElegida = habElegida;
    }

    
    public void setVeEi(boolean veEi) {
        this.veEi = veEi;
    }

    
    public void setVeEd(boolean veEd) {
        this.veEd = veEd;
    }

    
    public void setVeFa(boolean veFa) {
        this.veFa = veFa;
    }

    public void setVePe(boolean vePe) {
        this.vePe = vePe;
    }
}
