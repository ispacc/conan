package io.origins.conan.repository;

import io.origins.conan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
// JpaRepository 自动实现了很多内置的CURD方法
// 这些方法以后可直接调用，例如：
// List<T> findAll();
// Optional<T> findById(id);
// User save(user);
// void delete(user);
// void deleteById(id);
// long count();
// boolean existsById(id);
}
