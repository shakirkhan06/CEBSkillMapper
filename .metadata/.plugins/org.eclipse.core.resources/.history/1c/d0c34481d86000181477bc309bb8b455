package com.niit.CEBSkillMapperTest;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.CEBSkillMapper.Config.ConfigFileProject;
import com.niit.CEBSkillMapper.model.Skills;
import com.niit.CEBSkillMapper.service.SkillService;


@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ConfigFileProject.class)
public class SkillTest {
	@Autowired
	private SkillService skillService;
	
	@Test
	public void testAddSkill()
	{
		Skills skill=new Skills();
		skill.setEmployeeid(102);
		skill.setStudentsTrained(120);
		skill.setTeachingHrs(22);
		skill.setCertifications("ms sql java oracle");
		skill.setStudentPlaced(4);
		skill.setSkillName("java,c++,sql");
		assertEquals("Failed to add the skill",true,skillService.add(skill));
	}

}
