package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.*; 

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
                List<String> allVolunteers = new LinkedList<>(); 
           for(String name: students){
               long attendedEvents = attendeesMapping.values().stream()
                                        .filter(volunteer -> volunteer.contains(name))
                                        .count();
                if (attendedEvents < 2){
                        allVolunteers.add(name);
                }
           }    
        return allVolunteers;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
