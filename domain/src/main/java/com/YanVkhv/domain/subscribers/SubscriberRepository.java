package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.Repository;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

@Named
public class SubscriberRepository extends Repository<Subscriber> {
    @Override
    public List<Subscriber> getAll() {
        return getEntityManager()
                .createQuery("FROM Subscriber", Subscriber.class)
                .getResultList();
    }

    @Override
    public Subscriber get(UUID entityId) {
        return getEntityManager()
                .createQuery("FROM Subscriber WHERE id = :id", Subscriber.class)
                .setParameter("id", entityId.toString())
                .getSingleResult();
    }
}
