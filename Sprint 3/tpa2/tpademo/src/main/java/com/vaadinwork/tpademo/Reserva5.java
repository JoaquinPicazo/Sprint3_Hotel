package com.vaadinwork.tpademo;

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



@Route("Reserva5GUI")
public class Reserva5 extends VerticalLayout{  
    public Reserva5(){
        ////////////////// LAYOUT ////////////////
        HorizontalLayout plantilla = new HorizontalLayout();
        plantilla.getElement().setAttribute("theme", "dark");
        plantilla.setWidthFull();

        VerticalLayout opciones = new VerticalLayout();
        VerticalLayout ofertas = new VerticalLayout();
        HorizontalLayout botones = new HorizontalLayout();

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
        Span texto = new Span("Elija su excursion (opcional): ");
        Button Light = new Button("Light");
        Button Plus = new Button("Plus");
        Button Heavy = new Button("Heavy");
       

        Button confirmar = new Button("Confirmar incursion");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        Button omitir = new Button("Omitir");
        omitir.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        botones.add(omitir, confirmar);
        
        opciones.add(texto, Light, Plus, Heavy, botones);

        ///////////////////// OFERTAS EN TEXTO /////////////////////
        Span ex1 = new Span("Excursion light - Precio por persona: $5.000 - Descripcion: Corresponde a una excursion de tipo caminata de 6 horas en total por senderos de complejidad baja con hermosos lugares de vegetacion nativa y afluentes de agua, ideal para grupos familiares con ninos o personas de 3ra edad (inclusive para personas con dificultades metrices)");
        Span ex2 = new Span("Excursion plus - Precio por persona: $25.000 - Descripcion: Corresponde a una excursion de tipo hiking de 3 dias en total por una cadena montañosa, experiencia de campamento y contemplacion de glaciares y cascadas, ideal para grupos de personas con capacidades fisicas compatibles con la exigencia de la caminata");
        Span ex3 = new Span("Excursion heavy - Precio por persona: $50.000 - Descripcion: Corresponde a una excursion de tipo hiking de 5 dias en total por una cadena montañosa y con navegacion en afluentes locales. Se incluyen actividades extremas de Rapel, Canopi, Rafting y Escalada. Las actividades requieren de capacidades fisicas compatibles con la complejidad de la excursion. ");
        ofertas.add(ex1, ex2, ex3);

        ////////////// FINAL /////////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(0.666666);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Progreso de reserva (66.6%)");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");

        //////////////// ADDS ///////////////
        plantilla.add(opciones, ofertas);
        aux.add(TituloLayout, plantilla, barra, Final);
        add(aux);

        //////////// EVENTOS ///////////////

        Light.addClickListener(e -> {
            veE1=true;
            if(veE2){
                veE2=false;
                Plus.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veE3){
                veE3=false;
                Heavy.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            Light.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
        });

        Plus.addClickListener(e -> {
            veE2=true;
            if(veE1){
                veE1=false;
                Light.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veE3){
                veE3=false;
                Heavy.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            Plus.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
        });

        Heavy.addClickListener(e -> {
            veE3=true;
            if(veE1){
                veE1=false;
                Light.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veE2){
                veE2=false;
                Plus.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            Heavy.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
        });

        confirmar.addClickListener(e -> {
            if(veE1 || veE2 || veE3){
                if(veE1){
                    Excursion excursion = TpademoApplication.getExcs().get(0);
                    setExcElegida(excursion);
                }else if(veE2){
                    Excursion excursion = TpademoApplication.getExcs().get(1);
                    setExcElegida(excursion);
                }else if(veE3){
                    Excursion excursion = TpademoApplication.getExcs().get(2);
                    setExcElegida(excursion);
                }
                confirmar.getUI().ifPresent(ui ->
                    ui.navigate("Reserva6GUI"));
            };
        });

        omitir.addClickListener(e -> {
            setExcElegida(TpademoApplication.getExcs().get(3));
            omitir.getUI().ifPresent(ui ->
                ui.navigate("Reserva6GUI"));
        });
    } 

    public static Excursion excElegida;

    public Excursion getExcElegida() {
        return excElegida;
    }

    public void setExcElegida(Excursion excElegida) {
        Reserva5.excElegida = excElegida;
    }

    boolean veE1=false;
    boolean veE2=false;
    boolean veE3=false;
}