package org.elsys.ip.rest.service;

import org.elsys.ip.rest.model.Star;
import org.elsys.ip.rest.repository.StarRepository;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.function.Predicate;


public class StarService {
    private StarRepository starRepository = new StarRepository();

    public List<Star> getStarList() {
        return starRepository.getStarList();
    }

    public Star getStarById(Integer id) {
        return starRepository.getStarById(id).orElse(null);
    }

    public Star saveStar(Star star) {
        return starRepository.saveStar(star);
    }

    public List<Star> saveStars(List<Star> stars) {
        return starRepository.saveStars(stars);
    }

    public Star updateStar(Integer id, Star star) {
        return starRepository.updateStar(id, star);
    }

    public void deleteStar(Integer id) {
        starRepository.deleteStar(id);
    }

    public List<Star> filterByQueryParams(MultivaluedMap<String,String> fieldValueMap) {
        return starRepository.getByQueryParams(fieldValueMap);
    }

    public List<Star> filterByIds(MultivaluedMap<String,String> fieldValueMap) {
        return starRepository.getByIds(fieldValueMap);
    }

}
