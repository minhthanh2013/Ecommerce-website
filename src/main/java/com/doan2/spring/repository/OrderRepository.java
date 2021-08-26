package com.doan2.spring.repository;

import com.doan2.spring.entity.Customer;
import com.doan2.spring.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select s from Order s where s.idOrder = ?1")
    Page<Order> findByIdOrder(int idOrder, Pageable pageable);

    @Query(value = "select * from Order_Table   WHERE DATEDIFF(day,date,GETDATE()) between 0 and ?1 and idCus = ?2", nativeQuery = true)
    Page<Order> findByLastNDay(int day, int idCus, Pageable pageable);
    @Query(value = "select * from Order_Table   WHERE DATEDIFF(month,date,GETDATE()) between 0 and ?1 and idCus = ?2", nativeQuery = true)
    Page<Order> findByLastNMonth(int month, int idCus, Pageable pageable);

    @Query(value = "select *  from Order_Table WHERE idCus = ?1 order by idOrder desc ", nativeQuery = true)
    Page<Order> last5Order(int idCus, Pageable pageable );


    @Query(value = "select * from Order_Table where year(date) = ?1 and idCus = ?2", nativeQuery = true)
    Page<Order> findAllByYear(int year,int idCus, Pageable pageable);
    @Query(value = "select * from Order_Table where idCus = ?1", nativeQuery = true)
    Page<Order> findAllByIdCus(int idCus, Pageable pageable);


}
