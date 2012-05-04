/**
 * 
 */
package ca.footeware.propertiesbug.test.adapters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import ca.footeware.propertiesbug.test.model.Foo;

/**
 *
 */
public class FooPropertySource implements IPropertySource {
	private Foo foo;
	private List<IPropertyDescriptor> descriptors;

	public FooPropertySource(Foo foo) {
		this.foo = foo;
	}

	@Override
	public Object getEditableValue() {
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (descriptors == null) {
			descriptors = new ArrayList<IPropertyDescriptor>();
			descriptors.add(new PropertyDescriptor("name", "Name"));
		}
		return descriptors.toArray(new IPropertyDescriptor[0]);
	}

	@Override
	public Object getPropertyValue(Object id) {
		Object value = null;
		if (id instanceof String) {
			String property = (String) id;
			if ("name".equals(property)) {
				value = foo.getName();
			}
		}
		return value;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
	}

}
