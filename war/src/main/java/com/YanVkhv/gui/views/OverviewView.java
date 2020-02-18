package com.YanVkhv.gui.views;

import com.YanVkhv.domain.subscribers.Subscriber;
import com.YanVkhv.service.subscribers.SubscriberService;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.*;

import javax.inject.Inject;

@Route(value = "overview", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Overview")
@CssImport("./styles/views/overview/overview-view.css")
public class OverviewView extends Div implements AfterNavigationObserver {

    @Inject
    private SubscriberService subscriberService;

    private Grid<Subscriber> subscribers;

    private TextField firstname = new TextField();
    private TextField lastname = new TextField();
    private FormLayout addressForm = new FormLayout();
    private PasswordField password = new PasswordField();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<Subscriber> binder;

    public OverviewView() {
        setId("overview-view");
        // Configure Grid
        subscribers = new Grid<>();
        subscribers.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        subscribers.setHeightFull();
        subscribers.addColumn(Subscriber::getFirstname).setHeader("First name").setResizable(true).setAutoWidth(true);
        subscribers.addColumn(Subscriber::getLastname).setHeader("Last name").setResizable(true).setAutoWidth(true);
        subscribers.addColumn(Subscriber::getBirthdate).setHeader("Birthdate").setResizable(true).setAutoWidth(true);
        subscribers.addColumn(Subscriber::getNationalRegisterNumber).setHeader("NRN").setResizable(true).setAutoWidth(true);
        subscribers.addColumn(Subscriber::getAddress).setHeader("Address").setResizable(true).setAutoWidth(true);
        subscribers.addColumn(Subscriber::getSubscriptions).setHeader("Subscriptions").setResizable(true).setAutoWidth(true);

        //when a row is selected or deselected, populate form
        subscribers.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));

        // Configure Form
        binder = new Binder<>(Subscriber.class);

        // Bind fields. This where you'd define e.g. validation rules
        binder.bindInstanceFields(this);
        // note that password field isn't bound since that property doesn't exist in
        // Employee

        // the grid valueChangeEvent will clear the form too
        cancel.addClickListener(e -> subscribers.asSingleSelect().clear());

        save.addClickListener(e -> Notification.show("Not implemented"));

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        FormLayout formLayout = new FormLayout();
        addFormItem(editorDiv, formLayout, firstname, "First name");
        addFormItem(editorDiv, formLayout, lastname, "Last name");
        formLayout.add(addressForm);
        createButtonLayout(editorDiv);
        splitLayout.addToSecondary(editorDiv);
    }

    private void createButtonLayout(Div editorDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setId("button-layout");
        buttonLayout.setWidthFull();
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(cancel, save);
        editorDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(subscribers);
    }

    private void addFormItem(Div wrapper, FormLayout formLayout,
                             AbstractField field, String fieldName) {
        formLayout.addFormItem(field, fieldName);
        wrapper.add(formLayout);
        field.getElement().getClassList().add("full-width");
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        subscribers.setItems(subscriberService.getAllSubscribers());
    }

    private void populateForm(Subscriber value) {
        // Value can be null as well, that clears the form
        binder.readBean(value);

        // The password field isn't bound through the binder, so handle that
        password.setValue("");
    }
}
