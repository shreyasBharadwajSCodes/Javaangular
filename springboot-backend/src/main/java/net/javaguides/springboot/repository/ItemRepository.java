package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
	
	@Query("select I from Item I where itemname Like %:name%")
	public List<Item> findByNameMatch(@Param("name") String name);
}