package ilia.nemankov.repository;

import ilia.nemankov.model.Point;
import ilia.nemankov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
