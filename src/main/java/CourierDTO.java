import io.restassured.response.ValidatableResponse;

public class CourierDTO {
    private String login ;
    private String password;
    private String firstName;


    public CourierDTO(ValidatableResponse response){}


    public CourierDTO(String login){
        this.login = login;
    }


    public CourierDTO(String login, String password){
        this.login = login;
        this.password = password;
    }

    public CourierDTO(String login, String password, String firstName){
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

}
