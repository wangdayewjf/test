package com.example.test.utils;




import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//表示这个类是一个读取配置文件的类
@Configuration
@Component
//指定配置的一些属性,其中的prefix表示前缀
@ConfigurationProperties(prefix = "com.example.test")
@Data
//指定所读取的配置文件的路径
@PropertySource(value = "classpath:resource.properties")
public class Resource {

	private String name;
	private String website;
	private String language;

	//...setter and getter
}
