package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import val.project.entities.MailQueue;

import java.util.List;

public interface MailQueueDao extends JpaRepository<MailQueue,Long> {
        List<MailQueue> findByMainStatus(int status);
        long countAllByMainStatus(int id);
        @Query("delete  from MailQueue mq where mq.mainStatus=:statusID and id in ( select  )")
        void deleteAllByMainStatus(@Param("statusID") int statusID);


}
