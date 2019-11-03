package com.github;

import com.github.model.Person;

public interface SecurityService {

    Person userName (String login, String password);
}
