package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.model.Star;

import javax.ws.rs.core.MultivaluedMap;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.elsys.ip.rest.persistence.HibernateUtil;
import org.hibernate.Session;

import static org.elsys.ip.rest.repository.StarPredicates.hasName;

public class StarRepository {
    private static List<Star> starList = new ArrayList<>(
            Arrays.asList(
                    new Star(1, "Sun", 100, "main sense", 123, 700,
                            40000, 150000,"G2", 500000, 1000),
                    new Star(2, "SecondStar", 200, "red giant", 1278, 7760,
                            12521300, 15420000,"G7", 50090800, 2000),
                    new Star(3, "ThirdStar", 300, "white djudje", 1278, 7760,
                            12521300, 18989000,"G9", 50090800, 3000),
                    new Star(4, "ForthStar", 400, "ne6to si", 1278, 5560,
                            12521300, 18989000,"G10", 34233, 4000)
            ));

    public List<Star> getStarList() {
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Star> stars = session.createQuery("FROM Stars").list();
        session.getTransaction().commit();
        return stars;
        
    }
    
    

    public Optional<Star> getStarById(Integer id) {
       // return starList.stream().filter(star -> star.getId() == id).findFirst();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Star star = session.get(Star.class, id);
        session.getTransaction().commit();
        
        return star;
    }

//     public List<Star> getStarByName(String name) {
//         return starList.stream().filter(star -> star.getName().equals(name)).collect(Collectors.toList());
//     }
    

    public Star saveStar(Star star) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(star);
        session.getTransaction().commit();
        
        return star;
    }

    public List<Star> saveStars(List<Star> stars) {
        for(Star star : stars){
            saveStar(star);
        }

        return stars;
    }
    public Star updateStar(Star star) {
//         int realId = id - 1;
//         starList.set(realId, star);
//         return star;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(star);
        session.getTransaction().commit();
        return star;
    }
    
    public void deleteStar(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(getStarById(id));
        session.getTransaction().commit();
    }


    public List<Star> getByQueryParams(MultivaluedMap<String,String> fieldValueMap) {

        return starList.stream().filter(
                star -> StarPredicates.getPredicatesByQuery(fieldValueMap)
                        .stream().allMatch(predicate -> predicate.test(star))
        ).collect(Collectors.toList());
    }

    public List<Star> getByIds(MultivaluedMap<String,String> fieldValueMap) {

        return starList.stream().filter(
                star -> StarPredicates.getPredicatesByQuery(fieldValueMap)
                        .stream().anyMatch(predicate -> predicate.test(star))
        ).collect(Collectors.toList());
    }



}
