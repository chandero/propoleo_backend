package dtos

import java.util.Date

class UserDto {
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
}