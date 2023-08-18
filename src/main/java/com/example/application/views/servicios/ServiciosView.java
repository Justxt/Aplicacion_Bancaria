package com.example.application.views.servicios;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.example.application.views.agua.AguaView;
import com.example.application.views.internet.InternetView;
import com.example.application.views.luz.LuzView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Servicios")
@Route(value = "servicios")
public class ServiciosView extends VerticalLayout {

    public ServiciosView() {
        setClassName("servicios-view");
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

        Button serAg = new Button();
        Image serAgI = new Image("images/agua.png", "Icono 1");
        serAg.setIcon(serAgI);
        serAgI.getStyle().set("padding", "0px 0px 100px");
        serAg.getStyle().set("padding", "100px 0px 0px 0px");
        serAg.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("luz")));

        Button serLu = new Button();
        Image serLuI = new Image("images/luz.png", "Icono 2");
        serLuI.getStyle().set("padding", "0px 0px 100px");
        serLu.getStyle().set("padding", "100px 0px 0px 0px");
        serLu.setIcon(serLuI);
        serLu.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("agua")));

        Button serIn = new Button();
        Image serInI = new Image("images/internet.png", "Icono 3");
        serInI.getStyle().set("padding", "0px 0px 100px");
        serIn.getStyle().set("padding", "100px 0px 0px 0px");
        serIn.setIcon(serInI);
        serIn.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("internet")));

        VerticalLayout iconIm = new VerticalLayout();
        iconIm.add(serAg, serLu, serIn);
        iconIm.setAlignItems(Alignment.CENTER);
        iconIm.setJustifyContentMode(JustifyContentMode.CENTER);
        iconIm.setWidthFull();

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

        add(header, infMot, iconIm, textFoo, icoSoc);
    }

}
