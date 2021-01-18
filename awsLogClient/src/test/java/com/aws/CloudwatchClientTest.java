package com.aws;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.aws.logs.AWSLogsClient;
import com.aws.model.CreateLogGroupRequest;


public class CloudwatchClientTest {

    @Test
    public void test() {
        CreateLogGroupRequest g = new CreateLogGroupRequest();
        // g.setKmsKeyId("kms");
        g.setLogGroupName("logG1");
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "test");
        g.setTags(map);
        AWSLogsClient log = new AWSLogsClient();
        log.createLogGroup(g);
    }
}
