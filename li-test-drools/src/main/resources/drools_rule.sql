set foreign_key_checks=0;

-- ----------------------------
-- table structure for drools_rule
-- ----------------------------
drop table if exists `drools_rule`;
create table `drools_rule` (
  `id` int(11) not null auto_increment,
  `name` varchar(64) character set utf8mb4 default null,
  `rule` mediumtext character set utf8mb4,
  `create_time` timestamp null default current_timestamp,
  `update_time` timestamp null default current_timestamp on update current_timestamp,
  `visible` int(11) default null,
  primary key (`id`)
) engine=innodb auto_increment=5 default charset=latin1;

-- ----------------------------
-- records of drools_rule
-- ----------------------------
insert into `drools_rule` values (
'1', 
'rule_001', 
'package com.li.test.drools.dto;
import com.li.test.drools.dto.Person;
rule "2"
	when
        $p : Person(age < 30);
    then
		System.out.println("hello, young li2!");
		$p.setDesc("young "+$p.getName());
		retract($p)
end', 
current_timestamp, 
current_timestamp, 
'1');

insert into `drools_rule` values (
'2', 
'rule_002', 
'package com.li.test.drools.dto;
import com.li.test.drools.dto.Person;
rule "2"
	when
        $p : Person(age > 30);
    then
		System.out.println("hello, young li2!");
end
query "people2"
    person : Person( age > 30 )
end', 
current_timestamp, 
current_timestamp, 
'1');