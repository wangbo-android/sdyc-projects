package com.sql2.dao;

import com.sql2.entity.Puser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Puser,Integer> {

    public Puser findByName(String name);

    @Query("select p from Puser p where p.name=?1 and p.departmentId=?2")
    public Puser findPuser(String name, Integer departmentId);

    @Query(value = "select * from puser where department_id=?",nativeQuery = true)
    public Page<Puser> queryPusersPageOne(Integer departmentId, Pageable page);

    @Modifying
    @Query("update Puser p set p.name=?1 where p.id=?2")
    public int updateName(String name,Integer id);
}
