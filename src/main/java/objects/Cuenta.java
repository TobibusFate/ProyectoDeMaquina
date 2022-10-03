package objects;

public class Cuenta {
    private String cuenta, pass, email, tipo;

    public Cuenta(String cuenta, String pass) {
        this.cuenta = cuenta;
        this.pass = pass;
    }

    public Cuenta(String cuenta, String pass, String tipo) {
        this.cuenta = cuenta;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Cuenta(String cuenta, String pass, String email, String tipo) {
        this.cuenta = cuenta;
        this.pass = pass;
        this.email = email;
        this.tipo = tipo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setcuenta(String user) {
        this.cuenta = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}