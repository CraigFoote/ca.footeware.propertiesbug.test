/**
 * 
 */
package ca.footeware.propertiesbug.test.adapters;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;

import ca.footeware.propertiesbug.test.views.TestView;

/**
 *
 */
public class TestViewContributedContentViewAdapter implements
		IContributedContentsView {
	private TestView view;
	
	public TestViewContributedContentViewAdapter(TestView view) {
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.IContributedContentsView#getContributingPart()
	 */
	@Override
	public IWorkbenchPart getContributingPart() {
		return view;
	}

}
