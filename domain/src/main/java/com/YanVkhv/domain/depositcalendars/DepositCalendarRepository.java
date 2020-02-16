package com.YanVkhv.domain.depositcalendars;

import com.YanVkhv.domain.Repository;

import javax.inject.Named;
import java.util.List;

@Named
public class DepositCalendarRepository extends Repository<DepositCalendar> {
    @Override
    public List<DepositCalendar> getAll() {
        return getEntityManager()
                .createQuery("FROM DepositCalendar", DepositCalendar.class)
                .getResultList();
    }

    @Override
    public DepositCalendar get(Long entityId) {
        return getEntityManager()
                .createQuery("FROM DepositCalendar WHERE id = :id", DepositCalendar.class)
                .setParameter("id", entityId)
                .getSingleResult();
    }
}
