package com.example.application.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.registrar.Usuario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@PageTitle("Registrar")
@Route(value = "registrar")
public class RegistrarView extends VerticalLayout {

    private TextField nombreField;
    private TextField correoInF;
    private PasswordField contraField;
    private TextField saldoInicialField;

    private static final Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    public RegistrarView() {
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

        FormLayout formReg = new FormLayout();

        nombreField = new TextField("NOMBRE");
        correoInF = new TextField("CORREO");
        contraField = new PasswordField("CONTRASEÑA");
        saldoInicialField = new TextField("SALDO INICIAL");

        Button regBot = new Button("ABRIR CUENTA");
        regBot.getStyle().set("padding", "20px");
        regBot.getStyle().set("background-color", "aqua");
        regBot.addClickListener(e -> registrarUsuario());
        regBot.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("iniciar")));
        formReg.add(regBot);

        formReg.add(nombreField, correoInF, contraField, saldoInicialField, regBot);

        Button crearInic = new Button("¿YA TIENES UNA?");
        crearInic.getStyle().set("background-color", "aqua");
        crearInic.getStyle().set("color", "white");
        crearInic.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("iniciar")));

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

        add(header, infMot, formReg, crearInic, textFoo, icoSoc);

    }


    private void registrarUsuario() {
        String nombre = nombreField.getValue();
        String correo = correoInF.getValue();
        String contra = contraField.getValue();
        double saldoInicial = Double.parseDouble(saldoInicialField.getValue());

        String numeroCuenta = generarNumeroCuenta();

        Usuario nuevoUsuario = new Usuario(nombre, correo, contra, saldoInicial, numeroCuenta);

        usuariosRegistrados.put(nombre, nuevoUsuario);

        Notification.show("Usuario registrado con éxito").setPosition(Notification.Position.TOP_START);
    }

    private String generarNumeroCuenta() {
        Random random = new Random();
        int numeroCuenta = random.nextInt(9000) + 1000;
        return String.valueOf(numeroCuenta);
    }

    public static Map<String, Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

}
