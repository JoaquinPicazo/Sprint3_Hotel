package com.vaadinwork.tpademo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Objects;

public class Cliente {
    String rut;
    String nombre;
    String apellido;
    static Scanner sc = new Scanner(System.in);
    
    public Cliente(String rut, String nombre, String apellido){
        setRut(rut);
        setNombre(nombre);
        setApellido(apellido);
    }


    public String getRut(){
        return this.rut;
    }
    public String getName(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }

    public void setRut(String rut){
        this.rut = rut;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    static public boolean rutComp(String rut) {
        boolean valido;
        String regex = "^[1-9]\\d{6,7}$";
        Pattern p = Pattern.compile(regex);
        if(rut == null){
            valido = false;
        }
        Matcher m = p.matcher(rut);
        valido = m.matches();
        return valido;
    }

    static public boolean nomComp(String nombre){
        boolean valido;
        String regex = "^[A-Za-z]\\w{2,29}$";
        Pattern p = Pattern.compile(regex);
        if (nombre == null) {
            valido = false;
        }
        Matcher m = p.matcher(nombre);
        String regex2 = ".*[0-9].*";
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(nombre);
        valido = m.matches();
        if(m.matches()){
            valido = !m2.matches();
        }
        return valido;
    }

    static public boolean apeComp(String apellido){
        boolean valido;
        String regex = "^[A-Za-z]\\w{2,29}$";
        Pattern p = Pattern.compile(regex);
        if (apellido == null) {
            valido = false;
        }
        Matcher m = p.matcher(apellido);
        String regex2 = ".*[0-9].*";
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(apellido);
        valido = m.matches();
        if(m.matches()){
            valido = !m2.matches();
        }
        return valido;
    }

    @Override
    public boolean equals(Object o){
        // Compara con el objeto o con una instancia
        if(this == o)
            return true;
        // Omitir los objetos nulos
        if(o == null)
            return false;

        //validamos la clase del objeto entregado
        if(getClass() != o.getClass())
            return false;

        Cliente a = (Cliente) o;

        //Comparando entre valores
        return Objects.equals(rut, a.rut);
    }
}
