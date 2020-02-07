package com.YanVkhv.domain.subscriptions;

import com.YanVkhv.domain.Repository;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

@Named
public class SubscriptionRepository extends Repository<Subscription> {
    @Override
    public List<Subscription> getAll() {
        return getEntityManager()
                .createQuery("FROM Subscription", Subscription.class)
                .getResultList();
    }

    @Override
    public Subscription get(UUID entityId) {
        return getEntityManager()
                .createQuery("FROM Subscription WHERE id = :id", Subscription.class)
                .setParameter("id", entityId.toString())
                .getSingleResult();
    }
}
