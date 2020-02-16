package com.YanVkhv.gui.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class LoginView extends Div {

    private LoginOverlay loginOverlay = new LoginOverlay();

    public LoginView() {
        loginOverlay.setOpened(true);
        loginOverlay.setDescription("User authentication required");
        loginOverlay.setTitle("The Aloy Project");
        loginOverlay.setForgotPasswordButtonVisible(false);
        add(loginOverlay);
    }
}
