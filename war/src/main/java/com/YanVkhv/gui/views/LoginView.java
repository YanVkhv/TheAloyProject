package com.YanVkhv.gui.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class LoginView extends Div {

    private LoginForm loginForm = new LoginForm();

    public LoginView() {
        add(loginForm);
    }
}
