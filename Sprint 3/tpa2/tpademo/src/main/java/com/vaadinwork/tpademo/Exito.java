package com.vaadinwork.tpademo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



@Route("ExitoGUI")
public class Exito extends VerticalLayout{  
    
    public Exito(){
        ///////////// LAYOUTS //////////////
        HorizontalLayout base = new HorizontalLayout();
        base.getElement().setAttribute("theme", "dark");
        base.setWidthFull();
        VerticalLayout aviso = new VerticalLayout();
        

        /////////// AVISO /////////
        Span aviso1 = new Span("¡Accion realizada con exito!");
        Button menu = new Button("Volver al menu");
        menu.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        aviso.add(aviso1, menu);


        /////////// ADDDS ///////////////
        base.add(aviso);
        add(base);

        //////////// EVENTOS //////////
        menu.addClickListener(e ->
        menu.getUI().ifPresent(ui ->
            ui.navigate(""))
        );
        
        
    }
    
}
