package com.ssginc.commonservice.chat.repository;

import com.ssginc.commonservice.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {

}
