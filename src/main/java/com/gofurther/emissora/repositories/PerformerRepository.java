package com.gofurther.emissora.repositories;

import com.gofurther.emissora.entities.Performer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PerformerRepository extends CrudRepository<Performer, Integer> {
  Optional<Performer> findByEmail(String email);

  List<Performer> findAllByStatus(boolean status);

  @Query(value = "SELECT * FROM PERFORMER A LEFT JOIN PERFORMER_GENRE B ON B.PERFORMER_ID = A.ID LEFT JOIN RESERVATION C  \n" +
          "ON C.PERFORMER_ID = A.ID WHERE A.SALARY <= ?1 AND B.GENRE = ?2 \n" +
          "AND (NOT ?3 BETWEEN  C.START_DATE AND C.FINISH_DATE OR  C.START_DATE  IS NULL)", nativeQuery = true)
  List<Performer> findAllBySalaryAndGenre(double budget,String genre,LocalDateTime date);

  @Query("select p from Performer p where p.salary between :salary*0.8 and :salary*1.2 and p.status = :status")
  List<Performer> findAllByStatusAndSalary(@Param("status") boolean status,
                                           @Param("salary") double salary);

  @Query("select p from Performer p where p.stars between :stars*0.8 and :stars*1.2 and p.status = :status")
  List<Performer> findAllByStatusAndStars(@Param("status") boolean status,
                                          @Param("stars") double stars);

  @Query("select p from Performer p where p.stars between :stars*0.8 and :stars*1.2 and p.status = :status and p.salary between :salary*0.8 and :salary*1.2")
  List<Performer> findAllByStatusAndStarsAndSalary(@Param("status") boolean status,
                                                   @Param("stars") double stars, @Param("salary") double salary);
}
