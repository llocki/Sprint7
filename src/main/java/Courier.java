public class Courier {
    private String login ;

    private String password;
    private String firstName;


    //private String id;

    public Courier(){}

    public Courier(String login){
        this.login = login;
    }


    public Courier(String login, String password){
        this.login = login;
        this.password = password;
    }


    public Courier(String login, String password, String firstName){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    //--------------------------------------------------------------------
    //Сеттеры и геттеры
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() { return login; }

    public void setId(String id) { this.login = id; }

}
