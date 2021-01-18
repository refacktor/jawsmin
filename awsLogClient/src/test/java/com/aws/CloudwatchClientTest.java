package com.aws;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

import com.aws.logs.AWSLogsClient;
import com.aws.model.CreateLogGroupRequest;


class CloudwatchClientTest {

    @Test
    void test() {
        CreateLogGroupRequest g = new CreateLogGroupRequest();
        // g.setKmsKeyId("kms");
        g.setLogGroupName("logG1");
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        g.setTags(map);
        AWSLogsClient log = new AWSLogsClient();
        log.createLogGroup(g);
    }
}
