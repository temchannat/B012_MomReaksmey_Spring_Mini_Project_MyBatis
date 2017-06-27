package com.hrd.smey.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hrd.smey.model.User;
@Repository
public interface UserRepository {
	/**
	 * for select data from database
	 * @return
	 */
	@Select("SELECT id, name, gender, age, email, user_hash FROM userss WHERE status='1'")
	List<User> listdata();
	
	@Select("SELECT count(user_hash) FROM userss WHERE gender='Male' and status='1'")
	public int countmale();
	
	@Select("SELECT count(user_hash) FROM userss WHERE status='1' and gender='Female'")
	public int countfemale();
	/**
	 * 
	 * for insert data into database
	 */
	@Insert("INSERT INTO userss(name, email, age, gender, user_hash)"
			+ " VALUES(#{user.name}, #{user.email},#{user.age},#{user.gender}, #{user.user_hash})")
	public boolean save(@Param("user") User user);
	/**
	 * for delete data from database
	 * @param user_hash
	 * @return
	 */
	@Delete("UPDATE userss SET status='0' WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String user_hash);
	/**
	 * 
	 * for update data from database
	 * @param user
	 * @return
	 */
	@Update("UPDATE userss SET name=#{user.name}, email=#{user.email}, age=#{user.age} WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	@Select("SELECT id, name, gender, age, email, user_hash FROM userss WHERE user_hash=#{user_hash}")
	User findOne(@Param("user_hash") String user_hash);
	

}
