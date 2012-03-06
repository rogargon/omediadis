package cat.udl.omediadis.semdrms;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author  : http://rhizomik.net/~roberto
 */
public class eLearningTest 
{
	static String license_01 = "file:luisa/license_01.owl";
	static String copy_01a = "file:luisa/copy_01a.rdf";
	static String transfer_01a = "file:luisa/transfer_01a.rdf";
	static String copy_01b = "file:luisa/copy_01b.rdf";
	static String transfer_01b = "file:luisa/transfer_01b.rdf";
	static String copy_01c = "file:luisa/copy_01c.rdf";
	static String transfer_01c = "file:luisa/transfer_01c.rdf";
	
	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		CopyrightManager manager = new CopyrightManager();
        
		manager.loadLicense(new URL(license_01).openStream());
		
        manager.registerAction(new URL(copy_01a).openStream());      
        String use = "http://rhizomik.net/semdrms/luisa/actions#copy_01a";
        System.out.println("Registered "+use);      
        manager.registerAction(new URL(transfer_01a).openStream());
        String transfer = "http://rhizomik.net/semdrms/luisa/actions#transfer_01a";
        System.out.println("Registered "+transfer);
        System.out.println("It is "+manager.checkUse(use)+" that "+use+" is authorised.");
        manager.debugCheckUse(use);

        manager.registerAction(new URL(copy_01b).openStream());
        use = "http://rhizomik.net/semdrms/luisa/actions#copy_01b";
        System.out.println("Registered "+use);      
        manager.registerAction(new URL(transfer_01b).openStream());
        transfer = "http://rhizomik.net/semdrms/luisa/actions#transfer_01b";
        System.out.println("Registered "+transfer);
        System.out.println("It is "+manager.checkUse(use)+" that "+use+" is authorised.");
        manager.debugCheckUse(use);
        
        manager.registerAction(new URL(copy_01c).openStream());
        use = "http://rhizomik.net/semdrms/luisa/actions#copy_01c";
        System.out.println("Registered "+use);
        manager.registerAction(new URL(transfer_01c).openStream());
        transfer = "http://rhizomik.net/semdrms/luisa/actions#transfer_01c";
        System.out.println("Registered "+transfer);
        System.out.println("It is "+manager.checkUse(use)+" that "+use+" is authorised.");
        manager.debugCheckUse(use);
        
        manager.debugPatternsInstances();
	}
}
