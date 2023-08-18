package com.example.application.views.agua;

import com.example.application.views.InfoView;
import com.example.application.views.RegistrarView;
import com.example.application.views.registrar.Usuario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import java.util.Map;
import java.util.Random;

@PageTitle("Agua")
@Route(value = "agua")
public class AguaView extends VerticalLayout {

    private NumberField montoPagarField;

    public AguaView() {
        setClassName("agua-view");
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

        H2 titulo = new H2("Pago Agua");
        add(titulo);

        montoPagarField = new NumberField("Monto a Pagar");
        montoPagarField.setMin(10);
        montoPagarField.setMax(30);
        montoPagarField.setValue(generarMontoAleatorio());

        Button pagBot = new Button("Pagar");
        pagBot.getStyle().set("background-color", "aqua");
        pagBot.getStyle().set("color", "white");
        pagBot.addClickListener(e -> pagarAgua());
        pagBot.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("info")));

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

        add(header, infMot, montoPagarField, pagBot, textFoo, icoSoc);

    }


    private void pagarAgua() {
        double monto = montoPagarField.getValue();


        VaadinSession session = VaadinSession.getCurrent();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario != null) {
            Map<String, Usuario> usuariosRegistrados = RegistrarView.getUsuariosRegistrados();
            Usuario usuarioActual = usuariosRegistrados.get(nombreUsuario);

            if (usuarioActual != null) {
                if (usuarioActual.getSaldo() >= monto) {
                    usuarioActual.setSaldo(usuarioActual.getSaldo() - monto);

                    session.setAttribute("saldo", usuarioActual.getSaldo());

                    Notification.show("Pago realizado correctamente").setPosition(Notification.Position.TOP_START);
                    getUI().ifPresent(ui -> ui.navigate(InfoView.class));
                } else {
                    Notification.show("Fondos insuficientes").setPosition(Notification.Position.TOP_START);
                }
            }
        }
    }
    private double generarMontoAleatorio() {
        Random random = new Random();
        return 10 + (random.nextDouble() * (30 - 10));
    }
}
