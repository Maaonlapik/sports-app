package ee.te.sportsapi.Repository;


import ee.te.sportsapi.Model.User;
import ee.te.sportsapi.Util.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    //User findByEMail(String email);
    User findByUsername(String name);
    List<User> findAllByUsername(String name);

    @Transactional
    @Modifying
    @Query("UPDATE User u set u.role = :role where u.id = :id")
    void editRole(@Param("id") int id, @Param("role") Role role);

}

