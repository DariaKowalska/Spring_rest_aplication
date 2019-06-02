package pl.sda.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.rest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


}
