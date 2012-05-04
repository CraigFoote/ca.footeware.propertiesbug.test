/**
 * 
 */
package ca.footeware.propertiesbug.test.adapters.factories;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import ca.footeware.propertiesbug.test.adapters.TestViewContributedContentViewAdapter;
import ca.footeware.propertiesbug.test.adapters.TestViewPropertySheetPage;
import ca.footeware.propertiesbug.test.views.TestView;

/**
 * @author craig
 * 
 */
public class TestViewAdapterFactory implements IAdapterFactory {

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
		if (adaptableObject instanceof TestView) {
			TestView view = (TestView) adaptableObject;
			if (adapterType == IContributedContentsView.class) {
				adapter = new TestViewContributedContentViewAdapter(view);
			} else if (adapterType == IPropertySheetPage.class) {
				adapter = new TestViewPropertySheetPage(view);
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
		return new Class[] { IContributedContentsView.class,
				IPropertySheetPage.class };
	}

}
