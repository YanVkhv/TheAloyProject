package com.YanVkhv.gui.views;

import com.YanVkhv.domain.depositcalendars.DepositCalendar;
import com.YanVkhv.service.depositcalendars.DepositCalendarService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value = "deposit-calendar", layout = MainView.class)
@PageTitle("Deposit Calendar")
@CssImport("styles/views/calendar/calendar-view.css")
public class DepositCalendarView extends Div implements AfterNavigationObserver {

    @Inject
    private DepositCalendarService depositCalendarService;
    private final Grid<DepositCalendar> grid;

    public DepositCalendarView() {
        setId("calendar-view");
        grid = new Grid<>();
        grid.setId("list");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        grid.setHeightFull();
        grid.addColumn(new ComponentRenderer<>(calendar -> {
            H3 h3 = new H3(
                    calendar.getId() + ", " + calendar.getId());
            Anchor anchor = new Anchor("mailto:" + calendar.getId(),
                    String.valueOf(calendar.getId()));
            anchor.getElement().getThemeList().add("font-size-xs");
            Div div = new Div(h3, anchor);
            div.addClassName("calendar-column");
            return div;
        }));

        add(grid);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        grid.setItems(depositCalendarService.getAllDepositCalendars());
    }
}
