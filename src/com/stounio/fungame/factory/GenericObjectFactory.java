package com.stounio.fungame.factory;

/**
 * This factory is used to inject the corresponding implementation for a new object from its interface.
 * <p>
 * This factory avoids having a source code highly coupled with implementations, and decreases the risk of introducing dependencies.
 */
public class GenericObjectFactory {

	private static final String CLASS_DELIMITER = "\\.";
	private static final String CLASS_SUFFIX = "Impl";
	private static final String PACKAGE_SUFFIX = ".impl";
	
	private static final GenericObjectFactory factory = new GenericObjectFactory();

	private GenericObjectFactory(){
		
	}
	
	public static final GenericObjectFactory getFactory(){
		return factory;
	}
	/**
	 * Create a new object for the requested interface.
	 * <p>
	 * The implementation used to create the new object has respect the following rules : 
	 * <ul>
	 * <li>Being located in a sub-package ".impl".
	 * <li>Being suffixed with "Impl".
	 * <li>Having a default constructor.
	 * 
	 * @param interfaceClass
	 * @return
	 * @throws IllegalStateException
	 */
	public <T extends Object> T newInstance(Class<T> interfaceClass){
		try{
			Class<T> implementationClass = findImplementationClass(interfaceClass);
			try{
				return implementationClass.newInstance();
			} catch (InstantiationException e) {
				throw new IllegalStateException(e);
			} catch (IllegalAccessException e) {
				throw new IllegalStateException(e);
			}
		} catch (ClassNotFoundException e){
			throw new IllegalStateException(e);
		} 
	}
	
	/**
	 * Retrieve the Class object corresponding to the requested implementation.
	 * @param interfaceClass
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private static <T> Class<T> findImplementationClass(Class<T> interfaceClass) throws ClassNotFoundException{
		String interfaceName = interfaceClass.getName();
		String[] interfaceNameSegment = interfaceName.split(CLASS_DELIMITER);
		int length = interfaceNameSegment.length;
		int classPackageIndex = length -2;
		int classNameIndex = length-1;
		interfaceNameSegment[classPackageIndex] = interfaceNameSegment[classPackageIndex] + PACKAGE_SUFFIX;
		interfaceNameSegment[classNameIndex] = interfaceNameSegment[classNameIndex] + CLASS_SUFFIX;
		StringBuilder classNameBuilder = new StringBuilder();
		int segmentIndex = 0;
		for(String segment : interfaceNameSegment){
			segmentIndex ++;
			classNameBuilder.append(segment);
			if(segmentIndex < length){
				classNameBuilder.append(".");
			}
		}
		String className = classNameBuilder.toString();
		Class<?> forName = Class.forName(className);
		return (Class<T>) forName;
	}	
}
