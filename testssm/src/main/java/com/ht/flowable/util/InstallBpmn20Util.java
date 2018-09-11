package com.ht.flowable.util;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

/**
 * Created by hetao on 2018/9/5
 */
public interface InstallBpmn20Util {

    public static void main(String[] args) {
        /**
         * 会默认按照Resources目录下的flowable.cfg.xml创建流程引擎
         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("procuduer/input-data.bpmn.xml").deploy();

        //查询部署信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());
    }
}

