package app.ui;

import app.repository.UserRepositoryImplCollection;
import app.service.UserServiceImpl;
import app.service.inputports.UserService;
import app.service.outputports.UserRepository;
import app.service.validators.DataTypeValidator;
import app.view.SeatView;
import app.view.UserView;

public class CliUserInterface {

    UserRepository userRepository = new UserRepositoryImplCollection();
    UserService userService = new UserServiceImpl(userRepository);
    UserView userView = new UserView(userService);

    public CliUserInterface(UserView userView, SeatView seatView) {
    }

    public void applicationInit() {

        System.out.println("Bienvenido TicketMax V1");

        int init = DataTypeValidator.validateInt("Presione 1 para iniciar la aplicación: ");

        while (init != 0) {

            int option = DataTypeValidator.validateInt("\n--- MENÚ PRINCIPAL ---\n" +
                    "1. Gestión de Usuarios\n" +
                    "2. Salir\n" +
                    "Seleccione una opción: ");

            switch (option) {
                case 1:
                    userMenu(); // Abre el submenú con todas las opciones CRUD
                    break;
                case 2:
                    System.out.println("Saliendo de la aplicación TicketMax...");
                    init = 0;
                    break;
                default:
                    System.out.println("Seleccione una opción válida.");
                    break;
            }
        }
    }


    public void userMenu() {

        int option = DataTypeValidator.validateInt("\n--- MENÚ DE GESTIÓN DE USUARIOS ---\n" +
                "1. Registrar usuario\n" +
                "2. Consultar usuario por ID\n" +
                "3. Consultar todos los usuarios\n" +
                "4. Actualizar usuario\n" +
                "5. Eliminar usuario\n" +
                "6. Ver total de usuarios registrados\n" +
                "7. Volver / Salir\n" +
                "Seleccione una opción: ");

        switch (option) {
            case 1:
                System.out.println("\n--- Registrar Usuario ---");
                userView.createUser();
                break;

            case 2:
                System.out.println("\n--- Consultar Usuario por ID ---");
                userView.selectById(); // El ID se solicita dentro de selectById()
                break;

            case 3:
                System.out.println("\n--- Consultar Todos los Usuarios ---");
                userView.selectUsers();
                break;

            case 4:
                System.out.println("\n--- Actualizar Usuario ---");
                userView.update();
                break;

            case 5:
                System.out.println("\n--- Eliminar Usuario ---");
                userView.delete();
                break;

            case 6:
                System.out.println("\n--- Total de Usuarios ---");
                userView.countUsers();
                break;

            case 7:
                System.out.println("Volviendo al menú anterior...");
                break;

            default:
                System.out.println("Ingrese una opción válida.");
                break;
        }
    }
}

