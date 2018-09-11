package com.ht.flowable.util;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

/**
 * Created by hetao on 2018/9/5
 */
public class InitProcessEngineUtil {

        public static void main(String[] args) {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("flowable.cfg.xml");
        ProcessEngine processEngine = cfg.buildProcessEngine();
    }

//    public static void main(String[] args) {
//        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
//                .setJdbcUrl("jdbc:mysql://localhost:3306/flowable?useUnicode=true&zeroDateTimeBehavior=convertToNull")
//                .setJdbcUsername("root")
//                .setJdbcPassword("sdjg")
//                .setJdbcDriver("com.mysql.jdbc.Driver")
//                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//        ProcessEngine processEngine = cfg.buildProcessEngine();
//    }
}