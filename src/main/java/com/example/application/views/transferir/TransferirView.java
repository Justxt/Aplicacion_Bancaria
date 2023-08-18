package com.example.application.views.transferir;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.example.application.views.registrar.Usuario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import java.util.Map;

@PageTitle("Transferir")
@Route(value = "transferir")
public class TransferirView extends VerticalLayout {

    private TextField numeroCuentaField;
    private NumberField montoField;

    public TransferirView() {
        setClassName("transferir-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image logoI = new Image("images/logo.png", "Logo");
        logoI.setWidth("284px");
        logoI.setHeight("67px");

        VerticalLayout headerLayout = new VerticalLayout();
        headerLayout.add(logoI);
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.getStyle().set("padding", "20px");
        headerLayout.setWidthFull();

        Paragraph infMot = new Paragraph("TU DINERO SEGURO SIEMPRE!");
        infMot.getStyle().set("font-family", "Mansalva, cursive");
        infMot.getStyle().set("font-size", "25px");
        infMot.getStyle().set("text-align", "center");

        FormLayout formLayout = new FormLayout();

        numeroCuentaField = new TextField("Número de Cuenta");
        montoField = new NumberField("Monto a Transferir");

        Button transferirButton = new Button("Transferir");
        transferirButton.getStyle().set("background-color", "aqua");
        transferirButton.getStyle().set("color", "black");
        transferirButton.addClickListener(e -> transferirSaldo());
        transferirButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("info")));

        formLayout.add(numeroCuentaField, montoField, transferirButton);

        Paragraph textFoo = new Paragraph("BW Company");
        textFoo.getStyle().set("font-size", "30px");
        textFoo.getStyle().set("font-family", "Mansalva, cursive");
        Icon twitterIcon = VaadinIcon.TWITTER.create();
        Icon facebookIcon = VaadinIcon.FACEBOOK.create();
        Icon youtubeIcon = VaadinIcon.YOUTUBE.create();
        Icon abacusIcon = VaadinIcon.ABACUS.create();

        HorizontalLayout icoSoc = new HorizontalLayout(twitterIcon, facebookIcon, youtubeIcon);
        icoSoc.setSpacing(true);
        icoSoc.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        icoSoc.setWidthFull();


        add(headerLayout, infMot, formLayout, textFoo, icoSoc);
    }

    private void transferirSaldo() {
        String numeroCuenta = numeroCuentaField.getValue();
        double monto = montoField.getValue();

        // Obtener el usuario actualmente autenticado o guardado en la sesión
        VaadinSession session = VaadinSession.getCurrent();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario != null) {
            Map<String, Usuario> usuariosRegistrados = com.example.application.views.RegistrarView.getUsuariosRegistrados();
            Usuario usuarioActual = usuariosRegistrados.get(nombreUsuario);
            Usuario usuarioDestino = usuariosRegistrados.get(numeroCuenta);

            if (usuarioActual != null && usuarioDestino != null) {
                if (usuarioActual.getSaldo() >= monto) {
                    usuarioActual.setSaldo(usuarioActual.getSaldo() - monto);
                    usuarioDestino.setSaldo(usuarioDestino.getSaldo() + monto);

                    Notification.show("Transferencia exitosa").setPosition(Notification.Position.MIDDLE);
                } else {
                    Notification.show("Fondos insuficientes").setPosition(Notification.Position.MIDDLE);
                }
            } else {
                Notification.show("Número de cuenta inválido").setPosition(Notification.Position.MIDDLE);
            }
        }
    }
}
