package com.example.application.views.inicio;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;


@PageTitle("Inicio")
@Route(value = "inicio")
@RouteAlias(value = "")
public class InicioView extends VerticalLayout {

    public InicioView() {
        setClassName("inicio-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image logoI = new Image("images/logo.png", "Logo");
        logoI.setWidth("284px");
        logoI.setHeight("67px");

        VerticalLayout header = new VerticalLayout();
        header.add(logoI);
        header.setAlignItems(Alignment.CENTER);
        header.getStyle().set("padding", "20px");
        header.setWidthFull();

        Image imgC = new Image("images/card.png", "Card");
        imgC.setWidth("274px");
        imgC.setHeight("235px");
        imgC.getStyle().set("padding", "20px 20px");

        Image imgA = new Image("images/anuncio.png", "anuncio");
        imgA.setWidth("311px");
        imgA.setHeight("117px");
        imgA.getStyle().set("padding", "20px 20px");

        Button boAbrir = new Button("ABRIR CUENTA");
        boAbrir.getStyle().set("background-color", "aqua");
        boAbrir.getStyle().set("color", "white");
        boAbrir.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("registrar")));

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

        add(header, imgC, imgA, boAbrir, textFoo, icoSoc);
        
    }

}
