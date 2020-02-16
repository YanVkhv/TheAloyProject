package com.YanVkhv.domain.subscriptions;

import com.YanVkhv.domain.Repository;

import javax.inject.Named;
import java.util.List;

@Named
public class SubscriptionRepository extends Repository<Subscription> {
    @Override
    public List<Subscription> getAll() {
        return getEntityManager()
                .createQuery("FROM Subscription", Subscription.class)
                .getResultList();
    }

    @Override
    public Subscription get(Long entityId) {
        return getEntityManager()
                .createQuery("FROM Subscription WHERE id = :id", Subscription.class)
                .setParameter("id", entityId)
                .getSingleResult();
    }
}
