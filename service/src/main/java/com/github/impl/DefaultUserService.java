//package com.github.impl;
//
//import com.github.hib.dao.PersonDao;
//import com.github.hib.dao.impl.DefaultPersonDao;
//import com.github.hib.entity.Role;
//import com.github.model.Person;
//import com.github.UserService;
//
//import java.util.List;
//
//public class DefaultUserService implements UserService {
//
//    private PersonDao instance = DefaultPersonDao.getInstance();
//
//    private static class SingletonHolder {
//        static final UserService HOLDER_INSTANCE = new DefaultUserService();
//    }
//
//
//    public static UserService getInstance() {
//        return DefaultUserService.SingletonHolder.HOLDER_INSTANCE;
//    }
//
//    @Override
//    public Person getByLogin(String login) {
//        return instance.getByLogin(login);
//    }
//
//    @Override
//    public List<Person> getAll() {
//        return instance.getAll();
//    }
//
//    @Override
//    public Role getRole(String login, String password) {
//        return null;
//    }
//
//    @Override
//    public Role getRole(String login) {
//        return instance.getByLogin(login);
//    }
//
//    @Override
//    public int create(Person person) {
//        return instance.createPerson(person);
//    }
//
//    @Override
//    public Person saveUser(Person user) {
//        return user;
//    }
//
//    @Override
//    public int deleteUser(String name) {
//        return 0;
//    }
//
//    @Override
//    public void deletePerson(String name) {
//    }
//
//}
