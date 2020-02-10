package com.YanVkhv.gui.components;

import com.YanVkhv.gui.layouts.MainLayout;
import com.YanVkhv.gui.views.DepositCalendarView;
import com.YanVkhv.gui.views.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;

@ParentLayout(MainLayout.class)
public class NavigationBar extends Div implements RouterLayout {

    public NavigationBar() {
        addMenuElement(MainView.class, "Main");
        addMenuElement(DepositCalendarView.class, "Deposit Calendar");
    }

    private void addMenuElement(
            Class<? extends Component> navigationTarget,
            String name) {
        // implementation omitted
    }
}
