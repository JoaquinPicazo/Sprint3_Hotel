package com.vaadinwork.tpademo;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("")
public class MainWindow extends VerticalLayout{
    public MainWindow(){
        //////////////// DIVS Y LAYOUTS ////////////////
        Div creadores = new Div();
        Div baseacordeon = new Div();
        Div fondoprincipal = new Div();
        fondoprincipal.getElement().setAttribute("theme", "dark");
        fondoprincipal.setWidthFull();

        VerticalLayout BaseTodo= new VerticalLayout();
        HorizontalLayout menu = new HorizontalLayout();
        Div baselogo = new Div();
        HorizontalLayout basebotones = new HorizontalLayout();
        HorizontalLayout desarrollo = new HorizontalLayout();
        Div baseimagen = new Div();
        HorizontalLayout rrss = new HorizontalLayout();
    
        ///////////////// LOGO ESQUINA SUPERIOR IZQUIERDA ///////////////
        Image logo = new Image("https://cdn-icons-png.flaticon.com/512/7770/7770196.png", "ROUTE NOT FOUND");
        Span textocreadores = new Span("TPA Software - Universidad los lagos (proyecto semestral) - Hotel");
        creadores.add(textocreadores);
        logo.setWidth("100px");
        logo.setHeight("100px");

        baselogo.add(logo);
    

        ///////////////////// IMAGEN ////////////////
        Image imagen = new Image("https://cdn.pixabay.com/photo/2021/05/24/11/56/lake-6278825__340.jpg", "ROUTE NOT FOUND");
        Image imagen2 = new Image("https://cdn.pixabay.com/photo/2019/08/23/18/24/lake-4426212__340.jpg", "ROUTE NOT FOUND");
        Image imagen3 =  new Image("https://cdn.pixabay.com/photo/2019/08/19/13/58/bed-4416515__340.jpg", "ROUTE NOT FOUND");
        baseimagen.add(imagen, imagen3, imagen2);
        baseimagen.setMaxWidth("550px");

        ////////////////////// ACORDION ///////////////////////
        Accordion accordion = new Accordion();

        Span presentacion = new Span("Somos una empresa que ofrece variedad de servicios de calidad orientados al turismo, comprendemos de 2000 hectareas dedicadas a la conservacion de la flora y fauna nativa, con la finalidad de contemplacion, relajo y relacion con la naturaleza. ");
        Span servicios = new Span("Ofrecemos una gran variedad de serivicios en nuestro hotel, ¡realice un vistazo haciendo click en las flechas que estan a continuacion!:");
    
        Accordion subaccordion = new Accordion();
    
        Span espacio = new Span(" ");
        Span tituloHabitaciones = new Span("Contamos con las siguientes ofertas de habitaciones con el precio mas economico dentro del mercado: ");
        Span hab1 = new Span("Ejecutiva individual - Precio por noche: $50.000 - Capacidad: 2 personas");
        Span hab2 = new Span("Ejecutiva doble - Precio por noche: $80.000 - Capacidad: 4 personas");
        Span hab3 = new Span("Familiar - Precio por noche: $150.000 - Capacidad: 8 personas");
        Span hab4 = new Span("PentHouse - Precio por noche: $1.080.000 - Capacidad: 2 + invitados temporales");

        Span tituloMenus = new Span("Tambien tenemos los siguientes platos para usted (todas las reservas incluyen desayuno continental): ");
        Span menu1 = new Span("Inicial - Precio por persona: $10.000 - Descripcion: Incluye el plato principal de una comida (almuerzo o cena) del menu diario a gusto del chef.");
        Span menu2 = new Span("Intermedio - Precio por persona: $25.000 - Descripcion: Incluye una comida (almuerzo o cena) de tres tiempos (entrada, fondo y postre) del menu diario agusto del chef.");
        Span menu3 = new Span("Completo - Precio por persona: $45.000 - Descripcion: Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu diario agusto del chef.");
        Span menu4 = new Span("Avanzado - Precio por persona: $60.000 - Descripcion: Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu abierto de especialidad del chef.");
        Span menu5 = new Span("Premium - Precio por persona: $100.000 - Descripcion: Incluye tiempo de chef dedicado a todo momento para satisfacer los gustos exclusivos y peticiones especificas de los pasajeros para una cantidad no determinada de comidas al dia.");
    
        Span tituloExcursiones = new Span("Tambien puedes contratar alguno de nuestros planes de excursion para disfrutar de la naturaleza y su belleza:");
        Span ex1 = new Span("Excursion light - Precio por persona: $5.000 - Descripcion: Corresponde a una excursion de tipo caminata de 6 horas en total por senderos de complejidad baja con hermosos lugares de vegetacion nativa y afluentes de agua, ideal para grupos familiares con ninos o personas de 3ra edad (inclusive para personas con dificultades metrices)");
        Span ex2 = new Span("Excursion plus - Precio por persona: $25.000 - Descripcion: Corresponde a una excursion de tipo hiking de 3 dias en total por una cadena montañosa, experiencia de campamento y contemplacion de glaciares y cascadas, ideal para grupos de personas con capacidades fisicas compatibles con la exigencia de la caminata");
        Span ex3 = new Span("Excursion heavy - Precio por persona: $50.000 - Descripcion: Corresponde a una excursion de tipo hiking de 5 dias en total por una cadena montañosa y con navegacion en afluentes locales. Se incluyen actividades extremas de Rapel, Canopi, Rafting y Escalada. Las actividades requieren de capacidades fisicas compatibles con la complejidad de la excursion. ");

        Span email = new Span("Correo electronico: complejoturisticoreloncavi@company.com");
        Span direccion = new Span("Ubicacion: Ciudad: xxxx - Direccion: xxxx - Region: xxxx - Pais: Chile");
        Span telefono = new Span("Numero de telefono: 9 1111 1111");
        
        ///////// ICONOS RRSS /////////////
        Image instagram = new Image("https://cdn-icons-png.flaticon.com/512/1409/1409946.png", "ROUTE NOT FOUND");
        instagram.setWidth("40px");
        instagram.setHeight("40px");
        Image facebook = new Image("https://cdn-icons-png.flaticon.com/512/5968/5968764.png", "ROUTE NOT FOUND");
        facebook.setWidth("40px");
        facebook.setHeight("40px");
        Image twitter = new Image("https://cdn.icon-icons.com/icons2/1584/PNG/512/3721677-twitter_108058.png", "ROUTE NOT FOUND");
        twitter.setHeight("40px");
        twitter.setWidth("40px");
        rrss.add(instagram, facebook, twitter);
        VerticalLayout LayoutPresentacion = new VerticalLayout(presentacion);
        LayoutPresentacion.setSpacing(false);
        LayoutPresentacion.setPadding(false);

        VerticalLayout SubAcordion1 = new  VerticalLayout(tituloHabitaciones,hab1, hab2, hab3, hab4, espacio);
        VerticalLayout SubAcordion2 = new VerticalLayout(tituloMenus, menu1, menu2, menu3, menu4, menu5);
        VerticalLayout SubAcordion3 = new VerticalLayout(tituloExcursiones, ex1, ex2, ex3);

        subaccordion.add("Habitaciones",SubAcordion1);
        subaccordion.add("Planes de comida", SubAcordion2);
        subaccordion.add("Excursiones", SubAcordion3);
        VerticalLayout LayoutServicios = new VerticalLayout(espacio, servicios, subaccordion);

        VerticalLayout LayoutContacto = new VerticalLayout(email, direccion, telefono, rrss);
    
        accordion.add("¿Quienes somos? - Complejo Turistico Reloncavi (CTR): ", LayoutPresentacion);
        accordion.add("Nuestros servicios: ", LayoutServicios);
        accordion.add("Contacto: ", LayoutContacto);
        baseacordeon.add(accordion, espacio, espacio, espacio, creadores);

        ////////////////// BOTONES ////////////////
        Button RegistrarCliente = new Button("Registrarme");
        RegistrarCliente.addThemeVariants(ButtonVariant.LUMO_LARGE);
        RegistrarCliente.setAutofocus(true);
        RegistrarCliente.setHeight("70px");

        Button RegistrarReserva = new Button("Registrar mi reserva");
        RegistrarReserva.addThemeVariants(ButtonVariant.LUMO_LARGE);
        RegistrarReserva.setAutofocus(true);
        RegistrarReserva.setHeight("70px");

        Button PagarReserva = new Button("Pagar mi reserva");
        PagarReserva.addThemeVariants(ButtonVariant.LUMO_LARGE);
        PagarReserva.setAutofocus(true);
        PagarReserva.setHeight("70px");

        basebotones.add(RegistrarCliente, RegistrarReserva, PagarReserva);

        //////////////// ADDS /////////////
        menu.add(baselogo, basebotones);
        desarrollo.add(baseimagen, baseacordeon);
        BaseTodo.add(menu, desarrollo);
        
        fondoprincipal.add(BaseTodo);
        add(fondoprincipal);

        //////////// EVENTOS //////////
        RegistrarCliente.addClickListener(e ->
            RegistrarCliente.getUI().ifPresent(ui ->
                ui.navigate("RegistroGUI"))
        );

        RegistrarReserva.addClickListener(e ->
            RegistrarReserva.getUI().ifPresent(ui ->
                ui.navigate("Reserva1GUI"))
        );

        PagarReserva.addClickListener(e ->
            PagarReserva.getUI().ifPresent(ui ->
                ui.navigate("PagarGUI"))
        );
    }
}
