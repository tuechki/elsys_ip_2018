package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.model.Star;

import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class StarPredicates {

    public static List<Predicate<Star>> getPredicatesByQuery(MultivaluedMap<String,String> fieldValueMap){
        List<Predicate<Star>> predicateList = new ArrayList<Predicate<Star>>();


        for(String fieldName : fieldValueMap.keySet()){
            System.out.print(fieldName + " -> " );

            for(String value : fieldValueMap.get(fieldName)){

                System.out.print(value);
                System.out.println();
                switch (fieldName){
                    case "id": predicateList.add(hasId(Integer.parseInt(value)));
                        break;
                    case "name": predicateList.add(hasName(value));
                        break;
                    case "mass": predicateList.add(hasMass(Long.parseLong(value)));
                        break;
                    case "evolutionaryStage": predicateList.add(hasEvolutionaryStage(value));
                        break;
                    case "volume": predicateList.add(hasVolume(Long.parseLong(value)));
                        break;
                    case "escapeVelocity": predicateList.add(hasEscapeVelocity(Integer.parseInt(value)));
                        break;
                    case "age": predicateList.add(hasAge(Long.parseLong(value)));
                        break;
                    case "distanceFromEarth": predicateList.add(hasDistanceFromEarth(Long.parseLong(value)));
                        break;
                    case "spectralType": predicateList.add(hasSpectralType(value));
                        break;
                    case "temperature": predicateList.add(hasTemperature(Long.parseLong(value)));
                        break;
                    case "equatorialRadius": predicateList.add(hasEquatorialRadius(Long.parseLong(value)));
                        break;

                }
            }

        }

        return predicateList;
    }


    public static Predicate<Star> hasId(int id) {
        return p -> p.getId() == id;
    }

    public static Predicate<Star> hasName(String name) {
        return p -> p.getName().equals(name);
    }

    public static Predicate<Star> hasMass(long mass) {
        return p -> p.getMass() == mass;
    }

    public static Predicate<Star> hasEvolutionaryStage(String evolutionaryStage) {
        return p -> p.getEvolutionaryStage().equals(evolutionaryStage);
    }

    public static Predicate<Star> hasVolume(long volume) {
        return p -> p.getVolume() == volume;
    }

    public static Predicate<Star> hasEscapeVelocity(int escapeVelocity) {
        return p -> p.getEscapeVelocity() == escapeVelocity;
    }

    public static Predicate<Star> hasAge(long age) {
        return p -> p.getAge() == age;
    }

    public static Predicate<Star> hasDistanceFromEarth(long distanceFromEarth) {
        return p -> p.getDistanceFromEarth() == distanceFromEarth;
    }

    public static Predicate<Star> hasSpectralType(String spectralType) {
        return p -> p.getSpectralType().equals(spectralType);
    }

    public static Predicate<Star> hasTemperature(long temperature) {
        return p -> p.getTemperature() == temperature;
    }

    public static Predicate<Star> hasEquatorialRadius(long equatorialRadius) {
        return p -> p.getEquatorialRadius() == equatorialRadius;
    }

}
