package com.anselmopfeifer.jenkins

import org.junit.Before
import org.junit.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static org.junit.Assert.assertTrue

import com.lesfurets.jenkins.unit.cps.BasePipelineTestCPS
import com.lesfurets.jenkins.unit.global.lib.GitSource

class ExampleTest extends BasePipelineTestCPS {

    String clonePath = 'build/toClone'

    @Before
    void setup() {
        super.setUp()
        helper.registerSharedLibrary(library('jenkins-pipeline-unit-example')
                        .defaultVersion('master')
                        .allowOverride(true)
                        .targetPath(clonePath)
                        .retriever(GitSource.gitSource('git@github.com:AnselmoPfeifer/jenkins-pipeline-unit-example.git'))
                        .build())
    }


    @Test
    void start_tests_pipelines() {
        loadScript('pipeline.groovy')
        printCallStack()
        assertTrue(true)
    }

}