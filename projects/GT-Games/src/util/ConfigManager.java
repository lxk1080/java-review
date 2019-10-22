package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//单例模式---设计模式  23种
//一个对象
public class ConfigManager {
	private static ConfigManager configManager;
	//properties.load(InputStream);读取配置文件
	private static Properties properties; 
	//构造方法 私有化 不能在其他类中new对象
	private ConfigManager(){
		String configFile="database.properties";
		properties=new Properties();
		InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
}

