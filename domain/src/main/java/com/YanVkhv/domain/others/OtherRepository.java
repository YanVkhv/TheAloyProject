package com.YanVkhv.domain.others;

import com.YanVkhv.domain.Repository;

import javax.inject.Named;
import java.util.List;

@Named
public class OtherRepository extends Repository<Other> {
    @Override
    public List<Other> getAll() {
        return getEntityManager()
                .createQuery("FROM Other ", Other.class)
                .getResultList();
    }

    @Override
    public Other get(Long entityId) {
        return getEntityManager()
                .createQuery("FROM Other WHERE id = :id", Other.class)
                .setParameter("id", entityId)
                .getSingleResult();
    }
}
