package com.masai.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.Entity.Fir;
import com.masai.app.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
	@Query("Select fir from User where userId=?1")
	public List<Fir> findFir(int id);
}
