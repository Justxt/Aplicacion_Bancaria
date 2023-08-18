package com.example.application.views.registrar;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import java.util.Map;

@PageTitle("Iniciar")
@Route(value = "iniciar")
public class IniciarView extends VerticalLayout {

    private TextField nombreUsuarioField;
    private PasswordField contraField;

    public IniciarView() {
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

        Paragraph infMot = new Paragraph("TU DINERO SEGURO SIEMPRE!");
        infMot.getStyle().set("font-family", "Mansalva, cursive");
        infMot.getStyle().set("font-size", "25px");
        infMot.getStyle().set("text-align", "center");

        FormLayout formInic = new FormLayout();

        nombreUsuarioField = new TextField("NOMBRE");
        contraField = new PasswordField("CONTRASEÑA");

        Button iniSes = new Button("ACCEDER");
        iniSes.getStyle().set("background-color", "aqua");
        iniSes.getStyle().set("color", "white");
        iniSes.addClickListener(e -> iniciarSesion());
        iniSes.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("info")));

        formInic.add(nombreUsuarioField, contraField, iniSes);

        Button regisInic = new Button("¿NO TIENES UNA?");
        regisInic.getStyle().set("background-color", "aqua");
        regisInic.getStyle().set("color", "white");
        regisInic.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("registrar")));

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

        add(header, infMot, formInic, regisInic, textFoo, icoSoc);
    }

    private void iniciarSesion() {
        String nombreUsuario = nombreUsuarioField.getValue();
        String contra = contraField.getValue();

        if (valCreden(nombreUsuario, contra)) {
            VaadinSession session = VaadinSession.getCurrent();
            session.setAttribute("nombreUsuario", nombreUsuario);

            Notification.show("Inicio de sesión exitoso").setPosition(Notification.Position.TOP_START);
            getUI().ifPresent(ui -> ui.navigate("info"));
        } else {
            Notification.show("Datos Incorrecto pa").setPosition(Notification.Position.TOP_START);
        }
    }

    private boolean valCreden(String nombreUsuario, String contra) {
        Map<String, Usuario> usuariosRegistrados = com.example.application.views.RegistrarView.getUsuariosRegistrados();
        Usuario usuario = usuariosRegistrados.get(nombreUsuario);
        return usuario != null && usuario.getContra().equals(contra);
    }

}
