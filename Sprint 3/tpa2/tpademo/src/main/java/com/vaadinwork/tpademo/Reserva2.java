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



@Route("Reserva2GUI")
public class Reserva2 extends VerticalLayout{  
    
    public Reserva2(){
        ////////// LAYOUTS ////////////////
        HorizontalLayout base = new HorizontalLayout();
        base.getElement().setAttribute("theme", "dark");
        base.setWidthFull();

        VerticalLayout datos = new VerticalLayout();
        VerticalLayout texto = new VerticalLayout();

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

        ////////////// Reserva ///////////////////
        TextField dia = new TextField("Dia de su reserva: ");
        dia.setRequiredIndicatorVisible(true);
        dia.setErrorMessage("Este campo es obligatorio");

        TextField mes = new TextField("Mes de su reserva: ");
        mes.setRequiredIndicatorVisible(true);
        mes.setErrorMessage("Este campo es obligatorio");

        TextField cantidad = new TextField("Cantidad de pasajeros: ");
        cantidad.setRequiredIndicatorVisible(true);
        cantidad.setErrorMessage("Este campo es obligatorio");

        Button confirmar = new Button("Confirmar mis datos de reserva");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        datos.add(dia, mes, cantidad, confirmar);

        //////////////// TEXTOS ///////////////
        Span instruccion1 = new Span("★ Al ingresar dia, mes y cantidad use numeros enteros. Tambien, al ingresar la cantidad tenga en cuenta los limites de la habitacion que reservará. Gracias. Para otorgarle mayor informacion le dejaremos las ofertas de las habitaciones a continuacion.");
        Span tituloHabitaciones = new Span("Contamos con las siguientes ofertas de habitaciones con el precio mas economico dentro del mercado: ");
        Span hab1 = new Span("Ejecutiva individual - Precio por noche: $50.000 - Capacidad: 2 personas");
        Span hab2 = new Span("Ejecutiva doble - Precio por noche: $80.000 - Capacidad: 4 personas");
        Span hab3 = new Span("Familiar - Precio por noche: $150.000 - Capacidad: 8 personas");
        Span hab4 = new Span("PentHouse - Precio por noche: $1.080.000 - Capacidad: 2 + invitados temporales");
        texto.add(instruccion1, tituloHabitaciones, hab1, hab2, hab3, hab4);

        ////////////// FINAL /////////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(0.1666666);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Progreso de reserva (16.6%)");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");


        /////////// ADDS ///////////////
        base.add(datos, texto);
        aux.add(TituloLayout, base, barra, Final);
        add(aux);


        //////////// EVENTOS ///////////////
        confirmar.addClickListener(e -> {

            boolean diaValido;
            

            if(Integer.parseInt(dia.getValue())>31 || Integer.parseInt(dia.getValue())<1){
                //                           //
                // agregar mensajes de error //
                //                           //

                diaValido = false;
            }else{
                diaValido = true;
            }

            boolean mesValido;
            if(Integer.parseInt(mes.getValue())>12 || Integer.parseInt(mes.getValue())<1){
                //                           //
                // agregar mensajes de error //
                //                           //

                mesValido=false;
            }else{
                mesValido=true;

            }

            boolean pasValido;
            if(Integer.parseInt(cantidad.getValue())<1 || Integer.parseInt(cantidad.getValue())>8){
                //                           //
                // agregar mensajes de error //
                //                           //

                pasValido=false;                
            }else{
                pasValido=true;
            }
            if(diaValido && mesValido && pasValido){                
                setDiaElegido(Integer.parseInt(dia.getValue()));
                setMesElegido(Integer.parseInt(mes.getValue()));
                setCantidadPasajeros(Integer.parseInt(cantidad.getValue()));
                

                confirmar.getUI().ifPresent(ui ->
                    ui.navigate("Reserva3GUI"));

                // anterior // 
                //selecHabitacion(panelHabitaciones, temHabitaciones,diaElegido,mesElegido,cantidadPasajeros,actual,panelMenu,temMenu,temExcursiones,panelExcursiones,temFinalReserva,panelFinalReserva,temInicio,panelInicio);
            }

        });
        confirmar.addClickShortcut(Key.ENTER);
    }

    public static int diaElegido, mesElegido;
    public static int cantidadPasajeros;

    public int getDiaElegido() {
        return diaElegido;
    }
    public void setDiaElegido(int diaElegido) {
        Reserva2.diaElegido = diaElegido;
    }

    public int getMesElegido() {
        return mesElegido;
    }
    public void setMesElegido(int mesElegido) {
        Reserva2.mesElegido = mesElegido;
    }
    
    public static int getCantidadPasajeros() {
        return cantidadPasajeros;
    }
    public void setCantidadPasajeros(int cantidadPasajeros) {
        Reserva2.cantidadPasajeros = cantidadPasajeros;
    }
}
