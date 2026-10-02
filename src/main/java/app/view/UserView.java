package app.view;

import app.domain.User;
import app.domain.enums.SelectPreferencesEnum;
import app.service.helpers.SetUserState;
import app.service.inputports.UserService;
import app.service.validators.DataTypeValidator;

import java.util.List;

public class UserView {

    private final UserService userService;

    public UserView(UserService userService){
        this.userService = userService;
    }


    //CREAR USUARIO

    public void createUser() {
        int id = DataTypeValidator.validateInt("Ingrese el id del usuario: ");
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");


        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");

        System.out.println("Ingrese el estado del usuario: ");
        String state = SetUserState.getUserState();

        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");

        System.out.println("Ingrese las preferencias del usuario: ");
        String preferences = setUserPreferences();

        userService.create(id, name, lastName, email, phone, password, state, city, preferences);
        System.out.println(" Usuario registrado con éxito.\n");
    }

    //SELECCIONAR POR ID

    public void selectById() {
        int Id = DataTypeValidator.validateInt("Ingrese el ID del usuario a buscar: ");
        User user = userService.selectById(Id);

        if (user != null) {
            System.out.println("** USUARIO ENCONTRADO **");
            imprimirUsuario(user);
        } else {
            System.out.println("** USUARIO NO ENCONTRADO **" + Id);
        }

    }


    //SELECCION DE USUARIO
    public void selectUsers(){

        List<User> users = userService.selectUsers();
        if  (users != null || users.isEmpty()) {
            System.out.println("** USUARIOS ENCONTRADOS **");
        }

        System.out.println("** LISTA DE USUARIOS **");
        for (User user : users) {
            imprimirUsuario(user);
        }


    }

    // UPDATE
    public void update() {
    int id = DataTypeValidator.validateInt("Ingrese el ID del usuario: ");
    User existingUser = userService.selectById(id);
    if (existingUser == null) {
        System.out.println("** EL USUARIO NO ENCONTRADO **" + id + "** NO EXISTE**");
        return;
    }
        System.out.println("--- Ingrese los nuevos datos del usuario ---");
        String name = DataTypeValidator.validateString("Ingrese el nuevo nombre: ");
        String lastName = DataTypeValidator.validateString("Ingrese el nuevo apellido: ");
        String email = DataTypeValidator.validateString("Ingrese el nuevo correo: ");
        String phone = DataTypeValidator.validateString("Ingrese el nuevo telefono: ");
        String password = DataTypeValidator.validateString("Ingrese la nueva contraseña: ");

        System.out.println("Ingrese el nuevo estado: ");
        String state = SetUserState.getUserState();

        String city = DataTypeValidator.validateString("Ingrese la nueva ciudad: ");

        System.out.println("Ingrese las nuevas preferencias: ");
        String preferences = setUserPreferences();

        // LLAMADA DEL METODO ACTUALIZADO
        User updated = userService.update(id, name, lastName, email, phone, password, state, city, preferences);

        if (updated != null) {
            System.out.println(" Usuario actualizado exitosamente.");
        } else {
            System.out.println(" No se pudo actualizar el usuario.");
        }

    }

    //DELETE
    public void delete() {
        int Id = DataTypeValidator.validateInt("Ingrese el ID del usuario a eliminar: ");
        userService.deleteUser(Id);
        System.out.println(" Si el usuario existía, ha sido eliminado del sistema.");
    }

    // METODO CONTAR USUARIOS
    public void countUsers() {
        int total = userService.countUsers();
        System.out.println("\n Total de usuarios registrados: " + total + "\n");
    }




// Métodos Helpers

    private void imprimirUsuario(User user) {
        System.out.println("ID: " + user.getId() +
                " | Nombre: " + user.getName() + " " + user.getLastName() +
                " | Email: " + user.getEmail() +
                " | Tel: " + user.getPhone() +
                " | Estado: " + user.isState() +
                " | Ciudad: " + user.getCity() +
                " | Pref: " + user.getPreferences());
    }

    public String setUserPreferences() {
        int option = DataTypeValidator.validateInt("Seleccione 1. VIP 2. General 3. Preferencial: ");
        String preferences = "";

        switch (option) {
            case 1:
                preferences = SelectPreferencesEnum.VIP.getPreference();
                break;
            case 2:
                preferences = SelectPreferencesEnum.GENERAL.getPreference();
                break;
            case 3:
                preferences = SelectPreferencesEnum.PREFERENCIAL.getPreference();
                break;
            default:
                System.out.println("Opción no válida");
        }
        return preferences;
    }

}
