package com.gpichot.fungame.factory;

import org.junit.Assert;
import org.junit.Test;

import com.gpichot.fungame.factory.GenericObjectFactory;
import com.gpichot.fungame.factory.testobject.DefaultValidObject;
import com.gpichot.fungame.factory.testobject.InvalidObjectWithNoDefaultConstructor;
import com.gpichot.fungame.factory.testobject.InvalidObjectWithNoImplementation;

/**
 * Tests the generic factory used by the application.
 */
public class GenericObjectFactoryTest {

	@Test
	public void should_instanciate_a_valid_object_from_its_interface(){
		DefaultValidObject validObjectTest = GenericObjectFactory.getFactory().newInstance(DefaultValidObject.class);
		Assert.assertNotNull(validObjectTest);
	}
	
	@Test(expected=IllegalStateException.class)
	public void should_fail_to_instanciate_an__object_with_no_implementation_found_from_its_interface(){
		GenericObjectFactory.getFactory().newInstance(InvalidObjectWithNoImplementation.class);
	}
	@Test(expected=IllegalStateException.class)
	public void should_fail_to_instanciate_an__object_with_no_default_constructor_from_its_interface(){
		GenericObjectFactory.getFactory().newInstance(InvalidObjectWithNoDefaultConstructor.class);
	}
}
