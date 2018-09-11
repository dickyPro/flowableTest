package com.ht.flowable.util;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Created by hetao on 2018/9/6
 */

public class CallExternalSystemDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Calling the external system for employee: "
                + execution.getVariable("employee")+ execution.getVariable("ewai"));
    }
}