/**
 * Copyright 2016-2017 com.nanf.cross.api
 * All rights reserved.
 * 
 * @project
 * @author li.hui
 * @version 1.0
 * @date 2016-11-18
 */


import org.junit.Test;

import com.lycheeframework.core.common.helper.GlobEnv;
import com.lycheeframework.mapping.MappingRuning;
import com.lycheeframework.mapping.db.Engine;

/**
 * 
 * @author li.hui
 *
 */
public class TestMapping extends TestBase {
	
	@Test
	public void test() throws Exception {
		String url = GlobEnv.get("mysql.url");
		String userName = GlobEnv.get("mysql.username");
		String passwd = GlobEnv.get("mysql.password");
		String beanPath = "D:/A-generator/po/";
		String sqlmapPath = "D:/A-generator/sql/";
		
		String packageName = "com.micropower.manager.model.po";
		
		MappingRuning runing = new MappingRuning(Engine.mysql, url, userName, passwd);

		runing.generate("alarmthreshold", beanPath, sqlmapPath, packageName);

		
	}
}