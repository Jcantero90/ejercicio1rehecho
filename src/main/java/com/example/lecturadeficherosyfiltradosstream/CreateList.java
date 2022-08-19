package com.example.lecturadeficherosyfiltradosstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreateList {

    public Persona createObjectPeople(String name, String city, int age){
    Persona persona = new Persona(name, city, age);
    return persona;
    }

    public List<Persona> addPeopleList (Persona persona){
        List<Persona> list = new ArrayList<>();
        list.add(persona);
        return list;
    }

    public void showList(List<Persona> persona){
        persona.stream().forEach(System.out::println);
    }

    public void readListToCSV () throws emptyFieldException, errorAgeException {
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
        while(line != null){
            String[] person = line.split(":");
            try {
                name = person[0];
            }catch (Exception e){
                throw new emptyFieldException("Empty field");
            }
            try {
                city = person[1];
            }catch (Exception e){
                throw new emptyFieldException("Empty field");
            }
            try {
                age = Integer.parseInt(person[2]);
            }catch (Exception e){
                throw new errorAgeException("Wrong Age");
            }
            Persona createdPeople = createObjectPeople(name,city,age);
            List<Persona> listPeople = addPeopleList(createdPeople);
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            listPeople.stream().forEach(System.out::println);
        }

    }
}
