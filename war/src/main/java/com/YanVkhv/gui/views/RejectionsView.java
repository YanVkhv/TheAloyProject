package com.YanVkhv.gui.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "rejections", layout = MainView.class)
@PageTitle("Rejections")
@CssImport("styles/views/rejections/rejections-view.css")
public class RejectionsView extends Div {

    public RejectionsView() {
        setId("rejections-view");
        add(new Label("Content placeholder"));
    }

}
