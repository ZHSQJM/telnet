package com.zhs.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/25 8:43
 * 描述: 七牛服务器
 **/
@Data
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String cdnPrefix;
}
