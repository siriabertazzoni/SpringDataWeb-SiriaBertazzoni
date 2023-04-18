package it.data_web.spring_data_web.repository;

import java.util.List;

import java.util.Map;

import it.data_web.spring_data_web.model.Autore;

public interface CustomAutoreRepository {
    public List<Autore> dynamicQuery(Map<String, String> filter);
}
