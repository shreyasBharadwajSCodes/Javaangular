package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Bill;

public interface BillRepository extends JpaRepository<Bill,Long>{

		@Query("select b from Bill b where b.customer.cid =:cid")
		public List<Bill> getAllBillsByCID(@Param("cid") Long cid );
}
