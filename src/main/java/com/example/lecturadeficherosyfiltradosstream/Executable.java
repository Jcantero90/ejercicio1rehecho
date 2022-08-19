package com.example.lecturadeficherosyfiltradosstream;

import java.util.List;

public class Executable {
    static CreateList executable = new CreateList();
    public static void main(String[] args) throws errorAgeException, emptyFieldException {
    executable.readListToCSV();
    }
}
