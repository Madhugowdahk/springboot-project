package com.example.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootproject.entities.Cars;


public interface CarRepository extends JpaRepository<Cars, Long> {
	
//	JPQL (Entity-based, NOT table-based)
//	@Query("SELECT c FROM Cars c WHERE c.carOwner = :owner")
//	List<Cars> findCarsByOwner(@Param("owner") String owner);
//
//
//	👉 Uses entity name (Cars) and field names, not DB column names.
	
//	JPQL with multiple params
//	@Query("SELECT c FROM Cars c WHERE c.carName = :name AND c.fuelType = :fuel")
//	List<Cars> findByNameAndFuel(
//	        @Param("name") String name,
//	        @Param("fuel") Character fuelType
//	);
	
//	Update query
//	@Modifying
//	@Query("UPDATE Cars c SET c.carOwner = :owner WHERE c.id = :id")
//	int updateCarOwner(@Param("owner") String owner,
//	                   @Param("id") Long id);
//
//	Delete query
//	@Modifying
//	@Query("DELETE FROM Cars c WHERE c.carName = :name")
//	int deleteByCarName(@Param("name") String name);
//
//
//	📌 Must be inside a transaction
//
//	@Transactional
//
//
//	(Add it on service method or repository method)


}
