package models

import java.util.Date
import dtos.UserDto

class User {
    var ID_EMPLEADO: String
    var DOCUMENTO: String
    var PRIMER_APELLIDO: String
    var SEGUNDO_APELLIDO: String
    var NOMBRE: String
    var NUMERO_CUENTA: String
    var ULTIMO_CAMBIO_PASABORDO: Date
    var AG: Int
    var CONTRASENA: String
    var TIPO: Int
    var EMAIL: String
    def toDto(): UserDto = {
        var userDto = new UserDto()
        userDto.ID_EMPLEADO = ID_EMPLEADO
        userDto.DOCUMENTO = DOCUMENTO
        userDto.PRIMER_APELLIDO = PRIMER_APELLIDO
        userDto.SEGUNDO_APELLIDO = SEGUNDO_APELLIDO
        userDto.NOMBRE = NOMBRE
        userDto.TIPO = TIPO
        userDto.EMAIL = EMAIL
        return userDto
    }
}