package com.li.test.drools.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author yuan.li
 *
 */
@Mapper
public interface RulesDao {
	@Select("select * from drools_rule where id = #{id}")
	Rules selectById(@Param("id") Integer id);

	@Insert("insert into drools_rule(name,rule) value(#{name},#{rule})")
	Integer insert(@Param("name") String name, @Param("rule") String rule);

	@Select("select * from drools_rule order by create_time desc")
	List<Rules> getRuleList();

	@Update("update drools_rule set visible=0 where id = #{id}")
	Integer deleteRule(@Param("id") Integer id);

	@Update("update drools_rule set rule= #{rule} and name = #{name} where id = #{id}")
	Integer updateRule(@Param("id") Integer id, @Param("name") String name, @Param("rule") String rule);
}
