/**
 * 
 */
package ca.footeware.propertiesbug.test.adapters.factories;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import ca.footeware.propertiesbug.test.adapters.FooPropertySource;
import ca.footeware.propertiesbug.test.model.Foo;

/**
 * 
 */
public class FooAdapterFactory implements IAdapterFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 * java.lang.Class)
	 */
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		Object adapter = null;
		if (adaptableObject instanceof Foo) {
			Foo foo = (Foo) adaptableObject;
			if (adapterType == IPropertySource.class) {
				adapter = new FooPropertySource(foo);
			}
		}
		return adapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IPropertySource.class };
	}

}
