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



@Route("Reserva4GUI")
public class Reserva4 extends VerticalLayout{  
    public Reserva4(){
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
        Span texto = new Span("Elija su plan (menu) preferido (opcional): ");
        Button Inicial = new Button("Inicial");
        Button Intermedio = new Button("Intermedio");
        Button Completo = new Button("Completo");
        Button Avanzado = new Button("Avanzado");
        Button Premium = new Button("Premium");

        Button confirmar = new Button("Confirmar mi menu");
        confirmar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        Button omitir = new Button("Omitir");
        omitir.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        botones.add(omitir, confirmar);
        
        opciones.add(texto, Inicial, Intermedio, Completo, Avanzado, Premium, botones);

        ///////////////////// OFERTAS EN TEXTO /////////////////////
        Span menu1 = new Span("Inicial - Precio por persona: $10.000 - Descripcion: Incluye el plato principal de una comida (almuerzo o cena) del menu diario a gusto del chef.");
        Span menu2 = new Span("Intermedio - Precio por persona: $25.000 - Descripcion: Incluye una comida (almuerzo o cena) de tres tiempos (entrada, fondo y postre) del menu diario agusto del chef.");
        Span menu3 = new Span("Completo - Precio por persona: $45.000 - Descripcion: Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu diario agusto del chef.");
        Span menu4 = new Span("Avanzado - Precio por persona: $60.000 - Descripcion: Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu abierto de especialidad del chef.");
        Span menu5 = new Span("Premium - Precio por persona: $100.000 - Descripcion: Incluye tiempo de chef dedicado a todo momento para satisfacer los gustos exclusivos y peticiones especificas de los pasajeros para una cantidad no determinada de comidas al dia.");
        ofertas.add(menu1, menu2, menu3, menu4, menu5);

        /////////// FINAL /////////
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(0.49999);

        Div progressBarLabel = new Div();
        progressBarLabel.setText("Progreso de reserva (49.9%)");

        VerticalLayout barra = new VerticalLayout();

        barra.add(progressBarLabel, progressBar);

        Span Final = new Span("TPA Software 2022- Universidad de los lagos (Proyecto semestral) - Hotel");

        //////////////// ADDS ///////////////
        plantilla.add(opciones, ofertas);
        aux.add(TituloLayout, plantilla, barra, Final);
        add(aux);


        /////////// EVENTOS ///////////
        //inicial,Intermedio,Completo,Avanzado,Premium
        Inicial.addClickListener(e ->{
            veM1=true;
            if(veM2){
                veM2=false;
                Intermedio.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM3){
                veM3=false;
                Completo.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM4){
                veM4=false;
                Avanzado.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM5){
                veM5=false;
                Premium.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            if(veM1){
                Inicial.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        Intermedio.addClickListener(e ->{
            veM2=true;
            if(veM1){
                veM1=false;
                Inicial.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM3){
                veM3=false;
                Completo.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM4){
                veM4=false;
                Avanzado.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM5){
                veM5=false;
                Premium.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            if(veM2){
                Intermedio.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        Completo.addClickListener(e ->{
            veM3=true;
            if(veM1){
                veM1=false;
                Inicial.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM2){
                veM2=false;
                Intermedio.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM4){
                veM4=false;
                Avanzado.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM5){
                veM5=false;
                Premium.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            if(veM3){
                Completo.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        Avanzado.addClickListener(e ->{
            veM4=true;
            if(veM1){
                veM1=false;
                Inicial.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM2){
                veM2=false;
                Intermedio.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM3){
                veM3=false;
                Completo.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM5){
                veM5=false;
                Premium.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            if(veM4){
                Avanzado.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        Premium.addClickListener(e ->{
            veM5=true;
            if(veM1){
                veM1=false;
                Inicial.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM2){
                veM2=false;
                Intermedio.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM3){
                veM3=false;
                Completo.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }else if(veM4){
                veM4=false;
                Avanzado.removeThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
            if(veM5){
                Premium.addThemeVariants(ButtonVariant.LUMO_PRIMARY,ButtonVariant.LUMO_CONTRAST);
            }
        });

        confirmar.addClickListener(e -> {
            if(veM1 || veM2 || veM3 || veM4){
                if(veM1){
                    PlanMenu planMenu = TpademoApplication.getPlans().get(0);
                    setPlanElegido(planMenu);
                    //seleccionExcursiones(panelExcursiones, temFinalReserva,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,planMenu,panelFinalReserva,temInicio,panelInicio);
                }else if(veM2){
                    PlanMenu planMenu = TpademoApplication.getPlans().get(1);
                    setPlanElegido(planMenu);
                    //seleccionExcursiones(panelExcursiones, temFinalReserva,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,planMenu,panelFinalReserva,temInicio,panelInicio);
                }else if(veM3){
                    PlanMenu planMenu = TpademoApplication.getPlans().get(2);
                    setPlanElegido(planMenu);
                    //seleccionExcursiones(panelExcursiones, temFinalReserva,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,planMenu,panelFinalReserva,temInicio,panelInicio);
                }else if(veM4){
                    PlanMenu planMenu = TpademoApplication.getPlans().get(3);
                    setPlanElegido(planMenu);
                    //seleccionExcursiones(panelExcursiones, temFinalReserva,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,planMenu,panelFinalReserva,temInicio,panelInicio);
                }else if(veM5){
                    PlanMenu planMenu = TpademoApplication.getPlans().get(4);
                    setPlanElegido(planMenu);
                    //seleccionExcursiones(panelExcursiones, temFinalReserva,diaElegido,mesElegido,cantidadPasajeros,actual,habitacion,planMenu,panelFinalReserva,temInicio,panelInicio);
                }
                confirmar.getUI().ifPresent(ui ->
                    ui.navigate("Reserva5GUI"));
            }
        });

        omitir.addClickListener(e -> {
            setPlanElegido(TpademoApplication.getPlans().get(5));
            omitir.getUI().ifPresent(ui ->
                ui.navigate("Reserva5GUI"));
        });
    }

    public static PlanMenu planElegido;

    public PlanMenu getPlanElegido() {
        return planElegido;
    }

    public void setPlanElegido(PlanMenu planElegido) {
        Reserva4.planElegido = planElegido;
    }

    boolean veM1=false;
    boolean veM2=false;
    boolean veM3=false;
    boolean veM4=false;
    boolean veM5=false;
}
