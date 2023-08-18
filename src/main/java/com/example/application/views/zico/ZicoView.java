package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("Solicitud")
@Route(value = "zico")
public class ZicoView extends VerticalLayout {

    public ZicoView() {
        setClassName("zico-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        setClassName("registrar-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image logoI = new Image("images/logo.png", "Logo");
        logoI.setWidth("284px");
        logoI.setHeight("67px");

        VerticalLayout header = new VerticalLayout();
        header.add(logoI);
        header.setAlignItems(Alignment.CENTER);
        header.getStyle().set("padding", "20px");
        header.setWidthFull();

        Image imgZ = new Image("images/card.png", "Card");
        imgZ.setWidth("274px");
        imgZ.setHeight("235px");
        imgZ.getStyle().set("padding", "20px 20px");

        H2 titulo = new H2("Solicitud de Tarjeta");
        titulo.getStyle().set("font-family", "Mansalva, cursive");

        FormLayout formTarj = new FormLayout();

        TextField nombreField = new TextField("Nombre");
        TextField correoField = new TextField("Correo");
        TextField telefonoField = new TextField("Número de Teléfono");
        TextField direccionField = new TextField("Dirección");

        Button solic = new Button("Pagar");
        solic.getStyle().set("background-color", "aqua");
        solic.getStyle().set("color", "white");
        solic.addClickListener(e -> notif());
        solic.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("info")));

        formTarj.add(nombreField, correoField, telefonoField, direccionField, solic);
        add(header, imgZ, titulo, formTarj);
    }

    private void notif() {
        Notification.show("INFORMACION PROCESADA CORRECTAMENTE").setPosition(Notification.Position.TOP_START);
    }

}
