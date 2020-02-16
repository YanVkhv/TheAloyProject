package com.YanVkhv.domain.institutions;

import com.YanVkhv.domain.Repository;

import javax.inject.Named;
import java.util.List;

@Named
public class InstitutionRepository extends Repository<Institution> {
    @Override
    public List<Institution> getAll() {
        return getEntityManager()
                .createQuery("FROM Institution ", Institution.class)
                .getResultList();
    }

    @Override
    public Institution get(Long entityId) {
        return getEntityManager()
                .createQuery("FROM Institution WHERE id = :id", Institution.class)
                .setParameter("id", entityId)
                .getSingleResult();
    }
}
