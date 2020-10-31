package com.gofurther.emissora.repositories;

import com.gofurther.emissora.entities.Performer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformerRepository extends CrudRepository<Performer,Integer> {
    Performer findByEmail(String email);

    List<Performer> findAllByStatus(boolean status);

    @Query("select p from Performer p where p.salary between :salary*0.8 and :salary*1.2 and p.status = :status")
    List<Performer> findAllByStatusAndSalary(@Param("status") boolean status, @Param("salary") double salary);

    @Query("select p from Performer p where p.stars between :stars*0.5 and :stars*1.5 and p.status = :status")
    List<Performer> findAllByStatusAndStars(@Param("status")boolean status, @Param("stars") double stars);

    @Query("select p from Performer p where p.stars between :stars*0.5 and :stars*1.5 and p.status = :status and p.salary between :salary*0.8 and :salary*1.2")
    List<Performer> findAllByStatusAndStarsAndSalary(@Param("status")boolean status,@Param("stars") double stars,@Param("salary") double salary);
}
