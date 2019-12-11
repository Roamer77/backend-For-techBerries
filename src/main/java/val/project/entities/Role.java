package val.project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(name="USER_ROLE")
    private  String userRole;

    @OneToMany(mappedBy = "role")
    private List <Accounts> accounts;

    @OneToOne(optional = false,mappedBy = "role")
    private  Manager manager;
    public Role() {
    }

    public Role( String userRole) {
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
