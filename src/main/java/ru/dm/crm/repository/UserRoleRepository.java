package ru.dm.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dm.crm.entity.UserRole;


/**
 * Created by Denis on 31.03.18.
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Modifying
    @Transactional
    @Query("DELETE UserRole role WHERE role.userId = ?1")
    void deleteByUserId(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE UserRole role SET role.authority = ?1 where role.userId = ?2")
    void updateAuthorityByUserId(String role, Long userId);

    UserRole findByUserId(Long userId);
}
