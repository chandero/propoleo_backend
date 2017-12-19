package v1.oficina;

public class OficinaResource {
    private Integer id;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String codigoContable;
    private Integer codigoMunicipio;
    private String ip;
    private Integer puerto;
    private Boolean activa;
    private String ciudad;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String value) {
		this.direccion = value;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String value) {
		this.telefono = value;
	}

	public String getCodigoContable() {
		return this.codigoContable;
	}

	public void setCodigoContable(String value) {
		this.codigoContable = value;
	}

	public Integer getCodigoMunicipio() {
		return this.codigoMunicipio;
	}

	public void setCodigoMunicipio(Integer value) {
		this.codigoMunicipio = value;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String value) {
		this.ip = value;
	}

	public Integer getPuerto() {
		return this.puerto;
	}

	public void setPuerto(Integer value) {
		this.puerto = value;
	}

	public Boolean getActiva() {
		return this.activa;
	}

	public void setActiva(Boolean value) {
		this.activa = value;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String value) {
		this.ciudad = value;
	}
    
}