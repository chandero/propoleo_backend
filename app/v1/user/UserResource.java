package v1.user;


public class UserResource {
    private String idEmpleado;
    private String documento;
    private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String numeroCuenta;
    private String ultimoCambioPasabordo;
    private Integer ag;
    private String contrasenha;
    private Integer tipo;
	private String email;
	
	UserResource(){}

	UserResource(UserData ud){
		this.idEmpleado = ud.getIdEmpleado();
		
	}

	public String getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(String value) {
		this.idEmpleado = value;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String value) {
		this.documento = value;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String value) {
		this.primerApellido = value;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String value) {
		this.segundoApellido = value;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public String getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(String value) {
		this.numeroCuenta = value;
	}

	public String getUltimoCambioPasabordo() {
		return this.ultimoCambioPasabordo;
	}

	public void setUltimoCambioPasabordo(String value) {
		this.ultimoCambioPasabordo = value;
	}

	public Integer getAg() {
		return this.ag;
	}

	public void setAg(Integer value) {
		this.ag = value;
	}

	public String getContrasenha() {
		return this.contrasenha;
	}

	public void setContrasenha(String value) {
		this.contrasenha = value;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer value) {
		this.tipo = value;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String value) {
		this.email = value;
	}
   
}