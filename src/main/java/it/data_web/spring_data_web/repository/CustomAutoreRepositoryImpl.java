package it.data_web.spring_data_web.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import it.data_web.spring_data_web.model.Autore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomAutoreRepositoryImpl implements CustomAutoreRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Autore> dynamicQuery(Map<String, String> filter){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Autore> query = cb.createQuery(Autore.class);
        Root<Autore> autore = query.from(Autore.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for(Field field : Autore.class.getDeclaredFields()){
            String valueOnMap = filter.get(field.getName());
            if(valueOnMap != null){
                Path<String> fieldPath = autore.get(field.getName());
                predicates.add(cb.equal(fieldPath, valueOnMap));
            }
        }

        if(predicates.size() > 0)
            query.select(autore).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        else
            query.select(autore);
        return entityManager.createQuery(query).getResultList();
    }
}
