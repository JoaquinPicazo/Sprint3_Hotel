package com.vaadinwork.tpademo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpademoApplication {

	public static void main(String[] args) {
		listaHabitaciones();
        listaPlan();
        listaExcursion(); 

        try {
            File nuevoArchivo = new File("Datos Clientes.csv");
            if (nuevoArchivo.createNewFile()) {
                System.out.println("Archivo Creado: " + nuevoArchivo.getName());
                try (FileWriter escritor = new FileWriter("Datos Clientes.csv", true)) {
                    escritor.write("Nombre,Apellido,Rut");
                    escritor.close();
                }
            }
            Scanner lector = new Scanner(nuevoArchivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] valor = linea.split(",");
                if (!valor[0].equals((String) "Nombre")) {
                    String nombre = valor[0], apellido = valor[1], rut = valor[2];
                    Cliente cliente = new Cliente(rut, nombre, apellido);
                    clts.add(cliente);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error en la creación del archivo");
            e.printStackTrace();
        }

        ///// CREACION Y REVISION DE RESERVAS /////
        try {
            File nuevoArchivo = new File("reservas.csv");
            if (nuevoArchivo.createNewFile()) {
                System.out.println("Archivo Creado: " + nuevoArchivo.getName());
                try (FileWriter escritor = new FileWriter("reservas.csv")) {
                    escritor.write(
                            "Nombre,Apellido,Rut,Pasajeros,Dia Inicio,Mes Inicio,Habitacion,Plan Menu,Excursion,Noches");
                    escritor.close();
                }
            }else {
                Scanner lector = new Scanner(nuevoArchivo);
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    String[] valor = linea.split(",");
                    Habitacion habitacion = rooms.get(0);
                    for (int i = 0; i < rooms.size(); i++) {
                        habitacion = rooms.get(i);
                        if (habitacion.getTipo().equals(valor[6])) {
                            habitacion.setDisponible(habitacion.getDisponible() - 1);
                        }
                        rooms.remove(i);
                        rooms.add(i, habitacion);
                    }
                    if (!valor[0].equals("Nombre")) {
                        int noches = Integer.parseInt(valor[9]), diaInicio = Integer.parseInt(valor[4]),
                                mesInicio = Integer.parseInt(valor[5]), pasajeros = Integer.parseInt(valor[3]);
                        Cliente cliente;
                        cliente = clts.get(0);
                        for (int i = 0; !valor[2].equals(cliente.getRut()); i++) {
                            cliente = clts.get(i);
                        }
                        // Habitacion habitacion;
                        habitacion = rooms.get(0);
                        for (int i = 0; !habitacion.getTipo().equals(valor[6]); i++) {
                            habitacion = rooms.get(i);
                        }
                        PlanMenu planMenu;
                        planMenu = plans.get(0);
                        for (int i = 0; !planMenu.getTipo().equals(valor[7]); i++) {
                            planMenu = plans.get(i);
                        }
                        Excursion excursion;
                        excursion = excs.get(0);
                        for (int i = 0; !excursion.getTipo().equals(valor[8]); i++) {
                            excursion = excs.get(i);
                        }
                        float precio = (habitacion.getPrecio() + planMenu.getPrecio() + excursion.getPrecio())
                                * noches;
                        Reserva reserva = new Reserva(precio, noches, diaInicio, mesInicio, cliente, pasajeros,
                                habitacion, planMenu, excursion);
                        resers.add(reserva);
                    }
                }
                lector.close();
            }
        }catch(IOException e){
            System.out.println("Ocurrió un error en la creación del archivo");
            e.printStackTrace();
        }

		SpringApplication.run(TpademoApplication.class, args);
	}

    
	static ArrayList<Cliente> clts = new ArrayList<Cliente>();
    static ArrayList<Habitacion> rooms = new ArrayList<Habitacion>();
    static ArrayList<PlanMenu> plans = new ArrayList<PlanMenu>();
    static ArrayList<Excursion> excs = new ArrayList<Excursion>();
    static ArrayList<Reserva> resers = new ArrayList<Reserva>();
    
    public static ArrayList<Cliente> getClts(){
        return clts;
    }
    
    public static ArrayList<Habitacion> getRooms(){
        return rooms;
    }
    
    public static ArrayList<PlanMenu> getPlans() {
        return plans;
    }
    
    public static ArrayList<Excursion> getExcs() {
        return excs;
    }  
    
    public static ArrayList<Reserva> getResers(){
        return resers;
    }

	private static void listaHabitaciones() {
        Habitacion ejecutivaIndividual = new Habitacion("Ejecutiva Individual", 50000, 2, 9);
        rooms.add(ejecutivaIndividual);
        Habitacion ejecutivaDoble = new Habitacion("Ejecutivo Doble", 80000, 4, 10);
        rooms.add(ejecutivaDoble);
        Habitacion familiar = new Habitacion("Familiar", 150000, 8, 10);
        rooms.add(familiar);
        Habitacion pentHouse = new Habitacion("Pent-House", 1080000, 2, 2);
        rooms.add(pentHouse);
    }

	private static void listaPlan() {
        PlanMenu inicial = new PlanMenu("Inicial", "Incluye el plato principal de una comida (almuerzo o cena) del menu diario a gusto del chef.", 10000);
        plans.add(inicial);
        PlanMenu intermedio = new PlanMenu("Intermedio","Incluye una comida (almuerzo o cena) de tres tiempos (entrada, fondo y postre) del menu diario a gusto del chef.",25000);
        plans.add(intermedio);
        PlanMenu completo = new PlanMenu("Completo","Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu diario a gusto del chef.",45000);
        plans.add(completo);
        PlanMenu avanzado = new PlanMenu("Avanzado","Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu abierto de especialidad del chef.",60000);
        plans.add(avanzado);
        PlanMenu premium = new PlanMenu("Premium","Incluye tiempo de chef dedicado a todo momento para satisfacer los gustos exclusivos y peticiones especificas de los pasajeros para una cantidad no determinada de comidas al dia.",100000);
        plans.add(premium);
        PlanMenu mNinguno = new PlanMenu("Ninguno", "", 0);
        plans.add(mNinguno);
    }

    private static void listaExcursion(){
        Excursion light = new Excursion("Light", "Corresponde a una excursion de tipo caminata de 6 horas en total por senderos de complejidad baja con hermosos lugares de vegetacion nativa y afluentes de agua, ideal para grupos familiares con ninos o personas de 3ra edad (inclusive para personas con dificultades metrices)", 5000);
        excs.add(light);
        Excursion plus = new Excursion("Plus", "Corresponde a una excursion de tipo hiking de 3 dias en total por una cadena montanosa, experiencia de campamento y contemplacion de glaciares y cascadas, ideal para grupos de personas con capacidades fisicas compatibles con la exigencia de la caminata", 25000);
        excs.add(plus);
        Excursion heavy = new Excursion("Heavy", "Corresponde a una excursion de tipo hiking de 5 dias en total por una cadena montanosa y con navegacion en afluentes locales. Se incluyen actividades extremas de Rapel, Canopi, Rafting y Escalada. Las actividades requieren de capacidades fisicas compatibles con la complejidad de la excursion.", 50000);
        excs.add(heavy);
        Excursion eNinguno = new Excursion("Ninguno", "", 0);
        excs.add(eNinguno);
    }
}
