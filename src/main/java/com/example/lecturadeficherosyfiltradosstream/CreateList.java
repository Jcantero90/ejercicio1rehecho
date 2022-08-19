package com.example.lecturadeficherosyfiltradosstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreateList {
 private List<Persona> listPeople = new ArrayList<>(); //Creo la lista como variable global.

//We can create objects by this method.
    public Persona createObjectPeople(String name, String city, int age){
    Persona persona = new Persona(name, city, age);
    return persona;
    }
/*  //This method doesn't works.
    public List<Persona> addPeopleList (Persona persona){
        List<Persona> list = new ArrayList<>();
        list.add(persona);
        return list;
    }
 */
    //Filter list.
    public void showList(List<Persona> persona){
        persona.stream().forEach(System.out::println);
        System.out.println("Filtrar por edad menor de 25");
        System.out.println("*=========================================*");
        persona.stream().filter((p)-> p.getAge() <25).forEach(System.out::println);
        System.out.println("Filtrado por nombre diferente a A");
        System.out.println("*=========================================*");
        persona.stream().filter((p)->!p.getName().startsWith("A")).forEach(System.out::println);
        System.out.println("Filtrar por menor de 25 y Ciudad Madrid");
        System.out.println("*=========================================*");
        persona.stream().filter((p)-> p.getAge() <25).filter((p)->p.getCity().equals("Madrid")).forEach(System.out::println);
        System.out.println("Filtrar por menor de 25 y ciudad Barcelona");
        System.out.println("*=========================================*");
        persona.stream().filter((p)-> p.getAge() <25).filter((p)->p.getCity().equals("Barcelona")).forEach(System.out::println);
    }
    //This method can read people.txt, create objects and add the fields into a List<Persona>.
    public List<Persona> readListToCSV () throws emptyFieldException, errorAgeException {
        Path path = Paths.get("C:/Users/jonatan.cantero/Documents/Apuntes/SpringBoot/LecturaDeFicherosYFiltradosStream/src/main/java/com/example/lecturadeficherosyfiltradosstream/people.txt");
        BufferedReader reader = null;
        String name = null;
        String city = null;
        int age = 0;
        try {
            reader = Files.newBufferedReader(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (line != null) {
            String[] person = line.split(":");
            try {
                name = person[0];
            } catch (Exception e) {
                throw new emptyFieldException("Empty field");
            }
            try {
                city = person[1];
            } catch (Exception e) {
                throw new emptyFieldException("Empty field");
            }
            try {

                age = Integer.parseInt(person[2]);
            } catch (Exception e) {
                throw new errorAgeException("Wrong Age");
            }
            Persona createdPeople = createObjectPeople(name, city, age);
            listPeople.add(createdPeople);
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return listPeople;
    }
}
