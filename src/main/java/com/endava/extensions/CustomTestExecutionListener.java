package com.endava.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;


public class CustomTestExecutionListener implements TestExecutionListener {

    private static final Logger LOGGER = LogManager.getLogger(CustomTestExecutionListener.class);

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        LOGGER.info("Starting test {} / {}", testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        LOGGER.info("Finishing test {} / {}", testIdentifier.getDisplayName(), testExecutionResult.getStatus());

    }

}
