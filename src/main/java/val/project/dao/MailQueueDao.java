package val.project.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import val.project.entities.MailQueue;


import java.util.List;

public interface MailQueueDao extends JpaRepository<MailQueue,Long> {
        List<MailQueue> findByMainStatus(int status);
        List<MailQueue> findAllByMainStatus(int status, Pageable pageable);
        long countAllByMainStatus(int id);
        @Transactional
        void deleteMailQueuesByMainStatus(int statusId);



}
