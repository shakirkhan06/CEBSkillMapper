package com.niit.CEBSkillMapperTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.CEBSkillMapper.Config.ConfigFileProject;
import com.niit.CEBSkillMapper.model.Profile;
import com.niit.CEBSkillMapper.service.ProfileService;
import com.niit.CEBSkillMapper.service.SkillService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ConfigFileProject.class)
public class ProfileTest {
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private SkillService skillService;
	
	
	@Test
	public void testAddprofile() {			
		Profile p=new Profile();
		p.setEmployeeId(109);
		p.setQualification("MSC");
		p.setSupervisorname("Lakshmi");
		p.setProfileviews(0);
		assertEquals("failed to add the profile",true, profileService.add(p));
				
	}
	/*@Test
	public void testDeleteProfile()
	{
		assertEquals(true,profileService.delete(102));
	}
		*/
}
