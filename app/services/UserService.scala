package services

import javax.inject._

import play.api.mvc._

import daos._

import dtos._

class UserService @Inject()(userDao: UserDao) {

    def findByUsername(username: String) : UserDto =
        userDao.findByUsername(username).toDto()
}