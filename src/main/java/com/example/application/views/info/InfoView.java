package com.example.application.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.registrar.Usuario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@PageTitle("Info")
@Route(value = "info")
public class InfoView extends VerticalLayout {

    public InfoView() {
        setClassName("info-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VaadinSession session = VaadinSession.getCurrent();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario != null) {
            Map<String, Usuario> usuariosRegistrados = com.example.application.views.RegistrarView.getUsuariosRegistrados();
            Usuario usuario = usuariosRegistrados.get(nombreUsuario);

            if (usuario != null) {
                Image logoI = new Image("images/logo.png", "Logo");
                logoI.setWidth("284px");
                logoI.setHeight("67px");

                VerticalLayout header = new VerticalLayout();
                header.add(logoI);
                header.setAlignItems(Alignment.CENTER);
                header.getStyle().set("padding", "20px");
                header.setWidthFull();

                Paragraph nro = new Paragraph("Nro. " + usuario.getNumeroCuenta());
                Paragraph saldo = new Paragraph();
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                String saldoFormateado = decimalFormat.format(usuario.getSaldo());
                saldo.setText(saldoFormateado);
                saldo.getStyle().set("font-size", "60px");
                saldo.getStyle().set("font-family", "Mansalva, cursive");
                saldo.getStyle().set("text-align", "center");
                saldo.getStyle().set("color", "#5CE1E6");


                Button iTransB = new Button();
                Image iTransI = new Image("images/transferencia.png", "Icono 1");
                iTransB.getStyle().set("width", "60px");
                iTransB.setIcon(iTransI);
                iTransB.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("transferir")));

                Button iServB = new Button();
                Image iServI = new Image("images/servicios.png", "Icono 2");
                iServB.getStyle().set("width", "60px");
                iServB.setIcon(iServI);
                iServB.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("servicios")));

                Button iSooB = new Button();
                Image iSooI = new Image("images/pronto.png", "Icono 3");
                iSooB.getStyle().set("width", "60px");
                iSooB.setIcon(iSooI);
                iSooB.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("info")));

                HorizontalLayout iconIm = new HorizontalLayout();
                iconIm.add(iTransB, iServB, iSooB);
                iconIm.getStyle().set("padding", "25px");
                iconIm.setJustifyContentMode(JustifyContentMode.EVENLY);
                iconIm.setWidthFull();


                Button imgC = new Button();
                Image imgCI = new Image("images/card.png", "Card");
                imgC.setWidth("274px");
                imgC.setHeight("235px");
                imgC.setIcon(imgCI);
                imgC.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("zico")));

                HorizontalLayout imgCm = new HorizontalLayout();
                iconIm.add(imgC);
                iconIm.getStyle().set("padding", "25px");
                iconIm.setJustifyContentMode(JustifyContentMode.EVENLY);
                iconIm.setWidthFull();


                Paragraph textFoo = new Paragraph("BW Company");
                textFoo.getStyle().set("font-size", "30px");
                textFoo.getStyle().set("font-family", "Mansalva, cursive");

                Button cerrSes = new Button("Cerrar sesión");
                cerrSes.getStyle().set("color", "black");
                cerrSes.getStyle().set("background-color", "aqua");

                cerrSes.addClickListener(e -> {
                    session.setAttribute("nombreUsuario", null);
                    getUI().ifPresent(ui -> ui.navigate("inicio"));
                });

                add(header, nro, saldo, iconIm, imgC, cerrSes, textFoo);
            }
        }
    }

}
