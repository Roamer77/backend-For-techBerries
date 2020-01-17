package val.project.entities;

import javax.persistence.*;

@Entity
public class MailQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MAILQUEUE_ID")
    @SequenceGenerator(sequenceName = "MAILQUEUE_ID",allocationSize = 1,name = "MAILQUEUE_ID")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private UserOrder userOrder;

    //1 - отправлен  2- ожидает
    private int mainStatus;

    public MailQueue() {
    }

    public MailQueue(UserOrder userOrder, int mainStatus) {
        this.userOrder = userOrder;
        this.mainStatus = mainStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public int getMainStatus() {
        return mainStatus;
    }

    public void setMainStatus(int mainStatus) {
        this.mainStatus = mainStatus;
    }
}
