package com.YanVkhv.gui.components;

import com.YanVkhv.gui.layouts.MainLayout;
import com.YanVkhv.gui.views.DepositCalendarView;
import com.YanVkhv.gui.views.MainView;
import com.YanVkhv.gui.views.RejectionsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@ParentLayout(MainLayout.class)
public class NavigationBar extends Composite<HorizontalLayout> implements RouterLayout {

    public NavigationBar() {
        addMenuElement(MainView.class, "Main");
        addMenuElement(DepositCalendarView.class, "Deposit Calendar");
        addMenuElement(RejectionsView.class, "Rejections");
    }

    private void addMenuElement(Class<? extends Component> navigationTarget, String name) {
        RouterLink routerLink = new RouterLink();
        routerLink.setRoute(navigationTarget);
        routerLink.add(new Button(name));
        getContent().add(routerLink);
    }
}
