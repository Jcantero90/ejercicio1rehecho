package com.example.lecturadeficherosyfiltradosstream;

import java.util.List;

public class Executable {
    //I created a CreateList Object to use its methods.
    static CreateList executable = new CreateList();
    public static void main(String[] args) throws errorAgeException, emptyFieldException {
    //Its necessary create a List<Persona> to get the list, and add the list into executable.showList.
    List<Persona> CreatedList = executable.readListToCSV();
    executable.showList(CreatedList);
    }
}
