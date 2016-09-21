package ie.com.fexco.eircode.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.com.fexco.eircode.api.domain.AddressLookup;

public interface AddressLookupRepository extends JpaRepository<AddressLookup, Long>
{

	@Query(" SELECT al FROM AddressLookup al where al.requestedURL = :requestedURL ")
	AddressLookup findByRequestURL(@Param("requestedURL") String psRequestedURL);
}
