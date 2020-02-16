package com.YanVkhv.service.depositcalendars;

import com.YanVkhv.domain.depositcalendars.DepositCalendar;
import com.YanVkhv.domain.depositcalendars.DepositCalendarRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DepositCalendarService {

    private final DepositCalendarRepository depositCalendarRepository;

    @Inject
    public DepositCalendarService(DepositCalendarRepository depositCalendarRepository) {
        this.depositCalendarRepository = depositCalendarRepository;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<DepositCalendar> getAllDepositCalendars() {
        return depositCalendarRepository.getAll();
    }
}
