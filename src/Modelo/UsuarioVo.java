package Modelo;

public class UsuarioVo {
    private Integer id_user;
    private String firstname;
    private String lastname;
    private String email;
    private Integer id_country;
    private Integer id_state;
    private Integer id_location;
    private Integer cp;
    private String direction;
    private String phone;
    private String rfc;
    private String register_date;
    private double money;
    private String estado;
    private String localidad;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_country() {
        return id_country;
    }

    public void setId_country(Integer id_country) {
        this.id_country = id_country;
    }

    public Integer getId_state() {
        return id_state;
    }

    public void setId_state(Integer id_state) {
        this.id_state = id_state;
    }

    public Integer getId_location() {
        return id_location;
    }

    public void setId_location(Integer id_location) {
        this.id_location = id_location;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }
    
}
