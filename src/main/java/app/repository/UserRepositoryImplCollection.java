package app.repository;

import app.domain.User;
import app.service.outputports.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplCollection implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User selectById(int id) {
        for (User user : users) {
            if (user.getId() == id){
                return user;  //Si encontramos un usuario lo retornamos
            }
        }
        return null;
    }


    @Override
    public List<User> selectAll() {
        return users;
    }

    @Override
    public User updateUser(User user) {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                users.set(i, user); // Reemplaza el ususario viejo por el actualizado
                return user;
            }
        }
        return null; //Retorna null si no encontron el usuario que debe actualizar
    }

    @Override
    public void deleteById(int id) {
    users.removeIf(User -> User.getId() == id);  //Elimina el usuario que coincida con el ID
    }

    //Metodo Contar Total Usuarios

    @Override
    public int countUsers(){
        return users.size();
    }
}
