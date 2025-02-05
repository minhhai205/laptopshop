package vn.minhhai.laptopshop.domain.dto;

public class RegisterDTO {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegisterDTO [name=" + name + ", email=" + email + ", password=" + password + ", confirmPassword="
                + confirmPassword + "]";
    }

}
