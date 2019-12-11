package dto;

import lombok.Data;

@Data
public class UserDto {
    private Long user_id;
    private String name;
    private String password;
    private boolean enabled;
    private String login;
    //private String[] role;
}
