package com.github;

import Model.AuthUser;

public interface SecurityService {

    AuthUser userName (String login, String password);
}
