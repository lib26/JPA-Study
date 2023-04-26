package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class dto {

    private String account_id;
    private String role_id;
    private String user_name;
    private String user_description;
    private String update_date;

    public dto(String account_id, String role_id, String user_name, String user_description, String update_date) {
        this.account_id = account_id;
        this.role_id = role_id;
        this.user_name = user_name;
        this.user_description = user_description;
        this.update_date = update_date;
    }
}
