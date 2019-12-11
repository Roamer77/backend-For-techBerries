package val.project.entities.testEntites;

import javax.persistence.Embeddable;

@Embeddable
public class AlianFullName {
    private  String name;
    private String  secondName;
    private String lastName;

    public AlianFullName() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
