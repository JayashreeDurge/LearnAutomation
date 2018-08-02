package factory;

import data_provider.*;


public class AllObjects
{
 public static DataProvider getDataProviderMethods()
 {
	 DataProvider data = new DataProvider();
	 return data;
 }
 
 public static ConfigProvider getConfigProviderMethods()
 {
	 ConfigProvider config = new ConfigProvider();
	 return config;
 }
}
