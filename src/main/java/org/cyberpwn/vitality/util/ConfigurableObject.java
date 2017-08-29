package org.cyberpwn.vitality.util;

/**
 * Represents a configurable object
 * 
 * @author cyberpwn
 */
public abstract class ConfigurableObject implements Configurable
{
	private String codeName;
	private DataCluster cc;
	
	/**
	 * Create a configurable object
	 * 
	 * @param codeName
	 *            the code name for the configurable object
	 */
	public ConfigurableObject(String codeName)
	{
		this.codeName = codeName;
		cc = new DataCluster();
	}
	
	public void updateCodeName(String cn)
	{
		codeName = cn;
	}
	
	@Override
	public void onNewConfig()
	{
		
	}
	
	@Override
	public void onReadConfig()
	{
		
	}
	
	@Override
	public DataCluster getConfiguration()
	{
		return cc;
	}
	
	@Override
	public String getCodeName()
	{
		return codeName;
	}
}
