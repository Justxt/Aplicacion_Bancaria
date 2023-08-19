# BW - IMAGENES DEL PROGRAMA CORRIENDO!
##ESTA APLICACION ESTA ADAPTADA PARA APLICACION MOVILES!

# SECCION 1
-- Al correr el programa se nos mostrará el inicio de la aplicacion.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/d7bfbecf-f4c0-4f9d-aa4c-bca20cc52aef)

#SECCION 2
-- Cuando se elija la opcion abrir cuenta se dirijirá a la seccion de registrar la cuenta.
-- Llenamos los datos y procedemos a crear una cuenta. En el caso de ya contar con una se elije el boton de abajo.
-- Al momento de crearse una cuenta se creará un numero de cuenta automaticamente.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/78ff97e9-3f7d-4b68-97b8-0093cc521679)

#SECCION 3
-- Una vez creada la cuenta se reedirijirá a la seccion de iniciar sesion.
-- Llenamos los datos y continuamos.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/c2cd5043-947a-47f3-a4c2-23344936c535)

#SECCION 4
-- Se ingresara al DASHBOARD de la cuenta.
-- Aqui contamos con 4 opciones: Transferir, Pago de Servicios Basicos, Solicitud de tarjeta y Cerrar Sesion.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/b40c6a5f-f277-4254-b1f3-8a2f546d0860)

#SECCION 5
-- TRANSFERIR
-- Insertamos el numero de cuenta y un monto a enviar
-- Cuando se envie se mostrará una ventana indicando si la transaccion fue exitosa.
-- El saldo se descontará automaticamente y se le aumentará a la cuenta enviada.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/8aae00fb-5e05-4ac8-93c0-b6d35dd0bbbb)

#SECCION 6
-- PAGO SERVICIOS
-- Se mostraá una lista de 3 servicio basicos.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/0b86c9b8-c232-4ebe-a0b8-11014a1d057b)

# SECCION 7
-- Se mostrará una monto a pagar del servicio elegido.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/0c757344-ae39-493d-b21d-c70a938f2315)
-- Cuando se realice la operacion se mostrará un aviso de pago realizado y se descontará.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/11bccad3-e05c-4d66-b920-45c92649da33)

#SECCION 8
-- FORMULARIO SOLICITUD DE TARJETA
-- Al hacer click en la tarjeta que aparece en el DASHBOARD se reedirijirá a un formulario.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/0e476d38-73be-4a74-9a1b-842b12115760)
-- Llenamos y enviamos.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/5f73918d-ef9c-4721-b5b3-dc6732e700ac)
-- Muestra notificacion si fue exitosa.
![image](https://github.com/Justxt/Aplicacion_Bancaria/assets/96129728/8e84c3cb-8b4d-46dc-bf59-72705296d0e4)


This project can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/bw-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorial at [vaadin.com/docs/latest/tutorial/overview](https://vaadin.com/docs/latest/tutorial/overview).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/docs/latest/components](https://vaadin.com/docs/latest/components).
- View use case applications that demonstrate Vaadin capabilities at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Build any UI without custom CSS by discovering Vaadin's set of [CSS utility classes](https://vaadin.com/docs/styling/lumo/utility-classes). 
- Find a collection of solutions to common use cases at [cookbook.vaadin.com](https://cookbook.vaadin.com/).
- Find add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin).
