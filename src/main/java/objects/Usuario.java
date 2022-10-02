package objects;

public class Usuario {
    private String user, pass, tel, email;
    private int tipo;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Usuario(String user, String pass, int tipo) {
        this.user = user;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Usuario(String user, String pass, String tel, String email, int tipo) {
        this.user = user;
        this.pass = pass;
        this.tel = tel;
        this.email = email;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}