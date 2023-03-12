package mate.academy.service.impl;

import javax.naming.AuthenticationException;
import mate.academy.dao.UserDao;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDao userDao;

    public AuthenticationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
        /*
        Optional<User> userOptional = userDao.findByLogin(login);
        if(userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return userOptional.get();
        }
       throw new AuthenticationException("Incorrect username or password");
    }

         */
        return null;
    }
}
