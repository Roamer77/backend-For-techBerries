package val.project.entities.testEntites;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;


@Entity
public class Alian {


    private int id;

    private AlianFullName fullName;

    private String color;


    private Human slavedHuman;

    public Alian() {
    }

    public Alian( AlianFullName fullName, String color) {
        this.fullName = fullName;
        this.color = color;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlianFullName getFullName() {
        return fullName;
    }

    public void setFullName(AlianFullName fullName) {
        this.fullName = fullName;
    }

    public String getColor() {
        return "Pip"+color;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="human_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //хз мб аукниться потом
    @JsonManagedReference
    public Human getSlavedHuman() {
        return slavedHuman;
    }

    public void setSlavedHuman(Human slavedHuman) {
        this.slavedHuman = slavedHuman;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
